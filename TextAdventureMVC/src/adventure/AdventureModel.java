package adventure;

import java.util.HashSet;
import java.util.Set;

/**
 * AdventureModel stores all data related to the adventure,
 * including valid verbs, nouns, inventory, and adventure state.
 */
public class AdventureModel {

    private Set<String> verbs = new HashSet<>();
    private Set<String> nouns = new HashSet<>();
    private Set<String> inventory = new HashSet<>();

    private boolean doorOpen = false;

    public AdventureModel() {
        verbs.add("open");
        verbs.add("take");
        verbs.add("drink");
        verbs.add("wear");
        verbs.add("check");
        verbs.add("leave");

        nouns.add("door");
        nouns.add("backpack");
        nouns.add("coffee");
        nouns.add("phone");
        nouns.add("shoes");
        nouns.add("clock");
        nouns.add("house");
    }

    public boolean isValidVerb(String verb) {
        return verbs.contains(verb);
    }

    public boolean isValidNoun(String noun) {
        return nouns.contains(noun);
    }

    public String processCommand(String verb, String noun) {
        if (verb.equals("open") && noun.equals("door")) {
            doorOpen = true;
            return "You open the door.";
        }

        if (verb.equals("take")) {
            inventory.add(noun);
            return "You take the " + noun + ".";
        }

        if (verb.equals("leave") && noun.equals("house")) {
            if (doorOpen && inventory.contains("backpack") && inventory.contains("shoes")) {
                return "You leave the house fully prepared. Adventure complete!";
            }
            return "You are not ready to leave yet.";
        }

        return "Nothing happens.";
    }
}
