package ps.exalt.training.serverpool.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ps.exalt.training.serverpool.repositories.ServerRepository;
import ps.exalt.training.serverpool.models.ServerEntity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * The service which is responsible to handle the creation and retrieval of Server entities.
 */
@Service
public class ServerService {

    @Autowired
    private ServerRepository serverRepository;

    /**
     * Gets all the Server entities from a repository and sorts them by id.
     * @return the sorted list of servers.
     */
    public List<ServerEntity> getAllServers() {
        List<ServerEntity> servers = new ArrayList<>();
        serverRepository.findAll().forEach(servers::add);
        servers.sort(Comparator.comparing(ServerEntity::getId));

        return servers;
    }

    /**
     * Gets a Server entity from a repository by a specified id.
     * @param id the id of the server to find.
     * @return the Server entity if it's found, otherwise null.
     */
    public ServerEntity getServerById(int id) {
        return serverRepository.findOne(id);
    }

    /**
     * Adds a new server to the server pool.
     * @param server the server to add.
     */
    public void create(ServerEntity server) {
        serverRepository.save(server);
    }

    /**
     * Deletes all the servers from the server pool.
     */
    public void deleteAllServers() {
        serverRepository.deleteAll();
    }
}
