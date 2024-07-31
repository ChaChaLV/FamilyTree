package view.commands;

import view.ConsoleUi;

public class Finish extends Command{
    public Finish (ConsoleUi consoleUi) {
        super("Завершить работу", consoleUi);
    }

    @Override
    public void execute() {
        getConsoleUi().finish();
    }
}
