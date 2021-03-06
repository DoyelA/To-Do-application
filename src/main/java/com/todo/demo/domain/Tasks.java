package com.todo.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@Table(name="task",schema = "public")
public class Tasks {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "task_seq")
    @SequenceGenerator(allocationSize = 1,initialValue = 1,name="task_seq", schema = "public")
    @Column(name="task_id", nullable=false, unique=true)
    private Long id;

    @Column(name="task_description", nullable = false, length=200)
    private String description;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.REMOVE}, fetch=FetchType.EAGER)
    @JoinColumn(name="task_skills")
    private Set<Skill> taskSkills;

    @OneToOne(cascade = {CascadeType.MERGE},fetch=FetchType.EAGER)
    @JoinColumn(name="user_tasks")
    private User user;

    public Tasks() {
    }
}
