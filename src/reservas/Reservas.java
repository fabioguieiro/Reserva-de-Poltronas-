package reservas;
import java.util.Scanner;
public class Reservas {
    public static void main(String[] args) {
        Scanner ler = new Scanner (System.in);
        Scanner str = new Scanner (System.in);
        System.out.println("Digite quantos assentos existem");       
        int pTotal = ler.nextInt();
        Poltronas poltronas = new Poltronas(pTotal);
        int menu = 1;
                


        while (menu!=0){
        System.out.println("\t\t\t***Bem vindo ao programa de reserva de passagens***");
        System.out.println("digite 0 para sair");
        System.out.println("digite 1 para ler o arquivo");
        
        menu = ler.nextInt();
        switch (menu){
            case 0:
                break;
            case 1:               
                System.out.print("Digite o nome do arquivo - ");
                String caminho = str.nextLine(); 
                Thread read = new Thread(new Reader (caminho, poltronas));
                read.start();
                break;
        }
    }
    }
}
