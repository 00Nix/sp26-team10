package com.backend_api_team10;

import java.util.List;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "customer")
@AllArgsConstructor
@Data
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "customer_id")
public class Customer extends User {

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnoreProperties("customer")
	

	@Column(nullable = false)
	private String customerName;
}