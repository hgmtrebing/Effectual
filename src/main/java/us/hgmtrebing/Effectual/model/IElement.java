package us.hgmtrebing.Effectual.model;

import java.sql.Timestamp;

public interface IElement {
  public abstract long getId();
  public abstract void setId(long id);

  public abstract String getName();
  public abstract void setName(String name);

  public abstract String getDescription();
  public abstract void setDescription(String description);

  public abstract IUser getAuthor();
  public abstract void setAuthor(IUser author);

  public abstract Timestamp getCreateDate();
  public abstract void setCreateDate(Timestamp date);

  public abstract Timestamp getLastModifiedTime();
  public abstract void setLastModifiedTime(Timestamp date);
}
