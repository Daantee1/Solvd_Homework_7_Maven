package org.solvd;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class App {
    public static void main(String[] args) throws IOException {


        File fileNew = new File("src/resources/new.txt");
        File fileResults = new File("src/resources/results.txt");

        Map<String, Integer> wordCountMapOfFileNew = new HashMap<>();

        List<String> linesOfFileNew = FileUtils.readLines(fileNew, "UTF-8");


        for (String line : linesOfFileNew) {
            String[] words = StringUtils.split(line, " \n ,");

            for (String word :words){
                word = word.toLowerCase();
                wordCountMapOfFileNew.put(word, wordCountMapOfFileNew.getOrDefault(word,0) +1);

            }
        }
        FileUtils.writeLines(fileResults, "UTF-8", wordCountMapOfFileNew.entrySet());

    }





}