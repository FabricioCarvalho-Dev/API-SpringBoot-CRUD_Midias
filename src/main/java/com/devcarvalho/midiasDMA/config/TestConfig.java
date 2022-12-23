package com.devcarvalho.midiasDMA.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.devcarvalho.midiasDMA.entities.Autor;
import com.devcarvalho.midiasDMA.entities.Category_midia;
import com.devcarvalho.midiasDMA.entities.Desenvolvedor;
import com.devcarvalho.midiasDMA.entities.Editora;
import com.devcarvalho.midiasDMA.entities.Jogo;
import com.devcarvalho.midiasDMA.entities.Livro;
import com.devcarvalho.midiasDMA.entities.Order;
import com.devcarvalho.midiasDMA.entities.Revista;
import com.devcarvalho.midiasDMA.entities.User;
import com.devcarvalho.midiasDMA.entities.enums.OrderStatus;
import com.devcarvalho.midiasDMA.repositories.AutorRepository;
import com.devcarvalho.midiasDMA.repositories.CategoryRepository;
import com.devcarvalho.midiasDMA.repositories.DesenvolvedorRepository;
import com.devcarvalho.midiasDMA.repositories.EditoraRepository;
import com.devcarvalho.midiasDMA.repositories.JogoRepository;
import com.devcarvalho.midiasDMA.repositories.LivroRepository;
import com.devcarvalho.midiasDMA.repositories.OrderRepository;
import com.devcarvalho.midiasDMA.repositories.RevistaRepository;
import com.devcarvalho.midiasDMA.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private LivroRepository livroRepository;

	@Autowired
	private RevistaRepository revistaRepository;

	@Autowired
	private JogoRepository jogoRepository;

	@Autowired
	private AutorRepository autorRepository;

	@Autowired
	private EditoraRepository editoraRepository;

	@Autowired
	private DesenvolvedorRepository desenvolvedorRepository;

	@Override
	public void run(String... args) throws Exception {

		Autor a1 = new Autor(null, "Carlos maia");
		Autor a2 = new Autor(null, "Miskatonic Edition");
		autorRepository.saveAll(Arrays.asList(a1, a2));
		
        //----------------------------------------------------------------
		Livro l1 = new Livro(null, "Casa Blanca", "terror", 55.50, 2, false, a1);
		Livro l2 = new Livro(null, "Lovecraft", "terror", 55.50, 2, false, a2);
		livroRepository.saveAll(Arrays.asList(l1, l2));
		
		//----------------------------------------------------------------
		Editora e1 = new Editora(null, "ABRIL");
		Editora e2 = new Editora(null, "JovenPan");
		editoraRepository.saveAll(Arrays.asList(e1, e2));
		
		//----------------------------------------------------------------
		Revista r1 = new Revista(null, "animé", 10.50, true, e1);
		Revista r2 = new Revista(null, "jovicon", 15.50, true, e2);
		Revista r3 = new Revista(null, "Naruto", 20.50, false, e1);
		revistaRepository.saveAll(Arrays.asList(r1, r2, r3));
		
		//----------------------------------------------------------------
		Category_midia cat1 = new Category_midia(null, "REVISTA");
		Category_midia cat2 = new Category_midia(null, "LIVRO");
		Category_midia cat3 = new Category_midia(null, "JOGO");
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		
		//----------------------------------------------------------------
		Desenvolvedor d1 = new Desenvolvedor(null, "EA games");
		Desenvolvedor d2 = new Desenvolvedor(null, "RockStar Games");
		Desenvolvedor d3 = new Desenvolvedor(null, "Ubisoft");
		desenvolvedorRepository.saveAll(Arrays.asList(d1, d2, d3));
		
		//----------------------------------------------------------------
		Jogo j1 = new Jogo(null, "CallOfDury", 185.50, false, true);
		Jogo j2 = new Jogo(null, "Battlefild", 200.00, false, true);
		Jogo j3 = new Jogo(null, "DBZ Bongukay", 185.50, false, true);
		Jogo j4 = new Jogo(null, "Red dead Redention ", 100.70, false, true);
		Jogo j5 = new Jogo(null, "Naruto Shippuden", 185.50, false, true);
		Jogo j6 = new Jogo(null, "LineAgee", 50.30, false, true);
		jogoRepository.saveAll(Arrays.asList(j1, j2, j3, j4, j5, j6));
		
		//----------------------------------------------------------------
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		User u3 = new User(null, "David", "David@gmail.com", "4545154545", "98985654");
		
		//----------------------------------------------------------------
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);

		userRepository.saveAll(Arrays.asList(u1, u2, u3));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));

	}

}
