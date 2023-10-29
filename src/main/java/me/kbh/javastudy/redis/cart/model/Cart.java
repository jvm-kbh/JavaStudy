package me.kbh.javastudy.redis.cart.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Builder
@ToString
@EqualsAndHashCode
public class Cart implements Serializable {
  public long cartId;
  public long userId;
  public long productId;
}
