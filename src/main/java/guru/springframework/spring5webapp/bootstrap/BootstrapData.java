package guru.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;

@Component
public class BootstrapData implements CommandLineRunner {

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;
	
	public BootstrapData (AuthorRepository authorRepository, 
			BookRepository bookRepository, 
			PublisherRepository publisherRepository) {
		
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		Author author1 = new Author("Isaac", "Asimov");
		Book book1 = new Book("Foundation", "1234");
		author1.getBooks().add(book1);
		book1.getAuthors().add(author1);
		
		authorRepository.save(author1);
		bookRepository.save(book1);
		
		Author clark = new Author("Arthur", "Clark");
		Book rama = new Book("Rama", "ab456");
		clark.getBooks().add(rama);
		rama.getAuthors().add(clark);
		
		authorRepository.save(clark);
		bookRepository.save(rama);
		
		Publisher publisher = new Publisher ("MingLabs");

		publisher.setAddress1("123 Road St.");
		publisher.setCity("Nocity");
		publisher.setState("CA");
		publisher.setZip("92880");
		
		publisherRepository.save(publisher);
		
		System.out.println("Bootstrap data");
		
		System.out.println("Number of books: " + bookRepository.count());
		
		System.out.print("Numbe of publishers: " + publisherRepository.count());
	}

}
