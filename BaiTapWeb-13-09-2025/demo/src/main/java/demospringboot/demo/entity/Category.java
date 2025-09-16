package demospringboot.demo.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "categories")
@NamedQuery(
        name = "Category.findByCategoryNameContaining",
        query = "SELECT c FROM Category c WHERE c.categoryName LIKE CONCAT('%', :name, '%')"
)
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_name", nullable = false, unique = true)
    private String categoryName;

}