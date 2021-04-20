package wm2.second.assignment.library.service;

import wm2.second.assignment.library.model.dto.CommentModel;
import wm2.second.assignment.library.model.entity.CommentEntity;

import java.util.List;

public interface CommentService {

    List<CommentModel> getCommentByBookExtId(long id);

}
