package com.jeffgoyette.notetaker.category;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    public Category createCategory(Category category) {
        category.setId(UUID.randomUUID());
        return categoryRepository.save(category);
    }

    public Category findCategoryById(String id) {
        return categoryRepository.findById(UUID.fromString(id)).orElse(Category.builder().build());
    }

}
