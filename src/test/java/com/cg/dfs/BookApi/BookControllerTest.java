package com.cg.dfs.BookApi;
import com.cg.dfs.BookApi.controller.BookController;
import com.cg.dfs.BookApi.model.Book;
import com.cg.dfs.BookApi.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(BookController.class)
public class BookControllerTest {

    private MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();
    ObjectWriter objectWriter = objectMapper.writer();

    @Mock
    private BookService bookService;

    @InjectMocks
    @Autowired
    private BookController bookController;

    // Mock init
    @Before
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
    }


    // Creating test data
    Book book1 = new Book(1, "Do Epic Shit", 349.0);
    Book book2 = new Book(2, "Fault in our stars", 200.0);



    // Mock the get all books 200 httpStatus
    @Test
    public void getBooks_success() throws Exception {

        List<Book> books = new ArrayList<>(Arrays.asList(book1, book2));

        Mockito.when(bookService.getBook()).thenReturn(books);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/book/get")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[1].bookName", is("Fault in our stars")));

    }


    // Mock the save book 200 httpStatus
    @Test
    public void saveBooks_success() throws Exception{

        Book bookRecord = Book.builder()
                .bookId(15)
                .bookName("Programming with Java")
                .bookCost(499.0)
                .build();

        Mockito.when(bookService.saveBook(bookRecord)).thenReturn(bookRecord);

        String content = objectWriter.writeValueAsString(bookRecord);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/book/add")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);


        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.bookName", is("Programming with Java")));
    }


    // Mock the save book 400 httpStatus
    @Test
    public void saveBooks_BadRequest() throws Exception{

        Book badRecord = Book.builder()
                .bookId(5)
                .bookName("")
                .bookCost(999.99)
                .build();

        String content = objectWriter.writeValueAsString(badRecord);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/book/add")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);


        mockMvc.perform(mockRequest)
                .andExpect(status().isBadRequest());


    }


}
