package eclass.hackthon.mercedesbenz.io.eclassteam.service;

import eclass.hackthon.mercedesbenz.io.eclassteam.entity.User;
import eclass.hackthon.mercedesbenz.io.eclassteam.entity.Post;
import eclass.hackthon.mercedesbenz.io.eclassteam.repository.PostRepository;
import eclass.hackthon.mercedesbenz.io.eclassteam.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public UserService(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public void followUser(Long userId, Long followerId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        User follower = userRepository.findById(followerId).orElseThrow(() -> new RuntimeException("Follower not found"));
        user.getFollowers().add(follower);
        userRepository.save(user);
    }

    public void likePost(Long userId, Long postId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Post post = postRepository.findById(postId).orElseThrow(() -> new RuntimeException("Post not found"));
        user.getLikedPosts().add(post);
        userRepository.save(user);
    }

    public List<Post> getUserFeed(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        List<Post> feed = new ArrayList<>();
        for (User followedUser : user.getFollowers()) {
            feed.addAll(followedUser.getPosts());
        }
        return feed;
    }

}