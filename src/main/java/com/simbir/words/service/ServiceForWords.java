package com.simbir.words.service;

import com.simbir.words.database.entity.WordsInDb;
import com.simbir.words.database.repository.ItemRepository;
import com.simbir.words.exception.IncorrectUrlException;
import com.simbir.words.to.GetUniqueWords;
import lombok.NoArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

@NoArgsConstructor
@Service
public class ServiceForWords implements Words {
    @Autowired
    ItemRepository itemRepository;

    private static final Logger log = Logger.getLogger(ServiceForWords.class.getName());
    private final static char[] DELIMITERS = {' ', ',', '.', '!', '?', '"', ';', ':', '[', ']', '(', ')', '\n', '\r', '\t'};


    @Override
    public TreeMap<String, Integer> getUniqueWordFromUrl(String url) {
        String textBody = getResponse(url);
        log.info("INFO we received the data and started analyzing this.");
        TreeMap<String, Integer> answer = GetUniqueWords.main(DELIMITERS, textBody);
        log.info("INFO The end analyzing this data.");

        return answer;
    }

    /**
     * Получаем текст со страницы сайта
     *
     * @param url {String} адрес сайта
     * @return данные с сайта в виде текста
     */
    public static String getResponse(String url) {
        String response = null;
        Document getSite = null;
        try {
            System.out.println(" response " + response);
            getSite = Jsoup.connect(url).get();
            log.info("INFO We made a get request and received the data with " + url);

        } catch (IOException e) {
            log.log(Level.WARNING, "No have connection internet", e);

        } catch (IllegalArgumentException ex) {
            log.log(Level.WARNING, " Bad url for request  ", ex.getMessage());
            throw new IncorrectUrlException(
                    "Bad url for request " + ex.getMessage()
            );
        }
        if (getSite != null) {
            response = Jsoup.parse(getSite.html()).body().text();
        }

        return response;
    }

    public boolean save(TreeMap<String, Integer> words) {
        System.out.println("ServiceForWords ");
        WordsInDb foo = new WordsInDb(words);
        itemRepository.insert(foo);
        return true;
        };

    }


