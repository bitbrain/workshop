package io.workshop.repository;

import io.workshop.model.Workshop;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkshopRepository extends ListCrudRepository<Workshop, Integer>, PagingAndSortingRepository<Workshop, Integer> {
}
