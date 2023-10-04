package me.kbh.javastudy.redis.event.presentation;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import me.kbh.javastudy.redis.event.service.EventCountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/page")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EventCountController {

    EventCountService eventCountService;

    @PostMapping("/{pageId}")
    public void pushEventPageCount(@PathVariable int pageId){
        eventCountService.increaseEventPageCount(pageId);
    }

    @GetMapping("/{pageId}")
    public ResponseEntity<Long> byId(@PathVariable int pageId){
        return ResponseEntity.ok(eventCountService.getEventPageCountById(pageId));
    }

    @GetMapping("")
    public ResponseEntity<Long> allCount(){
        return ResponseEntity.ok(eventCountService.getEventPageCount());
    }
}
