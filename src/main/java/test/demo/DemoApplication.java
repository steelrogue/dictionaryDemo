package test.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URL;
import java.util.HashSet;

@SpringBootApplication
public class DemoApplication {
	@Autowired
	DictionaryConcatenator dictionaryConcatenator;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
