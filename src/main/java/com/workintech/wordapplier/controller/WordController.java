package com.workintech.wordapplier.controller;

import com.workintech.wordapplier.entity.Word;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/word")
@CrossOrigin("https://to-do-list-lagg.vercel.app")
public class WordController {

    private Map<Long, Word> wordMap;

    @PostConstruct
    public void init() {
        wordMap = new HashMap<>();
    }


    //map post data save
    @PostMapping("/")
    public Word save(@RequestBody Word word){
        wordMap.put(word.getId(), word);
        return word;
    }

    //get all info
    @GetMapping("/")
    public List<Word> findAll(){
        return wordMap.values().stream().toList();
    }

    //delete
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        wordMap.remove(id);
    }

}
