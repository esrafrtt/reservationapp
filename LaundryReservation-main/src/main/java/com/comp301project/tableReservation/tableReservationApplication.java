package com.comp301project.tableReservation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.comp301project.FirstThings.FirstThings;

@SpringBootApplication
public class tableReservationApplication {

	public static void main(String[] args) {
		//WriteDefaultData.getInstance().returnToDefaults();
		FirstThings.handleFirstThings();
		SpringApplication.run(tableReservationApplication.class, args);
	}

}