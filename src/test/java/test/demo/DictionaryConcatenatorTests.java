package test.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URL;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class DictionaryConcatenatorTests {
    @Autowired
    DictionaryConcatenator dictionaryConcatenator;

    @Test
    void testUniqueSet() {
        URL url = getClass().getClassLoader().getResource("wordlist.txt");
        HashSet<String> result = dictionaryConcatenator.concatenateDictionaryUniqueSet(url);
        assertNotNull(result);
        assertTrue(result.size() != 0);
        System.out.println("Result size is " + result.size());
    }

    @Test
    void miniTestUniqueSet() {
        URL url = getClass().getClassLoader().getResource("miniwordlist.txt");
        HashSet<String> result = dictionaryConcatenator.concatenateDictionaryUniqueSet(url);
        assertNotNull(result);
        assertTrue(result.size() != 0);
        System.out.println("Result size is " + result.size());
    }

    @Test
    void testDictionaryObjectSet() {
        URL url = getClass().getClassLoader().getResource("wordlist.txt");
        HashSet<DictionaryObject> result = dictionaryConcatenator.concatenateDictionaryObjectSet(url);
        assertNotNull(result);
        assertTrue(result.size() != 0);
        result.forEach(x-> System.out.println(x.toString()));
        System.out.println("Result size is " + result.size());
    }

    @Test
    void miniTestDictionaryObjectSet() {
        URL url = getClass().getClassLoader().getResource("miniwordlist.txt");
        HashSet<DictionaryObject> result = dictionaryConcatenator.concatenateDictionaryObjectSet(url);
        assertNotNull(result);
        assertTrue(result.size() != 0);
        result.forEach(x-> System.out.println(x.toString()));
        System.out.println("Result size is " + result.size());
    }
}
