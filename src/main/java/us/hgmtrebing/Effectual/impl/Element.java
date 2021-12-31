package us.hgmtrebing.Effectual.impl;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;

@MappedSuperclass
public class Element {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
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

  public Element() {
    this("", "", null);
  }

  public Element(String name, String description, User author) {
    this.name = name;
    this.description = description;
    this.author = author;

    Timestamp now = new Timestamp(System.currentTimeMillis());
    this.createDate = now;
    this.lastModifiedTime = now;
  }

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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Element element = (Element) o;
    return id == element.id && name.equals(element.name) && description.equals(element.description) && author.equals(element.author) && createDate.equals(element.createDate) && lastModifiedTime.equals(element.lastModifiedTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, description, author, createDate, lastModifiedTime);
  }

  @Override
  public String toString() {
    return "Element{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", description='" + description + '\'' +
            ", author=" + author +
            ", createDate=" + createDate +
            ", lastModifiedTime=" + lastModifiedTime +
            '}';
  }
}
