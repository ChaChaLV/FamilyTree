package view.commands;

import view.ConsoleUi;

public class GetHumanListInfo extends Command{


    public GetHumanListInfo (ConsoleUi consoleUi) {

        super("Получить список членов семьи", consoleUi);
    }

    @Override
    public void execute() {
        getConsoleUi().getHumanListInfo();
    }
}
