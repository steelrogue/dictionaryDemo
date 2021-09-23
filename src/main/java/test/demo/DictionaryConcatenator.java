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
    DictionaryParser dictionaryParser;

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

    public HashSet<String> concatenateDictionaryOptimized(URL path) {
        List<String> dictionary = dictionaryParser.parseDictionary(path);

        List<String> lookupDictionarySet = dictionary.stream().filter(x -> x.length() == 6).collect(Collectors.toCollection(ArrayList::new));
        HashSet<String> subsetDictionary = dictionary.stream().filter(x -> x.length() <= 5).collect(Collectors.toCollection(HashSet::new));

        HashSet<String> result = lookupDictionarySet.stream().filter(x -> {
            for(int i = 0; i < 5; i++) {
                if (subsetDictionary.contains(x.substring(0,i+1)) && subsetDictionary.contains(x.substring(i+1,6)))
                    return true;
            }
            return false;
        }).collect(Collectors.toCollection(HashSet::new));
        return result;
    }

    public HashSet<DictionaryObject> concatenateDictionaryOptimized2(URL path) {
        List<String> dictionary = dictionaryParser.parseDictionary(path);

        List<String> lookupDictionarySet = dictionary.stream().filter(x -> x.length() == 6).collect(Collectors.toCollection(ArrayList::new));
        HashSet<String> subsetDictionary = dictionary.stream().filter(x -> x.length() <= 5).collect(Collectors.toCollection(HashSet::new));

        HashSet<DictionaryObject> result = lookupDictionarySet.stream().flatMap(x -> {
            List<DictionaryObject> list = new ArrayList<>();
            for(int i = 0; i < 5; i++) {
                list.add(new DictionaryObject(x, x.substring(0,i+1), x.substring(i+1,6)));
            }
            return list.stream();
        }).filter(x -> subsetDictionary.contains(x.getSubString1()) && subsetDictionary.contains(x.getSubString2())).collect(Collectors.toCollection(HashSet::new));
        return result;
    }
}
