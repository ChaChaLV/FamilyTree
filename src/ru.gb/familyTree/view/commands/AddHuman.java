package view.commands;

import view.ConsoleUi;

public class AddHuman extends Command{


    public AddHuman(ConsoleUi consoleUi) {

        super("Добавить члена семьи", consoleUi);
    }

    @Override
    public void execute() {
        getConsoleUi().addHuman();
    }
}
