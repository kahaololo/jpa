package ua.pp.kaha;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import javax.crypto.SecretKey;
import java.security.Key;

/**
 * Created by skokhanenko on 17.02.2017.
 */
public class Main {
    static Key key;

    public static void main(String[] args) {
        ApplicationContext context = new FileSystemXmlApplicationContext("src/main/resources/META-INF/applicationContext.xml");

        key = (SecretKey) context.getBean("key");
    }
}
