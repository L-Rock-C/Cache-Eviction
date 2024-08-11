package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ServiceOrder {

    int nodeHeight;
    ServiceOrder left, right;

    private int id;
    private String name;
    private String client;

    private String description;

    private LocalDateTime requestDate;
    private LocalDateTime deadline;
    private DateTimeFormatter dateTimeFormater;

    public ServiceOrder(int id, String name, String client, String description, LocalDateTime deadline) {
        this.id = id;
        this.name = name;
        this.client = client;
        this.description = description;
        this.requestDate = LocalDateTime.now();
        this.deadline = deadline;
    }
    public ServiceOrder(int id, String name, String client, String description, LocalDateTime requestDate,
                        LocalDateTime deadline) {
        this.id = id;
        this.name = name;
        this.client = client;
        this.description = description;
        this.requestDate = requestDate;
        this.deadline = deadline;
    }

    public ServiceOrder(){};

    public void show(){
        System.out.println("Id: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Client: " + getClient());
        System.out.println("Description: " + getDescription());
        System.out.println("Request Date: " + getRequestDate());
        System.out.println("Deadline: " + getDeadline());
    }

    public void listShow(){
        System.out.print("  Id: " + getId() + "  |  ");
        System.out.print("Name: " + getName() + "  |  ");
        System.out.println("Deadline: " + getDeadline());
    }

    @Override
    public String toString(){
        String toString;
        toString = getId() + ";" + getName() + ";" + getClient() + ";" + getDescription() + ";" + getRequestDate() + ";"
                   + getDeadline() + "\n";
        return toString;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDateTime requestDate) {
        this.requestDate = requestDate;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public DateTimeFormatter getDateTimeFormater() {
        return dateTimeFormater;
    }

    public void setDateTimeFormater(DateTimeFormatter dateTimeFormater) {
        this.dateTimeFormater = dateTimeFormater;
    }
}
