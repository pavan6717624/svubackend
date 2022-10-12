package com.SVUniversity.MocX.dto;

import lombok.Data;

@Data
public class LoginStatusDTO {
	Long mobile=0L;
	String role="NONE";
	Boolean loginStatus=false;
	String jwt="";
	String message = "";
}
