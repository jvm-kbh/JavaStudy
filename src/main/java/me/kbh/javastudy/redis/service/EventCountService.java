package me.kbh.javastudy.redis.service;

public interface EventCountService {
    void increaseEventPageCount(int pageId);

    long getEventPageCountById(int pageId);

    long getEventPageCount();
}
