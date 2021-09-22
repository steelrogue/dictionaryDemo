package test.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URL;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class DictionaryFilterTests {
    @Autowired
    DictionaryFilter dictionaryFilter;

    @Test
    void test() {
        URL url = getClass().getClassLoader().getResource("wordlist.txt");
        List<HashSet<String>> result = dictionaryFilter.filterDictionary(url);
        assertTrue(result != null);
        assertTrue(result.size() != 0);
        assertTrue(result.get(0).size() != 0);
        for (HashSet<String> set : result) {
            System.out.println("Result size is " + set.size());
        }
    }

    @Test
    void miniTest() {
        URL url = getClass().getClassLoader().getResource("miniwordlist.txt");
        List<HashSet<String>> result = dictionaryFilter.filterDictionary(url);
        assertTrue(result != null);
        assertTrue(result.size() != 0);
        assertTrue(result.get(0).size() != 0);
        for (HashSet<String> set : result) {
            System.out.println("Result size is " + set.size());
        }
    }
}
