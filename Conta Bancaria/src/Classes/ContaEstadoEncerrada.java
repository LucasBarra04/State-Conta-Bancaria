package Classes;

public class ContaEstadoEncerrada extends ContaEstado {

    private static ContaEstadoEncerrada instance;

    private ContaEstadoEncerrada() {}

    public static ContaEstadoEncerrada getInstance() {
        if (instance == null) instance = new ContaEstadoEncerrada();
        return instance;
    }

    @Override
    public String getEstado() { return "Encerrada"; }
}