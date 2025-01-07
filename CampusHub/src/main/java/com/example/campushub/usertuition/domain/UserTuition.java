package com.example.campushub.usertuition.domain;

import static jakarta.persistence.FetchType.*;

import java.util.Date;

import com.example.campushub.schoolyear.domain.SchoolYear;
import com.example.campushub.tuition.domain.Tuition;
import com.example.campushub.user.domain.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserTuition {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "tuition_id")
	private Tuition tuition;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "school_year_id")
	private SchoolYear schoolYear;

	private boolean paymentStatus;
	private Date paymentDate;

	@Builder
	public UserTuition(User user, Tuition tuition, SchoolYear schoolYear, boolean paymentStatus, Date paymentDate) {
		this.user = user;
		this.tuition = tuition;
		this.schoolYear = schoolYear;
		this.paymentStatus = paymentStatus;
		this.paymentDate = paymentDate;
	}
}
