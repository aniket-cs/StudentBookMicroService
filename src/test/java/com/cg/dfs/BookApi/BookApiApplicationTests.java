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
		Book book = new Book(1, "What Young India Wants", 367.0);
		Book savedBook = repo.save(book);

		assertNotNull(savedBook);

	}


	// Testing to Fetch all Book from db
	@Test
	public void testGetBook(){
		List<Book> books = (List<Book>) repo.findAll();

		Assertions.assertThat(books).size().isGreaterThan(0);

	}

}
