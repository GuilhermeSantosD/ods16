package com.unijorge.ods16.service;


import com.unijorge.ods16.model.SecurityPost;
import com.unijorge.ods16.model.SecurityTip;
import com.unijorge.ods16.model.User;
import com.unijorge.ods16.repository.SecurityPostRepository;
import com.unijorge.ods16.repository.SecurityTipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.unijorge.ods16.repository.UserRepository;

import java.util.List;

public class SosService {

    @Autowired
    private SecurityTipRepository securityTipRepository;
    @Autowired
    private SecurityPostRepository securityPostRepository;
    @Autowired
    private UserRepository userRepository;

    public List<SecurityTip> getAllSecurityTips (){
        return securityTipRepository.findAll();
    }

    public List <SecurityPost> getAllSecurityPosts(){
        return securityPostRepository.findAll();
    }

    public SecurityTip addSecurityTip(SecurityTip securityTip){
        return securityTipRepository.save(securityTip);
    }
    public SecurityPost addSecurityPost(SecurityPost securityPost){
        return securityPostRepository.save(securityPost);
    }
    public User addUserSecurityTip(Long userId, Long tipId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        SecurityTip tip = securityTipRepository.findById(tipId).orElseThrow(() -> new RuntimeException("Tip not found"));
        user.getSecurityTips().add(tip);
        return userRepository.save(user);
    }

    public User addUserSecurityPost(Long userId, Long postId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        SecurityPost post = securityPostRepository.findById(postId).orElseThrow(() -> new RuntimeException("Post not found"));
        user.getSecurityPosts().add(post);
        return userRepository.save(user);
    }

    public List<SecurityTip> getUserSecurityTips(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        return List.copyOf(user.getSecurityTips());
    }

    public List<SecurityPost> getUserSecurityPosts(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        return List.copyOf(user.getSecurityPosts());
    }
}
