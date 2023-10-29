package controller;


import expense.model.Expense;
import expense.model.ExpenseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/expense")
public class ExpenseController {
    @Autowired
    private Expense expenseService;

    @GetMapping("/expenses")
    List<ExpenseImpl> getAllExpenses() {
        return expenseService.findAll();
    }

    @DeleteMapping("/expenses/{id}")
    ResponseEntity<?> deleteExpense(@PathVariable Long id) {
        expenseService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/expenses")
    ResponseEntity<Expense> createExpense(@RequestBody Expense expense) throws URISyntaxException {
        Expense result = expenseService.save(expense);
        return ResponseEntity.created(new URI("/api/expense/expenses" + result.getId())).body(result);
    }
}
