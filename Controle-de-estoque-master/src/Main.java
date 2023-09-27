import java.sql.SQLOutput;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Inicio inicio = new Inicio();
        inicio.comecar();
    }

    public static void controleEstoque() {
        List listaProdutos = new ArrayList<>();
        Map<Integer, Produto> produtos = new HashMap();
        float valprod;
        //Valor do Produto
        int cdgprod;
        //Código do Produto
        String opcao;
        //Opções do Switch case
        Scanner entrada = new Scanner(System.in);
        do {
            System.out.println(
                    "OMEGA STOCK CONTROL\n" +
                            "1 - Cadastrar Produto\n2 - Consultar Produtos\n" +
                            "3 - Cadastrar Venda\n4 - Cadastrar Entradas dos Produtos\n" +
                            "5 - Mostrar todas as informações cadastradas\n" +
                            "6 - Encerrar programa");
            opcao = entrada.next();
            // switch serve basicamente para fazer escolhas, e o break para o código para não chamar
            // os outros case (opcões) desnecessariamente e executar somente o código dentro do case.
            switch (opcao) {
                case "1":
                    Produto produto = new Produto();
                    System.out.println("Cadastrar Produto");
                    System.out.println("me informa o nome");
                    produto.setNome(entrada.next());
                    System.out.println("Me informe o código: ");
                    produto.setCodigo(entrada.nextInt());
                    listaProdutos.add(produto);
                    break;
                case "2":
                    System.out.println("Consultar Produto");
                    produtos = (Map<Integer, Produto>) listaProdutos.stream().collect(Collectors.toMap(Produto::getCodigo, Function.identity()));
                    System.out.println("Me informe o código: ");
                    //listaProdutos.get(entrada.nextInt());
                    Produto produtofinal = produtos.get(entrada.nextInt());
                    System.out.println(produtofinal);
                    break;
                case "3":
                    System.out.println("Cadastrar Venda");
                    System.out.println("Insira o código do produto: ");
                    cdgprod = entrada.nextInt();
                    System.out.println("Código: " + cdgprod);
                    System.out.println("Insira o valor da venda: ");
                    valprod = entrada.nextFloat();
                    System.out.println("Produto: " + cdgprod + " registrado.\nValor: " + valprod);
                    break;
                case "4":
                    System.out.println("Cadastrar Entradas dos Produtos");
                    break;
                case "5":
                    System.out.println("Mostrar todas as informações cadastradas");
                    break;
                case "6":
                    Fim.fim();
                    break;
                default:
                    System.out.println("Você não escolheu nenhuma opção");
                    break;
            }
        } while (!opcao.equals(String.valueOf(6)));
    }
}