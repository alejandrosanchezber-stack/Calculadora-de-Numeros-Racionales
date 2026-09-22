public class PilaDoblementeEnlazada<T> implements Pila<T> {

    private NodoPila<T> inicio;
    private NodoPila<T> fin;

    PilaDoblementeEnlazada() {
        this.inicio = null;
        this.fin = null;
    }

    @Override
    public boolean esVacia() {
        return this.inicio == null && this.fin == null;
    }

    @Override
    public T tope() throws IllegalStateException {
        if(esVacia()) {
        throw new IllegalStateException("Pila vacía");
    }
        return fin.getItem();
    }

    @Override
    public void apilar(T elem) throws IllegalStateException {
        NodoPila<T> nuevoNodo = new NodoPila<>(null, elem, null);
        if(esVacia()){
            this.inicio = nuevoNodo;
            this.fin = nuevoNodo;
        } else{
            this.fin.setNext(nuevoNodo);
            nuevoNodo.setPrev(this.fin);
            this.fin = nuevoNodo;

        }
    }

    @Override
    public T desapilar() throws IllegalStateException {
        if(esVacia()==true){
            throw new IllegalStateException("Pila vacía");
        }
        NodoPila<T> nodoDesapilado = fin; //Variable que usamos para retornar el elemento eliminado
        NodoPila<T> nodoAux = fin.getPrev(); // Elemento anterior al que queremos eliminar
        if(nodoDesapilado.getPrev() == null){ // Si el anterior del elemento es null, significa que hay un solo elemento, entonces dejamos en null las 2 variables
            this.inicio = null;                 //de esta manera no llamamos ningun metodo a un elemento null que pueda romper el programa
            this.fin = null;
        } else{                     //Si hay mas de 1 elemento en la lista podemos llamar a los metodos mutadores Next y Prev para desenlazar el nodoDesapilado
        nodoAux.setNext(null);
        nodoDesapilado.setPrev(null);
        this.fin = nodoAux;
        }
        return nodoDesapilado.getItem(); //Retornamos el nodo desapilado
    }

    @Override
    public void imprimir() {
        if(esVacia()== true){
            System.out.println("La lista es Vacia");
        } else{ 
        NodoPila<T> nodoAux = fin;
        while(nodoAux!= null){
            System.out.println(nodoAux.getItem());
            nodoAux = nodoAux.getPrev();
        }
    }
}

}


