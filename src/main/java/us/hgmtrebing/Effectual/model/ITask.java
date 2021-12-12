package us.hgmtrebing.Effectual.model;

import java.time.LocalDateTime;

public interface ITask {
    public abstract long getId();
    public abstract String getTitle();
    public abstract String getDescription();
    public abstract IUser getAuthor();
    public abstract IUser getOwner();
    public abstract LocalDateTime getCreateDate();
    public abstract LocalDateTime getLastModifiedDate();
}
