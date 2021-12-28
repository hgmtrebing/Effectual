package us.hgmtrebing.Effectual.impl;

import javax.persistence.*;
import java.sql.Timestamp;

@MappedSuperclass
public class Element {

  @Id
  @GeneratedValue
  private long id;
  private String name;
  private String description;

  @JoinColumn
  @ManyToOne
  private User author;

  @Column (name="create_date")
  private Timestamp createDate;

  @Column (name="last_modified_time")
  private Timestamp lastModifiedTime;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public User getAuthor() {
    return author;
  }

  public void setAuthor(User author) {
    this.author = author;
  }

  public Timestamp getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Timestamp createDate) {
    this.createDate = createDate;
  }

  public Timestamp getLastModifiedTime() {
    return lastModifiedTime;
  }

  public void setLastModifiedTime(Timestamp lastModifiedTime) {
    this.lastModifiedTime = lastModifiedTime;
  }
}
