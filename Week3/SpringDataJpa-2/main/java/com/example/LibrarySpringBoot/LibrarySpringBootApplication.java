package com.example.LibrarySpringBoot;

import com.example.LibrarySpringBoot.model.Book;
import com.example.LibrarySpringBoot.model.Member;
import com.example.LibrarySpringBoot.repository.MemberRepository;
import com.example.LibrarySpringBoot.service.BookService;
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

	//we do not directly inject the repositories, we interact with services
	@Autowired
	MemberService memberService;

	@Autowired
	BookService bookService;

	public static void main(String[] args) {
		SpringApplication.run(LibrarySpringBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		List<Member> members = memberService.getAllMembers();
//		for(Member m : members){
//			System.out.println(m);
//		}
//
//		Member m = memberService.getOneById(10);
//		System.out.println(m);
//
//		Member newMember = new Member();
//		newMember.setEmail("martina@sky.com");
//		newMember.setPhone_num("07537245367");
//		newMember.setName("Martina");
//
//		Member newm = memberService.saveNewMember(newMember);
//		System.out.println(newm);
//
//		List<Member> members2 = memberService.findMembersByFirstLetterName('J');
//		for (Member m2 : members2){
//			System.out.println(m2);
//		}

//		List<Book> books = bookService.getAllBooks();
//		for (Book b :books){
//			System.out.println(b);
//		}
	}
}
