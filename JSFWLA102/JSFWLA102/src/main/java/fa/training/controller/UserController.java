package fa.training.controller;


import fa.training.dto.create.ClientRegisterDTO;
import fa.training.services.templates.ISecurityService;
import fa.training.services.templates.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import javax.validation.Valid;

@Controller
@RequestMapping
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ISecurityService securityService;

    @GetMapping("/register")
    public String registration(Model model) {
        model.addAttribute("user", new ClientRegisterDTO());
        return "register-form";
    }

    @PostMapping("/register")
    public String registration(@ModelAttribute("user") @Valid ClientRegisterDTO cUser, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "register-form";
        }
        userService.save(cUser);

        securityService.autoLogin(cUser.getUsername(), cUser.getPassword());
        return "redirect:/blog/create";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login-page";
    }

    @GetMapping("/logout")
    public String logout(Model model){
        return "home-page";
    }
}
