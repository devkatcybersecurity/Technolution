package com.example.backend.service.impl;

import com.example.backend.dao.Groups;
import com.example.backend.exception.ApiError;
import com.example.backend.exception.CustomException;
import com.example.backend.repository.GroupsRepository;
import com.example.backend.service.GroupsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupsServiceImpl implements GroupsService {
    private final GroupsRepository groupsRepository;


    @Autowired
    public GroupsServiceImpl(GroupsRepository groupsRepository) {
        this.groupsRepository = groupsRepository;
    }

    @Override
    public List<Groups> getAllGroups() {
        return groupsRepository.findAll();
    }

    @Override
    public Groups getGroupById(Integer id) {
        Groups groups = groupsRepository.findById(id).orElseThrow(
                () -> new CustomException("Group with id " + id + " not found", HttpStatus.NOT_FOUND));
        return groups;
    }

    @Override
    public Groups addGroup(Groups groups) {

            return groupsRepository.save(Groups.builder().name(groups.getName()).build());

    }
    

    @Override
    public Groups updateGroup(Integer groupId, String name) {
        
        groupsRepository.findById(groupId).orElseThrow(() -> new CustomException("Group with id " + groupId + " not found", HttpStatus.NOT_FOUND));
        return groupsRepository.save(Groups.builder().groupId(groupId).name(name).build());
         
    }

    @Override
    public void deleteGroup(Integer groupId) {
        
        try{
            groupsRepository.deleteById(groupId);
        } catch (Exception e) {
            throw new CustomException("Group with id " + groupId + " not found", HttpStatus.NOT_FOUND);
        }

    }
}

