package org.example.auth.mediator;

import lombok.RequiredArgsConstructor;
import org.example.auth.entity.FriendRequest;
import org.example.auth.service.FriendService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class FriendMediator {

    private final FriendService friendService;

    public void addFriend(FriendRequest request) {
        friendService.addFriend(request);
    }


}
