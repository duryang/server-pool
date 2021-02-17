package ps.exalt.training.serverpool.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ps.exalt.training.serverpool.models.ServerEntity;
import ps.exalt.training.serverpool.services.ApplicationService;
import ps.exalt.training.serverpool.services.ServerService;

import java.util.List;

/**
 * The controller for Server related REST requests.
 */
@RestController
@RequestMapping("/api/servers")
public class ServerController {

    @Autowired
    private ServerService serverService;

    @Autowired
    private ApplicationService applicationService;

    @GetMapping
    public List<ServerEntity> getAll() {
        return serverService.getAllServers();
    }

    @GetMapping
    @RequestMapping("{id}")
    public ServerEntity getById(@PathVariable int id) {
        return serverService.getServerById(id);
    }

    @DeleteMapping
    public synchronized void deleteAll() {
        serverService.deleteAllServers();
        applicationService.deleteAllApplications();
    }
}
