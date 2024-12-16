package org.example.auth.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.auth.entity.FriendRequest;
import org.example.auth.entity.User;
import org.example.auth.repository.UserRepository;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class FriendService {

    private final UserRepository userRepository;

    public void addFriend(FriendRequest request) {
        User user = userRepository.findUserById(request.getUserId()).orElse(null);
        User friend = userRepository.findUserById(request.getFriendId()).orElse(null);
        if(user != null && friend != null){
            user.addFriend(friend);
            userRepository.saveAndFlush(user);
        }
    }


}
