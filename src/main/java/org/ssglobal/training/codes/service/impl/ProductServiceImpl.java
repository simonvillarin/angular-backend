package org.ssglobal.training.codes.service.impl;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.ssglobal.training.codes.model.Image;
import org.ssglobal.training.codes.model.Product;
import org.ssglobal.training.codes.repository.ImageRepository;
import org.ssglobal.training.codes.repository.ProductRepository;
import org.ssglobal.training.codes.response.Response;
import org.ssglobal.training.codes.service.ProductService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
	
	private final ProductRepository productRepository;
	private final ImageRepository imageRepository;
	
	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(Integer productId) {
		Optional<Product> productOpt = productRepository.findById(productId);
		if (productOpt.isPresent()) {
			return productOpt.get();
		} else {
			throw new RuntimeException("Product not found");
		}
	}

	@Override
	public Response addProduct(Product product, MultipartFile file) {
		Optional<Product> productOpt = productRepository.findByProductName(product.getProductName());
		Optional<Image> imageOpt = imageRepository.findByFilename(file.getOriginalFilename());
		
		if (productOpt.isPresent()) {
			return Response.builder()
					.statusCode(409)
					.message("Product name already exists")
					.timestamp(LocalDateTime.now())
					.build();
		}
		
		if (imageOpt.isPresent()) {
			product.setImg(createImageLink(file.getOriginalFilename()));
			productRepository.save(product);
			return Response.builder()
					.statusCode(201)
					.message("Product successfully added")
					.timestamp(LocalDateTime.now())
					.imageLink(createImageLink(file.getOriginalFilename()))
					.build();
		} 
		Image image = null;
		try {
			image = Image.builder()
					.filename(file.getOriginalFilename())
					.mimeType(file.getContentType())
					.data(file.getBytes())
					.build();
		} catch (IOException e) {
			e.printStackTrace();
		}
		imageRepository.save(image);
		product.setImg(createImageLink(image.getFilename()));
		productRepository.save(product);
		return Response.builder()
				.statusCode(201)
				.message("Product successfully added")
				.timestamp(LocalDateTime.now())
				.imageLink(createImageLink(file.getOriginalFilename()))
				.build();
	}
	
	private String createImageLink(String filename) {
		return ServletUriComponentsBuilder.fromCurrentRequest()
				.replacePath("/api/v1/auth/" + filename)
				.toUriString();
	}

	@Override
	public Response updateProduct(Integer productId, Product product, MultipartFile file) {
		Optional<Product> productOpt = productRepository.findById(productId);
		Optional<Product> productOpt1 = productRepository.findByProductName(product.getProductName());
		Optional<Image> imageOpt = imageRepository.findByFilename(file.getOriginalFilename());
		
		if (productOpt.isPresent()) {
			Product _product = productOpt.get();
			if (product.getProductName() != null) {
				_product.setProductName(product.getProductName());
			}
			if (product.getBrand() != null) {
				_product.setBrand(product.getBrand());
			}
			if (product.getCategory() != null) {
				_product.setCategory(product.getCategory());
			}
			if (product.getDescription() != null) {
				_product.setDescription(product.getDescription());
			}
			if (product.getQuantity() != null) {
				_product.setQuantity(product.getQuantity());
			}
			if (product.getPrice() != null) {
				_product.setPrice(product.getPrice());
			}
			if (product.getNumOfUserRated() != null) {
				_product.setNumOfUserRated(product.getNumOfUserRated());
			}
			if (product.getRatings() != null) {
				_product.setRatings(product.getRatings());
			}
			if (product.getSoldItems() != null) {
				_product.setSoldItems(product.getSoldItems());
			}
			if (product.getSoldPrice() != null) {
				_product.setSoldPrice(product.getSoldPrice());
			}
			if (product.getIsAvailable() != null) {
				_product.setIsAvailable(product.getIsAvailable());
			}
			
			if (productOpt1.isPresent()) {
				return Response.builder()
						.statusCode(409)
						.message("Product name already exists")
						.timestamp(LocalDateTime.now())
						.build();
			}
			
			if (imageOpt.isPresent()) {
				product.setImg(createImageLink(file.getOriginalFilename()));
				productRepository.save(product);
				return Response.builder()
						.statusCode(201)
						.message("Product successfully added")
						.timestamp(LocalDateTime.now())
						.imageLink(createImageLink(file.getOriginalFilename()))
						.build();
			} 
			Image image = null;
			try {
				image = Image.builder()
						.filename(file.getOriginalFilename())
						.mimeType(file.getContentType())
						.data(file.getBytes())
						.build();
			} catch (IOException e) {
				e.printStackTrace();
			}
			imageRepository.save(image);
			_product.setImg(createImageLink(image.getFilename()));
			productRepository.save(_product);
			return Response.builder()
					.statusCode(200)
					.message("Product successfully updated")
					.timestamp(LocalDateTime.now())
					.imageLink(createImageLink(file.getOriginalFilename()))
					.build();
		} else {
			throw new RuntimeException("Product not found");
		}
	}
	
	@Override
	public Response updateProduct(Integer productId, Product product) {
		Optional<Product> productOpt = productRepository.findById(productId);
		Optional<Product> productOpt1 = productRepository.findByProductName(product.getProductName());
		
		if (productOpt.isPresent()) {
			Product _product = productOpt.get();
			if (product.getProductName() != null) {
				_product.setProductName(product.getProductName());
			}
			if (product.getBrand() != null) {
				_product.setBrand(product.getBrand());
			}
			if (product.getCategory() != null) {
				_product.setCategory(product.getCategory());
			}
			if (product.getDescription() != null) {
				_product.setDescription(product.getDescription());
			}
			if (product.getQuantity() != null) {
				_product.setQuantity(product.getQuantity());
			}
			if (product.getPrice() != null) {
				_product.setPrice(product.getPrice());
			}
			if (product.getNumOfUserRated() != null) {
				_product.setNumOfUserRated(product.getNumOfUserRated());
			}
			if (product.getRatings() != null) {
				_product.setRatings(product.getRatings());
			}
			if (product.getSoldItems() != null) {
				_product.setSoldItems(product.getSoldItems());
			}
			if (product.getSoldPrice() != null) {
				_product.setSoldPrice(product.getSoldPrice());
			}
			if (product.getIsAvailable() != null) {
				_product.setIsAvailable(product.getIsAvailable());
			}
			
			if (productOpt1.isPresent()) {
				return Response.builder()
						.statusCode(409)
						.message("Product name already exists")
						.timestamp(LocalDateTime.now())
						.build();
			}
	
			productRepository.save(_product);
			return Response.builder()
					.statusCode(200)
					.message("Product successfully updated")
					.timestamp(LocalDateTime.now())
					.build();
		} else {
			throw new RuntimeException("Product not found");
		}
	}


	@Override
	public Response deleteProduct(Integer productId) {
		Optional<Product> productOpt = productRepository.findById(productId);
		if (productOpt.isPresent()) {
			productRepository.deleteById(productId);
			return Response.builder()
					.statusCode(200)
					.message("Product successfully deleted")
					.timestamp(LocalDateTime.now())
					.build();
		} else {
			return Response.builder()
					.statusCode(404)
					.message("Product not found")
					.timestamp(LocalDateTime.now())
					.build();
		}
	}

}
