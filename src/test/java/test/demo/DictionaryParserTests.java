package test.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URL;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DictionaryParserTests {
    @Autowired
    DictionaryParser dictionaryParser;

    @Test
    void test() {
        URL url = getClass().getClassLoader().getResource("wordlist.txt");
        List<String> result = dictionaryParser.parseDictionary(url);
        assertNotNull(result);
        assertTrue(result.size() != 0);
        System.out.println("Result size is " + result.size());
    }

    @Test
    void miniTest() {
        URL url = getClass().getClassLoader().getResource("wordlist.txt");
        List<String> result = dictionaryParser.parseDictionary(url);
        assertNotNull(result);
        assertTrue(result.size() != 0);
        System.out.println("Result size is " + result.size());
    }
}
