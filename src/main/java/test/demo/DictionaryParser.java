package test.demo;

import org.springframework.stereotype.Component;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Component
public class DictionaryParser {

    /**
     * Parse textfile
     *
     * @param path - URL path of textfile
     * @return List of all words in textfile
     */
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
