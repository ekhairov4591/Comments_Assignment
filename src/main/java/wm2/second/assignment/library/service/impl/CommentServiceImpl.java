package wm2.second.assignment.library.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wm2.second.assignment.library.model.dto.CommentModel;
import wm2.second.assignment.library.model.entity.CommentEntity;
import wm2.second.assignment.library.repository.CommentRepository;
import wm2.second.assignment.library.service.CommentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {
    protected static final Logger logger = LoggerFactory.getLogger(CommentServiceImpl.class);



    private CommentRepository commentRepository;
// instead of autowired
    public CommentServiceImpl(CommentRepository commentRepository){
        this.commentRepository = commentRepository;
    }

    @Override
    public List<CommentModel> getCommentByBookExtId(long id){

        List<CommentModel> comments = new ArrayList<>(1);
        Optional<List<CommentEntity>> result = commentRepository.findAllByBookExtId(id);

// if empty return initial array list with capacity of 1
        if(!result.get().isEmpty()) {
            return comments;
        };
// however if not empty then push construct model from comment entity and push to CommentModel List then return it
            if(result.get().size() > 0){
                System.out.println(result.get());
                result.get().stream().forEach((commentEntity ->{
                    comments.add(new CommentModel(commentEntity));
                }));
            }

        return comments;
    }
}
