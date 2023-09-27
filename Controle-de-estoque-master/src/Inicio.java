import java.util.Scanner;

public class Inicio {
    public void comecar() {
        char opcao = 0;
        String resposta, tecla = "S";
        Scanner comeco = new Scanner(System.in);
        System.out.println("INSIRA QUALQUER TECLA PARA INICIAR O CONTROLE DE ESTOQUE (S/N)");
        opcao = comeco.nextLine().charAt(0);
        switch (opcao) {
            case 's', 'S':
                Main main = new Main();
                main.controleEstoque();
                break;
            case 'n', 'N':
                System.out.println("Encerrando...");
                Fim fim = new Fim();
                Fim.fim();
                break;
            default:
                System.out.println("Nenhuma opção selecionada");
        }
    }
}
