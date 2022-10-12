package com.SVUniversity.MocX.domain;

import java.io.Serializable;

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
@Data
@Table(name = "sv_roles")
public class Roles implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3166648302341332004L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String roleName="";
	String displayName="";
	@OneToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "logId")
	LogTable log;
	
	
	
	
	
	
	
}
