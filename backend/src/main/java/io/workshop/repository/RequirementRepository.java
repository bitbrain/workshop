package io.workshop.repository;

import io.workshop.model.Requirement;
import io.workshop.model.Workshop;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequirementRepository extends ListCrudRepository<Requirement, Integer>, PagingAndSortingRepository<Requirement, Integer> {
}
