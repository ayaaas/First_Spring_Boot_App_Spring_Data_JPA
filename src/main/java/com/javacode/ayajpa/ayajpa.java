package com.javacode.ayajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.javacode.ayajpa.entities.Product;
import org.springframework.context.annotation.ComponentScan;
import com.javacode.ayajpa.repository.ProductRepository;


import java.util.List;


@SpringBootApplication
public class ayajpa implements CommandLineRunner {

	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(ayajpa.class, args);
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
