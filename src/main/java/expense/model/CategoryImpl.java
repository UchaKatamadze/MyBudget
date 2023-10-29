package expense.model;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table(name = "category")
@Data
public class CategoryImpl {
    @Id

    private long id;
    private String name; // e.g. "Food", "Transportation", "Entertainment", "Utilities", "Rent", "Other"

}
