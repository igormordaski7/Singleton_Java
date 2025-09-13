import java.util.HashMap;
import java.util.Map;

public class AccountManager {
  
    private static AccountManager instanciaUnica;

    private Map<String, Double> contas;

    private AccountManager() {
        contas = new HashMap<>();
    }

    public static AccountManager getInstance() {
        if (instanciaUnica == null) {
            instanciaUnica = new AccountManager();
        }
        return instanciaUnica;
    }

    public void criarConta(String contaId, double saldoInicial) {
        contas.put(contaId, saldoInicial);
    }

    public void depositar(String contaId, double valor) {
        if (contas.containsKey(contaId)) {
            contas.put(contaId, contas.get(contaId) + valor);
            System.out.println("Depósito de " + valor + " na conta " + contaId);
        } else {
            System.out.println("Conta não encontrada!");
        }
    }

    public void sacar(String contaId, double valor) {
        if (contas.containsKey(contaId)) {
            double saldo = contas.get(contaId);
            if (saldo >= valor) {
                contas.put(contaId, saldo - valor);
                System.out.println("Saque de " + valor + " na conta " + contaId);
            } else {
                System.out.println("Saldo insuficiente!");
            }
        } else {
            System.out.println("Conta não encontrada!");
        }
    }

    public double verSaldo(String contaId) {
        return contas.getOrDefault(contaId, 0.0);
    }

    public void listarContasAtivas() {
        System.out.println("Contas ativas:");
        for (String contaId : contas.keySet()) {
            System.out.println("Conta " + contaId + " - Saldo: " + contas.get(contaId));
        }
    }
}
