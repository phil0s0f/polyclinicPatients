package com.polyclinicpatients.polyclinicPatients;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PolyclinicPatientsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PolyclinicPatientsApplication.class, args);
		//TODO: изменить doctor-details,patient-details, скорее всего это должно быть в контроллере Visit
		//TODO: подумать над ссылками в doctor-main, patient-main, они должны перекидывать на Visit
	}

}
