package minhho.utils;

public class Utils {

    public static int toBinary(int i) {
        if (i == 0) {
            return 0;
        } else {
            return (i % 2 + 10 * toBinary(i / 2));
        }
    }

}
