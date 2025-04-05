package Convertidor;

public class Binario {
    
    // Constructor por defecto
    public Binario() {
    }


    // Convertir a binario pasandole decimal
    public String decimalConvertBinary (int decimal){
        if (decimal == 0) {         // Si es 0, retorno 0 automaticamente
            return "0";
        }
        
        StringBuilder binary = new StringBuilder();         // Creo mi StringBuilder que me facilita el trabajo con los char de la cadena
        int temp = decimal;         // Creo una variable temporal para no usar directo el decimal
        
        while (temp > 0) {
            binary.append(temp % 2);        // Agrego a la cadena el resto de la devision entre 2
            temp = temp / 2;                // Y divido el decimal entre 2
        }                                   // Y vuelve a repetirse
        
        // Invierto la cadena para obtener la representación binaria correcta
        return binary.reverse().toString();
    }


    // Convertir a binario pasandole hexadecimal
    public String hexaConvertBinary (String hexadecimal){

        StringBuilder binary= new StringBuilder();          // Creo mi StringBuilder que me facilita el trabajo con los char de la cadena
        hexadecimal= hexadecimal.toUpperCase();             // Pongo las letras a mayusculas para trabajarlas todas por igual

        for (int i = 0; i < hexadecimal.length(); i++) {    // Recorro la cadena hexadecimal
            char c = hexadecimal.charAt(i);                 // Guardo cada caracter en un char para poder compararlo
            switch (c) {                            // Un switch para cada caracter
                case '0':
                    binary.append("0000");      // Si es 0, añado 0000
                    break;
                case '1':
                    binary.append("0001");      // Si es 1, añado 0001
                    break;
                case '2':
                    binary.append("0010");      // Si es 2, añado 0010
                    break;
                case '3':
                    binary.append("0011");      // Si es 3, añado 0011
                    break;
                case '4':
                    binary.append("0100");      // Si es 4, añado 0100
                    break;
                case '5':
                    binary.append("0101");      // Si es 5, añado 0101
                    break;
                case '6':
                    binary.append("0110");      // Si es 6, añado 0110
                    break;
                case '7':
                    binary.append("0111");      // Si es 7, añado 0111
                    break;
                case '8':
                    binary.append("1000");      // Si es 8, añado 1000
                    break;
                case '9':
                    binary.append("1001");      // Si es 9, añado 1001
                    break;
                case 'A':
                    binary.append("1010");      // Si es A, añado 1010
                    break;
                case 'B':
                    binary.append("1011");      // Si es B, añado 1011
                    break;
                case 'C':
                    binary.append("1100");      // Si es C, añado 1100
                    break;
                case 'D':
                    binary.append("1101");      // Si es D, añado 1101
                    break;
                case 'E':
                    binary.append("1110");      // Si es E, añado 1110
                    break;
                case 'F':
                    binary.append("1111");      // Si es F, añado 1111
                    break;
                default:
                    throw new IllegalArgumentException("Carácter hexadecimal inválido: " + c);      // Si no es un caracter valido, lanzo una excepción
            }
        }
    
        // Eliminar ceros iniciales (opcional)
        int startIndex = 0;
        while (startIndex < binary.length() - 1 && binary.charAt(startIndex) == '0') {      // Recorro y voy contanto los char que sean ceros
        startIndex++;
        }
        
        return binary.toString().substring(startIndex);     // Aqui retorno el toString del StringBuilder restandole los ceros innecesarios que conte anteriormente
    }





}
