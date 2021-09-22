package test.demo;

import org.springframework.stereotype.Component;

import javax.print.DocFlavor;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Component
public class DictionaryParser {
    public List<String> parseDictionary(URL path) {
        File file = new File(path.getPath());
        List<String> parsedDictionary = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line ="";
            while((line = br.readLine()) != null) {
                parsedDictionary.add(line);
            }
            return parsedDictionary;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
