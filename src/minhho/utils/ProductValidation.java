package minhho.utils;

public class ProductValidation {

    /**
     * Product code validation
     * Code have to be no space
     * @param code inspection code
     * @return true if valid, false if not
     */
    public static boolean isCodeValid(String code) {
        return code.matches("\\s+");
    }

}
