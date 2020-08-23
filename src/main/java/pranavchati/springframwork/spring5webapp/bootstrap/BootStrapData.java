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
        Publisher publisher = new Publisher("Pranav Chati Co", "1234 5th Street", "NYC", "NY", 12345);
        publisherRepository.save(publisher);

        //First Author Book
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        //Added Book to Publisher and etc
        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        //Adding class objects to repository
        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);


        //Second Author and Book
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "239583");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        //Added Book to Publisher and etc
        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        //Adding class objects to repository
        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);


        //Print Everything Out
        System.out.println("Started in BootStrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Publishers: " + publisherRepository.count());
        System.out.println("Publisher Number of Books: " + publisher.getBooks().size());
    }
}
