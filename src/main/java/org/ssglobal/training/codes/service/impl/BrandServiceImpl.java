package org.ssglobal.training.codes.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.ssglobal.training.codes.model.Brand;
import org.ssglobal.training.codes.repository.BrandRepository;
import org.ssglobal.training.codes.response.Response;
import org.ssglobal.training.codes.service.BrandService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {
	
	private final BrandRepository brandRepository;

	@Override
	public List<Brand> getAllBrands() {
		return brandRepository.findAll();
	}
	
	@Override
	public Response addBrand(Brand brand) {
		Optional<Brand> brandOpt = brandRepository.findByBrand(brand.getBrand());
		if (brandOpt.isEmpty()) {
			brandRepository.save(brand);
		}
		return Response.builder()
				.statusCode(201)
				.message("Brand successfully added")
				.build();
	}

	@Override
	public Response updateBrand(Integer brandId, Brand brand) {
		Optional<Brand> brandOpt = brandRepository.findById(brandId);
		if (brandOpt.isPresent()) {
			Brand _brand = brandOpt.get();
			if (brand.getBrand() != null) {
				_brand.setBrand(brand.getBrand());
			}
			brandRepository.save(_brand);
			return Response.builder()
					.statusCode(200)
					.message("Brand successfully updated")
					.build();
		}
		return Response.builder()
				.statusCode(404)
				.message("Brand not found")
				.build();
	}

	@Override
	public Response deleteBrand(Integer brandId) {
		Optional<Brand> brandOpt = brandRepository.findById(brandId);
		if (brandOpt.isPresent()) {
			brandRepository.deleteById(brandId);
			return Response.builder()
					.statusCode(200)
					.message("Brand successfully deleted")
					.build();
		}
		return Response.builder()
				.statusCode(404)
				.message("Brand not found")
				.build();
	}

	

}
