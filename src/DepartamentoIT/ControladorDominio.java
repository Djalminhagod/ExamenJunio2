package DepartamentoIT;

public class ControladorDominio extends NodoServidor {
    private int usuariosActivos;

    public ControladorDominio(String hostname, int ramAsignada, int usuariosActivos) {
        super(hostname, ramAsignada);
        this.usuariosActivos = usuariosActivos;
    }

    public int getUsuariosActivos() {
        return usuariosActivos;
    }

    public void setUsuariosActivos(int usuariosActivos) {
        this.usuariosActivos = usuariosActivos;
    }


    @Override
    public double cargaAdicional() {
        return ramAsignada*2 + (usuariosActivos*0.5);
    }
}
