package cheque;

import java.util.*;

public class Parse {
    String finalString = "";
    String subString = "";

    public Parse(String dollars, String cents) {
        finalString = parseDollars(Integer.parseInt(dollars)) + " DOLLARS";
        subString = "";
        if (Integer.parseInt(cents) != 0) {
            finalString += " AND " + parseCents(Integer.parseInt(cents)) + 
                    " CENTS";
        }
        System.out.println(finalString);
    }

    private String parseDollars(int dollars) {
        if (dollars < 10 && dollars > 0) {
            subString += Cheque.ones[dollars - 1];
        } else if (dollars < 20 && dollars > 10) {
            subString += Cheque.teens[(dollars % 10) - 1];
        } else if (dollars < 100 && dollars >= 20) {
            if (dollars % 10 == 0) {
                subString += Cheque.tens[dollars/10 - 1];
            } else {
                subString += Cheque.tens[(dollars/10) - 1];
                subString += "-";
                parseDollars((dollars % 10));
            }
        } else if (dollars < 1000 && dollars > 100) {
            if (dollars % 100 == 0) {
                subString += Cheque.ones[(dollars/100) - 1];
                subString += " HUNDRED ";
            } else {
                subString += Cheque.ones[(dollars/100) - 1];
                subString += " HUNDRED AND ";
                parseDollars((dollars % 100));
            }
        } else if (dollars < 10000 && dollars > 1000) {
            if (dollars % 1000 == 0) {
                subString += Cheque.ones[(dollars/1000) - 1];
                subString += " THOUSAND ";
            } else {
                subString += Cheque.ones[(dollars/1000) - 1];
                subString += " THOUSAND AND ";
                parseDollars((dollars % 1000));
            }
        } else if (dollars < 11000 && dollars > 10000) {
            subString += "TEN THOUSAND AND ";
            parseDollars((dollars % 1000));
        } else if (dollars < 20000 && dollars >= 11000) {
            if (dollars % 1000 == 0) {
                subString += Cheque.teens[((dollars/1000) % 10) - 1];
                subString += " THOUSAND";
            } else {
                subString += Cheque.teens[((dollars/1000) % 10) - 1];
                subString += " THOUSAND AND ";
                parseDollars(dollars % 1000);
            }
        } else if (dollars < 100000 && dollars > 20000) {
            if (dollars % 10000 == 0) {
                subString += Cheque.tens[(dollars/10000) - 1];
                subString += " THOUSAND ";
            } else {
                subString += Cheque.tens[(dollars/10000) - 1];
                if (Character.getNumericValue(Integer.toString(
                        dollars).charAt(1)) == 0) {
                    subString += " THOUSAND AND ";
                } else {
                    subString += "-";
                }
                parseDollars((dollars % 10000));
            }
        } else {
            // all other options not covered
            switch (dollars) {
                case 0:     subString += "ZERO";
                            break;
                case 10:    subString += "TEN";
                            break;
                case 100:   subString += "ONE HUNDRED";
                            break;
                case 1000:  subString += "ONE THOUSAND";
                            break;
                case 10000: subString += "TEN THOUSAND";
                            break;
                case 20000: subString += "TWENTY THOUSAND";
                            break;
                case 100000:subString += "ONE HUNDRED THOUSAND";
                            break;
            }
        }
        return subString;
    }

    private String parseCents(int cents) {
        if (cents < 10 && cents > 0) {
            subString += Cheque.ones[cents - 1];
        } else if (cents < 20 && cents > 10) {
            subString += Cheque.teens[(cents % 10) - 1];
        } else if (cents < 100 && cents >= 20) {
            if (cents % 10 == 0) {
                subString += Cheque.tens[cents/10 - 1];
            } else {
                subString += Cheque.tens[(cents/10) - 1];
                subString += "-";
                parseDollars((cents % 10));
            }
        } else {
            switch (cents) {
                case 10:    subString += "TEN";
                            break;
            }
        }
        return subString;
    }
}
