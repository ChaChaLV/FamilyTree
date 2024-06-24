package family_tree;

import human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends TreeNode<T>> implements Serializable, Iterable<T>{
    private List<T> family;

public FamilyTree (){
    this(new ArrayList<>());
}

public FamilyTree(List<T> family){ this.family = family; }

public boolean addHuman (T human){
    if (human == null) {
        return false;
    }
    if (!family.contains(human)) {
        family.add(human);

        addToParents(human);
        addToChildren(human);

        return true;
    }
    return false;
}

private void addToParents(T human){
    for (T parrent : human.getParents()) {
       parrent.addChild(human);
    }
}

private void addToChildren(T human){
    for (T child : human.getChildren()) {
        child.addParent(human);
    }
}

public List<T> getByName (String name){
    List<T> res = new ArrayList<>();
    for (T human : family) {
        if (human.getName().equals(name)) {
            res.add(human);
        }
    }
    return res;
}

@Override
public String toString() {
    return getInfo();
}

public String getInfo(){
    StringBuilder sb = new StringBuilder();
    for (T human : family) {
        sb.append(human);
        sb.append("\n");
    }
    return sb.toString();
}

public void sortByName(){family.sort(new FamilyTreeComparatorByName<>());}

public void sortByAge(){family.sort(new FamilyTreeComparatorAge<>());}

    @Override
    public Iterator<T> iterator() {
        return new FamilyTreeIterator<>(family);
    }

   }
