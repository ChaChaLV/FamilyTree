import model.fimily_tree.FamilyTree;
import model.human.Human;
import model.human.Gender;
import model.service.Service;
import model.writer.FileHandler;
import view.ConsoleUi;
import view.View;

import java.io.Console;
import java.time.LocalDate;


public class Main {

    public static void main(String[] args) {


//        // System.out.println(tree.toString());
//        String filePath = "C:\\Users\\Tochka0265\\Desktop\\DDD\\src\\ru.gb\\familyTree\\tree.txt";
//
//        FamilyTree tree = read(filePath);
//
//        save(tree, filePath);

        testTree();




    }

static FamilyTree read (String filePath){
    FileHandler fileHandler = new FileHandler();
    return (FamilyTree) fileHandler.read(filePath);
}

static void save (FamilyTree familyTree, String filePath){
    FileHandler fileHandler = new FileHandler();
    fileHandler.save(familyTree, filePath);
}

static void testTree() {
    FamilyTree tree = new FamilyTree();

    Human pavel = new Human("Павел", Gender.Male, LocalDate.of(1988, 01, 28));
    Human vera = new Human("Вера", Gender.Female, LocalDate.of(1990, 12, 12));

    tree.addHuman(pavel);
    tree.addHuman(vera);

    pavel.setSpouse(vera);
    vera.setSpouse(pavel);

    Human tima = new Human("Тимофей", Gender.Male, LocalDate.of
            (2016, 03, 18), pavel, vera);
    tree.addHuman(tima);

    tree.sortByName();
    System.out.println(tree.toString());
    System.out.println("============");
    tree.sortByAge();
    System.out.println(tree.toString());

    Service service = new Service(tree);
    service.setWritable(new FileHandler());
    service.save();

    View view = new ConsoleUi();
    view.start();
}
}