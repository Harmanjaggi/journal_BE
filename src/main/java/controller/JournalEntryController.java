package controller;

import com.harman.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/_journal")
public class JournalEntryController {
    private Map<Long, JournalEntry> journalEnteries = new HashMap<>();
    @GetMapping
    public List<JournalEntry> getAll() {
        return new ArrayList<>(journalEnteries.values());
    }
    @PostMapping
    public boolean createEnteries(@RequestBody JournalEntry myEntery) {
        journalEnteries.put(myEntery.getId(), myEntery);
        return true;
    }
}
