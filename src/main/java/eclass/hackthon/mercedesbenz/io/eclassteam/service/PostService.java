package eclass.hackthon.mercedesbenz.io.eclassteam.service;

import eclass.hackthon.mercedesbenz.io.eclassteam.entity.Post;
import eclass.hackthon.mercedesbenz.io.eclassteam.entity.Tag;
import eclass.hackthon.mercedesbenz.io.eclassteam.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final DeeplinkService deeplinkService;

    public PostService(PostRepository postRepository, DeeplinkService deeplinkService) {
        this.postRepository = postRepository;
        this.deeplinkService = deeplinkService;
    }

    public Post createPost(Post post) {
        fetchAndSetDeeplink(post);
        return postRepository.save(post);
    }

    private void fetchAndSetDeeplink(Post post) {
        for (Tag tag : post.getTags()) {
            if (tag.getName().startsWith("#")) {
                String deeplink = deeplinkService.fetchDeeplink(tag.getName().substring(1));

                // If the tag corresponds to a Mercedes model, add the deeplink to the post
                // You might need to modify this part based on how you plan to store the deeplinks in the Post entity
                post.setDeeplink(deeplink);

            }
        }
    }

    public Post getPost(Long id) {
        return postRepository.findById(id).orElse(null);
    }
}
