package com.cpe.backend.course.entity;

import lombok.*;

import java.util.UUID;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import java.util.Set;
import java.util.Collection;

import com.cpe.backend.register.entity.Student;
import com.cpe.backend.booking.entity.Booking;
import com.cpe.backend.timesharing.entity.TimeSharing;

@Data
@Entity
@NoArgsConstructor
@Table(name="COURSE")
public class Course {

    @Id
    @SequenceGenerator(name="COURSE_seq",sequenceName="COURSE_seq")               
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="COURSE_seq")  
    @Column(name = "Course_ID", unique = true, nullable = true)
    private @NonNull Long id;

    private @NonNull String bill = UUID.randomUUID().toString();
    
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Student.class)
    @JoinColumn(name = "Student_ID", insertable = true)
    private Student student;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Subjects.class)
    @JoinColumn(name = "SUBJECTS_ID", insertable = true)
    private Subjects subjects;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Type.class)
    @JoinColumn(name = "TYPE_ID", insertable = true)
    private Type type;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Grade.class)
    @JoinColumn(name = "Grade_ID", insertable = true)
    private Grade grade;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Booking> booking;

    @OneToMany(fetch = FetchType.EAGER)
    private Collection<TimeSharing> timesharing;

}
