package ps.exalt.training.serverpool.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ps.exalt.training.serverpool.models.ServerEntity;
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

    @GetMapping
    public List<ServerEntity> getAll() {
        return serverService.getAllServers();
    }

    @GetMapping
    @RequestMapping("{id}")
    public ServerEntity getById(@PathVariable int id) {
        return serverService.getServerById(id);
    }
}
