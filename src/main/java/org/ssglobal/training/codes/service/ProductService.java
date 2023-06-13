package org.ssglobal.training.codes.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.ssglobal.training.codes.model.Product;
import org.ssglobal.training.codes.response.Response;

public interface ProductService {
	List<Product> getAllProducts();
	Product getProductById(Integer productId);
	Response addProduct(Product product, MultipartFile file);
	Response updateProduct(Integer productId, Product product, MultipartFile file);
	Response updateProduct(Integer productId, Product product);
	Response deleteProduct(Integer productId);
}
