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
@Table(name = "checkout")
public class Checkout {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "checkout_id")
	private Integer checkoutId;
	
	@Column(name = "user_id")
	private Integer userId;
	
	@Column(name = "product_id")
	private Integer productId;
	
	@Column(name = "cart_id")
	private Integer cartId;
	
	@Column(name = "product_name", length = 80)
	private String productName;
	
	@Column(name = "category", length = 80)
	private String category;
	
	@Column(name = "description")
	private List<String> description;
	
	@Column(name = "image")
	private String img;
	
	@Column(name = "quantity")
	private Integer quantity;
	
	@Column(name = "price", precision = 2)
	private Double price;
}
