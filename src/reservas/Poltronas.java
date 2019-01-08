package reservas;

public class Poltronas { // classe guarda e trata poltronas 
    final int  poltrona[]; // array de poltronas
    private final int tam; //tamanho passado pelo usuario 
    private boolean disponivel; //disponibilidade do assento
 
    public Poltronas(int tam ) { //construtor
       this.tam=tam;
       poltrona = new int[tam];       
    }
    
    public void Exibe(){ //metodo exibe o array de poltronas
        while (disponivel == false){
        for (int x=0;x<tam;x++){
            if (poltrona[x]==0){
            System.out.println(""+poltrona[x]+" = LIVRE");
            }
            else{
            System.out.println(""+poltrona[x]+" = OCULPADA");    
            }
        }
    }
        
    public void aloca(int lugar, int codusuario){ //ocupa posicao do array de poltronas, recebe o usuario que reservou e o lugar escolhido
        if(poltrona[lugar] == 0){  //se a posicao esta disponivel, a posicao do array recebe o identificador de usuario
            poltrona[lugar] = codusuario;
        } 
        else { //senao exibe mensagem de erro
        System.out.println("Poltrona Oculpada");
                }
        this.Exibe(); //ao final exibe o array de poltronas
        
    }
    
    public void cancela(int lugar, int codusuario){ //cancela reserva de poltrona
            if(poltrona[lugar] == codusuario){ //confere se o usuario que reservou é quem esta cancelando a reserva 
            poltrona[lugar] = 0; //cancela
        }
        else { //senao exibe mensagem de erro
        System.out.println("Poltrona nao pertence a voce!");
                }
            this.Exibe(); // ao final exibe o array de poltronas 
    }
}

