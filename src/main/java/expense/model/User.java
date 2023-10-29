package expense.model;

        import javax.persistence.Entity;
        import javax.persistence.Id;
        import javax.persistence.OneToMany;
        import javax.persistence.Table;

        import lombok.AllArgsConstructor;
        import lombok.Data;
        import lombok.Generated;
        import lombok.NoArgsConstructor;

        import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @Generated
    private long id;
    private String name;
    private String email;

    @OneToMany
    private Set<CategoryImpl> categoryImpl;
}
