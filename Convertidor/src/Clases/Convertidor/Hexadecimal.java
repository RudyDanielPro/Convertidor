package Clases.Convertidor;

import java.util.HashMap;
import java.util.Map;

public class Hexadecimal {
    
    // Constructor por defecto
    public Hexadecimal() {
    }


    // Convertir a hexadecimal pasandole decimal
    public String decimalConvertHexa (int decimal){

        // Si es 0, retorno 0 automaticamente
        if (decimal == 0) {
            return "0";
        }
        
        StringBuilder hexa = new StringBuilder();       // Creo un StringBuilder que es mejor para trabajar con los char del String
        int temp = decimal;             // Creo una variable temporal para no usar directo la variable decimal
        
        while (temp > 0) {                  // Mientras el numero decimal sea mayor que 0
            int resto = temp % 16;          // Obtengo el resto de dividir el numero decimal entre 16
            char hexChar;
            
            if (resto < 10) {                       // Si el resto es menor que 10
                hexChar = (char) ('0' + resto);     // hexChar va a ser un (char) numero entre 0-9
            } else {
                hexChar = (char) ('A' + (resto - 10));      // hexChar va a ser un (char) entre A-F
            }   

            /*Por ejemplo:
            Si resto = 5, entonces hexChar = '0' + 5 = '5'
            Si resto = 12, entonces hexChar = 'A' + (12 - 10) = 'A' + 2 = 'C */
            
            hexa.append(hexChar);       // Agrego ese caracter a mi StringBuilder hexa
            temp = temp / 16;           // Se divide entre 16 para pasar a la otra iteracion 
        }
        
        // Una vez obtenido hexa, lo tenemos en orden contrario, por tanto se vira al reves
        return hexa.reverse().toString();       // Se vira la cadena al reves y se retorna
    }



    // Convertir a hexadecimal pasandole un binario
    public String binaryConvertHexa (String binario){

        // Si el binario es vacio o nulo, retorno 0
        if (binario == null || binario.isEmpty()) {
            return "0";
        }
    
        // Si el binario es "0", retorno 0
        if (binario.equals("0")) {
            return "0";
        }
    
        // Aseguramos que la longitud del binario sea multiplo de 4, porque queremos dividir en 4 bits
        int remainder = binario.length() % 4;
        if (remainder != 0) {                       // Si el resto me da 0 es que la longitud del binario es multiplo de 4 y no entra al if
            StringBuilder aux = new StringBuilder();       // Pero si no da 0, creamos un StringBuilder donde se van a guardar los 0 que faltan
        for (int i = 0; i < 4 - remainder; i++) {       // Recorro las posiciones donde voy agregar los 0
            aux.append('0');               // Por cada posicion que lleve 0, le agregamos un 0 a aux con el metodo append(0);
        }
        aux.append(binario);
        binario = aux.toString();
        }
    
        // Mapa para convertir grupos de 4 bits a un dígito hexadecimal
        Map<String, Character> binaryToHex = new HashMap<>();       // Se crea un diccionario que por cada binario tiene su hexadecimal
        binaryToHex.put("0000", '0');               // 0000 es "0"
        binaryToHex.put("0001", '1');               // 0001 es "1"
        binaryToHex.put("0010", '2');               // 0010 es "2"
        binaryToHex.put("0011", '3');               // 0011 es "3"
        binaryToHex.put("0100", '4');               // 0100 es "4"
        binaryToHex.put("0101", '5');               // 0101 es "5"
        binaryToHex.put("0110", '6');               // 0110 es "6"
        binaryToHex.put("0111", '7');               // 0111 es "7"
        binaryToHex.put("1000", '8');               // 1000 es "8"
        binaryToHex.put("1001", '9');               // 1001 es "9"
        binaryToHex.put("1010", 'A');               // 1010 es "A"
        binaryToHex.put("1011", 'B');               // 1011 es "B"
        binaryToHex.put("1100", 'C');               // 1100 es "C"
        binaryToHex.put("1101", 'D');               // 1101 es "D"
        binaryToHex.put("1110", 'E');               // 1110 es "E"
        binaryToHex.put("1111", 'F');               // 1111 es "F"
    
        StringBuilder hexadecimal = new StringBuilder();        // Creo el StringBuilder que va almacenar los valores hexadecimales
    
        // Convertir cada grupo de 4 bits a un dígito hexadecimal
        for (int i = 0; i < binario.length(); i += 4) {     // Recorremos el binario en grupos de 4 bits (de 4 en 4)
        String chunk = binario.substring(i, i + 4);         // Aqui guardo el primer grupo de 4 bits binarios del numero binario en general
        hexadecimal.append(binaryToHex.get(chunk));         // Entonces a hexadecimal le guardo el valor que coincide con el numero binario almacenado en chunk
        }

        /*Por ejemplo, si el binario es "10110101":
        Primer chunk: "1011" → 'B'
        Segundo chunk: "0101" → '5'
        Resultado: "B5" */
    
        // Eliminar ceros no significativos al inicio (opcional)
        int startIndex = 0;
        while (startIndex < hexadecimal.length() - 1 && hexadecimal.charAt(startIndex) == '0') {    // Contar los ceros no significativos a la izquierda
        startIndex++;
        }
    
        return hexadecimal.toString().substring(startIndex);       // Retornar el toString de hexadecimal, restandole los ceros insignificantes a la izquierda
    }

    public static boolean esBinario(String valor) {
        return valor.matches("^[01]+$");
    }

    public static boolean esDecimal(String valor) {
        return valor.matches("^\\d+$");
    }

    public static boolean esHexadecimal(String valor) {
        return valor.matches("^[0-9A-Fa-f]+$");
    }
}
