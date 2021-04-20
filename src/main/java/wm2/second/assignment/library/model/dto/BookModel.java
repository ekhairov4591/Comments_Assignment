package wm2.second.assignment.library.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import wm2.second.assignment.library.model.entity.BookEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Data
@NoArgsConstructor
public class BookModel implements Serializable {
    private Long id;
    private String bookname;
    private String bookauthor;
    private String date;
    private String genre;
    private int available;


    private List<CommentModel> comments;


    public BookModel(BookEntity book){
        this.id = book.getId();
        this.bookname = book.getBookname();
        this.bookauthor = book.getBookauthor();
        this.available = book.getAvailable();
        this.date = book.getDate();
        this.genre = book.getGenre();
    }


    public void setComments(List<CommentModel> comments){
        this.comments = comments;
    }



}
