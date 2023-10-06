import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bem vindo ao sistema de cadastro de Pessoas Fisicas e Juridicas");

        Scanner leitor = new Scanner(System.in);

        String opcao;

        do {
            System.out.println("Escolha uma opçao: 1- Pessoa Física / 2 - Pessoa Jurídica / 0 - Sair");
            opcao= leitor.nextLine();

            switch (opcao){
                case "1":
                    System.out.println("Case 1");
                    break;
                case "2":
                    System.out.println("Case 2");
                    break;
                case "0":
                    System.out.println("Case 0");
                    break;
                default:
                    break;
            }

        }while (!opcao.equals("0"));
    }
}