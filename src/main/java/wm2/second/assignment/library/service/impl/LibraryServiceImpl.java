package wm2.second.assignment.library.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wm2.second.assignment.library.model.dto.BookModel;
import wm2.second.assignment.library.model.dto.CommentModel;
import wm2.second.assignment.library.model.entity.BookEntity;
import wm2.second.assignment.library.model.entity.CommentEntity;
import wm2.second.assignment.library.repository.BookRepository;
import wm2.second.assignment.library.repository.UserRepository;
import wm2.second.assignment.library.service.CommentService;
import wm2.second.assignment.library.service.LibraryService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class LibraryServiceImpl implements LibraryService {

    protected static final Logger logger = LoggerFactory.getLogger(LibraryServiceImpl.class);

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CommentService commentService;

    @Override
    public Iterable getAllBooks() {


        Iterable book = bookRepository.findAll(); // finding all

        if(book == null ) return null;
        else
            return book;
    }


    @Override
    public List<BookEntity> getBookByName(String bookName){

        List<BookEntity> book =  bookRepository.findAllByBookname(bookName);

        if(book == null) return null;
        else return book;
    }

    @Override
    public List<BookEntity> getBookByAuthor(String bookAuthor) {

        List<BookEntity> book =  bookRepository.findAllByBookauthor(bookAuthor);

        if(book == null) return null;
        else return book;
    }

    @Override
    public List<BookEntity> getBookByGenre(String bookGenre) {

        List<BookEntity> book =  bookRepository.findAllByGenre(bookGenre);

        if(book == null) return null;
        else return book;
    }

    @Override
    public List<BookEntity> getBookByDate(String date) {

        List<BookEntity> book =  bookRepository.findAllByDate(date);

        if(book == null) return null;
        else return book;
    }

    @Override
    public List<BookEntity> getBookByAvailable() {

        List<BookEntity> book =  bookRepository.findAllByAvailable(1);

        if(book == null) return null;
        else return book;
    }



    @Override
    public BookModel getBookById(Long bookId){
        Optional<BookEntity> book = bookRepository.findById(bookId);
// if there's content make model, set comments, return model
        if(book.isPresent()){
            BookModel bookModel = new BookModel(book.get());

            bookModel.setComments(commentService.getCommentByBookExtId(bookId));
            System.out.println(bookModel.toString());
            return bookModel;
        }
        return null;
    }

}