package com.example.campushub.scholarship.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Scholarship {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String scholarshipName;
	@Enumerated(EnumType.STRING)
	private PaymentType type;
	private int amount;

	@Builder
	public Scholarship(String scholarshipName, int amount, PaymentType type) {
		this.scholarshipName = scholarshipName;
		this.amount = amount;
		this.type = type;
	}


}
