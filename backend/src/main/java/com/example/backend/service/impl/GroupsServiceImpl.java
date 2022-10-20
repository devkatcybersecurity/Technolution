package com.example.backend.service.impl;

import com.example.backend.repository.GroupsRepository;
import com.example.backend.service.GroupsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupsServiceImpl implements GroupsService {
    private final GroupsRepository groupsRepository;


    @Autowired
    public GroupsServiceImpl(GroupsRepository groupsRepository) {
        this.groupsRepository = groupsRepository;
    }
}

