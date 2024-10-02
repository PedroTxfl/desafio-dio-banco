public abstract class Conta implements IConta{


    protected int agencia;
    protected int numero;
    protected double saldo;
    private Cliente cliente;
    private Banco banco;


    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    public Conta(Cliente cliente, Banco banco) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.banco =  banco;
        banco.adicionarConta(this);
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }


    @Override
    public void sacar(double valor) {
        if (saldo < valor) {
            System.out.println("Saldo atual insuficiente para este saque.");
        } else {
            saldo -= valor;
            System.out.println("Saque efetuado. Saldo atual: " + saldo);
        }
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito efetuado. Saldo atual: " + saldo);
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        if (saldo < valor) {
            System.out.println("Saldo atual insuficiente para fazer esta transferência.");
        } else {
            this.sacar(valor);
            contaDestino.depositar(valor);
        }
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }

    @Override
    public String toString() {
        return "Conta{" +
                "agencia=" + agencia +
                ", numero=" + numero +
                ", cliente=" + cliente +
                ", banco=" + banco +
                '}';
    }
}
