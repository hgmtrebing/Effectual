package us.hgmtrebing.Effectual.impl;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table (name = "tbl_user_impl") // Hibernate automatically generates a Table Name - this can override the default name.
public class User {

  @Id
  @GeneratedValue
  @Column (name = "user_id")
  private long id;

  @Column (name = "user_first_name")
  private String firstName;

  @Column (name = "user_last_name")
  private String lastName;

  @Column (name = "user_name")
  private String username;

  @Column (name = "user_email_address")
  private String emailAddress;

  @Column (name="create_date")
  private Timestamp createDate;

  @Column (name="last_modified_date")
  private Timestamp lastModifiedDate;

  @Column (name="last_login_time")
  private Timestamp lastLoginTime;


  public User() {
    this.firstName = "";
    this.lastName = "";
    this.username = "";
    this.emailAddress = "";

    Timestamp now = new Timestamp(System.currentTimeMillis());
    this.createDate = now;
    this.lastModifiedDate = now;
    this.lastLoginTime = now;
  }

  public long getId() {
    return this.id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public String getUsername() {
    return this.username;
  }

  public String getEmailAddress() {
    return this.emailAddress;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  public Timestamp getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Timestamp createDate) {
    this.createDate = createDate;
  }

  public Timestamp getLastModifiedDate() {
    return lastModifiedDate;
  }

  public void setLastModifiedDate(Timestamp lastModifiedDate) {
    this.lastModifiedDate = lastModifiedDate;
  }

  public Timestamp getLastLoginTime() {
    return lastLoginTime;
  }

  public void setLastLoginTime(Timestamp lastLoginTime) {
    this.lastLoginTime = lastLoginTime;
  }
}
