package com.example.LibrarySpringBoot;

import com.example.LibrarySpringBoot.model.Member;
import com.example.LibrarySpringBoot.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class LibrarySpringBootApplication implements CommandLineRunner {

	@Autowired
	MemberRepository memberRepo;

	public static void main(String[] args) {
		SpringApplication.run(LibrarySpringBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Member> members = memberRepo.getAllMembers();
		for(Member m : members){
			System.out.println(m);
		}

		Member m = memberRepo.getMemberById(1);
		System.out.println(m);

		Member newMember = new Member();
		newMember.setEmail("martina@matrina.com");
		newMember.setMember_id(6);
		newMember.setPhone_num("07537245367");
		newMember.setName("Martina");
		memberRepo.saveNewMember(newMember);
	}
}
