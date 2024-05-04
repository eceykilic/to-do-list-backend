package com.workintech.wordapplier.controller;

import com.workintech.wordapplier.entity.Word;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/word")
@CrossOrigin("http://localhost:5173")
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

    //her şeyi getir
    @GetMapping("/")
    public List<Word> findAll(){
        return wordMap.values().stream().toList();
    }

    //silme
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        wordMap.remove(id);
    }

}
