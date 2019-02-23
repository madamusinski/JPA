package model;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class AccountLogger{

    private Date createDate;
    private Date lastLogon;
    private String lastLoggedFrom;

    public AccountLogger(Date createDate, Date lastLogon, String lastLoggedFrom){
        this.createDate = createDate;
        this.lastLogon = lastLogon;
        this.lastLoggedFrom = lastLoggedFrom;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Date getLastLogon(){
        return lastLogon;
    }

    public String getLastLoginLocation(){
        return lastLoggedFrom;
    }
}