import java.time.LocalDate;


public class Main {

    public static void main(String[] args) {


        // System.out.println(tree.toString());
        String filePath = "C:\\Users\\Tochka0265\\Desktop\\DDD\\src\\ru.gb\\familyTree\\tree.txt";

        FamilyTree tree = read(filePath);

        save(tree, filePath);

        // Writable writable = new FileHandler();

    }

static FamilyTree read (String filePath){
    FileHandler fileHandler = new FileHandler();
    return (FamilyTree) fileHandler.read(filePath);
}

static void save (FamilyTree familyTree, String filePath){
    FileHandler fileHandler = new FileHandler();
    fileHandler.save(familyTree, filePath);
}

static FamilyTree trstTree(){
        FamilyTree tree = new FamilyTree();

        Human pavel = new Human("Павел", Gender.Male, LocalDate.of(1988, 01, 28));
        Human vera = new Human("Вера", Gender.Female, LocalDate.of(1990, 12, 12));

        tree.addHuman(pavel);
        tree.addHuman(vera);

        pavel.setSpouse(vera);
        vera.setSpouse(pavel);

        Human tima = new Human("Тимофей",Gender.Male, LocalDate.of
                               (2016, 03, 18), pavel, vera);
        tree.addHuman(tima);

        return tree;
}
}