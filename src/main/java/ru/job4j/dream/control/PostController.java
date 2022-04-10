package ru.job4j.dream.control;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.dream.model.City;
import ru.job4j.dream.model.Post;
import ru.job4j.dream.service.CityService;
import ru.job4j.dream.service.PostService;

@ThreadSafe
@Controller
public class PostController {

    private final PostService postService;
    private final CityService cityService;

    public PostController(PostService postService, CityService cityService) {
        this.postService = postService;
        this.cityService = cityService;
    }

    @GetMapping("/posts")
    public String posts(Model model) {
        model.addAttribute("posts", postService.findAll());
        return "posts";
    }

    @GetMapping("/addPost")
    public String addPost(Model model) {
        model.addAttribute("post", new Post(0, "Заполните поле", new City(1, "мск")));
        return "addPost";
    }

    @GetMapping("/formPost")
    public String formAddPost(Model model) {
        /*TODO Города*/
        model.addAttribute("cities", cityService.getAllCities());
        return "addPost";
    }

    @PostMapping("/savePost")
    public String savePost(@ModelAttribute Post post) {
        postService.add(post);
        return "redirect:/posts";
    }

    @PostMapping("/createPost")
    public String createPost(@ModelAttribute Post post) {
        City cityNow = cityService.findById(post.getCity().getId());
        var cityNowName = cityNow.getName();
        postService.create(post, cityNowName);
        return "redirect:/posts";
    }

    @GetMapping("/formUpdatePost/{postId}")
    public String formUpdatePost(Model model, @PathVariable("postId") int id) {
        model.addAttribute("post", postService.findById(id));
        model.addAttribute("cities", cityService.getAllCities());
        return "updatePost";
    }

    @PostMapping("/updatePost")
    public String updatePost(@ModelAttribute Post post, @RequestParam("city.id") int id) {
        post.setCity(cityService.findById(id));
        Post post1 = post;
        postService.update(post);
        return "redirect:/posts";
    }
}
