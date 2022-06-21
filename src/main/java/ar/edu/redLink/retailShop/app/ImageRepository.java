package ar.edu.redLink.retailShop.app;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ImageRepository extends PagingAndSortingRepository<Image, Long> {
	

}
