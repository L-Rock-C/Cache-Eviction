package model;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ServiceOrder {

    int nodeHeight;
    ServiceOrder left, right;

    private int id;
    private String name;
    private String client;

    private String description;

    private LocalTime requestTime;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

    public ServiceOrder(int id, String name, String client, String description) {
        this.id = id;
        this.name = name;
        this.client = client;
        this.description = description;
        this.requestTime = LocalTime.now();
    }

    public ServiceOrder(int id, String name, String client, String description, LocalTime requestTime) {
        this.id = id;
        this.name = name;
        this.client = client;
        this.description = description;
        this.requestTime = requestTime;
    }

    public ServiceOrder() {
    }

    ;

    public void show() {
        System.out.println("Id: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Client: " + getClient());
        System.out.println("Description: " + getDescription());
        System.out.println("Request Time: " + getRequestTime().format(formatter));
    }

    public void listShow() {
        System.out.print("  Id: " + getId() + "  |  ");
        System.out.print("Name: " + getName() + "  |  ");
        System.out.print("Client: " + getClient() + "  |  ");
        System.out.print("Description: " + getDescription() + "  |  ");
        System.out.println("Request Time: " + getRequestTime().format(formatter));
    }

    @Override
    public String toString() {
        String toString;
        toString = getId() + ";" + getName() + ";" + getClient() + ";" + getDescription() + ";" + getRequestTime() + "\n";
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

    public LocalTime getRequestTime() {
        return requestTime;
    }
}
