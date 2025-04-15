package com.bootproject.workouttracker;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.bootproject.workouttracker.run.Location;
import com.bootproject.workouttracker.run.Run;
import com.bootproject.workouttracker.run.RunRepository;

@SpringBootApplication
public class WorkouttrackerApplication {

	private static final Logger log = LoggerFactory.getLogger(WorkouttrackerApplication.class);

	public static void main(String[] args) {
		// run application
		SpringApplication.run(WorkouttrackerApplication.class, args);

		// Log Sample
		log.info("start");

		/*
		 * // Bean Injection Sample
		 * ConfigurableApplicationContext context =
		 * SpringApplication.run(WorkouttrackerApplication.class, args);
		 * SampleBean bean = (SampleBean) context.getBean("sampleBean");
		 * System.out.println(bean.getWelcomeMessage());
		 */
	}

	@Bean
	CommandLineRunner runner(RunRepository runRepository) {
		return args -> {
			Run run = new Run(1, "First run", LocalDateTime.now(), LocalDateTime.now().plus(30, ChronoUnit.MINUTES), 3,
					Location.INDOOR);
			runRepository.create(run);
			log.info("run : " + run);
		};
	}

}
