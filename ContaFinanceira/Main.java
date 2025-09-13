public class Main {
    public static void main(String[] args) {

        Cliente c1 = new Cliente("001", "Igor", 1000);
        Cliente c2 = new Cliente("002", "Camili", 500);

        c1.depositar(200);
        c2.sacar(100);

        c1.verSaldo();
        c2.verSaldo();

        AccountManager am1 = AccountManager.getInstance();
        AccountManager am2 = AccountManager.getInstance();

        System.out.println("As instâncias são iguais? " + (am1 == am2));

        am1.listarContasAtivas();
    }
}
