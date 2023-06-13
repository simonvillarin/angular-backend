package org.ssglobal.training.codes.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Integer productId;
	
	@Column(name = "product_name", length = 80)
	private String productName;
	
	@Column(name = "brand", length = 80)
	private String brand;
	
	@Column(name = "category", length = 80)
	private String category;
	
	@Column(name = "description")
	private List<String> description;
	
	@Column(name = "img")
	private String img;
	
	@Column(name = "quantity")
	private Integer quantity;
	
	@Column(name = "price", precision = 2)
	private Double price;
	
	@Column(name = "num_of_user_rated")
	private Integer numOfUserRated;
	
	@Column(name = "ratings", precision = 2)
	private Double ratings;
	
	@Column(name = "sold_items")
	private Integer soldItems;
	
	@Column(name = "sold_price")
	private Double soldPrice;
	
	@Column(name = "available")
	private Boolean isAvailable;
}
