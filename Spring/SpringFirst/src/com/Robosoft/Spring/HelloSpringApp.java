package com.Robosoft.Spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

    public HelloSpringApp() {
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Coach theCoach = (Coach)context.getBean("myCoach", Coach.class);
        System.out.println(theCoach.getDailyWorkout());
        context.close();
    }
}
