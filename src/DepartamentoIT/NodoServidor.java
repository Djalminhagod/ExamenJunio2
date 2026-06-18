package DepartamentoIT;

public abstract class NodoServidor implements Monitorizable {
    protected String hostname;
    protected int ramAsignada;

    public NodoServidor(String hostname, int ramAsignada) {
        this.hostname = hostname;
        this.ramAsignada = ramAsignada;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public int getRamAsignada() {
        return ramAsignada;
    }

    public void setRamAsignada(int ramAsignada) {
        this.ramAsignada = ramAsignada;
    }

    @Override
    public String toString() {
        return "NodoServidor{" +
                "hostname='" + hostname + '\'' +
                ", ramAsignada=" + ramAsignada +
                '}';
    }
}
