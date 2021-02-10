package ps.exalt.training.serverpool.controllers;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ps.exalt.training.serverpool.services.ApplicationService;
import ps.exalt.training.serverpool.models.ApplicationEntity;

import java.util.List;

/**
 * The controller for Application related REST requests.
 */
@RestController
@RequestMapping("/api/apps")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @GetMapping
    public List<ApplicationEntity> getAll() {
        return applicationService.getAllApplications();
    }

    @GetMapping
    @RequestMapping("{id}")
    public ApplicationEntity getById(@PathVariable int id) {
        return applicationService.getApplicationById(id);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ApplicationEntity create(@Validated @RequestBody final ApplicationEntity app) {
        return applicationService.create(app);
//        return "Added " + app.getName() + " in server #" + app.getServerId();
    }
}
