import java.util.Scanner;
/**
 * @author Lucas Larry
 *
 */
//Faça um programa para pesquisar o valor 8 no vetor dado:
//inteiro vetor[] = {1, 3, 5, 8, 9, 10}
public class LocalizaNumero {
    // Corrigir este algoritmo.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int vetor[] = {1,2,3,4,5,6,7,8,9,10};

        System.out.print("Digite o número que deseja localizar: ");
        int numero = scanner.nextInt();
        if(numero > 10 || numero <1){
            System.out.println("Só é possível achar números de 1 até 10");
        }else {

            boolean achou = false;
            int posicao = -1;

            for (int i = 0; i < 10; i++) {
                if (vetor[i] == numero) {
                    achou = true;
                    posicao = i;
                    break;
                }
            }

            if (achou) {
                System.out.println("Achei");
                System.out.printf("Na Posição %d está localizado do numero %d.", posicao, vetor[posicao]);
            } else {
                System.out.println("Número não encontrado.");
            }
        }
        scanner.close();
    }

}