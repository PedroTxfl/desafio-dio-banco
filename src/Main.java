//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Cliente pedro = new Cliente();
        pedro.setNome("pedro");

        Conta cc1 = new ContaCorrente(pedro);
        Conta poupanca1 = new ContaPoupanca(pedro);

        cc1.depositar(100);
        cc1.transferir(100, poupanca1);

        cc1.imprimirExtrato();
        poupanca1.imprimirExtrato();
        }
}
