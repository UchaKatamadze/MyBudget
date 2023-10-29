package expense.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Expense extends JpaRepository<ExpenseImpl, Long> {
    ExpenseImpl findByDescription(String description);
}
