package it.poliba.is45.ecoshipping;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;


@SpringBootApplication
@Component

public class EcoshippingApplication {

	public static void main(String[] args) throws Throwable{
		SpringApplication.run(EcoshippingApplication.class, args);
			
	}


}
