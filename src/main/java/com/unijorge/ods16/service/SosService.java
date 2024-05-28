package com.unijorge.ods16.service;


import com.unijorge.ods16.model.SecurityPost;
import com.unijorge.ods16.model.SecurityTip;
import com.unijorge.ods16.repository.SecurityPostRepository;
import com.unijorge.ods16.repository.SecurityTipRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SosService {

    @Autowired
    private SecurityTipRepository securityTipRepository;
    @Autowired
    private SecurityPostRepository securityPostRepository;

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

}
