package Service;

import java.time.LocalDate;
import java.sql.Date;

public class Client {
    protected String FIO;
    protected String Mobile;
    protected Date data;
    protected String time;

    public Client(String FIO, String Mobile, Date data, String time) {
        this.FIO = FIO;
        this.Mobile = Mobile;
        this.data = data;
        this.time = time;
    }

    public String getFIO() {
        return this.FIO;
    }

    public String getMobile() {
        return this.Mobile;
    }

    public Date getData() {
        return this.data;
    }
    public String getTime(){return this.time;}
}