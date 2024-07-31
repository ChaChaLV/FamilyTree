package view.commands;

import view.ConsoleUi;

public class Load extends Command{


    public Load(ConsoleUi consoleUi) {

        super("Загрузить семейное древо", consoleUi);
    }

    @Override
    public void execute() {
        getConsoleUi().load();
    }
}
