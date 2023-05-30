package com.zancheema.pos.category;

import com.zancheema.pos.category.dto.CategoryCreationPayload;
import com.zancheema.pos.category.dto.CategoryDistribution;
import com.zancheema.pos.category.dto.CategoryInfo;
import com.zancheema.pos.category.dto.CategoryPatch;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<CategoryInfo> getCategories();

    List<CategoryDistribution> getCategoryDistributions();

    Optional<CategoryInfo> addCategory(CategoryCreationPayload payload);

    Optional<CategoryInfo> updateCategory(CategoryPatch patch);

    void deleteCategory(long categoryId);
}
