package ps.exalt.training.serverpool.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ps.exalt.training.serverpool.models.ApplicationEntity;
import ps.exalt.training.serverpool.models.ServerEntity;
import ps.exalt.training.serverpool.repositories.ApplicationRepository;
import ps.exalt.training.serverpool.repositories.ServerRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * The service which is responsible to handle the creation and retrieval of Application entities.
 */
@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private ServerRepository serverRepository;

    @Autowired
    private ServerService serverService;

    /**
     * Gets all the Application entities from a repository and sorts them by id.
     * @return the sorted list of applications.
     */
    public List<ApplicationEntity> getAllApplications() {
        List<ApplicationEntity> apps = new ArrayList<>();
        applicationRepository.findAll().forEach(apps::add);
        apps.sort(Comparator.comparing(ApplicationEntity::getId));

        return apps;
    }

    /**
     * Gets an Application entity from a repository by a specified id.
     * @param id the id of the application to find.
     * @return the Application entity if it's found, otherwise null.
     */
    public ApplicationEntity getApplicationById(int id) {
        return applicationRepository.findOne(id);
    }

    /**
     * Adds the given application to an appropriate server in the server pool.
     * If there are no appropriate servers, creates one.
     * @param app the application to add.
     * @return the instance of the created Application entity.
     */
    public synchronized ApplicationEntity create(ApplicationEntity app) {
        if (app.getStorage() > 100 || app.getStorage() < 0)
            return null;

        List<ServerEntity> allServers = serverService.getAllServers();

        int minAvailable = 101;
        ServerEntity serverToStore = null;

        for (ServerEntity server : allServers) {
            if (server.getFreeStorage() >= app.getStorage() &&
                    server.getDbType() == app.getDbType() &&
                    server.getFreeStorage() < minAvailable) {
                minAvailable = server.getFreeStorage();
                serverToStore = server;
            }
        }

        // Not enough space in any of the existing servers.
        if (serverToStore == null) {
            serverToStore = new ServerEntity(app.getDbType());
            serverToStore.setId(allServers.size() + 1);
            serverService.create(serverToStore);
        }

        serverToStore.setFreeStorage(serverToStore.getFreeStorage() - app.getStorage());
        serverToStore.setUsedStorage(serverToStore.getUsedStorage() + app.getStorage());

        List<ApplicationEntity> allApplications = getAllApplications();
        app.setId(allApplications.size() + 1);
        app.setServerId(serverToStore.getId());
        serverToStore.getApplicationIds().add((long)app.getId());

        serverRepository.save(serverToStore);
        applicationRepository.save(app);

        return app;
    }
}
