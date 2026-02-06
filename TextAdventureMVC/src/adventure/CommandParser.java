package adventure;

/**
 * CommandParser extracts a verb and noun from user input
 * without using split or regular expressions.
 */
public class CommandParser {

    public String[] parse(String input) {
        input = input.toLowerCase().trim();

        String verb = "";
        String noun = "";
        boolean spaceFound = false;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c == ' ' && !spaceFound) {
                spaceFound = true;
                continue;
            }

            if (!spaceFound) {
                verb += c;
            } else {
                noun += c;
            }
        }

        return new String[]{verb, noun};
    }
}
