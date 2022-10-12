package com.SVUniversity.MocX.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sv_log_table")
public class LogTable implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2410314089623184776L;
	/**
	 * 
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	Boolean isDeleted;
	Boolean isDisabled;
	@Column(columnDefinition="datetime")
	 Timestamp  createdOn;
	
}
