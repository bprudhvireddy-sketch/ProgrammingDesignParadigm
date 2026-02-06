package adventure;

/**
 * AdventureView handles all output shown to the user.
 */
public class AdventureView {

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showError(String error) {
        System.out.println("Error: " + error);
    }
}
