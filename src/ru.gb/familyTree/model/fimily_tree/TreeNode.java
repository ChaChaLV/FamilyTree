package model.fimily_tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface TreeNode <T>{

    void setId(long id);
    long getId();
    T getFather();
    T getMother();
    boolean addParent (T human);
    boolean  addChild (T human);
    String getName();
    LocalDate getBirthDate();
    LocalDate getDeathDate();
    List<T> getParents();
    List<T> getChildren();
    T getSpouse();
    void setSpouse(T human);
}
