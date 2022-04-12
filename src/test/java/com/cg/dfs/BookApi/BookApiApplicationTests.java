package com.cg.dfs.BookApi;

import com.cg.dfs.BookApi.model.Book;
import com.cg.dfs.BookApi.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.assertj.core.api.Assertions;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class BookApiApplicationTests {

	@Autowired
	private BookRepository repo;


	// Testing to Save Book into db
	@Test
	public void testSaveBook(){
		Book book1 = new Book(1, "What Young India Wants", 200.0);
		Book book2 = new Book(2,"Do Epic Shit", 349.65);

		Book savedBook1 = repo.save(book1);
		Book savedBook2 = repo.save(book2);

		// Saving status testing
		assertNotNull(savedBook1);
		assertNotNull(savedBook2);

		// Testing of data during save

		// Name testing
		assertEquals("Do Epic Shit", "Do Epic Shit", "Book name should match");

		// Price testing
		assertEquals(349.65, 349.65, "Price should be same");


	}


	// Testing to Fetch all Book from db
	@Test
	public void testGetBook(){
		List<Book> books = (List<Book>) repo.findAll();

		// Size is testing
		Assertions.assertThat(books).size().isEqualTo(2);


		// Testing of data during fetch

		// Name testing
		assertNotEquals("What Young India Wants", "what young india wants", "Book name should not match");

		// Price testing
		assertNotEquals(100.0,200.0, "Price should be different");

	}

}
