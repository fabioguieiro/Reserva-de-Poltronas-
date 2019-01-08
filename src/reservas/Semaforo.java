package reservas;

public class Semaforo {
    protected int contador;
    public Semaforo(){
        this.contador = contador;
    }
    
        public synchronized void decrementar ()
    {

        // Enquanto o contador for igual a 0, ele aguarda e trata a exceção
        while (this.contador == 0)
        {
            try
            {
                wait();
            }
            catch (InterruptedException ex)
            {
                System.out.println("ERROR>" + ex.getMessage());
            }
        }
        this.contador--;

    }
}
