package fa.training.services.templates;

import fa.training.dto.create.CommentForCreateDTO;

public interface CommentService {
    void save(CommentForCreateDTO commentForCreateDTO);
}
