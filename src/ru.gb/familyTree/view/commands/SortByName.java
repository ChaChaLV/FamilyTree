package view.commands;

import view.ConsoleUi;

public class SortByName extends Command{
    public SortByName (ConsoleUi consoleUi) {

        super("Сортировать по имени", consoleUi);
    }

    @Override
    public void execute() {
        getConsoleUi().sortByName();
    }
}
