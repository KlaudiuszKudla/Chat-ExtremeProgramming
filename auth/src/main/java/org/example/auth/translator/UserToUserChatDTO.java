package org.example.auth.translator;

import org.example.auth.entity.User;
import org.example.auth.entity.UserChatDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public abstract class UserToUserChatDTO {

    public UserChatDTO toUserChatDTO(User user){
        return translateToUserChatDTO(user);
    }

    @Mapping(target = "uuid", source = "uuid")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "login", source = "username")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "imageUrl", source = "imageUuid")
    protected abstract UserChatDTO translateToUserChatDTO(User user);
}
