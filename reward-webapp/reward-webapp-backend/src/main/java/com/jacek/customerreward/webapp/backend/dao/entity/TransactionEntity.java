package com.jacek.customerreward.webapp.backend.dao.entity;

import java.math.BigDecimal;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.jacek.customerreward.webapp.backend.model.Transaction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder(toBuilder = true)
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = TransactionEntity.TABLE_NAME)
public class TransactionEntity {
	
	static final String TABLE_NAME = "tab_transaction";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "price", nullable = false)
	private BigDecimal price;
	
	@Column(name = "date")
	private Instant date;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_customer")
	private CustomerEntity customer;
}
