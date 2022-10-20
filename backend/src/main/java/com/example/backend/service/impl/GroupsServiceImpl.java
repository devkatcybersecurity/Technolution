package com.example.backend.service.impl;

import com.example.backend.dao.Groups;
import com.example.backend.exception.ApiError;
import com.example.backend.exception.CustomException;
import com.example.backend.repository.GroupsRepository;
import com.example.backend.service.GroupsService;
import org.springframework.beans.factory.annotation.Autowired;
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
                () -> new CustomException(ApiError.GROUP_NOT_FOUND.getApiError(), ApiError.GROUP_NOT_FOUND.getErrorMessage()));
        return groups;
    }

    @Override
    public Groups addGroup(Groups group) {
        try{
            return groupsRepository.save(group);
        } catch (Exception e) {
            throw new CustomException(ApiError.GROUP_NOT_FOUND.getApiError(), ApiError.GROUP_NOT_FOUND.getErrorMessage());
        }    
    }
    

    @Override
    public Groups updateGroup(Integer groupId, String name) {
        
        groupsRepository.findById(groupId).orElseThrow(() -> new CustomException(ApiError.GROUP_NOT_FOUND.getApiError(), ApiError.GROUP_NOT_FOUND.getErrorMessage()));
        return groupsRepository.save(Groups.builder().groupId(groupId).name(name).build());
         
    }

    @Override
    public void deleteGroup(Integer groupId) {
        
        try{
            groupsRepository.deleteById(groupId);
        } catch (Exception e) {
            throw new CustomException(ApiError.GROUP_NOT_FOUND.getApiError(), ApiError.GROUP_NOT_FOUND.getErrorMessage());
        }

    }
}

