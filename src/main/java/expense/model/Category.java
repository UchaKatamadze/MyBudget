package expense.model;


import org.springframework.data.jpa.repository.JpaRepository;

public interface Category extends JpaRepository<CategoryImpl, Long> {
    CategoryImpl findByName(String name);
}
