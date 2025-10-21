package first_spring_boot_app_spring_data_jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import entities.Product;
import org.springframework.context.annotation.ComponentScan;
import repository.ProductRepository;

import java.util.List;


@SpringBootApplication
@ComponentScan(basePackages = {"repository", "entities"})
public class FirstSpringBootAppSpringDataJpaApplication implements CommandLineRunner {

	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(FirstSpringBootAppSpringDataJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		productRepository.save(new Product(null, "Computer", 4300, 3));
		productRepository.save(new Product(null, "Printer", 1200, 4));
		productRepository.save(new Product(null, "Phone", 2500, 5));

		List<Product> products = productRepository.findAll();
		products.forEach(System.out::println);

		Product product = productRepository.findById(1L).get();
		System.out.println("*****************");
		System.out.println(product.getId());
		System.out.println(product.getName());
		System.out.println(product.getQuantity());
		System.out.println("*****************");

		System.out.println("-----------------");
		List<Product> productList = productRepository.findByNameContains("C");
		productList.forEach(System.out::println);
	}
}
