package entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "profile")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@NamedQuery(name="User.findAll", query="SELECT o FROM User o")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String fullname;

    @Column(length=20)
    private String phone;

    @Column(length=255)
    private String image; // lưu tên file
}
