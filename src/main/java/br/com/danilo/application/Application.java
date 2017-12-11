package br.com.danilo.application;

import br.com.danilo.application.entities.User;
import br.com.danilo.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by danilopereira on 13/11/17.
 */
@SpringBootApplication
public class Application implements CommandLineRunner{

    @Autowired
    DataSource dataSource;

    @Autowired
    UserRepository userRepository;

    public static void main(String [] args){
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("DATASOURCE = "+ dataSource);

        long start = System.currentTimeMillis();
        List<User> list = userRepository.findAll();
        long end = System.currentTimeMillis();
        list.forEach(user -> System.out.println(user.toString()));
        System.out.println("Time: "+ (end - start) + "ms");
    }
}
