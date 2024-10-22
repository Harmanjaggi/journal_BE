package com.harman.journalApp.controller;

import com.harman.journalApp.entity.JournalEntry;
import com.harman.journalApp.entity.User;
import com.harman.journalApp.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        List<User> all = userService.getAll();
        if(all != null && !all.isEmpty()) {
            return new ResponseEntity<>(all, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping
    public ResponseEntity<User> createEntry(@RequestBody User myEntery) {
        try {
            userService.saveEntry(myEntery);
            return new ResponseEntity<>(myEntery, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping ("id/{myId}")
    public ResponseEntity<?> deleteUserById(@PathVariable ObjectId myId) {
        userService.deleteById(myId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody String userName) {
        try {
            User userinDb = userService.findByUserName(userName);
            if(userinDb != null) {
                userinDb.setUserName(userinDb.getUserName());
                userinDb.setPassword(userinDb.getPassword());
                userService.saveEntry(userinDb);
            }
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
