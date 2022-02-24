package com.ekureka.famms;

import com.ekureka.famms.Dao.CategoryRepository;
import com.ekureka.famms.Dao.ProductRepository;
import com.ekureka.famms.entities.Category;
import com.ekureka.famms.entities.Product;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;

@SpringBootApplication
public class FammsApplication implements CommandLineRunner {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	public static void main(String[] args) {
		SpringApplication.run(FammsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		categoryRepository.save(new Category(null,"Man & Women Clothes","very trend fashion",null));
		categoryRepository.save(new Category(null,"ELectronic Devices","Ultimate high devices",null));
		categoryRepository.save(new Category(null,"Jewellery accessories","shine jewelleries just for you guys ",null));
		categoryRepository.save(new Category(null,"Hiiiiiiiii awasome","just trying to figure out that thing",null));
		Random rnd= new Random();
		categoryRepository.findAll().forEach(c->{
			for (int i=0; i<10; i++)
			{
				Product product = new Product();
				product.setName(RandomString.make(18));
				product.setCurrentPrice(100 + rnd.nextInt(10000));
				product.setAvailable(rnd.nextBoolean());
				product.setPromotion(rnd.nextBoolean());
				product.setSelected(rnd.nextBoolean());
				product.setCategory((Category) c);
				productRepository.save(product);
			}

		});
	}
}
