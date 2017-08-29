/*29.08.2017*/
package com.epam.courses.jf.practice.filippov.collections;

public class Client implements Comparable<Client>{

    private int clientID;
    private String surname;
    private String name;
    private String patronymic;
    private int amountOfOrders = 0;
    private int moneySpent = 0;

    public Client(int clientID, String surname, String name, String patronymic) {
        this.clientID = clientID;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
    }

    @Override
    public int compareTo(Client other) {
        if (this.moneySpent > other.moneySpent) {
            return 1;
        } else if (this.moneySpent == other.moneySpent) {
            return 0;
        } return -1;
    }

    public int getAmountOfOrders() {
        return amountOfOrders;
    }

    public void setAmountOfOrders(int amountOfOrders) {
        this.amountOfOrders = amountOfOrders;
    }

    public int getMoneySpent() {
        return moneySpent;
    }

    public void setMoneySpent(int moneySpent) {
        this.moneySpent = moneySpent;
    }

    public void addMoneySpent(int moneySpent) {
        this.moneySpent = this.moneySpent + moneySpent;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }
}
