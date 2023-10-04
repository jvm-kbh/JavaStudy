package me.kbh.javastudy.redis.like.presentation;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import me.kbh.javastudy.redis.like.service.LikeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/like")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class LikeController {

    LikeService likeService;

    @PostMapping("/user/{userId}/post/{postId}")
    public ResponseEntity<Void> save(@PathVariable long userId,
                                     @PathVariable long postId) {
        likeService.save(userId, postId);
        return ResponseEntity.ok().build();
    }
}
