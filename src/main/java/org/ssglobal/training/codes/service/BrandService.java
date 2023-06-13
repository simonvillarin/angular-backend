package org.ssglobal.training.codes.service;

import java.util.List;

import org.ssglobal.training.codes.model.Brand;
import org.ssglobal.training.codes.response.Response;

public interface BrandService {
	List<Brand> getAllBrands();
	Response addBrand(Brand brand);
	Response updateBrand(Integer brandId, Brand brand);
	Response deleteBrand(Integer brandId);
}
