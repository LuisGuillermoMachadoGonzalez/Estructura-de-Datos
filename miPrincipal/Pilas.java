
public class Pilas <T> {
    private T[] pila;
    private int tope = -1;
    private T dato;
    private int max = 0;
    
    Pilas(int maximo){
        this.max = maximo;
        this.pila = (T[]) new Object[max];
    }
    public void borrarpila(){
        tope = -1;
    }
    private boolean Pilallena(){
        boolean res = false;
        if(tope == (max - 1)){
            res = true;
        }else{
            res = false;
        }
        return res;
    }
    private boolean Pilavacia(){
        boolean res = false;
        if(tope == -1)
        res = true;
        return res;
    }
    public boolean  Insertar(T dato){
        boolean res = false;
        if(!Pilallena()){
            tope++;
            pila[tope] = dato;
            res = true;
        }
        return res;
    }
    public T Retirar(){
        T res;
        if (!Pilavacia()){
            res = pila[tope];
                  tope --;
        }else{
            System.out.println("Pila vacia ");
            res = null;
        }
        return res;
    }
    public void Mostrar(){
        for(int i = 0;i < tope + 1; i++){
            System.out.println(pila[i]);
        }
    }
    public void invertirPila() {
        Pilas<T> pilaAux = new Pilas<>(max);
        while (!Pilavacia()) {
            pilaAux.Insertar(Retirar());
        }
        pila = pilaAux.pila;
        tope = pilaAux.tope;
    }
    public String esPalindromo() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= tope; i++) {
            sb.append(pila[i]);
        }
        String original = sb.toString();
        String reversed = sb.reverse().toString();
        return original.equals(reversed) ? "Es palíndromo" : "No es palíndromo";
    }
    
}
