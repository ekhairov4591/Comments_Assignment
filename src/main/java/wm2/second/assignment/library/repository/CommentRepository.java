package wm2.second.assignment.library.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import wm2.second.assignment.library.model.entity.CommentEntity;

import java.util.List;
import java.util.Optional;
//String because of MongoDB
@Repository
public interface CommentRepository extends MongoRepository<CommentEntity, String> {


    Optional<List<CommentEntity>> findAllByBookExtId(long bookExtId);


}
