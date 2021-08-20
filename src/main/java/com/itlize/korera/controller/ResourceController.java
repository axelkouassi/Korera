package com.itlize.korera.controller;

import com.itlize.korera.model.Project;
import com.itlize.korera.model.ProjectResource;
import com.itlize.korera.model.Resource;
import com.itlize.korera.model.User;
import com.itlize.korera.service.ProjectResourceService;
import com.itlize.korera.service.ProjectService;
import com.itlize.korera.service.ResourceService;
import com.itlize.korera.service.UserService;
import com.itlize.korera.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/resource")
@RequiredArgsConstructor
public class ResourceController {

    @Autowired
    private UserService userService;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private ResourceService resourceService;
    @Autowired
    private ProjectResourceService projectResourceService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtTokenUtil;
    @Autowired
    private UserDetailsService userDetailsService;

    //Controller/api to create a resource
    @PostMapping("/create")
    public ResponseEntity<?> createResource(@RequestBody Resource resource){
        resourceService.saveResource(resource);
        return new ResponseEntity<>(resource, HttpStatus.CREATED);
    }

    //Controller/api to delete resource based on name
    @GetMapping("/delete/name/{name}")
    public ResponseEntity<?> deleteByName(@PathVariable String name){
        if (!resourceService.resourceNameExists(name)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource \"" + name + "\" does not exists!");
        }
        resourceService.deleteByName(name);
        return ResponseEntity.ok().body("Resource \"" + name + "\" was successfully deleted.");
    }

    //Controller/api to delete resource based on code
    @GetMapping("/delete/code/{code}")
    public ResponseEntity<?> deleteByCode(@PathVariable String code){
        if (!resourceService.resourceCodeExists(code)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource \"" + code + "\" does not exists!");
        }
        resourceService.deleteByCode(code);
        return ResponseEntity.ok().body("Resource \"" + code + "\" was successfully deleted.");
    }

    //Controller/api to delete resource by id
    @GetMapping("/delete/id/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id){
        if (!resourceService.resourceIdExists(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource with id \"" + id + "\" does not exists!");
        }
        resourceService.deleteById(id);
        return ResponseEntity.ok().body("Resource with id \"" + id + "\" was successfully deleted.");
    }

    /*//Controller/api to get project information based on project name
    @GetMapping("/projectname/{projectname}")
    public ResponseEntity<?> getProjectByName(@PathVariable String projectname){
        if (!projectService.projectNameExists(projectname)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Project \""
                    + projectService.findByName(projectname).getProjectName()
                    + "\" does not exists!");
        }
        return ResponseEntity.ok().body(projectService.findByName(projectname));
    }

    //Controller/api to get project information based on project id
    @GetMapping("/projectid/{projectid}")
    public ResponseEntity<?> getProjectById(@PathVariable Integer projectid){
        if (!projectService.projectIdExists(projectid)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Project \""
                    + projectService.findById(projectid).getProjectId()
                    + "\" does not exists!");
        }
        return ResponseEntity.ok().body(projectService.findById(projectid));
    }

    //Controller/api to get all the projects' information by user
    @GetMapping("/getprojects/{username}")
    public ResponseEntity<?> getProjectsByUsername(@PathVariable String username){
        return ResponseEntity.ok().body(projectService.getProjectsByUsername(username));
    }

    //Controller/api to get all the projects' information
    @GetMapping("/getprojects")
    public ResponseEntity<?> getProjects(){
        return ResponseEntity.ok().body(projectService.getProjects());
    }

    //Controller/api to update user associated with project
    @PostMapping("/update/user/{name}/{username}")
    public ResponseEntity<?> updateUser(@PathVariable String name, @PathVariable String username){
        User user = userService.findByUsername(username);
        Project project = projectService.findByName(name);
        if (!userService.usernameExists(user.getUsername())){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Username \"" + username + "\" does not exists!");
        }else if (!projectService.projectNameExists(project.getProjectName())){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Project \"" + project.getProjectName() + "\" does not exists!");
        }else{
            project.setUser(user);
            projectService.updateUser(name, username);
        }
        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    //Controller/api to update project name
    @PostMapping("/update/{name}/{newname}")
    public ResponseEntity<?> updateName(@PathVariable String name, @PathVariable String newname){
        Project project = projectService.findByName(name);
        if (!projectService.projectNameExists(project.getProjectName())){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Project \"" + project.getProjectName() + "\" does not exists!");
        }
        projectService.updateName(project,newname);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }


    //Controller/api to delete all the projects
    @GetMapping("/delete/projects")
    public ResponseEntity<?> deleteProjects(){
        projectService.deleteProjects();
        return ResponseEntity.ok().body("All projects have been successfully deleted.");
    }*/
}
