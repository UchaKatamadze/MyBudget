package com.example.myBudget.expense.modelTest;


import expense.model.ExpenseImpl;
import org.junit.Test;

import java.time.Instant;

import static org.junit.Assert.*;

public class ExpenseImplTest {


    // Creating a new ExpenseImpl object with valid parameters should set the object's properties correctly.
    @Test
    public void test_createExpenseImplWithValidParameters() {
        ExpenseImpl expense = new ExpenseImpl(1, Instant.now(), "Food", "Lunch");

        assertEquals(1, expense.getId());
        assertEquals(Instant.now(), expense.getDate());
        assertEquals("Food", expense.getExpenseCategory());
        assertEquals("Lunch", expense.getDescription());
    }

    // Setting and getting the 'id' property of an ExpenseImpl object should work as expected.
    @Test
    public void test_setAndGetIdProperty() {
        ExpenseImpl expense = new ExpenseImpl();
        expense.setId(1);

        assertEquals(1, expense.getId());
    }

    // Setting and getting the 'date' property of an ExpenseImpl object should work as expected.
    @Test
    public void test_setAndGetDateProperty() {
        Instant now = Instant.now();

        ExpenseImpl expense = new ExpenseImpl();
        expense.setDate(now);

        assertEquals(now, expense.getDate());
    }

    // Creating a new ExpenseImpl object with invalid parameters should throw an exception.
    @Test(expected = IllegalArgumentException.class)
    public void test_createExpenseImplWithInvalidParameters() {
        ExpenseImpl expense = new ExpenseImpl(-1, Instant.now(), "Food", "Lunch");
    }

    // Setting the 'id' property of an ExpenseImpl object to an invalid value should throw an exception.
    @Test(expected = IllegalArgumentException.class)
    public void test_setInvalidIdProperty() {
        ExpenseImpl expense = new ExpenseImpl();
        expense.setId(-1);
    }

    // Setting the 'date' property of an ExpenseImpl object to an invalid value should throw an exception.
    @Test(expected = IllegalArgumentException.class)
    public void test_setInvalidDateProperty() {
        ExpenseImpl expense = new ExpenseImpl();
        expense.setDate(null);
    }

}
