package wm2.second.assignment.library.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@Entity
@Document(collection = "Comment")
public class CommentEntity {
    @Id
    private String id;

    private String bookExtId;

    private String commentAuthorName;

    private String commentContent;

    public String getId() {
        return id;
    }


    public String getBookExtId() {
        return bookExtId;
    }

    public void setBookExtId(String bookExtId) {
        this.bookExtId = bookExtId;
    }

    public String getCommentAuthorName() {
        return commentAuthorName;
    }

    public void setCommentAuthorName(String commentAuthorName) {
        this.commentAuthorName = commentAuthorName;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    @Override
    public String toString() {
        return "CommentEntity{" +
                "id='" + id + '\'' +
                ", bookExtId='" + bookExtId + '\'' +
                ", commentAuthorName='" + commentAuthorName + '\'' +
                ", commentContent='" + commentContent + '\'' +
                '}';
    }
}
