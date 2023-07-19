package com.example.LibrarySpringBoot.controller;

import com.example.LibrarySpringBoot.model.Member;
import com.example.LibrarySpringBoot.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberController {

    @Autowired
    MemberService memberService;

    @GetMapping("/members")
    public List<Member> getAllMembers(){
        return memberService.getAllMembers();
    }

    @GetMapping("/members/{id}")
    public Member getMemberById(@PathVariable int id){
        return memberService.getOneById(id);
    }

    @PostMapping("/members")
    @ResponseStatus(HttpStatus.CREATED)
    public HttpStatus addMember(@RequestBody Member m){
        Member createdM = memberService.saveNewMember(m);
        if (createdM == null){
            return HttpStatus.BAD_REQUEST;
        }else{
            return HttpStatus.CREATED;
        }
    }


}
