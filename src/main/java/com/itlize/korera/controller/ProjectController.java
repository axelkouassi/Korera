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
}
