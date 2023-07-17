package com.example.catsAndOwners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Owner {
    @Value("Martina")
    private String name;


    private Cat cat;

    @Autowired
    public Owner(Cat cat){
        this.cat = cat;
    }

    //composition
    // dependency - constructor injection
//    public Owner(String name, Cat cat){
//        this.name = name;
//        this.cat = cat;
//    }


    //setter injection
    // @Autowired
//    public void setCat(Cat c){
//        this.cat = c;
//    }
//
    public void introduction(){
        System.out.println("Hello, my name is " + name + " and I have a  cat called "
                + cat.getName() + " that makes this noise: " + cat.makeNoise() );
    }
}
