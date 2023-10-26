package fa.training.services.templates;

import fa.training.dto.create.PostForCreateDTO;
import fa.training.entities.Post;

import java.util.List;

public interface PostService {
    void save(Post post) ;
    List<Post> getAll();
}
