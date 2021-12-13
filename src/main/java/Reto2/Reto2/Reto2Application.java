package Reto2.Reto2;

import Reto2.Reto2.interfaces.InterfaceCleaningProduct;
import Reto2.Reto2.interfaces.InterfaceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Reto2Application implements CommandLineRunner {

    
    @Autowired
    private InterfaceCleaningProduct interfaceCleanProd;
      @Autowired
      private InterfaceUser interfaceUser;
	public static void main(String[] args) {
		SpringApplication.run(Reto2Application.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        interfaceCleanProd.deleteAll();
        interfaceUser.deleteAll();
    }

}
