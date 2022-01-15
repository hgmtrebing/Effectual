package us.hgmtrebing.Effectual.impl;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="todo_elements")
public class TodoElement {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  @Column(name="id")
  private long id;

  @Column(name="name")
  private String name;

  @Column(name="description")
  private String description;

  @JoinColumn
  @ManyToOne
  @Transient
  private TodoElementType elementType;

  @JoinColumn
  @ManyToOne
  @Transient
  private TodoElementStatus elementStatus;

  @JoinColumn
  @ManyToOne
  private User author;

  @Column (name="create_date")
  private Timestamp createDate;

  @Column (name="last_modified_time")
  private Timestamp lastModifiedTime;

  public TodoElement(String name, String description, User author) {
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

  public TodoElementType getElementType() {
    return elementType;
  }

  public void setElementType(TodoElementType elementType) {
    this.elementType = elementType;
  }

  public TodoElementStatus getElementStatus() {
    return elementStatus;
  }

  public void setElementStatus(TodoElementStatus elementStatus) {
    this.elementStatus = elementStatus;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    TodoElement todoElement = (TodoElement) o;
    return id == todoElement.id && name.equals(todoElement.name) && description.equals(todoElement.description) && author.equals(todoElement.author) && createDate.equals(todoElement.createDate) && lastModifiedTime.equals(todoElement.lastModifiedTime);
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
