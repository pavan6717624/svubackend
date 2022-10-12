package com.SVUniversity.MocX.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name = "sv_user_details")
@Data
public class UserDetails implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3956721357336114735L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	String name="";
	Long mobile=0L;
	String email="";
	

	@OneToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "roleId")
	Roles role;
	
	@OneToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "logId")
	LogTable log;
	
	

	

}
