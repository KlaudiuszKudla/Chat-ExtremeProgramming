package org.example.auth.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserChatDTO {

    private String id;
    private String uuid;
    private String login;
    private String email;
    private String imageUrl;


}
