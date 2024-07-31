package view.commands;

import view.ConsoleUi;

public class Save extends Command{


    public Save (ConsoleUi consoleUi) {

        super("Дерево сохранено", consoleUi);
    }

    @Override
    public void execute() {
        getConsoleUi().save();
    }
}
