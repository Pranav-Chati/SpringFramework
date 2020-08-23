package pranavchati.springframwork.spring5webapp.repostories;

import org.springframework.data.repository.CrudRepository;
import pranavchati.springframwork.spring5webapp.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
    
}
