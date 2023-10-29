package me.kbh.javastudy.redis.like.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class LikeServiceImpl implements LikeService {

  RedisTemplate<String, String> redisTemplate;

  @Override
  public void save(long userId, long postId) {
    String key = "likes:" + postId;

    Boolean alreadyLiked = redisTemplate.opsForSet().isMember(key, String.valueOf(userId));

    if (alreadyLiked == null || !alreadyLiked) {
      // SETNX로 사용자를 게시물의 좋아요 목록에 추가
      Long added = redisTemplate.opsForSet().add(key, String.valueOf(userId));

      if (added != null && added == 1) {
        // 좋아요가 추가되었으므로 게시물의 좋아요 카운트를 증가
        redisTemplate.opsForValue().increment("likes:total:" + postId, 1);
      }
    }
  }
}
