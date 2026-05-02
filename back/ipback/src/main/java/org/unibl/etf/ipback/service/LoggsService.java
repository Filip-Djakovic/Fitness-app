package org.unibl.etf.ipback.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

@Service
public class LoggsService {

    public ArrayList<String> getAllStrings(){
        ArrayList<String> list = new ArrayList<>();

        try {
            File file = new File("loggs.txt");
            BufferedReader inputStream = new BufferedReader(new FileReader(file));
            String line = "";
            while((line = inputStream.readLine())!=null){
                if(!line.isEmpty())
                    list.add(line);
            }
            return list;
        }
        catch (Exception e){
            e.printStackTrace();
            return list;
        }

    }
}
