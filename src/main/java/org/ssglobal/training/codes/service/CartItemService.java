package org.ssglobal.training.codes.service;

import java.util.List;

import org.ssglobal.training.codes.model.CartItem;
import org.ssglobal.training.codes.response.Response;

public interface CartItemService {
	List<CartItem> getCartItemByUserId(Integer userId);
	CartItem getCartItemById(Integer cartId);
	Response addCartItem(CartItem cartItem);
	Response updateCartItem(Integer cartId, CartItem cartItem);
	Response deleteCartItem(Integer cartId);
	Response getCartItemByProductName(CartItem cartItem);
}
