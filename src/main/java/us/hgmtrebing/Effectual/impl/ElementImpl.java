package us.hgmtrebing.Effectual.impl;

import us.hgmtrebing.Effectual.model.IElement;
import us.hgmtrebing.Effectual.model.IUser;

import java.time.LocalDateTime;

public class ElementImpl implements IElement {
  private long id;
  private String name;
  private String description;
  private IUser author;
  private LocalDateTime createDate;
  private LocalDateTime lastModifiedTime;

  @Override
  public long getId() {
    return 0;
  }

  @Override
  public String getName() {
    return null;
  }

  @Override
  public String getDescription() {
    return null;
  }

  @Override
  public IUser getAuthor() {
    return null;
  }

  @Override
  public LocalDateTime getCreateDate() {
    return null;
  }

  @Override
  public LocalDateTime getLastModifiedTime() {
    return null;
  }
}
