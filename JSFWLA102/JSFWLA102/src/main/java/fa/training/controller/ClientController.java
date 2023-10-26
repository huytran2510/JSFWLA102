package fa.training.controller;


import antlr.NameSpace;
import fa.training.dto.create.CommentForCreateDTO;
import fa.training.dto.create.PostForCreateDTO;
import fa.training.dto.login.UserLoginDTO;
import fa.training.entities.Post;
import fa.training.entities.User;
import fa.training.repository.PostRepository;
import fa.training.repository.UserRepository;
import fa.training.services.UserDetailsSeviceImpl;
import fa.training.services.templates.CommentService;
import fa.training.services.templates.PostService;
import fa.training.services.templates.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/blog")
public class ClientController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private PostService postService;


    @GetMapping("/home")
    public String home(){
        return "home-page";
    }

    @GetMapping("/create")
    public String createPostForm(Model model) {
        List<Post> list = postService.getAll();
        model.addAttribute("posts",list);
        PostForCreateDTO postForCreateDTO = new PostForCreateDTO();
        model.addAttribute("post",postForCreateDTO);
        return "create-post";
    }

    @PostMapping("/create")
    public String createPostDatabase(@ModelAttribute("post") @Valid PostForCreateDTO postForCreateDTO,Principal principal, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "create-post";
        }
        System.out.println(principal.getName());
        User user = userService.findByUsername(principal.getName());
        Post post = new Post(postForCreateDTO);
        LocalDate currentTime = LocalDate.now();
        post.setCreate_time(currentTime);
        post.setUser(user);
        postService.save(post);
        return "create-post";
    }

}
