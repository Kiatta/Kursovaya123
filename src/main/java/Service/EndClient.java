package Service;

public class EndClient {
    protected int id;
    protected String name;


    public EndClient(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}