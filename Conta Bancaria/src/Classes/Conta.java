package Classes;

public class Conta {

    private ContaEstado estado;
    private double saldo;
    private String titular;

    public Conta(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
        this.estado = ContaEstadoAtiva.getInstance();
    }

    public void setEstado(ContaEstado estado) { this.estado = estado; }
    public String getEstado()                 { return estado.getEstado(); }
    public double getSaldo()                  { return saldo; }
    public void setSaldo(double saldo)        { this.saldo = saldo; }
    public String getTitular()               { return titular; }

    public void sacar(double valor)   { estado.sacar(this, valor); }
    public void depositar(double valor) { estado.depositar(this, valor); }
    public void bloquear()            { estado.bloquear(this); }
    public void encerrar()            { estado.encerrar(this); }
}