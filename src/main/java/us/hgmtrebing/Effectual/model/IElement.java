package us.hgmtrebing.Effectual.model;

import java.time.LocalDateTime;

public interface IElement {
  public abstract long getId();
  public abstract String getName();
  public abstract String getDescription();
  public abstract IUser getAuthor();
  public abstract LocalDateTime getCreateDate();
  public abstract LocalDateTime getLastModifiedTime();
}
