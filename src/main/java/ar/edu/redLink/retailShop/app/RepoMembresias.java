package ar.edu.redLink.retailShop.app;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ar.edu.redLink.retailShop.model.Membresias;

@RepositoryRestResource(path = "membresias")
public interface RepoMembresias extends PagingAndSortingRepository<Membresias, Integer> {

}
