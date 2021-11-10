package com.revature;

import java.io.IOException;
import com.revature.controllers.FrontController;
import com.revature.exceptions.LoginException;

public class Driver {

	public static void main(String[] args) throws IOException, LoginException {		
		FrontController.welcome();

	}
}
