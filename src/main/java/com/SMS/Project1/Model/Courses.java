package com.SMS.Project1.Model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "courses")
public class Courses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String timings;

    @Column(nullable = false)
    private String description;

    // Many courses can be taken by the same student
    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    // Many courses can be taught by the same teacher
    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teacher teacher;
}
