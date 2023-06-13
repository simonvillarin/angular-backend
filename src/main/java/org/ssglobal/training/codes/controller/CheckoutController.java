package org.ssglobal.training.codes.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ssglobal.training.codes.model.Checkout;
import org.ssglobal.training.codes.response.Response;
import org.ssglobal.training.codes.service.impl.CheckoutServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class CheckoutController {
	
	private final CheckoutServiceImpl checkoutServiceImpl;

	@GetMapping("/checkout/{id}")
	public ResponseEntity<List<Checkout>> getCheckoutByUserId(@PathVariable("id") Integer userId) {
		return ResponseEntity.ok(checkoutServiceImpl.getCartItemByUserId(userId));
	}
	
	@PostMapping("/checkout")
	public ResponseEntity<Response> addCheckout(@RequestBody Checkout checkout) {
		return ResponseEntity.status(HttpStatus.CREATED).body(checkoutServiceImpl.addCheckout(checkout));
	}
	
	
	@DeleteMapping("/checkout/{id}")
	public ResponseEntity<Response> deleteCheckout(@PathVariable("id") Integer checkoutId) {
		return ResponseEntity.ok(checkoutServiceImpl.deleteCheckout(checkoutId));
	}
	
	@DeleteMapping("/checkouts/{id}")
	public void deleteCheckouts(@PathVariable("id") List<Integer> checkoutIds) {
		checkoutServiceImpl.deleteCheckouts(checkoutIds);
	}
	
	@PostMapping("/checkout/productName")
	public ResponseEntity<Response> getCheckoutByProductName(@RequestBody Checkout checkout) {
		return ResponseEntity.ok(checkoutServiceImpl.getCheckoutByProductName(checkout));
	}
	
	@DeleteMapping("/checkout/all")
	public void deleteAll() {
		checkoutServiceImpl.deleteAll();
	}
}
