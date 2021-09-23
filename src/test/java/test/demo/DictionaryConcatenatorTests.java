package test.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URL;
import java.util.HashSet;

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

    @Test
    void testOptimized() {
        URL url = getClass().getClassLoader().getResource("wordlist.txt");
        HashSet<String> result = dictionaryConcatenator.concatenateDictionaryOptimized(url);
        assertTrue(result != null);
        assertTrue(result.size() != 0);
        System.out.println("Result size is " + result.size());
    }

    @Test
    void miniTestOptimized() {
        URL url = getClass().getClassLoader().getResource("miniwordlist.txt");
        HashSet<String> result = dictionaryConcatenator.concatenateDictionaryOptimized(url);
        assertTrue(result != null);
        assertTrue(result.size() != 0);
        System.out.println("Result size is " + result.size());
    }

    @Test
    void testOptimized2() {
        URL url = getClass().getClassLoader().getResource("wordlist.txt");
        HashSet<DictionaryObject> result = dictionaryConcatenator.concatenateDictionaryOptimized2(url);
        assertTrue(result != null);
        assertTrue(result.size() != 0);
        result.forEach(x-> System.out.println(x.toString()));
        System.out.println("Result size is " + result.size());
    }

    @Test
    void miniTestOptimized2() {
        URL url = getClass().getClassLoader().getResource("miniwordlist.txt");
        HashSet<DictionaryObject> result = dictionaryConcatenator.concatenateDictionaryOptimized2(url);
        assertTrue(result != null);
        assertTrue(result.size() != 0);
        result.forEach(x-> System.out.println(x.toString()));
        System.out.println("Result size is " + result.size());
    }
}
