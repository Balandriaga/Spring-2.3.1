package app.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", length = 20, nullable = false)
    @NotBlank(message = "Имя не должно быть пустым")
    private String name;

    @Column(name = "lastname", length = 30, nullable = false)
    @NotBlank(message = "Фамилия не должна быть пустой")
    private String lastName;

    @Column(name = "age", nullable = false)
    private Byte age;

    @Column(name = "address", length = 150, nullable = false)
    @NotBlank(message = "Адрес не должен быть пустым")
    private String address;

    public User(String name, String lastName, Byte age, String address) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
    }
}