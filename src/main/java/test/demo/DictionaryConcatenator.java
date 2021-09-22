package test.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class DictionaryConcatenator {
    @Autowired
    DictionaryFilter dictionaryFilter;

    public HashSet<String> concatenateDictionary(URL path) {
        List<HashSet<String>> filteredDictionary = dictionaryFilter.filterDictionary(path);
        HashSet<String> lookupDictionarySet = filteredDictionary.get(filteredDictionary.size() - 1);
        filteredDictionary.remove(filteredDictionary.size() - 1);
        HashSet<String> concatedDictionary = new HashSet<>();
        for(int i = 0; i < filteredDictionary.size(); i++) {
            HashSet<String> dictionarySetWithLengthI = filteredDictionary.get(i);
            HashSet<String> complementaryDictionarySet = filteredDictionary.get(filteredDictionary.size() - 1 - i);
            dictionarySetWithLengthI.stream().forEach(x -> {
                 complementaryDictionarySet.stream().forEach(y -> {
                     String s = x + y;
                    if(lookupDictionarySet.contains(s)){
                        concatedDictionary.add(s);
                    }
                 });
            });
        }
        return concatedDictionary;
    }
}
