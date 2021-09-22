package test.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DictionaryFilter {
    @Autowired
    DictionaryParser dictionaryParser;

    public List<HashSet<String>> filterDictionary(URL path) {
        List<String> dictionary = dictionaryParser.parseDictionary(path);
        List<HashSet<String>> filteredDictionarySets = new ArrayList<>();
        for(int i = 1; i<=6; i++) {
            final int length = i;
            filteredDictionarySets.add(
                    dictionary.stream().filter(x -> x.length() == length).collect(Collectors.toCollection(HashSet::new))
            );
        }
        return filteredDictionarySets;
    }
}
