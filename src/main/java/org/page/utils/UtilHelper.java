package org.utils;

public class UtilHelper {

    // Converts a product name to a lowercase with replacing the spaces by "-"

    public static String toDataTestFormat(String productName) {
        return productName.toLowerCase().replaceAll(" ", "-");
    }
}
