import java.util.ArrayList;
import java.util.Scanner;

abstract class Veiculo {
    protected String placa;
    protected int ano;

    public Veiculo(String placa, int ano) {
        this.placa = placa;
        this.ano = ano;
    }

    public abstract double calcularValorSeguro();

    public void exibirDetalhes() {
        System.out.println("Placa: " + placa + ", Ano: " + ano);
    }
}

interface Manutencao {
    String realizarManutencao();
}

class Carro extends Veiculo implements Manutencao {
    private int numeroPortas;

    public Carro(String placa, int ano, int numeroPortas) {
        super(placa, ano);
        this.numeroPortas = numeroPortas;
    }

    @Override
    public double calcularValorSeguro() {
        return 700.0 * (numeroPortas);
    }

    @Override
    public String realizarManutencao() {
        return "Realizar a manutenção para o carro a cada 10000km ou 1 ano - " + placa + ".";
    }
}

class Moto extends Veiculo implements Manutencao {
    private int cilindrada;

    public Moto(String placa, int ano, int cilindrada) {
        super(placa, ano);
        this.cilindrada = cilindrada;
    }

    @Override
    public double calcularValorSeguro() {
        return (cilindrada * 4.5);
    }

    @Override
    public String realizarManutencao() {
        return "Realizar a manutenção para a moto a cada 2000km ou 6 meses - " + placa + ".";
    }
}

public class GerenciadorVeiculos {
    public static void main(String[] args) {
        ArrayList<Veiculo> frota = new ArrayList<>();

        frota.add(new Carro("AAA 9999", 2024, 4));
        frota.add(new Moto("BBB 7777", 2023, 300));

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar Carro");
            System.out.println("2. Adicionar Moto");
            System.out.println("3. Listar Veículos");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1: // Adicionar Carro
                    System.out.print("Digite a placa: ");
                    String placaCarro = scanner.nextLine();
                    System.out.print("Digite o ano: ");
                    int anoCarro = scanner.nextInt();
                    System.out.print("Digite o número de portas: ");
                    int portas = scanner.nextInt();
                    frota.add(new Carro(placaCarro, anoCarro, portas));
                    System.out.println("Carro adicionado com sucesso!");
                    break;

                case 2: // Adicionar Moto
                    System.out.print("Digite a placa: ");
                    String placaMoto = scanner.nextLine();
                    System.out.print("Digite o ano: ");
                    int anoMoto = scanner.nextInt();
                    System.out.print("Digite a cilindrada: ");
                    int cilindrada = scanner.nextInt();
                    frota.add(new Moto(placaMoto, anoMoto, cilindrada));
                    System.out.println("Moto adicionada com sucesso!");
                    break;

                case 3: // Listar Veículos
                    if (frota.isEmpty()) {
                        System.out.println("Nenhum veículo cadastrado.");
                    } else {
                        for (Veiculo veiculo : frota) {
                            veiculo.exibirDetalhes();
                            System.out.println("Valor do Seguro: R$ " + veiculo.calcularValorSeguro());
                            if (veiculo instanceof Manutencao) {
                                System.out.println(((Manutencao) veiculo).realizarManutencao());
                            }
                            System.out.println();
                        }
                    }
                    break;

                case 4: // Sair
                    System.out.println("Encerrando o programa.");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 4);

        scanner.close();
    }
}