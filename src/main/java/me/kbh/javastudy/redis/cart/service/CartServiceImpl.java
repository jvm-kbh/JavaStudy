package me.kbh.javastudy.redis.cart.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import me.kbh.javastudy.redis.cart.model.Cart;
import me.kbh.javastudy.redis.cart.util.CartUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CartServiceImpl implements CartService {

  RedisTemplate<String, String> redisTemplateForCart;
  ObjectMapper objectMapper;

  public void save() {
    String serializeString = "";

    Cart cart = Cart.builder().cartId(1L).userId(1L).productId(1L).build();

    try {
      serializeString = objectMapper.writeValueAsString(cart);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }

    String keyProductInCartByUserId = CartUtil.getKeyProductInCartByUserId(1L, 1L);
    redisTemplateForCart.opsForValue().set(keyProductInCartByUserId, serializeString);
    redisTemplateForCart.opsForValue().set("1:cart", "김보훈");
  }

  @Override
  public void update() {
    String keyProductInCartByUserId = CartUtil.getKeyProductInCartByUserId(1L, 1L);
    try {
      Cart cart =
          objectMapper.readValue(
              redisTemplateForCart.opsForValue().get(keyProductInCartByUserId), Cart.class);
      Cart newCart = Cart.builder().cartId(1).userId(1).productId(2).build();
      redisTemplateForCart
          .opsForValue()
          .set(keyProductInCartByUserId, objectMapper.writeValueAsString(newCart));
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }
}
