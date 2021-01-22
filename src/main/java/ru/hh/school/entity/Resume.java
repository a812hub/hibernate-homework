package ru.hh.school.entity;

import javax.persistence.*;

@Entity
@Table(name = "resume")
public class Resume {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
  @SequenceGenerator(name = "sequence", sequenceName = "resume_id_seq", allocationSize = 10)
  private Integer id;

  private String description;

  Resume() {}

  public Resume(String description) {
    this.description = description;
  }

}
