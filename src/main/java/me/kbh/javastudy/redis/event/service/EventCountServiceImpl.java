package me.kbh.javastudy.redis.event.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EventCountServiceImpl implements EventCountService {

  RedisTemplate<String, String> redisTemplate;

  String EVENT_COUNT_KEY = "event:click:";
  String EVENT_COUNT_ALL_PATTERN = "event:click:*";

  @Override
  public void increaseEventPageCount(int pageId) {
    redisTemplate.opsForValue().increment(EVENT_COUNT_KEY + pageId);
  }

  @Override
  public long getEventPageCountById(int pageId) {
    String eventPageKey = EVENT_COUNT_KEY + pageId;
    String value = redisTemplate.opsForValue().get(eventPageKey);
    return value != null ? Long.parseLong(value) : 0L;
  }

  @Override
  public long getEventPageCount() {
    // 특정 패턴과 일치하는 모든 키 검색
    Set<String> keys = redisTemplate.keys(EVENT_COUNT_ALL_PATTERN);

    long totalPageVisits = 0;

    for (String key : keys) {
      // 각 키에 저장된 값을 조회하여 페이지 방문 회수를 더합니다.
      long eventPageCount = Long.parseLong(redisTemplate.opsForValue().get(key));
      totalPageVisits += eventPageCount;
    }

    return totalPageVisits;
  }
}
