package DepartamentoIT;

public class ServidorVirtual extends NodoServidor{
    private String tipoSistema;

    public ServidorVirtual(String hostname, int ramAsignada, String tipoSistema) {
        super(hostname, ramAsignada);
        this.tipoSistema = tipoSistema;
    }

    public String getTipoSistema() {
        return tipoSistema;
    }

    public void setTipoSistema(String tipoSistema) {
        this.tipoSistema = tipoSistema;
    }

    @Override
    public double cargaAdicional() {
        return ramAsignada*1.5;
    }
}
