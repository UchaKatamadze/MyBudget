package expense.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Table(name = "expense")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Expense {

    @Id
    private long id;

    private Instant date;

    private String description;


    @ManyToOne
    private Category category;

    @ManyToOne
    private User user;
}
