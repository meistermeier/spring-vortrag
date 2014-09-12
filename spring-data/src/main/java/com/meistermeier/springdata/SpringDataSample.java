package com.meistermeier.springdata;

import com.meistermeier.springdata.domain.User;
import com.meistermeier.springdata.domain.UserRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringDataSample {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(DataContext.class);

        UserRepository userRepository = context.getBean(UserRepository.class);

        userRepository.save(createUser());

        Iterable<User> allUser = userRepository.findAll();
        System.out.println(allUser);

        System.out.println(userRepository.findByName("Hans"));
        System.out.println(userRepository.findByNameAndAge("Hans", 39));
        System.out.println(userRepository.findByGender("Hans"));
    }

    private static User createUser() {
        User user = new User();
        user.setName("Hans");
        user.setProfession("IT Guy");
        user.setAge(39);
        return user;
    }
}
