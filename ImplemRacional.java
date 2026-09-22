public class ImplemRacional implements Racional {
    private int numerador;
    private int denominador;

    public ImplemRacional(int numerador, int denominador){
        this.numerador = numerador;
        this.denominador = denominador;
         if (!repOk()) {
        throw new IllegalArgumentException("Invariante roto: el denominador no puede ser 0");
    }
    }
    
    /**
     * Operacion para suma racionales
     * Suma a la instancia actual el racional r.
     */
    public void suma(Racional r){
         if (!repOk()) {
        throw new IllegalArgumentException("Invariante roto: el denominador no puede ser 0");
    }

        ImplemRacional rCasteo = (ImplemRacional) r;
        this.numerador = (this.numerador * rCasteo.denominador) + (this.denominador * rCasteo.numerador);
        this.denominador = (this.denominador * rCasteo.denominador);

         if (!repOk()) {
        throw new IllegalArgumentException("Invariante roto: el denominador no puede ser 0");
    }
    }

    /**
     * Operacion para multiplicacion de racionales
     * Multiplica la instancia actual con el racional r.
     */
    public void mult(Racional r){
         if (!repOk()) {
        throw new IllegalArgumentException("Invariante roto: el denominador no puede ser 0");
    }
        ImplemRacional rCasteo = (ImplemRacional) r;
        this.numerador = (this.numerador* rCasteo.numerador);
        this.denominador = (this.denominador * rCasteo.denominador);
         if (!repOk()) {
        throw new IllegalArgumentException("Invariante roto: el denominador no puede ser 0");
    }

    }

    /**
     * Representa la resta unaria.
     * 
     * operacion para resta de racionales: A-B = A+B.neg()
     * 
     * Ej (2/4).neg() == -2/4
     * (-2/4).neg() == 2/4
     */
    public void neg(){
         if (!repOk()) {
        throw new IllegalArgumentException("Invariante roto: el denominador no puede ser 0");
    }
        this.numerador = this.numerador * -1;

         if (!repOk()) {
        throw new IllegalArgumentException("Invariante roto: el denominador no puede ser 0");
    }
    }

    /**
     * Operacion para dividir racionales
     * Divide la instancia actual por el racional r
     * Ej: r1.div(r2) == r1/r2
     */
    public void div(Racional r){
        if (!repOk()) {
        throw new IllegalArgumentException("Invariante roto: el denominador no puede ser 0");
    }
        ImplemRacional rCasteo = (ImplemRacional) r;
        this.numerador = (this.numerador * rCasteo.denominador);
        this.denominador = (this.denominador * rCasteo.numerador);
        if (!repOk()) {
        throw new IllegalArgumentException("Invariante roto: el denominador no puede ser 0");
    }
    }

    /**
     * Invariante de representacion, chequea que el denominador sea diferente de 0
     */
    public boolean repOk(){
        if(this.denominador == 0){
            return false;
        }
        return true;
    }

    /**
     * Retorna una representacion del racional de la forma 
     * "numerador/denominador"
     */
    public String toString(){
         if (!repOk()) {
        throw new IllegalArgumentException("Invariante roto: el denominador no puede ser 0");
    }
        return numerador + "/"+ denominador;
    }

}
