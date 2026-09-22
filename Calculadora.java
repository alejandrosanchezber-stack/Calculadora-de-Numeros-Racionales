public class Calculadora {

    /**
     * Evalua una expresion matemática
     * 
     * @param expresion Representación como string de la expresión matemática a
     *                  evaluar
     * @return
     */
    public static Racional evaluarExpresion(String expresion) {
        PilaDoblementeEnlazada<Racional> racional = new PilaDoblementeEnlazada<>();
        String[] expresiones = expresion.split(" "); //Con este metodo ya tenemos todas las expresiones separadas en los indices correspondientes
        for(int i=expresiones.length -1; i>=0; i--){
            String expresionActual = expresiones[i];

            if(expresionActual.equals("+")){
                Racional parteIzquierda = racional.desapilar(); //Osea el primer elemento entrado a la lista
                Racional parteDerecha = racional.desapilar(); //Osea el ultimo elemento entrado a la lista, osea el tope
                parteIzquierda.suma(parteDerecha); //Recordar que el resultado del metodo invocado afecta a los atributos del Racional que llamamos al metodo, no el parametro, osea es el primer racionar entrado a la pila
                racional.apilar(parteIzquierda); // apilamos el el Resultado de la operacion, que es el mismo racional que llamamos al metodo pero con su nuevo valor de la suma

            } else if(expresionActual.equals("*")){
                Racional parteIzquierda = racional.desapilar();
                Racional parteDerecha = racional.desapilar();
                parteIzquierda.mult(parteDerecha);
                racional.apilar(parteIzquierda);

            } else if(expresionActual.equals("-")){
                Racional parteIzquierda = racional.desapilar();
                Racional parteDerecha = racional.desapilar();
                parteDerecha.neg(); //multiplicamos la parte derecha por - Ej (2/4).neg() == -2/4  || (-2/4).neg() == 2/4
                parteIzquierda.suma(parteDerecha); // sumamos ya que aplicamos la neg(), entonces es lo mismo que restar o sumar, dependiendo que signo sea la parte derecha
                racional.apilar(parteIzquierda);

            } else if(expresionActual.equals("/")){
                Racional parteIzquierda = racional.desapilar();
                Racional parteDerecha = racional.desapilar();
                parteIzquierda.div(parteDerecha);
                racional.apilar(parteIzquierda);

            } 
            else { //si llega aca es porque la expresion es un numero no un operador
                if(expresionActual.contains("R")){ //si la expresion es del formato eje: 1R2
                String[] partesExpresion = expresionActual.split("R");
                int numerador = Integer.parseInt(partesExpresion[0]);
                int denominador = Integer.parseInt(partesExpresion[1]);
                Racional numeroRacional = new ImplemRacional(numerador , denominador);
                racional.apilar(numeroRacional);
                } else{ //si la expresion es del formato unitario sin R, eje: 3, entonces es 3/1
                int numerador = Integer.parseInt(expresionActual);
                Racional numeroRacional = new ImplemRacional(numerador , 1);
                racional.apilar(numeroRacional);
                }

            }

        }

        return racional.desapilar(); //La pila nos queda vacia y al desapilar nos retorna el ultimo resulado obtenido
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usar java Calculadora <expresion>");
            System.out.println("Ej: java Calculadora '+ 1R2 2R3'");
        } else {
            System.out.println(evaluarExpresion(args[0]));
        }
        System.out.println(evaluarExpresion("+ 1R2 2R3"));
        System.out.println(evaluarExpresion("+ 2 2"));
        System.out.println(evaluarExpresion("+ 2 2R2"));
        System.out.println(evaluarExpresion("+ 5R3 / 6R2 * 1R2 2R3"));

    }
}