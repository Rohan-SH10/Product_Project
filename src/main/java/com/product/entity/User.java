package com.product.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	@NotNull(message = "Invalid Input")
	@NotBlank(message="Invalid Input")
	@Schema(required = true)
	private String userName;
	
	@Min(value = 600000000l,message = "Phone No Should be more than 6000000000")
	@Max(value = 999999999l,message="Phone No Should be Less than 9999999999")
	private long userPhoneNo;
	
	@NotBlank(message = "Invalid Email")
	@NotNull(message="Invlaid Email")
	@Column(unique = true)
	@Email(regexp = "[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+\\.[a-z]{2,}",message = "Invlaid Email format")
	@Schema(required = true)
	private String userEmail;
	
	@NotBlank(message = "Invalid Password")
	@NotNull(message="Invlaid Password")
	@Size(min=8,max=20,message = "Password must be beyween 8 and 20 charecter")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$#^&+=])(?=\\$+$).[8,]$",
	message = "password must contain at least one letter,one number,one special charecter")
	private String userPassword;
}
