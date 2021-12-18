package us.hgmtrebing.Effectual.model;

import java.util.List;

public interface IProject extends IElement{

  public abstract IProject getParent();
  public abstract void setParent(IProject newParent);

  public abstract List<IProject> getChildren();
  public abstract void addChild(IProject child);
  public abstract void removeChild(IProject child);

  public abstract List<ITask> getTasks();
  public abstract void addTask(ITask task);
  public abstract void removeTask(ITask task);
}
