package me.kbh.javastudy.redis.cart.util;

public class CartUtil {
    private static final String KEY_CART_LIST = ":cart:product";
    private static final String KEY_PRODUCT_IN_CART = ":cart:productid:";

    public static String getKeyCartListByUserId(long userId){
        return userId + KEY_CART_LIST;
    }

    public static String getKeyProductInCartByUserId(long userId, long productId){
        return userId + KEY_PRODUCT_IN_CART + productId;
    }
}
