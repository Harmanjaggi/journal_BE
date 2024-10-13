package controller;

import com.harman.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {
    @GetMapping
    public List<JournalEntry> getAll() {
        return null;
    }
    @PostMapping
    public boolean createEnteries(@RequestBody JournalEntry myEntery) {
        return true;
    }
    @DeleteMapping ("id/{myId}")
    public JournalEntry deleteJournalEntryById(@PathVariable Long myld) {
        return null;
    }
    @PutMapping ("/id/{id}")
    public JournalEntry updateJournalById(@PathVariable Long id, @RequestBody JournalEntry myEntry) {
        return null;
    }
}
