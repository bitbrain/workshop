package io.workshop.repository;

import io.workshop.model.Workshop;
import io.workshop.model.WorkshopActivity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkshopActivityRepository extends ListCrudRepository<WorkshopActivity, Integer>, PagingAndSortingRepository<WorkshopActivity, Integer> {
}
