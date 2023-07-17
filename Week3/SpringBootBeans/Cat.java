package com.example.catsAndOwners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Cat {
    @Value("Agnes")
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String newName){
        this.name = newName;
    }

    public String makeNoise(){
        return "meow meow";
    }

}
