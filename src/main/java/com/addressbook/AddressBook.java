package com.addressbook;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddressBook {
	
	static List<Contact> addressBook;
	public static void main(String[] args) {
		System.out.println("Welcome to AddressBook System");
		Scanner scanner = new Scanner(System.in);
		
		addContact(scanner );
	}
	
	public static String validateFirstName(String firstName, Scanner scanner) {
		String resultPattern = "^[A-Z]{1}[a-z]{2,9}$";
		Pattern regex = Pattern.compile(resultPattern);
		Matcher inputMatcher = regex.matcher(firstName);

		while (!inputMatcher.matches()) {
			System.out.println("Error: Invalid first name, please try again");
			firstName = scanner.nextLine();
			inputMatcher = regex.matcher(firstName);
		}
		return firstName;
	}

	public static String validateLastName(String lastName, Scanner scanner) {
		String resultPattern = "^[A-Z]{1}[a-z]{2,9}$";
		Pattern regex = Pattern.compile(resultPattern);
		Matcher inputMatcher = regex.matcher(lastName);

		while (!inputMatcher.matches()) {
			System.out.println("Error: Invalid Last name, please try again");
			lastName = scanner.nextLine();
			inputMatcher = regex.matcher(lastName);
		}
		return lastName;
	}

	public static String validateCity(String city, Scanner scanner) {
		String resultPattern = "^[A-Z]{1}[a-z]{2,}$";
		Pattern regex = Pattern.compile(resultPattern);
		Matcher inputMatcher = regex.matcher(city);

		while (!inputMatcher.matches()) {
			System.out.println("Error: Invalid city, please try again");
			city = scanner.nextLine();
			inputMatcher = regex.matcher(city);
		}
		return city;
	}

	public static String validateState(String state, Scanner scanner) {
		String resultPattern = "^[A-Z]{1}[a-z]{2,}$";
		Pattern regex = Pattern.compile(resultPattern);
		Matcher inputMatcher = regex.matcher(state);

		while (!inputMatcher.matches()) {
			System.out.println("Error: Invalid State, please try again");
			state = scanner.nextLine();
			inputMatcher = regex.matcher(state);
		}
		return state;
	}

	public static String validatePhone(String phone, Scanner scanner) {
		String resultPattern = "^[+]{0,1}[0-9]{0,2}[0-9]{10}$";
		Pattern regex = Pattern.compile(resultPattern);
		Matcher inputMatcher = regex.matcher(phone);

		while (!inputMatcher.matches()) {
			System.out.println("Error: Invalid Phone number, please try again");
			phone = scanner.nextLine();
			inputMatcher = regex.matcher(phone);
		}
		return phone;
	}

	public static String validateEmail(String email, Scanner scanner) {
		String resultPattern = "^[a-z.]{2,30}@{1}[a-z]{3,10}.[a-z]{3}$";
		Pattern regex = Pattern.compile(resultPattern);
		Matcher inputMatcher = regex.matcher(email);

		while (!inputMatcher.matches()) {
			System.out.println("Error: Invalid Email, please try again");
			email = scanner.nextLine();
			inputMatcher = regex.matcher(email);
		}
		return email;
	}

	public static String validateZipcode(String zip, Scanner scanner) {
		String resultPattern = "^[0-9]{0,6}$";
		Pattern regex = Pattern.compile(resultPattern);
		Matcher inputMatcher = regex.matcher(zip);

		while (!inputMatcher.matches()) {
			System.out.println("Error: Invalid Zip code, please try again");
			zip = scanner.nextLine();
			inputMatcher = regex.matcher(zip);
		}
		return zip;
	}

	private static void addContact(Scanner scanner) {
		Contact contact = new Contact();

		System.out.println("Enter First Name: ");
		String firstName = scanner.nextLine();
		contact.setFirstname(validateFirstName(firstName, scanner));

		System.out.println("Enter Last Name: ");
		String lname = scanner.nextLine();
		contact.setLastname(validateLastName(lname, scanner));

		System.out.println("Enter city : ");
		String city = scanner.nextLine();
		contact.setCity(validateCity(city, scanner));

		System.out.println("Enter state : ");
		String state = scanner.nextLine();
		contact.setState(validateState(state, scanner));

		System.out.println("Enter Zip code : ");
		String zip = scanner.nextLine();
		contact.setZipcode(validateZipcode(zip, scanner));

		System.out.println("Enter Email Id: ");
		String email = scanner.nextLine();
		contact.setEmail(validateEmail(email, scanner));

		System.out.println("Enter phone  number: ");
		String phone = scanner.nextLine();
		contact.setPhonenumber(validatePhone(phone, scanner));

		addressBook.add(contact);
		System.out.println("Contact has been saved.");
	}

}
