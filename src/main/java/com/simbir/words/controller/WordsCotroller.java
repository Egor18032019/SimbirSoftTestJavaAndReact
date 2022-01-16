package com.simbir.words.controller;


import com.simbir.words.links.UserLinks;
import com.simbir.words.service.ServiceForWords;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.TreeMap;


@Tag(name = "Words controller need url site")
@RestController
@RequestMapping("/api/")
public class WordsCotroller {
    @Autowired
    ServiceForWords serviceForWords;
    static final Logger log =
            LoggerFactory.getLogger(WordsCotroller.class);
    @GetMapping(path = UserLinks.GET_WORDS)
    @ResponseBody
    public ResponseEntity<TreeMap<String, Integer>> getMeUniqueWordFromThisSite(
            @RequestParam(value = "url", required = true) String url
    ) {
        log.info("Request for " + url + " .");
        TreeMap<String, Integer> response = serviceForWords.getUniqueWordFromUrl(url);
        return ResponseEntity.ok(response);
    }

    @PostMapping(path = UserLinks.SAVE_WORDS)
    @ResponseBody
    public ResponseEntity<?> saveWordInDB(
            @RequestBody TreeMap<String, Integer> request
    ) {
        log.info("Attempt to save to the database.");
        try {
            if (request != null) {

                System.out.println("WordsInDb ");
                final boolean result = serviceForWords.save(request);
                System.out.println("result " + result);
                log.info("Save to the database.");
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                log.info("Error for attempt to save to the database.");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            log.info("UNPROCESSABLE_ENTITY for attempt to save to the database.");

            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
}
