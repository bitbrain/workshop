package io.workshop.repository;

import io.workshop.model.User;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ListCrudRepository<User, Integer>, PagingAndSortingRepository<User, Integer> {
}
