package us.hgmtrebing.Effectual.model;

import java.time.LocalDateTime;

public interface IUser {
    public abstract long getId();
    public abstract String getFirstName();
    public abstract String getLastName();
    public abstract String getUsername();
    public abstract String getEmailAddress();
    /*
    public abstract LocalDateTime getCreateDate();
    public abstract LocalDateTime getLastModifiedDate();
    public abstract LocalDateTime getLastLoginTime();

     */

    public abstract void setId(long id);
    public abstract void setFirstName(String firstName);
    public abstract void setLastName(String lastName);
    public abstract void setUsername(String username);
    public abstract void setEmailAddress(String emailAddress);
    /*
    public abstract void setCreateDate(LocalDateTime createDate);
    public abstract void setLastModifiedDate(LocalDateTime lastModifiedDate);
    public abstract void setLastLoginTime(LocalDateTime lastLoginTime);
     */
}
