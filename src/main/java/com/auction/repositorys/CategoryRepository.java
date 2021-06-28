package com.auction.repositorys;

import com.auction.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findAllByActive(boolean active);

    List<Category> findAllByName(String name);

    List<Category> findAllByDescription(String name);

    List<Category> findAllByNameContaining(String string);

    List<Category> findAllByDescriptionContaining(String string);


}
