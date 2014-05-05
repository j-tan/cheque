package cheque;

import java.util.*;

public class Cheque {
    public static final String[] ones = {
            "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", 
            "NINE"};
    public static final String[] teens = {
            "ELEVEN", "TWELVE", "THIRTEEN", "FOURTEEN", "FIFTEEN", "SIXTEEN", 
            "SEVENTEEN", "EIGHTEEN", "NINETEEN"};
    public static final String[] tens = {
            "TEN", "TWENTY", "THIRTY", "FORTY", "FIFTY", "SIXTY", "SEVENTY", 
            "EIGHTY", "NINETY"};

    public static void main(String[] args) {
        Input in = new Input();
        in.process();
    }
}
