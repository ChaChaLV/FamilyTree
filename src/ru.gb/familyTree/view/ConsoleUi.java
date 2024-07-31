
package view;

import presenter.Presenter;

import java.awt.*;
import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUi implements View{
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private Menu menu;

    public ConsoleUi(){
        Scanner scanner = new Scanner(System.in);
        Presenter presenter = new Presenter(this);
        work = true;
        Menu menu = new Menu(this);
    }

    public void addHuman() {
        System.out.println("Укажите имя");
        String name = scanner.nextLine();
        System.out.println("Укажите пол");
        String genderStr = scanner.nextLine();
        System.out.println("Укажите дату рождения в формате гггг.мм.дд");
        String birthDateStr =scanner.nextLine();
        System.out.println("Укажите id отца");
        String idFatherStr = scanner.nextLine();
        System.out.println("Укажите id матери");
        String idMotherStr = scanner.nextLine();
        presenter.addHuman(name,genderStr, birthDateStr, idFatherStr, idMotherStr);
    }

    public void load(){
        presenter.load();
    }
    @Override
    public void start() {
        while (work) {
            System.out.println(menu.print());
            String choice = scanner.nextLine();
            if (checkChoice(choice)) {
                menu.execute(Integer.parseInt(choice));
            }
        }
    }



    public boolean checkChoice(String choiceStr){
        if (choiceStr.matches("\\d")){
            int choice = Integer.parseInt(choiceStr);
            return choice >= 1 && choice <= menu.commandSize();
        }
        return false;
    }

    public void finish(){
        System.out.println("Пока-пока!");
        work = false;
    }

    public void sortByName(){
        presenter.sortByName();
    }

    public void sortByAge(){
        presenter.sortByAge();
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }


    public void getHumanListInfo() {
        presenter.getHumanListInfo();
    }

    public void save(){
        presenter.save();
    }
}



