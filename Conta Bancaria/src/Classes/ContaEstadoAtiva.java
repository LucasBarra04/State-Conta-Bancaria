package Classes;

public class ContaEstadoAtiva extends ContaEstado {

    private static ContaEstadoAtiva instance;

    private ContaEstadoAtiva() {}

    public static ContaEstadoAtiva getInstance() {
        if (instance == null) instance = new ContaEstadoAtiva();
        return instance;
    }

    @Override
    public String getEstado() { return "Ativa"; }

    @Override
    public void sacar(Conta conta, double valor) {
        if (conta.getSaldo() - valor < 0) {
            conta.setSaldo(conta.getSaldo() - valor);
            System.out.println("Saque de R$" + valor + " realizado. Saldo negativo: R$" + conta.getSaldo());
            conta.setEstado(ContaEstadoNegativa.getInstance());
        } else {
            conta.setSaldo(conta.getSaldo() - valor);
            System.out.println("Saque de R$" + valor + " realizado. Saldo: R$" + conta.getSaldo());
        }
    }

    @Override
    public void depositar(Conta conta, double valor) {
        conta.setSaldo(conta.getSaldo() + valor);
        System.out.println("Depósito de R$" + valor + " realizado. Saldo: R$" + conta.getSaldo());
    }

    @Override
    public void bloquear(Conta conta) {
        System.out.println("Conta bloqueada.");
        conta.setEstado(ContaEstadoBloqueada.getInstance());
    }

    @Override
    public void encerrar(Conta conta) {
        System.out.println("Conta encerrada.");
        conta.setEstado(ContaEstadoEncerrada.getInstance());
    }
}