package model;

import javax.persistence.Entity;

@Entity
public class PhoneDetails{

    private PhoneType phoneType;
    private int number;
    private String operator;

    public  PhoneDetails(String type, int number, String operator){
        this.setPhoneType(type);
        this.number = number;
        this.operator = operator;
    }

    public void changePhoneNumber(String type, int number, String operator){
        this.setPhoneType(type);
        this.number = number;
        this.operator = operator;
    }

    public void setPhoneType(String type) {
        if (type.equalsIgnoreCase("office") ) {
            this.phoneType = phoneType.OFFICE;
        }
        else { this.phoneType = phoneType.CELL_PHONE; }
    }

    public PhoneType getPhoneType(){
        return  phoneType;
    }

    public int getNumber(){
        return number;
    }

    public String getOperator(){
        return operator;
    }
}