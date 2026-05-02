package Classes;

public class ContaEstadoBloqueada extends ContaEstado {

    private static ContaEstadoBloqueada instance;

    private ContaEstadoBloqueada() {}

    public static ContaEstadoBloqueada getInstance() {
        if (instance == null) instance = new ContaEstadoBloqueada();
        return instance;
    }

    @Override
    public String getEstado() { return "Bloqueada"; }

    @Override
    public void depositar(Conta conta, double valor) {
        conta.setSaldo(conta.getSaldo() + valor);
        System.out.println("Depósito de R$" + valor + " realizado mesmo com conta bloqueada. Saldo: R$" + conta.getSaldo());
    }

    @Override
    public void encerrar(Conta conta) {
        System.out.println("Conta bloqueada encerrada.");
        conta.setEstado(ContaEstadoEncerrada.getInstance());
    }
}