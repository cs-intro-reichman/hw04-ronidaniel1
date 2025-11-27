public class MyString {
    public static void main(String[] args) {
        System.out.println("Testing lowercase:");
        System.out.println("UnHappy : " + lowerCase("UnHappy"));
        System.out.println("This costs 15 Sheksls : " + lowerCase("This costs 15 Sheksls"));
        System.out.println("TLV : " + lowerCase("TLV"));
        System.out.println("lowercase : " + lowerCase("lowercase"));

        System.out.println("Testing contains:");
        System.out.println(contains("unhappy", "happy")); // true
        System.out.println(contains("happy", "unhappy")); // false
        System.out.println(contains("historical", "story")); // false
        System.out.println(contains("psychology", "psycho")); // true
        System.out.println(contains("personality", "son")); // true
        System.out.println(contains("personality", "dad")); // false
        System.out.println(contains("resignation", "sign")); // true
    }

    /** Returns the lowercase version of the given string. */
    public static String lowerCase(String str) {
        // We will build the new string character by character
        String newStr = "";
        
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            
            // Check if the character is an uppercase letter (A-Z)
            if (c >= 'A' && c <= 'Z') {
                // Convert to lowercase by adding 32 to the ASCII value
                // ('A' is 65, 'a' is 97. The difference is 32)
                c = (char) (c + 32);
            }
            // Append the character (modified or original) to the result
            newStr = newStr + c;
        }
        
        return newStr;
    }

    /** If str1 contains str2, returns true; otherwise returns false. */
    public static boolean contains(String str1, String str2) {
        // If str2 is longer than str1, it clearly cannot be contained inside it
        if (str1.length() < str2.length()) {
            return false;
        }
        
        // Edge case: an empty string is theoretically contained in any string
        if (str2.length() == 0) {
            return true;
        }

        // Iterate through str1 only up to the point where str2 could still fit
        for (int i = 0; i <= str1.length() - str2.length(); i++) {
            
            boolean match = true;
            
            // Check if str2 matches str1 starting at index i
            for (int j = 0; j < str2.length(); j++) {
                if (str1.charAt(i + j) != str2.charAt(j)) {
                    match = false;
                    break; // Stop checking this position as soon as we find a mismatch
                }
            }
            
            // If we finished the inner loop and match is still true, we found it!
            if (match) {
                return true;
            }
        }
        
        return false;
    }
}