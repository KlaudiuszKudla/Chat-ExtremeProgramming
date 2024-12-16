package org.example.auth.mediator;

import lombok.RequiredArgsConstructor;
import org.example.auth.entity.FriendRequest;
import org.example.auth.entity.UserChatDTO;
import org.example.auth.service.FriendService;
import org.example.auth.translator.UserToUserChatDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class FriendMediator {

    private final FriendService friendService;
    private final UserToUserChatDTO userToUserChatDTO;

    public void addFriend(FriendRequest request) {
        friendService.addFriend(request);
    }

    public void acceptFriend(FriendRequest request) {
        friendService.acceptFriend(request);
    }

    public ResponseEntity<List<UserChatDTO>> findFriends(Long id) {
        List<UserChatDTO> userChatDTOS = new ArrayList<>();
        friendService.getFriends(id).forEach(value ->{
            userChatDTOS.add(userToUserChatDTO.toUserChatDTO(value));
        });
        return ResponseEntity.ok(userChatDTOS);
    }

    public ResponseEntity<List<UserChatDTO>> findFriendsSentRequest(Long id) {
        List<UserChatDTO> userChatDTOS = new ArrayList<>();
        friendService.getFriendsSentRequest(id).forEach(value ->{
            userChatDTOS.add(userToUserChatDTO.toUserChatDTO(value));
        });
        return ResponseEntity.ok(userChatDTOS);
    }

    public ResponseEntity<List<UserChatDTO>> findFriendsRequest(Long id) {
        List<UserChatDTO> userChatDTOS = new ArrayList<>();
        friendService.getFriendsRequest(id).forEach(value ->{
            userChatDTOS.add(userToUserChatDTO.toUserChatDTO(value));
        });
        return ResponseEntity.ok(userChatDTOS);
    }

}
