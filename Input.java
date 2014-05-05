package cheque;

import java.util.*;

public class Input {
    private Scanner sc;
    private String numInput;
    private String[] split;
    private boolean invalid = false;

    public Input() {
        sc = new Scanner(System.in);
        System.out.println("Usage: dollars.cents");
        System.out.println("type \'exit\' to quit");
    }

    public void process() {
        while (true) {
            System.out.print("> ");
            // scan in string
            numInput = sc.nextLine();

            if (numInput.equals("exit")) {
                break;
            }

            split = numInput.split("\\.");
            invalid = false;

            if (split.length != 2) {
                invalid = true;
                System.out.println("Usage: dollars.cents");
                continue;
            }

            if (split[0].length() == 0 || !isNumeric(split[0]) || 
                    !isNumeric(split[1])) {
                invalid = true;
                System.out.println("Usage: dollars.cents");
                continue;
            }

            if (split[1].length() > 2) {
                split[1] = split[1].substring(0,2);
            } else if (split[1].length() == 1) {
                // pad out string with an extra zero
                split[1] += "0";
            }

            if (invalid == false) {
                new Parse(split[0], split[1]);
            }
        }
    }

    private boolean isNumeric(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
