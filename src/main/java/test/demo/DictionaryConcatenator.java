package test.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DictionaryConcatenator {

    @Autowired
    DictionaryParser dictionaryParser;

    /**
     * Look for all six letter words which are composed of two concatenated smaller words
     *
     * @param path - URL path of textfile
     * @return Set of all unique six letter words
     */
    public HashSet<String> concatenateDictionaryUniqueSet(URL path) {
        List<String> dictionary = dictionaryParser.parseDictionary(path);

        // Get a list of all strings in dictionary with six letters
        List<String> lookupDictionarySet = dictionary.stream().filter(x -> x.length() == 6).collect(Collectors.toCollection(ArrayList::new));

        // Get a list of all strings in dictionary with less than six letters
        HashSet<String> subsetDictionary = dictionary.stream().filter(x -> x.length() <= 5).collect(Collectors.toCollection(HashSet::new));

        // Filter out all six letter words which are not composed of two concatenated smaller words
        return lookupDictionarySet.stream().filter(x -> {
            // Loop over all possible substring pairs for String x
            for (int i = 0; i < 5; i++) {
                if (subsetDictionary.contains(x.substring(0, i + 1)) && subsetDictionary.contains(x.substring(i + 1, 6)))
                    return true;
            }
            return false;
        }).collect(Collectors.toCollection(HashSet::new));
    }

    /**
     * Look for all six letter words which are composed of two concatenated smaller words
     *
     * @param path - URL path of textfile
     * @return Set of all unique six letter words and substring pairs
     */
    public HashSet<DictionaryObject> concatenateDictionaryObjectSet(URL path) {
        List<String> dictionary = dictionaryParser.parseDictionary(path);

        // Get a list of all strings in dictionary with six letters
        List<String> lookupDictionarySet = dictionary.stream().filter(x -> x.length() == 6).collect(Collectors.toCollection(ArrayList::new));

        // Get a list of all strings in dictionary with less than six letters
        HashSet<String> subsetDictionary = dictionary.stream().filter(x -> x.length() <= 5).collect(Collectors.toCollection(HashSet::new));

        // FlatMap: get a stream of all substring pairs of all six letter strings
        // Filter: Filter out all six letter words which are not composed of two concatenated smaller words
        return lookupDictionarySet.stream().flatMap(x -> {
            List<DictionaryObject> list = new ArrayList<>();
            // Loop over all possible substring pairs for String x
            for (int i = 0; i < 5; i++) {
                list.add(new DictionaryObject(x, x.substring(0, i + 1), x.substring(i + 1, 6)));
            }
            return list.stream();
        }).filter(x -> subsetDictionary.contains(x.getSubString1()) && subsetDictionary.contains(x.getSubString2())).collect(Collectors.toCollection(HashSet::new));
    }
}
