/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogotá - Colombia)
 * Departamento de Tecnologías de la Información y Comunicaciones
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Proyecto Evaluador de Expresiones Postfijas
 * Fecha: Febrero 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package universidadean.desarrollosw.postfijo;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * Esta clase representa una clase que evalúa expresiones en notación polaca o
 * postfija. Por ejemplo: 4 5 +
 */
public class EvaluadorPostfijo {

    /**
     * Realiza la evaluación de la expresión postfijo utilizando una pila
     * @param expresion una lista de elementos con números u operadores
     * @return el resultado de la evaluación de la expresión.
     */
    static int evaluarPostFija(List<String> expresion) {
        Stack<Integer> pila = new Stack<>();
/**
El método evaluarPostFija usa el método isNumeric y la lista llamada expresión.
Crea además un objeto que pertenece a la clase Stack. Este último es una estructura
 de datos tipo pila, es decir es una estructura de datos de tipo lineal con un único
 punto de acceso fijo, a través del cual es posible añadir, eliminar o consultar
 elementos. Luego con un bucle for recorremos la expresión, y con un condicional
 que usa el método isNumeric preguntamos si es entero, en caso de que sea un número
 lo añade a la pila y lo convierte en entero. En caso de que no sea un número entonces
 es porque es una operación, entonces saca el último elemento de la pila usando el
 método pop y lo guarda en la variable ultimo, luego saca el siguiente elemento de la
 pila y lo guarda en la variable penúltimo. Posteriormente se aplica un switch case.
 Dentro del switch, evalúa el tipo de operación ya sea +,-,*,/,  realiza las operaciones
 correspondientes entre penultimo y ultimo y lo guarda en resultado. Luego añade
 resultado en la pila. Por último, devuelve el último valor de la pila.
*/
        // TODO: Realiza la evaluación de la expresión en formato postfijo
        for(int i=0;i<expresion.size();i++){
            if(isNumeric(expresion.get(i))){
                pila.push(Integer.parseInt(expresion.get(i)));
            }
            else{
                int ultimo=pila.pop();
                int penultimo=pila.pop();
                switch (expresion.get(i)){
                    case "+":
                        int resultado=penultimo+ultimo;
                        pila.push(resultado);
                        break;
                    case "-":
                        resultado=penultimo-ultimo;
                        pila.push(resultado);
                        break;
                    case "*":
                        resultado=penultimo*ultimo;
                        pila.push(resultado);
                        break;
                    case "/":
                        resultado=penultimo/ultimo;
                        pila.push(resultado);
                        break;
                    default:
                        break;
                }
            }
        }


        
        return pila.pop();
    }
    /**
    Funcion para saber si es numero
     recibe una cadena y usa try/catch. Se le entrega una cadena al método
     y devuelve verdadero si se trata de un entero. Si no se trata de un número entero
     entonces devuelve falso.
     */
    private static boolean isNumeric(String cadena){
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe){
            return false;
        }
    }
    /**
     * Programa principal
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("> ");
        String linea = teclado.nextLine();

        try {
            List<String> expresion = Token.dividir(linea);
            System.out.println(evaluarPostFija(expresion));
        }
        catch (Exception e) {
            System.err.printf("Error grave en la expresión: %s", e.getMessage());
        }

    }
}
