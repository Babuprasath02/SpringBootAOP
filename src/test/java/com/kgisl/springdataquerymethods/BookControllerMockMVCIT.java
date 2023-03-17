// package com.kgisl.springdataquerymethods;

// import java.util.ArrayList;
// import java.util.List;

// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.http.MediaType;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

// import static org.mockito.BDDMockito.given;
// import static org.mockito.Mockito.when;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// import com.fasterxml.jackson.databind.ObjectMapper;
// import com.kgisl.springdataquerymethods.controller.BookController;
// import com.kgisl.springdataquerymethods.model.Book;
// import com.kgisl.springdataquerymethods.service.BookService;



// @WebMvcTest(value = BookController.class)
// public class BookControllerMockMVCIT {
//     @Autowired
//     private MockMvc mockMvc;
//     @MockBean
//     private BookService bookService;
//     public Book book1 = new BookBuilder().id(1L).build();
//     public Book book2 = new BookBuilder().id(2L).name("Book 2").build();

//     @Test
//     public void getAll() throws Exception {
//         List<Book> alist1 = new ArrayList<Book>();
//         alist1.add(book1);
//         given(bookService.getBooks()).willReturn(alist1);
//         mockMvc.perform(get("/api/books/").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
//                 .andExpect(content().json("[{'id': 1}]"));
//     }
//     @Test
//     public void getOne() throws Exception {
//         Long id = 2L;
//         // List<Book> alist1 = new ArrayList<Book>();
//         // alist1.add(book1);
//         given(bookService.findByBookId(id)).willReturn(book2);
//         mockMvc.perform(get("/api/books/2").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
//                 .andExpect(content().json("{'id': 2}"));
//     }
//     @Test
//     public void update() throws Exception {
//         Long id = 2L;
//         List<Book> alist1 = new ArrayList<Book>();
//         alist1.add(book1);
//         when(bookService.updateBook(id,book2)).thenReturn(book2);
//         mockMvc.perform(
//             MockMvcRequestBuilders.put("/api/books/"+id).contentType(MediaType.APPLICATION_JSON).content(asJsonString(book2)))
//                 .andExpect(status().isOk());
//     }

//     @Test
//     public void postmapping() throws Exception {
//         List<Book> alist1 = new ArrayList<Book>();
//         alist1.add(book1);
//         when(bookService.createBook(book1)).thenReturn(book1);
//         mockMvc.perform(
//                 post("/api/books/").contentType(MediaType.APPLICATION_JSON).content(asJsonString(book1)))
//                 .andExpect(status().isCreated());
//         // verify(accountService, times(1)).find(acc.getAccountId());
//         // verify(accountService, times(1)).save(acc);
//         // verifyNoMoreInteractions(accountService);
//     }

//     @Test
//     public void deleteByID() throws Exception {
//         List<Book> alist = new ArrayList<Book>();
//         alist.add(book1);
//         when(bookService.findByBookId(book1.getId())).thenReturn(book1);
//         mockMvc.perform(delete("/api/books/1", book1.getId())).andExpect(status().is2xxSuccessful());
//         // verify(eventService, times(1)).find(currentevent.getId());
//         // verify(bookService, times(1)).deleteBookById(book1.getId());
//         // verifyNoMoreInteractions(bookService);
//     }

//     public static String asJsonString(final Object obj) {
//         try {
//             final ObjectMapper mapper = new ObjectMapper();
//             return mapper.writeValueAsString(obj);
//         } catch (Exception e) {
//             throw new RuntimeException(e);
//         }
//     }
// }