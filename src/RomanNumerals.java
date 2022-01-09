import java.util.HashMap;

public class RomanNumerals {
    public static final int MAX = 3999;

    private static final Integer[] ARABIC = { 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000 };

    private static final String[] ROMAN = { "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M" };

    private static final HashMap<String, Integer> ARABIC_ROMAN = Utils.zip(ROMAN, ARABIC);

    public static boolean isRoman(String number) {
        return number.matches("^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$");
    }

    public static String arabicToRoman(int number) throws IllegalArgumentException {
        if (number > MAX || number < 1) {
            throw new IllegalArgumentException("value parameter should be in range of [1, 4000)");
        }

        StringBuilder builder = new StringBuilder();
        int index = ARABIC.length - 1;

        while (number > 0) {
            int div = number / ARABIC[index];
            number = number % ARABIC[index];
            while ((div--) > 0) {
                builder.append(ROMAN[index]);
            }
            index--;
        }

        return builder.toString();
    }

    public static int romanToArabic(String number) throws IllegalArgumentException {
        if (!isRoman(number)) {
            throw new IllegalArgumentException("invalid roman numeral");
        }

        int arabic = 0;
        String[] tmp = number.split("");

        for (int i = 0; i < tmp.length; i++) {
            if (i + 1 < tmp.length && ARABIC_ROMAN.get(tmp[i]) < ARABIC_ROMAN.get(tmp[i + 1])) {
                arabic += ARABIC_ROMAN.get(tmp[i + 1]) - ARABIC_ROMAN.get(tmp[i]);
                i++;
                continue;
            }
            arabic += ARABIC_ROMAN.get(tmp[i]);
        }

        return arabic;
    }

    public static void main(String[] args) {
        System.out.println("=== isRoman === ");
        QuickTestFramework.assertTrue(isRoman("I"));
        QuickTestFramework.assertTrue(isRoman("II"));
        QuickTestFramework.assertTrue(isRoman("III"));
        QuickTestFramework.assertTrue(isRoman("IV"));
        QuickTestFramework.assertTrue(isRoman("V"));
        QuickTestFramework.assertTrue(isRoman("VI"));
        QuickTestFramework.assertTrue(isRoman("VII"));
        QuickTestFramework.assertTrue(isRoman("VIII"));
        QuickTestFramework.assertTrue(isRoman("IX"));
        QuickTestFramework.assertTrue(isRoman("X"));
        QuickTestFramework.assertTrue(isRoman("XI"));
        QuickTestFramework.assertTrue(isRoman("XII"));
        QuickTestFramework.assertTrue(isRoman("XIII"));
        QuickTestFramework.assertTrue(isRoman("XIV"));
        QuickTestFramework.assertTrue(isRoman("XV"));
        QuickTestFramework.assertTrue(isRoman("XVI"));
        QuickTestFramework.assertTrue(isRoman("XVII"));
        QuickTestFramework.assertTrue(isRoman("XVIII"));
        QuickTestFramework.assertTrue(isRoman("XIX"));
        QuickTestFramework.assertTrue(isRoman("XX"));
        QuickTestFramework.assertTrue(isRoman("CCXII"));
        QuickTestFramework.assertTrue(isRoman("CDXVII"));
        QuickTestFramework.assertTrue(isRoman("CMXCIX"));
        QuickTestFramework.assertTrue(isRoman("MDCCCXII"));
        QuickTestFramework.assertTrue(isRoman("MMMCMXCIX"));
        QuickTestFramework.assertFalse(isRoman("IIII"));
        QuickTestFramework.assertFalse(isRoman("IIIE"));
        QuickTestFramework.assertFalse(isRoman("IIXXDD"));
        QuickTestFramework.assertFalse(isRoman("CDMIIXX"));
        QuickTestFramework.assertFalse(isRoman("MMMMCMXCIX"));

        System.out.println("=== romanToArabic ===");
        QuickTestFramework.assertEqual(1, romanToArabic("I"));
        QuickTestFramework.assertEqual(2, romanToArabic("II"));
        QuickTestFramework.assertEqual(3, romanToArabic("III"));
        QuickTestFramework.assertEqual(4, romanToArabic("IV"));
        QuickTestFramework.assertEqual(5, romanToArabic("V"));
        QuickTestFramework.assertEqual(6, romanToArabic("VI"));
        QuickTestFramework.assertEqual(7, romanToArabic("VII"));
        QuickTestFramework.assertEqual(8, romanToArabic("VIII"));
        QuickTestFramework.assertEqual(9, romanToArabic("IX"));
        QuickTestFramework.assertEqual(10, romanToArabic("X"));
        QuickTestFramework.assertEqual(11, romanToArabic("XI"));
        QuickTestFramework.assertEqual(12, romanToArabic("XII"));
        QuickTestFramework.assertEqual(13, romanToArabic("XIII"));
        QuickTestFramework.assertEqual(14, romanToArabic("XIV"));
        QuickTestFramework.assertEqual(15, romanToArabic("XV"));
        QuickTestFramework.assertEqual(16, romanToArabic("XVI"));
        QuickTestFramework.assertEqual(17, romanToArabic("XVII"));
        QuickTestFramework.assertEqual(18, romanToArabic("XVIII"));
        QuickTestFramework.assertEqual(19, romanToArabic("XIX"));
        QuickTestFramework.assertEqual(20, romanToArabic("XX"));
        QuickTestFramework.assertEqual(212, romanToArabic("CCXII"));
        QuickTestFramework.assertEqual(417, romanToArabic("CDXVII"));
        QuickTestFramework.assertEqual(999, romanToArabic("CMXCIX"));
        QuickTestFramework.assertEqual(1812, romanToArabic("MDCCCXII"));
        QuickTestFramework.assertEqual(3999, romanToArabic("MMMCMXCIX"));

        System.out.println("=== arabicToRoman ===");
        QuickTestFramework.assertEqual(arabicToRoman(1), "I");
        QuickTestFramework.assertEqual(arabicToRoman(2), "II");
        QuickTestFramework.assertEqual(arabicToRoman(3), "III");
        QuickTestFramework.assertEqual(arabicToRoman(4), "IV");
        QuickTestFramework.assertEqual(arabicToRoman(5), "V");
        QuickTestFramework.assertEqual(arabicToRoman(6), "VI");
        QuickTestFramework.assertEqual(arabicToRoman(7), "VII");
        QuickTestFramework.assertEqual(arabicToRoman(8), "VIII");
        QuickTestFramework.assertEqual(arabicToRoman(9), "IX");
        QuickTestFramework.assertEqual(arabicToRoman(10), "X");
        QuickTestFramework.assertEqual(arabicToRoman(11), "XI");
        QuickTestFramework.assertEqual(arabicToRoman(12), "XII");
        QuickTestFramework.assertEqual(arabicToRoman(13), "XIII");
        QuickTestFramework.assertEqual(arabicToRoman(14), "XIV");
        QuickTestFramework.assertEqual(arabicToRoman(15), "XV");
        QuickTestFramework.assertEqual(arabicToRoman(16), "XVI");
        QuickTestFramework.assertEqual(arabicToRoman(17), "XVII");
        QuickTestFramework.assertEqual(arabicToRoman(18), "XVIII");
        QuickTestFramework.assertEqual(arabicToRoman(19), "XIX");
        QuickTestFramework.assertEqual(arabicToRoman(20), "XX");
        QuickTestFramework.assertEqual(arabicToRoman(212), "CCXII");
        QuickTestFramework.assertEqual(arabicToRoman(417), "CDXVII");
        QuickTestFramework.assertEqual(arabicToRoman(999), "CMXCIX");
        QuickTestFramework.assertEqual(arabicToRoman(1812), "MDCCCXII");
        QuickTestFramework.assertEqual(arabicToRoman(3999), "MMMCMXCIX");
    }
}
