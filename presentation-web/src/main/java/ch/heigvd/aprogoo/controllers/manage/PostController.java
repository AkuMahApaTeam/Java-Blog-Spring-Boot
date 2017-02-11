package ch.heigvd.aprogoo.controllers.manage;

import ch.heigvd.aprogoo.domain.models.Post;
import ch.heigvd.aprogoo.services.IPostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * The controller managing the {@link Post}.
 */
@Controller
@RequestMapping("/manage/post")
public class PostController {
    /**
     * The service that manages the {@link Post}. Injected by constructor.
     */
    private IPostService postService;

    public PostController(IPostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("posts", postService.findAll());

        return "manage/post/index";
    }

    @GetMapping("delete/{postId}")
    public String delete(@PathVariable("postId") Long postId) {
        postService.delete(postId);
        return "redirect:/manage/post";
    }

    @GetMapping("update/{postId}")
    public String update(Model model, @PathVariable("postId") Long postId) {
        model.addAttribute("post", postService.findOne(postId));
        return "manage/post/edit";
    }

    @PostMapping("update/{postId}")
    public String update(@Valid Post post, @PathVariable("postId") Long postId, Model model, BindingResult binding) {
        if(binding.hasErrors()) {
            model.addAttribute("post", post);
            return "/manage/post/edit/" + postId;
        }

        postService.update(post);
        return "redirect:/manage/post";
    }

    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("post", new Post());
        return "manage/post/create";
    }

    @PostMapping("create")
    public String create(@Valid Post post, BindingResult binding, Model model) {
        if(binding.hasErrors()) {
            model.addAttribute("post", post);
            return "manage/post/create";
        }

        postService.save(post);
        return "redirect:/manage/post";
    }
}
