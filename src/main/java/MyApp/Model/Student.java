package MyApp.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String firstname = "User";
    @Column
    private String lastname = "Lastname";
    @Column
    private String address = "123 Main St";
    @Column
    private String phone_number = "(123)-123-1234";
    @Column
    private String dob = "00/00/0000";
    @Column
    private double balance;


    @OneToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    @JoinColumn(name = "login_id")
    private Login login;

    @ManyToMany
    @JoinTable(
            name = "students_courses",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Courses> myCourses;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", address='" + address + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", dob='" + dob + '\'' +
                ", balance=" + balance +
                ", myCourses=" + myCourses +
                '}';
    }
}
