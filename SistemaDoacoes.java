/* READ.me */
/*  */


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SistemaDoacoes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Double> valores = new HashMap<>();
        valores.put("dinheiro", 0.0);
        valores.put("alimentos", 0.0);
        valores.put("roupas", 0.0);
        valores.put("mantimentos", 0.0);

        boolean continuar = true;

        while (continuar) {
            System.out.println("=== Sistema de Gerenciamento de Doações ===");
            System.out.println("1. Doar via Pix");
            System.out.println("2. Doar Alimentos");
            System.out.println("3. Doar Roupas");
            System.out.println("4. Doar Mantimentos");
            System.out.println("5. Calcular Total de Doações");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    registrarDoacao("pix", scanner, valores);
                    break;
                case 2:
                    registrarDoacao("alimentos", scanner, valores);
                    break;
                case 3:
                    registrarDoacao("roupas", scanner, valores);
                    break;
                case 4:
                    registrarDoacao("mantimentos", scanner, valores);
                    break;
                case 5:
                    mostrarTotais(valores);
                    break;
                case 6:
                    continuar = false;
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida! Escolha novamente.");
            }
        }

        scanner.close();
    }

    public static void registrarDoacao(String tipo, Scanner scanner, Map<String, Double> valores) {
        System.out.println("\n=== Registrar Doação de " + tipo + " ===");
        System.out.print("Valor da Doação: ");
        double valor = scanner.nextDouble();
        scanner.nextLine(); // Limpar o buffer do scanner

        valores.put(tipo, valores.get(tipo) + valor);

        System.out.println("Doação de " + tipo + " registrada com sucesso!\n");
    }

    public static void mostrarTotais(Map<String, Double> valores) {
        System.out.println("\n=== Total de Doações ===");
        for (Map.Entry<String, Double> entry : valores.entrySet()) {
            System.out.println(entry.getKey() + ": R$ " + entry.getValue());
        }
        System.out.println();
    }
}
