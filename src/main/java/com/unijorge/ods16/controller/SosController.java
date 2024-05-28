package com.unijorge.ods16.controller;

import com.unijorge.ods16.model.SecurityPost;
import com.unijorge.ods16.model.SecurityTip;
import com.unijorge.ods16.service.SosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sos")
public class SosController {

    @Autowired
    private SosService sosService;

    @GetMapping("/security-tips")
    public List<SecurityTip> getAllSecurityTips() {
        return sosService.getAllSecurityTips();
    }

    @GetMapping("/security-posts")
    public List<SecurityPost> getAllSecurityPosts() {
        return sosService.getAllSecurityPosts();
    }

    @PostMapping("/security-tips")
    public SecurityTip addSecurityTip(@RequestBody SecurityTip securityTip) {
        return sosService.addSecurityTip(securityTip);
    }

    @PostMapping("/security-posts")
    public SecurityPost addSecurityPost(@RequestBody SecurityPost securityPost) {
        return sosService.addSecurityPost(securityPost);
    }
}
