package com.example.backend.service;

import com.example.backend.dao.Groups;

import javax.swing.*;
import java.util.List;

public interface GroupsService {

    List<Groups> getAllGroups();
    Groups getGroupById(Integer id);
    Groups addGroup(Groups groups);
    Groups updateGroup(Integer groupId, String name);
    void deleteGroup(Integer groupId);
}
