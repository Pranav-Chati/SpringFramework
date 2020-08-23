package pranavchati.springframwork.spring5webapp.repostories;

import org.springframework.data.repository.CrudRepository;
import pranavchati.springframwork.spring5webapp.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
