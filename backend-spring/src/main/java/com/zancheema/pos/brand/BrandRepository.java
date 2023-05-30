package com.zancheema.pos.brand;

import org.springframework.data.repository.CrudRepository;

public interface BrandRepository extends CrudRepository<Brand, Long> {
    boolean existsByNameIgnoreCase(String name);
}
