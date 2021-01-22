package ru.hh.school.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "employer")
public class Employer {

  @Id()
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "employer_id")
  private Integer id;

  @Column(name = "company_name", nullable = false, length = 100)
  private String companyName;

  @Column(name = "creation_time")
  private LocalDateTime creationTime;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "employer")
  private List<Vacancy> vacancies = new ArrayList<>();

  @Column(name = "block_time")
  private LocalDateTime blockTime;

  public Employer() {
  }

  public List<Vacancy> getVacancies() {
    return vacancies;
  }

  public Integer getId() {
    return id;
  }

  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  public LocalDateTime getBlockTime() {
    return blockTime;
  }

  public void setBlockTime(LocalDateTime blockTime) {
    this.blockTime = blockTime;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Employer employer = (Employer) o;
    return Objects.equals(companyName, employer.companyName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(companyName);
  }

}
