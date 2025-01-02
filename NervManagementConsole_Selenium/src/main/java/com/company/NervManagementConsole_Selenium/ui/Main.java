package com.company.NervManagementConsole_Selenium.ui;

import java.util.Scanner;

import com.company.NervManagementConsole_Selenium.test.LoginTest;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to Selenium -NervManagementConsole- LOGIN TEST\n"
				+ "Select Browser:\n"
				+ "-Chrome\n"
				+ "-Firefox\n"
				+ "-Edge\n"
				+ "-Opera\n");
		String driverChoice = scan.nextLine();

		LoginTest test = new LoginTest();
		test.testLogin(driverChoice);

		scan.close();
	}

}
