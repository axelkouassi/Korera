package com.itlize.korera.controller;

import com.itlize.korera.model.Project;
import com.itlize.korera.model.User;
import com.itlize.korera.service.ProjectService;
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
@RequestMapping("/project")
@RequiredArgsConstructor
public class ProjectController {

    @Autowired
    private UserService userService;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtTokenUtil;
    @Autowired
    private UserDetailsService userDetailsService;

    //Controller/api to create a project
    @PostMapping("/create/{username}")
    public ResponseEntity<?> createProject(@RequestBody Project project, @PathVariable String username){
        User user = userService.findByUsername(username);
        if (!userService.usernameExists(user.getUsername())){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Username \"" + username + "\" does not exists!");
        }else if (projectService.projectNameExists(project.getProjectName())){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Project \"" + project.getProjectName() + "\" already exists!");
        }else{
            project.setUser(user);
            projectService.saveProject(project);
        }
        return new ResponseEntity<>("Project " + project.getProjectName() +
                " has been successfully created.", HttpStatus.CREATED);
    }

    //Controller/api to get project information based on project name
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

}
