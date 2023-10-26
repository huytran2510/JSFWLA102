package fa.training.services;

import fa.training.dto.create.CommentForCreateDTO;
import fa.training.entities.Comment;
import fa.training.repository.CommentRepository;
import fa.training.services.templates.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    public ModelMapper modelMapper;
    @Autowired
    private CommentRepository commentRepository;
    @Override
    @Transactional
    public void save(CommentForCreateDTO commentForCreateDTO){
        Comment comment = modelMapper.map(commentForCreateDTO,Comment.class);
        commentRepository.save(comment);
    }
}
