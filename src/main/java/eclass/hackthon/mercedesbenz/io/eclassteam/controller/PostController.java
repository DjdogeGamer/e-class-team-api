package eclass.hackthon.mercedesbenz.io.eclassteam.controller;

import eclass.hackthon.mercedesbenz.io.eclassteam.entity.Post;
import eclass.hackthon.mercedesbenz.io.eclassteam.service.DeeplinkService;
import eclass.hackthon.mercedesbenz.io.eclassteam.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    private DeeplinkService deeplinkService;

    @Autowired
    private PostService postService;

    @PostMapping("/post")
    public Post createPost(@RequestBody Post post, @RequestParam String model) {
        String deeplink = deeplinkService.fetchDeeplink(model);
        post.setDeeplink(deeplink);
        return postService.createPost(post);
    }
    @GetMapping("/post/{id}")
    public Post getPost(@PathVariable Long id) {
        return postService.getPost(id);
    }
}
