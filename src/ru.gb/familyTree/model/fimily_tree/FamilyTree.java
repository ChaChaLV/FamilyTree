package model.fimily_tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends TreeNode<T>> implements Serializable, Iterable<T>{
    private long humansId;
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
        human.setId(humansId++);

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

    public List<T> getSiblings(int id){
        T human = getById(id);
        if (human == null){
            return null;
        }
        List<T> res = new ArrayList<>();
        for (T parent: human.getParents()){
            for (T child: parent.getChildren()){
                if (!child.equals(human)){
                    res.add(child);
                }
            }
        }
        return res;
    }

    public boolean setWedding(long humanId1, long humanId2){
        if (checkId(humanId1) && checkId(humanId2)){
            T human1 = getById(humanId1);
            T human2 = getById(humanId2);
            if (human1.getSpouse() == null && human2.getSpouse() == null){
                human1.setSpouse(human2);
                human2.setSpouse(human1);
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean setDivorce(long humanId1, long humanId2){
        if (checkId(humanId1) && checkId(humanId2)){
           T human1 = getById(humanId1);
            T human2 = getById(humanId2);
            if (human1.getSpouse() != null && human2.getSpouse() != null){
                human1.setSpouse(null);
                human2.setSpouse(null);
            } else {
                return false;
            }
        }
        return false;
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

    private boolean checkId(long id){
        if (id >= humansId || id < 0){
            return false;
        }
        for (T human: family){
            if (human.getId() == id){
                return true;
            }
        }
        return false;
    }

    public T getById(long id){
        for (T human: family){
            if (human.getId() == id){
                return human;
            }
        }
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return new FamilyTreeIterator<>(family);
    }

   }
