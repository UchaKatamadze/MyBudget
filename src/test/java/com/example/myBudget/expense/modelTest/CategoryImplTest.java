package com.example.myBudget.expense.modelTest;

import expense.model.CategoryImpl;
import org.junit.Test;
import static org.junit.Assert.*;
class CategoryImplTest {

        // Test that a new CategoryImpl object can be created successfully
        @Test
        public void test_newCategoryImplObjectCanBeCreatedSuccessfully() {
            CategoryImpl category = new CategoryImpl();
            assertNotNull(category);
        }

        // Test that getCategoryName() returns the correct category name
        @Test
        public void test_getCategoryNameReturnsCorrectCategoryName() {
            CategoryImpl category = new CategoryImpl();
            category.setName("Test Category");
            assertEquals("Test Category", category.getName());
        }

        // Test that setCategoryName() updates the category name correctly
        @Test
        public void test_setCategoryNameUpdatesCategoryNameCorrectly() {
            CategoryImpl category = new CategoryImpl();
            category.setName("Old Category");
            category.setName("New Category");
            assertEquals("New Category", category.getName());
        }

        // Test that getCategoryName() returns null if the category name has not been set
        @Test
        public void test_getCategoryNameReturnsNullIfCategoryNameNotSet() {
            CategoryImpl category = new CategoryImpl();
            assertNull(category.getName());
        }

        // Test that setCategoryName() throws an IllegalArgumentException if the category name is null
        @Test(expected = IllegalArgumentException.class)
        public void test_setCategoryNameThrowsIllegalArgumentExceptionIfCategoryNameIsNull() {
            CategoryImpl category = new CategoryImpl();
            category.setName(null);
        }

    }

