/* 
 * 
 * 
 * @author Hugo
 * @version 1.0
 * @date 14 de enero de 2023
 */

import java.io.*;

public class Ejercicio6 {
    public static void main(String[] args) throws IOException {
        calculadora();
    }

    public static void calculadora() throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader lector = new BufferedReader(input);

        double operando1 = 0;
        double operando2 = 0;
        char operador = ' ';

        String comando;

        do {
            mostrarOperaciones();

            System.out.print("Selección: ");
            operador = lector.readLine().charAt(0);
            operando1 = leerOperando();

            // sqaure root only need one operand
            if (operador != 's')
                operando2 = leerOperando();

            calcularResultado(operando1, operando2, operador);

            System.out.print("¿Salir? [Sí/No]: ");
            comando = lector.readLine();
        }
        while (!(comando.equals("Sí") || comando.equals("S") || comando.equals("s")));
    }

    public static void mostrarOperaciones() {
        System.out.println("Posibles operaciones:");
        System.out.println("1. Para la suma introduzca ( + )");
        System.out.println("2. Para la resta introduzca ( - )");
        System.out.println("3. Para la multiplicación introduzca ( * )");
        System.out.println("4. Para la división introduzca ( / )");
        System.out.println("4. Para la potencia introduzca ( p )");
        System.out.println("4. Para la raíz cuadrada introduzca ( s )");
    }

    public static double leerOperando() throws IOException{
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader lector = new BufferedReader(input);

        System.out.print("Introduzca el operando: ");
        return Double.parseDouble(lector.readLine());
    }

    public static void calcularResultado(double op1, double op2, char op) {
        double resultado = 0;

        if (op2 == 0.0 && op == '/')
            System.out.println("No se puede realizar la operación. Divisor nulo.");
        else {
            switch (op) {
                case '+' -> resultado = op1 + op2;
                case '-' -> resultado = op1 - op2;
                case '*' -> resultado = op1 * op2;
                case '/' -> resultado = op1 / op2;
                case 'p' -> resultado = Math.pow(op1, op2);
                // second operand ignored for the case of square root
                case 's' -> resultado = Math.sqrt(op1);
            }

            if (op == 's')
                System.out.printf("El resultado de sqrt(%.3f) es: %.3f\n", op1, resultado);
            else if (op == 'p')
                System.out.printf("El resultado de %.3f elevado a %.3f es: %.3f\n", op1, op2, resultado);
            else 
                System.out.printf("El resultado de [%.3f %c %.3f] es: %.3f\n", op1, op, op2, resultado);
        }
    }
}