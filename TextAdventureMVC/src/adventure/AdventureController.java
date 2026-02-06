package adventure;

import java.util.Scanner;

/**
 * AdventureController connects the model and view
 * and controls the flow of the adventure.
 */
public class AdventureController {

    private AdventureModel model;
    private AdventureView view;
    private CommandParser parser;

    public AdventureController() {
        model = new AdventureModel();
        view = new AdventureView();
        parser = new CommandParser();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        view.showMessage("Welcome to the Morning Adventure!");

        while (true) {
            String input = scanner.nextLine();
            String[] parts = parser.parse(input);

            String verb = parts[0];
            String noun = parts[1];

            if (!model.isValidVerb(verb)) {
                view.showError("Unknown verb");
                continue;
            }

            if (!model.isValidNoun(noun)) {
                view.showError("Unknown noun");
                continue;
            }

            String result = model.processCommand(verb, noun);
            view.showMessage(result);
        }
    }
}
