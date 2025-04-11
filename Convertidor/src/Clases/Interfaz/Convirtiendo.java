package Clases.Interfaz;

public class Convirtiendo {

    public static boolean esBinario(String valor) {
        return valor.matches("^[01]+$");
    }

    public static boolean esDecimal(String valor) {
        return valor.matches("^\\d+$");
    }

    public static boolean esHexadecimal(String valor) {
        return valor.matches("^[0-9A-Fa-f]+$");
    }

    public static String binarioADecimal(String bin) {
        return String.valueOf(Integer.parseInt(bin, 2));
    }

    public static String binarioAHexadecimal(String bin) {
        return Integer.toHexString(Integer.parseInt(bin, 2)).toUpperCase();
    }

    public static String decimalABinario(String dec) {
        return Integer.toBinaryString(Integer.parseInt(dec));
    }

    public static String decimalAHexadecimal(String dec) {
        return Integer.toHexString(Integer.parseInt(dec)).toUpperCase();
    }

    public static String hexadecimalADecimal(String hex) {
        return String.valueOf(Integer.parseInt(hex, 16));
    }

    public static String hexadecimalABinario(String hex) {
        return Integer.toBinaryString(Integer.parseInt(hex, 16));
    }
}
