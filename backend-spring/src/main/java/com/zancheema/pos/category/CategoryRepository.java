package com.zancheema.pos.category;

import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    boolean existsByNameIgnoreCase(String name);
}
