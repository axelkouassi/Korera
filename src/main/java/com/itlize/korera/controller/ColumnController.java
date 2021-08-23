package com.itlize.korera.controller;

import com.itlize.korera.model.Column;
import com.itlize.korera.model.ColumnType;
import com.itlize.korera.model.Resource;
import com.itlize.korera.service.*;
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
@RequestMapping("/column")
@RequiredArgsConstructor
public class ColumnController {

    @Autowired
    private UserService userService;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private ResourceService resourceService;
    @Autowired
    private ColumnService columnService;
    @Autowired
    private ProjectResourceService projectResourceService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtTokenUtil;
    @Autowired
    private UserDetailsService userDetailsService;

    //Controller/api to create a column
    @PostMapping("/create")
    public ResponseEntity<?> createColumn(@RequestBody Column column){
        columnService.saveColumn(column);
        return new ResponseEntity<>(column, HttpStatus.CREATED);
    }

    //Controller/api to get column information based on content
    @GetMapping("/content/{content}")
    public ResponseEntity<?> getByContent(@PathVariable String content){
        if (!columnService.columnContentExists(content)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Column content \""
                    + columnService.findByContent(content).getContent()
                    + "\" does not exists!");
        }
        return ResponseEntity.ok().body(columnService.findByContent(content));
    }

    //Controller/api to get column information based on column id
    @GetMapping("/id/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        if (!columnService.columnIdExists(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Column with id \""
                    + columnService.findById(id).getColumnId()
                    + "\" does not exists!");
        }
        return ResponseEntity.ok().body(columnService.findById(id));
    }

    //Controller/api to get column information based on type
    @GetMapping("/type/{type}")
    public ResponseEntity<?> getByType(@PathVariable ColumnType type){
        if (!columnService.columnTypeExists(type)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Column type \""
                    + type + "\" does not exists!");
        }
        return ResponseEntity.ok().body(columnService.findColumnsByType(type));
    }

    //Controller/api to get all the columns based on resource name
    @GetMapping("/getcolumns/{resourcename}")
    public ResponseEntity<?> getColumnsByResourceName(@PathVariable String resourcename){
        return ResponseEntity.ok().body(columnService.getColumsByResource(resourcename));
    }

    //Controller/api to get all the columns
    @GetMapping("/getcolumns")
    public ResponseEntity<?> getColumns(){
        return ResponseEntity.ok().body(columnService.getColumns());
    }

    //Controller/api to update column content
    @PostMapping("/update/content/{content}/{newcontent}")
    public ResponseEntity<?> updateContent(@PathVariable String content, @PathVariable String newcontent){
        Column column = columnService.findByContent(content);
        if (!columnService.columnContentExists(content)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Column content  \"" + content
                    + "\" does not exists!");
        }
        columnService.updateContent(column,newcontent);
        return new ResponseEntity<>(column, HttpStatus.OK);
    }

    //Controller/api to update column's type
    @PostMapping("/update/type/{content}/{newtype}")
    public ResponseEntity<?> updateType(@PathVariable String content, @PathVariable ColumnType newtype){
        Column column = columnService.findByContent(content);
        if (!columnService.columnContentExists(content)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Column content  \"" + content
                    + "\" does not exists!");
        }
        columnService.updateType(column,newtype);
        return new ResponseEntity<>(column, HttpStatus.OK);
    }

    //Controller/api to update resource
    @PostMapping("/update/resource/{content}/{resourcename}")
    public ResponseEntity<?> updateResource(@PathVariable String content, @PathVariable String resourcename){
        Column column =  columnService.findByContent(content);
        Resource resource =  resourceService.findByName(resourcename);
        if(!columnService.columnContentExists(content)){
            throw new NullPointerException("Column with content: " + content
                    + " was not found in the database.");
        }else if(!resourceService.resourceNameExists(resourcename)){
            throw new NullPointerException("Resource with name: " +
                    resourcename + " was not found in the database.");
        }
        return new ResponseEntity<>(columnService.updateResource(content, resourcename), HttpStatus.OK);
    }

    //Controller/api to delete column based on content
    @GetMapping("/delete/content/{content}")
    public ResponseEntity<?> deleteByContent(@PathVariable String content){
        if (!columnService.columnContentExists(content)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Column with  \""
                    + content + "\" does not exists!");
        }
        columnService.deleteByContent(content);
        return ResponseEntity.ok().body("Column with content \"" + content + "\" was successfully deleted.");
    }



    /*

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

    //Controller/api to delete all the resources
    @GetMapping("/delete/resources")
    public ResponseEntity<?> deleteResources(){
        resourceService.deleteResources();
        return ResponseEntity.ok().body("All resources have been successfully deleted.");
    }




   */


}
