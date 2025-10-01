package com.Utility;

import java.util.Locale;

import com.github.javafaker.Faker;
import com.ui.pojo.AddressPOJO;

public class FakeAddressUtility {
	public static void main(String[] args) {
		getFakerAddress();
	}
	public static AddressPOJO getFakerAddress() {
		Faker faker = new Faker(Locale.US);
		
		AddressPOJO addresspojo = 	
				
				new AddressPOJO(faker.company().name(), faker.address().buildingNumber(),faker.address().streetAddress(),faker.address().city(),faker.numerify("#####"),faker.phoneNumber().cellPhone(),faker.phoneNumber().cellPhone(), "other", "office address", 
						faker.address().state());
		return addresspojo;
		
	}
	}

