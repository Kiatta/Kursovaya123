package Service;

public class EndClient {
    protected int idClientpr;
    protected int idPrclient;


    public EndClient(int idClientpr, int idPrclient) {
        this.idClientpr = idClientpr;
        this.idPrclient = idPrclient;
    }


    public int getIdClientpr() {
        return idClientpr;
    }

    public int getIdPrclient() {
        return idPrclient;
    }
}
