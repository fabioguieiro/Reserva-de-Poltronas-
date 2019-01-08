package reservas;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Reader implements Runnable{
    
private String caminho; // variavel que armazena o arquivo .txt
private final Poltronas  poltronas; //objeto da classe poltronas 

public Reader(String caminho, Poltronas poltronas){ //construtor da classe reader 
    this.poltronas = poltronas; // set de atributos desta clase
    this.caminho = caminho;     //
}


    private void start() {

    }

    @Override
    public void run() { //metodo leitor de arquivo
        int aux=0; // auxiliar que possibilata saber que estamos lendo a primeira linha do arquivo, que armazena o identificador (unico) de cliente
        Scanner ler = new Scanner (System.in);           // objeto da classe Scanner 
        String conteudo = null; // declaracao e set de variavel armazenadora de todo o arquivo
        try { //tentativa de captura de excecao (arquivo nao encontrado)
            FileReader arq = new FileReader(caminho); //leitura do arquivo
            BufferedReader lerArq = new BufferedReader(arq); //leitura do arquivo
            String linha ; //variavel guarda conteudo da linha do arquivo processada no momento 
             int user = 0; //variavel que armazena o identificador (unico) do cliente
            try {//tentativa de captura de excecao (arquivo nao encontrado)
                linha = lerArq.readLine(); //leitura da linha atual 
                do{ //loop que se encerra quando nao existem mais linhas validas no arquivo 
                    if(aux==0){ // se for a primeira linha do arquivo, obter o numero de usuario
                        String[] str = linha.split("!"); //identificar o simbolo "!" que demarca o local que esta o numero identificador 
                        user =  Integer.parseInt(str[0]); //casting de string para inteiro é passado para variavel user 
                        System.out.println("numero do cliente "+user); 
                      
                    }
                    conteudo +=linha + "\n"; // variavel conteudo recebe linha mais o que ja estava em conteudo 
                    
                   
                    if(linha.contains("exibe")){ //identifica se a linha contem o comando "exibe"
                        poltronas.Exibe(); // exibe arraylist de poltronas
                    }else if (linha.contains("cancela")) { ////identifica se a linha contem o comando "cancela"
                        String[] line;
                        line = linha.split(","); // identifica a virgula na linha 
                        int canc = Integer.parseInt(line[1]); //casting de string para inteiro é armazenado para variavel canc
                        poltronas.cancela(canc, user); // cancela passando por parametro o valor 
                          
                    }else if(linha.contains("aloca")){ //identifica o comando "aloca" no arquivo
                        String[] line;
                        line = linha.split(","); //identifica a virgula na linha 
                        int alok = Integer.parseInt(line[1]); //casting de string para inteiro
                        
                        poltronas.aloca(alok, user); //aloca posicao informada no arquivo
                        
                    }
                    aux++; //incremento do contador de linhas
                    linha = lerArq.readLine(); //le a proxima linha
                }while(linha!=null); //condicao de parada do while
                arq.close(); // fecha arquivo
                Thread.currentThread().interrupt();
            }catch (IOException ex){ //captura da excecao 
                System.out.println("Erro: Não foi possivel ler o arquivo"); 
            }
        }catch(FileNotFoundException ex){//captura da excecao 
            System.out.println("Erro: Arquivo nao encontrado! ");         }
         
    }
    
    
   

}