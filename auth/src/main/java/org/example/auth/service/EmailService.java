package org.example.auth.service;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.auth.configuration.EmailConfiguration;
import org.example.auth.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
@RequiredArgsConstructor
@Slf4j
public class EmailService {

    private final EmailConfiguration emailConfiguration;

    @Value("${front.url}")
    private String fontendUrl;

    @Value("classpath:static/mail-aktywuj.html")
    private Resource activeTemplate;

    public void sendActivation(User user){
        try{
            String html = Files.toString(activeTemplate.getFile(), Charsets.UTF_8);
            html = html.replace("https://google.com",fontendUrl+"/aktywuj/"+user.getUuid());
            emailConfiguration.sendMail(user.getEmail(), html,"Aktywacja konta",true);
        }catch (IOException e){
            log.info("Cant send mail");
            throw new RuntimeException(e);
        }
    }
}
