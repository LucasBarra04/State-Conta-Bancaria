package Classes;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContaTest {

    @Test
    void contaDeveIniciarComoAtiva() {
        Conta conta = new Conta("João", 1000.0);
        assertEquals("Ativa", conta.getEstado());
    }

    @Test
    void saqueComSaldoSuficienteNaoDeveAlterarEstado() {
        Conta conta = new Conta("João", 1000.0);
        conta.sacar(500.0);
        assertEquals("Ativa", conta.getEstado());
        assertEquals(500.0, conta.getSaldo(), 0.01);
    }

    @Test
    void saqueAcimaDoSaldoDeveIrParaNegativa() {
        Conta conta = new Conta("João", 100.0);
        conta.sacar(300.0);
        assertEquals("Negativa", conta.getEstado());
        assertEquals(-200.0, conta.getSaldo(), 0.01);
    }

    @Test
    void depositoEmNegativaComRegularizacaoDeveVoltarParaAtiva() {
        Conta conta = new Conta("João", 100.0);
        conta.sacar(300.0);
        conta.depositar(250.0);
        assertEquals("Ativa", conta.getEstado());
        assertEquals(50.0, conta.getSaldo(), 0.01);
    }

    @Test
    void depositoEmNegativaInsuficienteDevePermaneceNegativa() {
        Conta conta = new Conta("João", 100.0);
        conta.sacar(300.0);
        conta.depositar(50.0);
        assertEquals("Negativa", conta.getEstado());
    }

    @Test
    void bloqueioDeContaAtivaDeveIrParaBloqueada() {
        Conta conta = new Conta("João", 1000.0);
        conta.bloquear();
        assertEquals("Bloqueada", conta.getEstado());
    }

    @Test
    void saqueEmContaBloqueadaDeveSerInvalido() {
        Conta conta = new Conta("João", 1000.0);
        conta.bloquear();
        conta.sacar(100.0);
        assertEquals("Bloqueada", conta.getEstado());
        assertEquals(1000.0, conta.getSaldo(), 0.01);
    }

    @Test
    void depositoEmBloqueadaDeveSerPermitido() {
        Conta conta = new Conta("João", 1000.0);
        conta.bloquear();
        conta.depositar(500.0);
        assertEquals(1500.0, conta.getSaldo(), 0.01);
        assertEquals("Bloqueada", conta.getEstado());
    }

    @Test
    void encerramentoDeContaBloqueadaDeveIrParaEncerrada() {
        Conta conta = new Conta("João", 1000.0);
        conta.bloquear();
        conta.encerrar();
        assertEquals("Encerrada", conta.getEstado());
    }

    @Test
    void todasAcoesEmEncerradaDevemSerInvalidas() {
        Conta conta = new Conta("João", 1000.0);
        conta.encerrar();
        conta.sacar(100.0);
        conta.depositar(100.0);
        conta.bloquear();
        assertEquals("Encerrada", conta.getEstado());
        assertEquals(1000.0, conta.getSaldo(), 0.01);
    }
}