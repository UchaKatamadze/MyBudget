package com.example.myBudget.categoryControllerTest;


import controller.CategoryController;
import expense.model.Category;
import expense.model.CategoryImpl;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;
import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CategoryControllerTest {

    // GET request for all categories returns a collection of CategoryImpl objects
    @Test
    public void test_getAllCategories_returnsCollection() {
        // Arrange
        Category category = mock(Category.class);
        Collection<CategoryImpl> expectedCategories = new ArrayList<>();
        expectedCategories.add(new CategoryImpl(1, "Food"));
        expectedCategories.add(new CategoryImpl(2, "Transportation"));
        when(category.findAll()).thenReturn(expectedCategories);
        CategoryController categoryController = new CategoryController(category);

        // Act
        Collection<CategoryImpl> actualCategories = categoryController.categories();

        // Assert
        assertEquals(expectedCategories, actualCategories);
    }

    // GET request for a specific category with valid id returns a ResponseEntity with the corresponding CategoryImpl object
    @Test
    public void test_getCategory_withValidId_returnsResponseEntityWithCategory() {
        // Arrange
        Category category = mock(Category.class);
        Long categoryId = 1L;
        CategoryImpl expectedCategory = new CategoryImpl(categoryId, "Food");
        when(category.findById(categoryId)).thenReturn(Optional.of(expectedCategory));
        CategoryController categoryController = new CategoryController(category);

        // Act
        ResponseEntity<?> responseEntity = categoryController.getCategory(categoryId);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedCategory, responseEntity.getBody());
    }

    // POST request to create a new category with valid CategoryImpl object returns a ResponseEntity with the created CategoryImpl object
    @Test
    public void test_createCategory_withValidCategory_returnsResponseEntityWithCreatedCategory() throws URISyntaxException {
        // Arrange
        Category category = mock(Category.class);
        CategoryImpl categoryToCreate = new CategoryImpl(1, "Food");
        CategoryImpl createdCategory = new CategoryImpl(1, "Food");
        when(category.save(categoryToCreate)).thenReturn(createdCategory);
        CategoryController categoryController = new CategoryController(category);

        // Act
        ResponseEntity<CategoryImpl> responseEntity = categoryController.createCategory(categoryToCreate);

        // Assert
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(createdCategory, responseEntity.getBody());
    }

    // GET request for all categories returns an empty collection if there are no categories
    @Test
    public void test_getAllCategories_returnsEmptyCollectionWhenNoCategoriesExist() {
        // Arrange
        Category category = mock(Category.class);
        Collection<CategoryImpl> expectedCategories = new ArrayList<>();
        when(category.findAll()).thenReturn(expectedCategories);
        CategoryController categoryController = new CategoryController(category);

        // Act
        Collection<CategoryImpl> actualCategories = categoryController.categories();

        // Assert
        assertTrue(actualCategories.isEmpty());
    }

    // GET request for a specific category with invalid id returns a ResponseStatusException with status code 404
    @Test
    public void test_getCategory_withInvalidId_returnsResponseStatusExceptionWith404() {
        // Arrange
        Category category = mock(Category.class);
        Long invalidCategoryId = 100L;
        when(category.findById(invalidCategoryId)).thenReturn(Optional.empty());
        CategoryController categoryController = new CategoryController(category);

        // Act and Assert
        assertThrows(ResponseStatusException.class, () -> categoryController.getCategory(invalidCategoryId));
    }

    // POST request to create a new category with invalid CategoryImpl object returns a ResponseEntity with status code 500
    @Test
    public void test_createCategory_withInvalidCategory_returnsResponseEntityWith500() throws URISyntaxException {
        // Arrange
        Category category = mock(Category.class);
        CategoryImpl invalidCategory = new CategoryImpl(1, null);
        when(category.save(invalidCategory)).thenThrow(new RuntimeException());
        CategoryController categoryController = new CategoryController(category);

        // Act
        ResponseEntity<CategoryImpl> responseEntity = categoryController.createCategory(invalidCategory);

        // Assert
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
    }

}