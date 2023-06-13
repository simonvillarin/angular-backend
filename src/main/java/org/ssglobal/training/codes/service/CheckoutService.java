package org.ssglobal.training.codes.service;

import java.util.List;

import org.ssglobal.training.codes.model.Checkout;
import org.ssglobal.training.codes.response.Response;

public interface CheckoutService {
	List<Checkout> getCartItemByUserId(Integer userId);
	Response addCheckout(Checkout checkout);
	Response deleteCheckout(Integer checkoutId);
	void deleteCheckouts(List<Integer> checkoutIds);
	Response getCheckoutByProductName(Checkout checkout);
	void deleteAll();
}
