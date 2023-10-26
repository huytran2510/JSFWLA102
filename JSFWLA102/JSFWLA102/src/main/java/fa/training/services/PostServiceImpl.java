package fa.training.services;

import fa.training.dto.create.PostForCreateDTO;
import fa.training.entities.Post;
import fa.training.repository.PostRepository;
import fa.training.services.templates.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PostRepository postRepository;

    @Override
    @Transactional
    public void save(Post post){
        postRepository.save(post);
    }

    public List<Post> getAll(){
        return postRepository.findAll();
    }
}
