package com.example.backend.controller;

import com.example.backend.dao.Groups;
import com.example.backend.exception.CustomException;
import com.example.backend.exception.ErrorResponse;
import com.example.backend.service.GroupsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
@PreAuthorize("hasRole('ADMIN')")
public class GroupsController {

    private final GroupsService groupsService;

    @Autowired
    public GroupsController(GroupsService groupsService) {
        this.groupsService = groupsService;
    }

    @GetMapping
    public ResponseEntity<List<Groups>> getAllGroups() {
        return ResponseEntity.ok(groupsService.getAllGroups());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getGroupById(@PathVariable("id") Integer id) {
        try {
            return ResponseEntity.ok(groupsService.getGroupById(id));
        } catch (CustomException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new CustomException(e.getMessage(), HttpStatus.BAD_REQUEST));
            

        }
    }

    @PostMapping
    public ResponseEntity<?> addGroup(@RequestBody Groups group) {
        try {
            return ResponseEntity.status(201).body(groupsService.addGroup(group));
        } catch (CustomException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new CustomException(e.getMessage(), HttpStatus.BAD_REQUEST));
        }
    }

    @PutMapping("/{groupId}")
    public ResponseEntity<?> updateGroup(@PathVariable Integer groupId, @RequestBody Groups group) {
        try{
            return ResponseEntity.status(204).body(groupsService.updateGroup(groupId, group.getName()));
        } catch (CustomException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new CustomException(e.getMessage(), HttpStatus.BAD_REQUEST));
        }
    }

    @DeleteMapping("/{groupId}")
    public ResponseEntity<?> deleteGroup(@PathVariable Integer groupId) {
        try {
            groupsService.deleteGroup(groupId);
            return ResponseEntity.status(204).build();
        } catch (CustomException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new CustomException(e.getMessage(), HttpStatus.BAD_REQUEST));
        }
    }
}
