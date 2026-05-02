package Classes;

public class ContaEstadoNegativa extends ContaEstado {

    private static ContaEstadoNegativa instance;

    private ContaEstadoNegativa() {}

    public static ContaEstadoNegativa getInstance() {
        if (instance == null) instance = new ContaEstadoNegativa();
        return instance;
    }

    @Override
    public String getEstado() { return "Negativa"; }

    @Override
    public void depositar(Conta conta, double valor) {
        conta.setSaldo(conta.getSaldo() + valor);
        System.out.println("Depósito de R$" + valor + " realizado. Saldo: R$" + conta.getSaldo());
        if (conta.getSaldo() >= 0) {
            System.out.println("Saldo regularizado. Conta voltou para Ativa.");
            conta.setEstado(ContaEstadoAtiva.getInstance());
        }
    }

    @Override
    public void bloquear(Conta conta) {
        System.out.println("Conta negativa bloqueada.");
        conta.setEstado(ContaEstadoBloqueada.getInstance());
    }

    @Override
    public void encerrar(Conta conta) {
        System.out.println("Conta negativa encerrada.");
        conta.setEstado(ContaEstadoEncerrada.getInstance());
    }
}