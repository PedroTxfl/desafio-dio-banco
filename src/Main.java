//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Cliente pedro = new Cliente("pedro");
        Banco banco1 = new Banco("PeBank");

        Conta cc1 = new ContaCorrente(pedro, banco1);
        Conta poupanca1 = new ContaPoupanca(pedro, banco1);

        cc1.depositar(100);
        cc1.transferir(100, poupanca1);

        System.out.println("===");
        cc1.imprimirExtrato();
        System.out.println("===");
        poupanca1.imprimirExtrato();

        System.out.println("===================");

        banco1.imprimirListaContas();

        }
}
