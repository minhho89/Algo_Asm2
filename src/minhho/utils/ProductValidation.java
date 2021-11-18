package minhho.utils;

public class ProductValidation {

    /**
     * Product code validation
     * Code have to be no space
     * @param code inspection code
     * @return true if valid, false if not
     */
    public static boolean isCodeValid(String code) {
        int length = code.length();
        char[] charArray = code.toCharArray();

        // Check if is there any white space or not
        for (int i = 0; i < length; i++) {
            if (Character.isWhitespace(charArray[i]))
                return false;
        }
        return true;
    }

    public static boolean isPriceValid(String price) {
        try {
            Double.parseDouble(price);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isQuantityValid(String qty) {
        try {
            Integer.parseInt(qty);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
