import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<PessoaFisica>listaPf=new ArrayList<>();
        PessoaFisica metodoPf = new PessoaFisica();

        System.out.println("Bem vindo ao sistema de cadastro de Pessoas Fisicas e Juridicas");

        Scanner leitor = new Scanner(System.in);

        String opcao;

        do {
            System.out.println("Escolha uma opçao: 1- Pessoa Física / 2 - Pessoa Jurídica / 0 - Sair");
            opcao= leitor.nextLine();

            switch (opcao){
                case "1":
                    String opcaoPf;
                    do {
                        System.out.println("Digite uma opçao: 1- Cadastrar PF / 2- Listar PF / 0- Voltar");
                        opcaoPf=leitor.nextLine();

                        switch (opcaoPf){
                            case "1":
                                PessoaFisica novaPf = new PessoaFisica();
                                Endereco novoEndPf = new Endereco();

                                System.out.println("Digite o nome:");
                                novaPf.nome=leitor.nextLine();

                                System.out.println("Digite o CPF:");
                                novaPf.cpf=leitor.nextLine();

                                System.out.println("Digite o rencimento:");
                                novaPf.rendimento=leitor.nextFloat();

                                System.out.println("Digite a data de nascimento: (DD/MM/AAAA)");
                                novaPf.dataNascimento= LocalDate.parse (leitor.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                                Period idade = Period.between(novaPf.dataNascimento, LocalDate.now());

                                if (idade.getYears() >=18){
                                    System.out.println("Idade Válida");
                                }else {
                                    System.out.println("Idade Inválida");
                                    break;
                                }

                                System.out.println("Digite o logradouro: ");
                                novoEndPf.logradouro = leitor.next();

                                System.out.println("Digite o numero:");
                                novoEndPf.numero = leitor.nextInt();

                                System.out.println("Este endereco é comercial? s/n");
                                String endCom = leitor.next();

                                if (endCom.equals("s") || endCom.equals("N")){
                                    novoEndPf.endComercial=true;
                                }else {
                                    novoEndPf.endComercial=false;
                                }
                                novaPf.endereco=novoEndPf;

                                listaPf.add(novaPf);
                                System.out.println("Cadastrado com sucesso!");

                                break;

                            case "2":
                                if (listaPf.size()>0){
                                    for (PessoaFisica cadaPf:listaPf){
                                        System.out.println("Nome: " +cadaPf.nome);
                                        System.out.println("CPF: " +cadaPf.cpf);
                                        System.out.println("Data de Nascimento: " +cadaPf.dataNascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                                        System.out.println("Imposto a ser pago: " +metodoPf.CalcularImposto(cadaPf.rendimento));
                                        System.out.println("Endereco: " +cadaPf.endereco.logradouro+"Numero: "cadaPf.endereco.numero);
                                        System.out.println();
                                        System.out.println("Aperte ENTER para continuar");
                                        leitor.nextLine();
                                    }
                                }else {
                                    System.out.println("Lista vazia!");
                                }

                                break;

                            case "0":
                                System.out.println("Voltar");
                                break;

                            default:
                                System.out.println("Opcao inválida!");
                                break;
                        }
                    }while (!opcao.equals("0"));
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