package us.hgmtrebing.Effectual.model;

import java.time.LocalDateTime;

public interface IUser {
    public abstract String getFirstName();
    public abstract String getLastName();
    public abstract String getUsername();
    public abstract String getEmailAddress();
    public abstract LocalDateTime getCreateDate();
    public abstract LocalDateTime getLastModifiedDate();
    public abstract LocalDateTime getLastLoginTime();
}
