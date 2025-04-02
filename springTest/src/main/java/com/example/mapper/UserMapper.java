package com.example.mapper;

import com.example.model.User;
import java.util.List;

public interface UserMapper {
    User findById(Long id);
    void insert(User user);
    void update(User user);
    void delete(Long id);
    List<User> findAll();
}