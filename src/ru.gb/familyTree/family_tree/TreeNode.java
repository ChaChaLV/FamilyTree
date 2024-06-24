package family_tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface TreeNode <T> extends Serializable{
    T getFather();
    T getMother();
    void addParent (T human);
    void  addChild (T human);
    String getName();
    LocalDate getBirthDate();
    LocalDate getDeathDate();
    List<T> getParents();
    List<T> getChildren();
}
