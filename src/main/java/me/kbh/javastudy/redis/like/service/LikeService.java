package me.kbh.javastudy.redis.like.service;

public interface LikeService {
    void save(long userId, long postId);
}
