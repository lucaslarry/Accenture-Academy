import controller.ContaController;
import model.Cliente;
import model.ContaCorrente;
import view.ContaView;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
       try {
           ContaView view = new ContaView();
           ContaController controller = new ContaController(view);

           Cliente cliente1 = new Cliente("João", "Silva", "111.222.333-44");
           Cliente cliente2 = new Cliente("Maria", "Souza", "555.666.777-88");

           ContaCorrente conta1 = new ContaCorrente(1001, cliente1, 500.0, LocalDate.now());
           System.out.println("--- Conta 1 Inicializada ---");
           controller.exibirSaldo(conta1);
           controller.depositar(conta1, 300.0);

           ContaCorrente conta2 = new ContaCorrente(2002, cliente2, 1000.0, LocalDate.now());

           controller.exibirNomeCliente(conta1);

           controller.sacar(conta1, 100.0);
           controller.transferir(conta1, conta2, 200.0);

           // Tenta transferir 5000 tendo apenas 500
           controller.transferir(conta1, conta2, 5000.0);

           controller.exibirExtrato(conta1);
           controller.exibirExtrato(conta2);

           // Conta com data anterior a atual
           ContaCorrente conta3 = new ContaCorrente(1001, cliente1, 500.0, LocalDate.of(2023, 1, 1));
       }catch (IllegalArgumentException e){
           System.err.println("Dados Inválidos, tente novamente");
       } catch (Exception e) {
           System.err.println("Algo deu errado :(");
       }
    }
}