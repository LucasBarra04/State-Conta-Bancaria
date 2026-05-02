package Classes;

public abstract class ContaEstado {

    public abstract String getEstado();

    public void sacar(Conta conta, double valor) {
        System.out.println("Ação inválida para o estado: " + getEstado());
    }
    public void depositar(Conta conta, double valor) {
        System.out.println("Ação inválida para o estado: " + getEstado());
    }
    public void bloquear(Conta conta) {
        System.out.println("Ação inválida para o estado: " + getEstado());
    }
    public void encerrar(Conta conta) {
        System.out.println("Ação inválida para o estado: " + getEstado());
    }
}