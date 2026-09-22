public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Pila<Integer> lista = new PilaDoblementeEnlazada<>();
        lista.apilar(2);
        lista.apilar(3);
        lista.apilar(5);
        lista.apilar(6);
        lista.imprimir();
        System.out.println("Desapilamos");
        lista.desapilar();
        lista.imprimir();
         System.out.println("Desapilamos 2 veces");
        lista.desapilar();
        lista.desapilar();
        lista.imprimir();
        System.out.println("Desapilamos ");
        lista.desapilar();
        lista.imprimir();




    }
}
