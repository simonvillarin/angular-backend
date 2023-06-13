package org.ssglobal.training.codes.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.ssglobal.training.codes.model.Checkout;
import org.ssglobal.training.codes.repository.CheckoutRepository;
import org.ssglobal.training.codes.response.Response;
import org.ssglobal.training.codes.service.CheckoutService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CheckoutServiceImpl implements CheckoutService{
	
	private final CheckoutRepository checkoutRepository;

	@Override
	public List<Checkout> getCartItemByUserId(Integer userId) {
		return checkoutRepository.findByUserId(userId);
	}

	@Override
	public Response addCheckout(Checkout checkout) {
		Optional<Checkout> checkoutOpt = checkoutRepository.findByProductName(checkout.getProductName());
		if (checkoutOpt.isEmpty()) {
			checkoutRepository.save(checkout);
		} else {
			Checkout _checkout = checkoutOpt.get();
			if (checkout.getQuantity() != null) {
				_checkout.setQuantity(checkout.getQuantity());
			}
			checkoutRepository.save(_checkout);
		}
		return Response.builder()
				.statusCode(201)
				.message("Checkout successfully added")
				.timestamp(LocalDateTime.now())
				.build();
	}


	@Override
	public Response deleteCheckout(Integer checkoutId) {
		Optional<Checkout> checkoutOpt = checkoutRepository.findById(checkoutId);
		if (checkoutOpt.isPresent()) {
			checkoutRepository.deleteById(checkoutId);
			return Response.builder()
					.statusCode(200)
					.message("Checkout successfully deleted")
					.timestamp(LocalDateTime.now())
					.build();
		} 
		return Response.builder()
				.statusCode(404)
				.message("Checkout not found")
				.timestamp(LocalDateTime.now())
				.build();
	}

	@Override
	public void deleteCheckouts(List<Integer> checkoutIds) {
		for (int i = 0; i < checkoutIds.size(); i++) {
			Optional<Checkout> checkoutOpt = checkoutRepository.findById(checkoutIds.get(i));
			if (checkoutOpt.isPresent()) {
				checkoutRepository.deleteById(checkoutIds.get(i));
			}
		}
		
	}

	@Override
	public Response getCheckoutByProductName(Checkout checkout) {
		Optional<Checkout> checkoutOpt = checkoutRepository.findByProductName(checkout.getProductName());
		if (checkoutOpt.isPresent()) {
			return Response.builder()
					.statusCode(200)
					.message("Checkout found")
					.timestamp(LocalDateTime.now())
					.id(checkoutOpt.get().getCheckoutId())
					.build();
		}
		return Response.builder()
				.statusCode(404)
				.message("Checkout not found")
				.timestamp(LocalDateTime.now())
				.build();
	}

	@Override
	public void deleteAll() {
		checkoutRepository.deleteAll();
		
	}

}
