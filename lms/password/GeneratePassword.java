package com.te.lms.password;

import java.util.Random;


public class GeneratePassword {
	public String passwordGenerator(int lengthOfPassword) {
	    
	    String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	    String Lower = "abcdefghijklmnopgrstuvwxyz";
	    
	    String num = "0123456789";

	    String specialChars = "<>, .?/}]{]+_-) (&%$#@!=";

	    String combination = upper + Lower + specialChars + num;

	    String password = "";

	    Random r = new Random();

	    for (int i = 0; i < lengthOfPassword; i++) {
	      password += combination.charAt(r.nextInt(combination.length()));
	    }
	    
	    return password;
	  }
	}

