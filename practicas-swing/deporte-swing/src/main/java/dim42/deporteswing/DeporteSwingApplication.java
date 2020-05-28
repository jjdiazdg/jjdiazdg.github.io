package dim42.deporteswing;

import javax.swing.UIManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class DeporteSwingApplication {

	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		SpringApplicationBuilder builder = new SpringApplicationBuilder(DeporteSwingApplication.class);
		builder.headless(false);
		builder.run(args);
	}

}
