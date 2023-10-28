package expense.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table(name = "category")
@Data
public class Category {
    @Id

    private long id;
    private String name; // e.g. "Food", "Transportation", "Entertainment", "Utilities", "Rent", "Other"


    @ManyToOne(cascade = CascadeType.PERSIST)
    private User user;
}
