package view;

import view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Command> commands;

    public Menu(ConsoleUi consoleUi) {
        commands = new ArrayList<>();
        commands.add(new AddHuman(consoleUi));
        commands.add(new GetHumanListInfo(consoleUi));
        commands.add(new SortByName(consoleUi));
        commands.add(new SortByAge(consoleUi));
        commands.add(new Finish(consoleUi));
    }

    public String print(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список комманд:\n");
        for (int i = 0; i < commands.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(commands.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int choice){
        Command command = commands.get(choice-1);
        command.execute();
    }

    public int commandSize(){
        return commands.size();
    }
}
