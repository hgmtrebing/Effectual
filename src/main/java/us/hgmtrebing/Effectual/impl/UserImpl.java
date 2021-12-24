package us.hgmtrebing.Effectual.impl;

import us.hgmtrebing.Effectual.model.IUser;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table (name = "tbl_user_impl") // Hibernate automatically generates a Table Name - this can override the default name.
public class UserImpl implements IUser {

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


  /*
  private LocalDateTime createDate;
  private LocalDateTime lastModifiedDate;
  private LocalDateTime lastLoginDate;
   */

  public UserImpl() {
    this.firstName = "";
    this.lastName = "";
    this.username = "";
    this.emailAddress = "";
  }

  @Override
  public long getId() {
    return this.id;
  }

  @Override
  public void setId(long id) {
    this.id = id;
  }

  @Override
  public String getFirstName() {
    return this.firstName;
  }

  @Override
  public String getLastName() {
    return this.lastName;
  }

  @Override
  public String getUsername() {
    return this.username;
  }

  @Override
  public String getEmailAddress() {
    return this.emailAddress;
  }

  /*
  @Override
  public LocalDateTime getCreateDate() {
    return this.createDate;
  }

  @Override
  public LocalDateTime getLastModifiedDate() {
    return this.lastModifiedDate;
  }

  @Override
  public LocalDateTime getLastLoginTime() {
    return this.lastLoginDate;
  }
   */

  @Override
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  @Override
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @Override
  public void setUsername(String username) {
    this.username = username;
  }

  @Override
  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  /*
  @Override
  public void setCreateDate(LocalDateTime createDate) {
    this.createDate = createDate;
  }

  @Override
  public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
    this.lastModifiedDate = lastModifiedDate;
  }

  @Override
  public void setLastLoginTime(LocalDateTime lastLoginTime) {
    this.lastLoginDate = lastLoginTime;
  }
   */
}
