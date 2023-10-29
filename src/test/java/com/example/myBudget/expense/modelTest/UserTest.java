package com.example.myBudget.expense.modelTest;


import expense.model.CategoryImpl;
import expense.model.User;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserTest {


    // Creating a new User with valid inputs should successfully create a User object
    @Test
    public void test_createUserWithValidInputs() {
        User user = new User(1, "John Doe", "john.doe@example.com");
        assertNotNull(user);
        assertEquals(1, user.getId());
        assertEquals("John Doe", user.getName());
        assertEquals("john.doe@example.com", user.getEmail());
    }

    // Adding a CategoryImpl object to a User's categoryImpl set should update the set with the new object
    @Test
    public void test_addCategoryImplToUser() {
        User user = new User(1, "John Doe", "john.doe@example.com");
        CategoryImpl category = new CategoryImpl(1, "Food");
        user.getCategoryImpl().add(category);
        assertTrue(user.getCategoryImpl().contains(category));
    }

    // Retrieving a User's name or email should return the correct value
    @Test
    public void test_getUserNameAndEmail() {
        User user = new User(1, "John Doe", "john.doe@example.com");
        assertEquals("John Doe", user.getName());
        assertEquals("john.doe@example.com", user.getEmail());
    }

    // Creating a new User with a null name should throw an exception
    @Test(expected = IllegalArgumentException.class)
    public void test_createUserWithNullName() {
        User user = new User(1, null, "john.doe@example.com");
    }

    // Creating a new User with a null email should throw an exception
    @Test(expected = IllegalArgumentException.class)
    public void test_createUserWithNullEmail() {
        User user = new User(1, "John Doe", null);
    }

    // Adding a null CategoryImpl object to a User's categoryImpl set should throw an exception
    @Test(expected = IllegalArgumentException.class)
    public void test_addNullCategoryImplToUser() {
        User user = new User(1, "John Doe", "john.doe@example.com");
        user.getCategoryImpl().add(null);
    }

}
