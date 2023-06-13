package org.ssglobal.training.codes.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.ssglobal.training.codes.model.CartItem;
import org.ssglobal.training.codes.repository.CartItemRepository;
import org.ssglobal.training.codes.response.Response;
import org.ssglobal.training.codes.service.CartItemService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartItemServiceImpl implements CartItemService {
	
	private final CartItemRepository cartItemRepository;
	
	@Override
	public List<CartItem> getCartItemByUserId(Integer userId) {
		return cartItemRepository.findByUserId(userId);
	}
	

	@Override
	public CartItem getCartItemById(Integer cartId) {
		Optional<CartItem> cartItemOpt = cartItemRepository.findById(cartId);
		if (cartItemOpt.isEmpty()) {
			return cartItemOpt.get();
		} else {
			throw new RuntimeException("Cart item not found");
		}
	}

	@Override
	public Response addCartItem(CartItem cartItem) {
		Optional<CartItem> cartItemOpt = cartItemRepository.findByUserIdAndProductName(cartItem.getUserId(), cartItem.getProductName());
		if (cartItemOpt.isPresent()) {
			CartItem _cartItem = cartItemOpt.get();
			if (cartItem.getQuantity() != null) {
				_cartItem.setQuantity(_cartItem.getQuantity());
			}
			cartItemRepository.save(_cartItem);
		} else {
			cartItemRepository.save(cartItem);
		}
		return Response.builder()
				.statusCode(201)
				.message("Cart item successfully added")
				.timestamp(LocalDateTime.now())
				.build();
	}

	@Override
	public Response updateCartItem(Integer cartId, CartItem cartItem) {
		Optional<CartItem> cartItemOpt = cartItemRepository.findById(cartId);
		if (cartItemOpt.isPresent()) {
			CartItem _cartItem = cartItemOpt.get();
			if (cartItem.getQuantity() != null) {
				_cartItem.setQuantity(cartItem.getQuantity());
			}
			cartItemRepository.save(_cartItem);
			return Response.builder()
					.statusCode(200)
					.message("Cart item successfully updated")
					.timestamp(LocalDateTime.now())
					.build();
		}
		return Response.builder()
				.statusCode(404)
				.message("Cart item not found")
				.timestamp(LocalDateTime.now())
				.build();
	}

	@Override
	public Response deleteCartItem(Integer cartId) {
		Optional<CartItem> cartItemOpt = cartItemRepository.findById(cartId);
		if (cartItemOpt.isPresent()) {
			cartItemRepository.deleteById(cartId);
			return Response.builder()
					.statusCode(200)
					.message("Cart item successfully deleted")
					.timestamp(LocalDateTime.now())
					.build();
		}
		return Response.builder()
				.statusCode(404)
				.message("Cart item not found")
				.timestamp(LocalDateTime.now())
				.build();
	}


	@Override
	public Response getCartItemByProductName(CartItem cartItem) {
		Optional<CartItem> cartItemOpt = cartItemRepository.findByProductName(cartItem.getProductName());
		if (cartItemOpt.isPresent()) {
			return Response.builder()
					.statusCode(200)
					.message("Cart item found")
					.timestamp(LocalDateTime.now())
					.id(cartItemOpt.get().getCartId())
					.build();
		}
		return Response.builder()
				.statusCode(404)
				.message("Cart item not found")
				.timestamp(LocalDateTime.now())
				.build();
	}
}
