package pranavchati.springframwork.spring5webapp.repostories;

import pranavchati.springframwork.spring5webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

/**
 * Create by Pranav Chati ON 8/22/20
 */
public interface AuthorRepository extends CrudRepository<Author, Long> {

}
