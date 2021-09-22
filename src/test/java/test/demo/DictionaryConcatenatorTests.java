package test.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URL;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class DictionaryConcatenatorTests {
    @Autowired
    DictionaryConcatenator dictionaryConcatenator;

    @Test
    void test() {
        URL url = getClass().getClassLoader().getResource("wordlist.txt");
        HashSet<String> result = dictionaryConcatenator.concatenateDictionary(url);
        assertTrue(result != null);
        assertTrue(result.size() != 0);
        System.out.println("Result size is " + result.size());
    }

    @Test
    void miniTest() {
        URL url = getClass().getClassLoader().getResource("miniwordlist.txt");
        HashSet<String> result = dictionaryConcatenator.concatenateDictionary(url);
        assertTrue(result != null);
        assertTrue(result.size() != 0);
        System.out.println("Result size is " + result.size());
    }
}
