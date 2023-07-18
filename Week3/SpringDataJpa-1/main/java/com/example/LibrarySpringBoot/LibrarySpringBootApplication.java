package com.example.LibrarySpringBoot;

import com.example.LibrarySpringBoot.model.Member;
import com.example.LibrarySpringBoot.repository.MemberRepository;
import com.example.LibrarySpringBoot.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class LibrarySpringBootApplication implements CommandLineRunner {

	@Autowired
	MemberService memberService;

	public static void main(String[] args) {
		SpringApplication.run(LibrarySpringBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Member> members = memberService.getAllMembers();
		for(Member m : members){
			System.out.println(m);
		}

		Member m = memberService.getOneById(10);
		System.out.println(m);

		Member newMember = new Member();
		newMember.setEmail("martina@sky.com");
		newMember.setPhone_num("07537245367");
		newMember.setName("Martina");

		Member newm = memberService.saveNewMember(newMember);
		System.out.println(newm);

		List<Member> members2 = memberService.findMembersByFirstLetterName('J');
		for (Member m2 : members2){
			System.out.println(m2);
		}
	}
}
