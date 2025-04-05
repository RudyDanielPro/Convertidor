package Convertidor;

public class Decimal {
    
    // Constructor por defecto
    public Decimal() {
    }

    
    // Convertir a decimal pasandole un binario
    public int binaryConvertDecimal (long binario){

        int resultado = 0;          // La variable que va almacenar el numero cuando se convierta a decimal
        long temp= binario;         // Una variable temporal para no usar directo el numero binario, es como un aux   
        int cantdigitos = 0;

        if (binario == 0){          // Si el numero binario es 0, entonces el resultado es 0
            cantdigitos = 1;
            return 0;
        } else {
         while (temp > 0){      // Esto es para recorrer el numero binario hasta que se cuente todos los digitos que tiene
            cantdigitos++;
            temp = temp / 10;       // En cada iteracion divido el binario entre 10 esto lo que hace es quitar el ultimo digito que seria el que conte
            }
        }

        int [] binaryInArray = new int[cantdigitos];       // Creo el arreglo con la cantidad de digitos que tiene el binario
        temp = binario;         // Se reinicia al valor original del binario

        // Este bucle coloca cada dígito en el arreglo
        for (int i = cantdigitos - 1; i >= 0; i--) {        // Se va guardando en el arreglo de atras hacia adelante, porque temp % 10 me da el ultimo valor del binario
            binaryInArray[i] = (int)(temp % 10);               // temp % 10 obtiene el último dígito del número (el resto de dividir por 10)
            temp /= 10;                             // Elimina el ultimo digito porque ya lo meti en el arreglo
        }

        // Convertir a decimal
        for (int i = 0; i < binaryInArray.length; i++) {
            int posicion = binaryInArray.length - 1 - i;       // Con esto obtenemos la potencia del numero empezando por la potencia mas alta
            int numero = (int) Math.pow(2, posicion);             // Ej: posicion= 4 - 1 - 0;     2^3 = 8
                                                                    // Ej: posicion= 4 - 1 - 1;     2^2 = 4     y asi sigue 

            if (binaryInArray[i] == 0) {       // Los valores del binario que sean 0 no se cojen, por tanto le sumo 0 al resultado para mantenerlo igual
                resultado += 0;
            }
            if (binaryInArray[i] == 1) {       // Los valores del binario que sean 1 cojo y sumo el numero a resultado
                resultado += numero;
            }
        }
    
    return resultado;
}


    // Convertir a decimal pasandole un hexadecimal
    public int hexaConvertDecimal (String hexadecimal){

        // Para validar que no entre el usuario un numero incorrecto
        for (int i=0; i<hexadecimal.length(); i++){                     // Recorrer cada caracter del string
            char c = hexadecimal.charAt(i);                                 // Lo guardo en c
            if (!((c >= '0' && c <= '9') || (c >= 'A' && c <= 'F'))) {              // Si algun caracter no es ninguno de los que admite los numeros hexadecimales, lanzo la excepcion
                throw new IllegalArgumentException("Carácter no válido en hexadecimal: " + c);
            }
        }

        int resultado = 0;                          // Creo una variable que va almacenar el resultado
        int cantdigitos = hexadecimal.length();         // Guardo la cantidad de char que tiene el String hexadecimal
        hexadecimal= hexadecimal.toUpperCase();         // Para que ponga todas las letras en mayusculas
            
        int [] hexaInArray = new int[cantdigitos];      // Creo un arreglo con la cantidad de digitos que tiene el hexadecimal

        // Para colocar cada digito en el arreglo
        for (int i=0; i<cantdigitos; i++){              // Recorro el String hexadecimal
            char caracter= hexadecimal.charAt(i);       // Extraer cada caracter por separado y entonces compararlo
            if (caracter == 'A'){
                hexaInArray[i] = 10;                    // Si el caracter es A, agrego 10 al arreglo
            } else if (caracter == 'B'){
                hexaInArray[i] = 11;                    // Si el caracter es B, agrego 11 al arreglo
            } else if (caracter == 'C'){
                hexaInArray[i] = 12;                    // Si el caracter es C, agrego 12 al arreglo
            } else if (caracter == 'D'){
                hexaInArray[i] = 13;                    // Si el caracter es D, agrego 13 al arreglo
            } else if (caracter == 'E'){
                hexaInArray[i] = 14;                    // Si el caracter es E, agrego 14 al arreglo
            } else if (caracter == 'F'){
                hexaInArray[i] = 15;                    // Si el caracter es F, agrego 15 al arreglo
            } else {
                hexaInArray[i] = Integer.parseInt(String.valueOf(caracter));      //Si fuera numero lo paso a entero y lo agrego al arreglo
            }                                                                           // Porque puede ser '0' = 0;  '2'= 2;
        }  

        // Convertir a decimal
        for (int i=0; i< hexaInArray.length; i++){          // Recorro mi arreglo hexadecimal con todos los numeros convertidos a enteros
            int posicion = hexaInArray.length - 1 - i;          // Declaro la potencia
            int numero = (int) Math.pow(16, posicion);          // En numero guardo 16 a la potencia (posicion)

            if (hexaInArray[i] != 0){                       // Todos los valores del arreglo que no sean 0 (todos van a ser numeros ya)
                resultado += numero * hexaInArray[i];       // Le agrego a resultado la variable numero (que es 16 a la potencia) multiplicado por el valor del arreglo
            } else {
                resultado += 0;             // Si fuera 0, sumo 0, o sea lo dejo igual
            }
        }
        return resultado;               // Y por ultimo retorno el resultado
    }

    // Ejemplo: temp= alian;    -->    temp= lian; 
    // Esto hace el substring(1) para quitar la primera letra

}
