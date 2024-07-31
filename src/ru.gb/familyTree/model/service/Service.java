package model.service;

import model.fimily_tree.FamilyTree;
import model.human.Gender;
import model.human.Human;
import model.writer.Writable;

import java.time.LocalDate;

public class Service {

    private Writable writable;
    private FamilyTree<Human> activeFamily;


    public Service(FamilyTree<Human> activeFamily) {
        this.activeFamily = activeFamily;
    }

    public Service(){
        activeFamily = new FamilyTree<>();
    }

    public boolean save(){
        if (writable == null){
            return false;
        }
        return writable.save(activeFamily);
    }

    public boolean load(){
        if(writable == null){
            return false;
        }
        activeFamily = writable.read();
        return true;
    }
    public void addHuman(String name, String genderString, String birthDateStr,String idFatherStr,
                         String idMotherStr){

        Gender gender = Gender.valueOf(genderString);
        LocalDate birthDate = LocalDate.parse(birthDateStr);
        Human father = activeFamily.getById(Integer.parseInt(idFatherStr));
        Human mother = activeFamily.getById(Integer.parseInt(idMotherStr));
        Human human = new Human(name, gender, birthDate, father, mother);
        activeFamily.addHuman(human);
    //    return "Человек успешно добавлен в дерево";
    }

    public void setWritable(Writable writable) {
        this.writable = writable;
    }

    public void sortByName(){
        activeFamily.sortByName();
    }

    public void sortByAge(){
        activeFamily.sortByAge();
    }

    public String getHumanList() {
        return activeFamily.getInfo();
    }

}