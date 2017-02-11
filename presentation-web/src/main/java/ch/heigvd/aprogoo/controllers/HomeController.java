package ch.heigvd.aprogoo.controllers;

import ch.heigvd.aprogoo.domain.models.Post;
import ch.heigvd.aprogoo.services.IPostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * The controller in charge of displaying the entire blog.
 */
@Controller
public class HomeController {
    /**
     * The service that manages the {@link Post}. Injected by constructor.
     */
    private final IPostService postService;

    public HomeController(IPostService postService) {
        this.postService = postService;
    }


    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts", postService.findAll());

        return "home/index";
    }
}
