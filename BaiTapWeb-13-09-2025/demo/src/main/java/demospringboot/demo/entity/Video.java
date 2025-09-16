package demospringboot.demo.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "videos")
@NamedQuery(
        name = "Video.findByTitleContaining",
        query = "SELECT v FROM Video v WHERE v.title LIKE CONCAT('%', :title, '%')"
)
public class Video implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "url", nullable = false)
    private String url;
}
