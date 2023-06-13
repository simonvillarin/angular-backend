package org.ssglobal.training.codes.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ssglobal.training.codes.model.CartItem;
import org.ssglobal.training.codes.response.Response;
import org.ssglobal.training.codes.service.impl.CartItemServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class CartItemController {
	
	private final CartItemServiceImpl cartItemServiceImpl;
	
	@GetMapping("/cartItems/{id}")
	public ResponseEntity<List<CartItem>> getCartItemByUserId(@PathVariable("id") Integer userId) {
		return ResponseEntity.ok(cartItemServiceImpl.getCartItemByUserId(userId));
	}
	
	@GetMapping("/cartItem/{id}")
	public ResponseEntity<CartItem> getCartItemById(@PathVariable("id") Integer userId) {
		return ResponseEntity.ok(cartItemServiceImpl.getCartItemById(userId));
	}
	
	@PostMapping("/cartItem")
	public ResponseEntity<Response> addCartItem(@RequestBody CartItem cartItem) {
		return ResponseEntity.status(HttpStatus.CREATED).body(cartItemServiceImpl.addCartItem(cartItem));
	}
	
	@PutMapping("/cartItem/{id}")
	public ResponseEntity<Response> updateCartItem(@PathVariable("id") Integer cartId, @RequestBody CartItem cartItem) {
		return ResponseEntity.ok(cartItemServiceImpl.updateCartItem(cartId, cartItem));
	}
	
	@DeleteMapping("/cartItem/{id}")
	public ResponseEntity<Response> deleteCartItem(@PathVariable("id") Integer cartId) {
		return ResponseEntity.ok(cartItemServiceImpl.deleteCartItem(cartId));
	}
	
	@PostMapping("/cartItem/productName")
	public ResponseEntity<Response> getCartItemByProductId(@RequestBody CartItem cartItem) {
		return ResponseEntity.ok(cartItemServiceImpl.getCartItemByProductName(cartItem));
	}
	
}
