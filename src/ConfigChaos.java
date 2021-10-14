public class ConfigChaos {
    public static void main(String[] args) {
        String typ = "Automat AVR";
        String bezeichnung = "Q2021_FAB_A";
        String name = typ + " " + bezeichnung;
        System.out.println(name);

        char sprachModul = 'd';
        System.out.println("Sprache: " + sprachModul);

        final byte PRUEFNR = 4;
        System.out.println("Prüfnummer : " + PRUEFNR);

        double maximum = 100.00;
        double patrone = 46.24;
        double prozent = maximum - patrone;
        System.out.println("Füllstand Patrone: " + prozent + " %");

        int muenzenCent = 1280;
        int muenzenEuro = 130;
        double summe = muenzenCent + muenzenEuro * 100;
        double euro = summe / 100;
        System.out.println("Summe Euro: " + euro + " Cent");

        double cent = summe % 100;
        System.out.println("Summe Rest: " + cent + " Cent");

        Boolean status = (prozent >= 50.00) && (!(PRUEFNR == 5 || PRUEFNR == 6)) && (euro <= 150) && (euro >= 50)
                && (cent != 0) && (sprachModul == 'd');
        System.out.println("Status: " + status);
    }
}
