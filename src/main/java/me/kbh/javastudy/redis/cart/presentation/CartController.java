package me.kbh.javastudy.redis.cart.presentation;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import me.kbh.javastudy.redis.cart.service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CartController {

  CartService cartService;

  @PostMapping("")
  public ResponseEntity<Void> save() {
    cartService.save();
    return ResponseEntity.ok().build();
  }

  @PutMapping("")
  public ResponseEntity<Void> update() {
    cartService.update();
    return ResponseEntity.ok().build();
  }
}
