package guru.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.PublisherRepository;

@Component
public class BootstrapData implements CommandLineRunner {

	private final PublisherRepository publisherRepository;
	
	public BootstrapData (PublisherRepository publisherRepository) {
		this.publisherRepository = publisherRepository;
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		Publisher publisher = new Publisher ("MingLabs");

		publisher.setAddress1("123 Road St.");
		publisher.setCity("Nocity");
		publisher.setState("CA");
		publisher.setZip("92880");
		
		publisherRepository.save(publisher);
		
		System.out.println("Bootstrap data");
		
		System.out.print("Numbe of publishers: " + publisherRepository.count());
	}

}
