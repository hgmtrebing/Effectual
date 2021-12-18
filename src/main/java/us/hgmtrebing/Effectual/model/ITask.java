package us.hgmtrebing.Effectual.model;

import java.time.LocalDateTime;
import java.util.List;

public interface ITask extends IElement{
    public abstract IProject getProject();
    public abstract void setProject(IProject project);

    public abstract ITask getParent();
    public abstract void setParent(ITask parent);

    public abstract List<ITask> getChildren();
    public abstract void addChild(ITask child);
    public abstract void removeChild(ITask child);
}
