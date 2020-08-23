package pranavchati.springframwork.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pranavchati.springframwork.spring5webapp.domain.Author;
import pranavchati.springframwork.spring5webapp.domain.Book;

import pranavchati.springframwork.spring5webapp.domain.Publisher;
import pranavchati.springframwork.spring5webapp.repostories.AuthorRepository;
import pranavchati.springframwork.spring5webapp.repostories.BookRepository;
import pranavchati.springframwork.spring5webapp.repostories.PublisherRepository;


@Component //Tells the Spring Framework to detect this class as a Spring Manage Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);


        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "239583");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        Publisher publisher = new Publisher("Pranav Chati Co", "1234 5th Street", "NYC", "NY", 12345);
        publisherRepository.save(publisher);


        System.out.println("Started in BootStrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Publishers: " + publisherRepository.count());
    }
}
