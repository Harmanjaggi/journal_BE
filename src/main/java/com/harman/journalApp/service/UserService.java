package com.harman.journalApp.service;

import com.harman.journalApp.entity.JournalEntry;
import com.harman.journalApp.entity.User;
import com.harman.journalApp.repository.JournalEntryRepository;
import com.harman.journalApp.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void saveEntry(User user) {
        userRepository.save(user);
    }
    public List<User> getAll() {
        return userRepository.findAll();
    }
    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }
    public void deleteById(ObjectId id) {
        userRepository.deleteById(id);
    }
}
