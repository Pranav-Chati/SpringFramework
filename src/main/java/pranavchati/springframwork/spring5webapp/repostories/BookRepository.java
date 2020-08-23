package pranavchati.springframwork.spring5webapp.repostories;

import org.springframework.data.repository.CrudRepository;
import pranavchati.springframwork.spring5webapp.domain.Book;
/**
 * Create by Pranav Chati ON 8/22/20
 */
public interface BookRepository extends CrudRepository<Book, Long> {
    
}
