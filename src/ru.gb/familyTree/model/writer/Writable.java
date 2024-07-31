package model.writer;

import model.fimily_tree.FamilyTree;
import model.human.Human;

import java.io.Serializable;

public interface Writable {
    boolean save(FamilyTree<Human>family);
    FamilyTree<Human>read();
    void setFilePath(String filePath);
}
