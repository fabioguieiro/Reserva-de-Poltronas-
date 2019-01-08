package reservas;

public class Usario { //armazena cada usuario
    private int CodUsuario; //

    public Usario(int CodUsuario) { //construtor seta o seu numero atravez da leitura de arquivo
        this.CodUsuario = CodUsuario;
    }

    public int getCodUsuario() { // get de CodUsuario
        return CodUsuario;
    }

    public void setCodUsuario(int CodUsuario) { //set de CodUsuario
        this.CodUsuario = CodUsuario;
    }

    @Override
    public String toString() { //toString de CodUsuario
        return "Usario{" + "CodUsuario=" + CodUsuario + '}';
    }
    
}
