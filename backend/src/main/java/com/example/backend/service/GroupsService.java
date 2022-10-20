package com.example.backend.service;

import com.example.backend.dao.Groups;

import java.util.List;

public interface GroupsService {

    List<Groups> getAllGroups();
    Groups getGroupById(Integer id);
    Groups addGroup(Groups group);
    Groups updateGroup(Integer groupId, String name);
    void deleteGroup(Integer groupId);
}
