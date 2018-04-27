package com.example.springboot;

import java.io.File;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.*;
import java.util.Scanner;
import java.text.ParseException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
@RestController
@RequestMapping(value = "/wordladder")
public class Worldladdercontrol {
    @RequestMapping(value = "/word1={word1}&word2={word2}",method = RequestMethod.GET)
    public static String app(@PathVariable String word1,@PathVariable String word2) throws Exception
    {
        Scanner input=new Scanner(System.in);//创建一个键盘扫描类对象
        Map word_have_found = new HashMap();
        Map word_ladder = new HashMap();
        String filePath = "dictionary.txt";
        FileReader in = new FileReader(filePath);
        BufferedReader br=new BufferedReader(in);
        String line="";
        while ((line=br.readLine())!=null) {
            line = line.toLowerCase();
            word_have_found.put(line,false);
            word_ladder.put(line,"");
        }
        word_have_found.put("falsefalse",false);

        Iterator i_it1 = word_have_found.entrySet().iterator();
        Iterator i_it2 = word_ladder.entrySet().iterator();
        if ((!word_have_found.containsKey(word1)) || (!word_have_found.containsKey(word2)))
        {
            return("The two words must be found in the dictionary.");
        }
        else if (word1.length() != word2.length())
        {
            return("The two words must be the same length.");
        }
        else if (word1.equals(word2))
        {
            return("The two words must be different.");
        }
        else {
            Boolean break_loop = false;
            word_ladder.put(word2, word2);
            word_have_found.put(word2, true);         //pish the word_2 to the queue
            //word_have_found[word_1] = false;	 //add the word_1 into the map even if word_1 is not in the dictionary(extra features two)
            Queue<String> queue_ladder = new LinkedList<String>();
            queue_ladder.add(word2);
            int len_word_1;
            len_word_1 = word1.length();
            while (!queue_ladder.isEmpty())         //until the queue is empty
            {
                String first_word;
                first_word = queue_ladder.element();
                int len_first_word;
                len_first_word = first_word.length();
                queue_ladder.remove();
                len_first_word = first_word.length();
                if (len_first_word == len_word_1)//if the len of the word same as the word_1 (extra features one)
                {
                    for (int i = 0; i < first_word.length(); i = i + 1) {
                        for (int j = 0; j < 26; j = j + 1) {
                            String word_copy;
                            word_copy = first_word;
                            char acs = (char) ('a' + j);
                            String s_acs = String.valueOf(acs);
                            StringBuilder sb = new StringBuilder(word_copy);
                            sb.replace(i, i + 1, s_acs);
                            word_copy = sb.toString();
                            if ((word_have_found.containsKey(word_copy)) && (word_have_found.get(word_copy) == word_have_found.get("falsefalse"))) {

                                if (word1.equals(word_copy)) {
                                    break_loop = true;
                                    word_have_found.put(word_copy, true);
                                    word_ladder.put(word_copy, word_ladder.get(first_word) + " " + word_copy);
                                    queue_ladder.add(word_copy);
                                    break;
                                }
                                word_have_found.put(word_copy, true);
                                word_ladder.put(word_copy, word_ladder.get(first_word) + " " + word_copy);
                                queue_ladder.add(word_copy);
                            }
                        }
                        if (break_loop)             //if we find the word_1 then break the looper
                            break;
                    }
                }
                if (break_loop)                     //if we find the word_1 then break the looper
                    break;

            }
            if (break_loop)                         //if we can't find the solution than ouput we can't find
            {
                //cout << "A ladder from " << word_2 << " back to " << word_1 << ":" << endl;
                //cout << word_ladder[word_1] << endl;

                return (String) word_ladder.get(word1);
            } else
                //cout << "No word ladder found from azure back to metal." << endl;
                return "No word ladder found from azure back to metal.\n";


        }
    }

    public static String test(String word1,String word2) throws Exception
    {
        Scanner input=new Scanner(System.in);//创建一个键盘扫描类对象
        Map word_have_found = new HashMap();
        Map word_ladder = new HashMap();
        String filePath = "dictionary.txt";
        FileReader in = new FileReader(filePath);
        BufferedReader br=new BufferedReader(in);
        String line="";
        while ((line=br.readLine())!=null) {
            line = line.toLowerCase();
            word_have_found.put(line,false);
            word_ladder.put(line,"");
        }
        word_have_found.put("falsefalse",false);

        Iterator i_it1 = word_have_found.entrySet().iterator();
        Iterator i_it2 = word_ladder.entrySet().iterator();
        if ((!word_have_found.containsKey(word1)) || (!word_have_found.containsKey(word2)))
        {
            return("The two words must be found in the dictionary.");
        }
        else if (word1.length() != word2.length())
        {
            return("The two words must be the same length.");
        }
        else if (word1.equals(word2))
        {
            return("The two words must be different.");
        }
        else {
            Boolean break_loop = false;
            word_ladder.put(word2, word2);
            word_have_found.put(word2, true);         //pish the word_2 to the queue
            //word_have_found[word_1] = false;	 //add the word_1 into the map even if word_1 is not in the dictionary(extra features two)
            Queue<String> queue_ladder = new LinkedList<String>();
            queue_ladder.add(word2);
            int len_word_1;
            len_word_1 = word1.length();
            while (!queue_ladder.isEmpty())         //until the queue is empty
            {
                String first_word;
                first_word = queue_ladder.element();
                int len_first_word;
                len_first_word = first_word.length();
                queue_ladder.remove();
                len_first_word = first_word.length();
                if (len_first_word == len_word_1)//if the len of the word same as the word_1 (extra features one)
                {
                    for (int i = 0; i < first_word.length(); i = i + 1) {
                        for (int j = 0; j < 26; j = j + 1) {
                            String word_copy;
                            word_copy = first_word;
                            char acs = (char) ('a' + j);
                            String s_acs = String.valueOf(acs);
                            StringBuilder sb = new StringBuilder(word_copy);
                            sb.replace(i, i + 1, s_acs);
                            word_copy = sb.toString();
                            if ((word_have_found.containsKey(word_copy)) && (word_have_found.get(word_copy) == word_have_found.get("falsefalse"))) {

                                if (word1.equals(word_copy)) {
                                    break_loop = true;
                                    word_have_found.put(word_copy, true);
                                    word_ladder.put(word_copy, word_ladder.get(first_word) + " " + word_copy);
                                    queue_ladder.add(word_copy);
                                    break;
                                }
                                word_have_found.put(word_copy, true);
                                word_ladder.put(word_copy, word_ladder.get(first_word) + " " + word_copy);
                                queue_ladder.add(word_copy);
                            }
                        }
                        if (break_loop)             //if we find the word_1 then break the looper
                            break;
                    }
                }
                if (break_loop)                     //if we find the word_1 then break the looper
                    break;

            }
            if (break_loop)                         //if we can't find the solution than ouput we can't find
            {
                //cout << "A ladder from " << word_2 << " back to " << word_1 << ":" << endl;
                //cout << word_ladder[word_1] << endl;

                return (String) word_ladder.get(word1);
            } else
                //cout << "No word ladder found from azure back to metal." << endl;
                return "No word ladder found from azure back to metal.\n";


        }
    }

}
