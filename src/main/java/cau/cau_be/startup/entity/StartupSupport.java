package cau.cau_be.startup.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class StartupSupport {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private final Long id;

  @Column(nullable = false)
  private final String title;

  @Column(nullable = false)
  private final String content;

  @Column(nullable = false)
  private final String supporter;

  protected StartupSupport() {
    this(null, null, null, null);
  }

  public StartupSupport(Long id, String title, String content, String supporter) {
    this.id = id;
    this.title = title;
    this.content = content;
    this.supporter = supporter;
  }

  public Long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getContent() {
    return content;
  }

  public String getSupporter() {
    return supporter;
  }
}
