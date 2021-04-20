package wm2.second.assignment.library.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import wm2.second.assignment.library.model.entity.CommentEntity;

import java.io.Serializable;
import java.util.List;


@NoArgsConstructor
@Data
public class CommentModel implements Serializable {
    private String id;
    private String authorName;
    private String content;

    private List<CommentModel> replies;


    public CommentModel(CommentEntity entity) {
        this.id = entity.getId();
        this.authorName = entity.getCommentAuthorName();
        this.content = entity.getCommentContent();
    }

}
