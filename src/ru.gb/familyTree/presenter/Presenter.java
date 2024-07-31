package presenter;

import model.service.Service;
import view.View;

import java.time.LocalDate;

public class Presenter {
    private Service service;
    private View view;

    public Presenter(View view){
        this.view = view;
        service = new Service();
    }

    public void addHuman(String name, String genderStr, String birthDateStr, String idFatherStr,
                         String idMotherStr) {
        service.addHuman (name, genderStr ,birthDateStr, idFatherStr, idMotherStr);
        getHumanListInfo();
    }

    public void load(){
        service.load();
    }
    public void sortByName() {
        service.sortByName();
        getHumanListInfo();
    }

    public void getHumanListInfo() {
        String info = service.getHumanList();
        view.printAnswer(info);
    }

    public void sortByAge(){
        service.sortByAge();
        getHumanListInfo();
    }

    public void save() {
        service.save();
    }

}
