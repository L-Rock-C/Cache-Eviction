package control;

import model.AVLTree;
import model.Node;
import model.ServiceOrder;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class ServiceOrderController {
    FileAcess fileAcess = new FileAcess();
    AVLTree serviceOrders = fileAcess.readSOFile("C:\\Users\\Rock\\IdeaProjects\\Cache-Eviction\\src\\file\\serviceOrders.txt");
    Scanner input = new Scanner(System.in);

    public ServiceOrderController() throws IOException { }

    public void serviceOrdersList(){
        System.out.println("------- Service Orders List --------\n");

        serviceOrders.inorder();
        serviceOrders.showNodeList();

        System.out.print("\nSelect a service order by its id to visualize: ");
        int choice = input.nextInt();

        Node chosen = serviceOrders.searchNode(choice);
        if(chosen != null) {
            System.out.println("\nId:" + chosen.getServiceOrder().getId());
            System.out.println("Name: " + chosen.getServiceOrder().getName());
            System.out.println("Client: " + chosen.getServiceOrder().getClient());
            System.out.println("Description: " + chosen.getServiceOrder().getDescription());
            System.out.println("Deadline: " + chosen.getServiceOrder().getDeadline());

            System.out.print("\nPress Enter to continue.");
            input.nextLine();
            input.nextLine();
        } else{
            System.out.println("\nService Order with id " + choice + " doesn't exist.\n");
        }

        System.out.println();
    }

    public void serviceOrderEdit() throws IOException {
        System.out.println("------- Service Order Edit --------\n");

        serviceOrders.inorder();
        serviceOrders.showNodeList();

        System.out.print("\nSelect a service order by its id to edit: ");
        int choice = input.nextInt();

        Node chosen = serviceOrders.searchNode(choice);
        if(chosen != null){
            boolean done = false;
            while(!done){
                System.out.println("\n------- Editing Service Order --------\n");

                System.out.println("[1] Id:" + chosen.getServiceOrder().getId());
                System.out.println("[2] Name: " + chosen.getServiceOrder().getName());
                System.out.println("[3] Client: " + chosen.getServiceOrder().getClient());
                System.out.println("[4] Description: " + chosen.getServiceOrder().getDescription());
                System.out.println("[5] Deadline: " + chosen.getServiceOrder().getDeadline());
                System.out.println("\n[6] Finish edit.\n");

                System.out.print("Select a field to edit: ");
                choice = input.nextInt();
                input.nextLine();

                switch(choice){
                    case 1:
                        System.out.print("Insert new Id value: ");
                        int id = input.nextInt();
                        chosen.getServiceOrder().setId(id);
                        break;
                    case 2:
                        System.out.print("Insert new Name value: ");
                        String name = input.nextLine();
                        chosen.getServiceOrder().setName(name);
                        break;
                    case 3:
                        System.out.print("Insert new Client value: ");
                        String client = input.nextLine();
                        chosen.getServiceOrder().setClient(client);
                        break;
                    case 4:
                        System.out.print("Insert new Description value: ");
                        String description = input.nextLine();
                        chosen.getServiceOrder().setDescription(description);
                        break;
                    case 5:
                        System.out.print("Insert new Deadline value: ");
                        LocalDateTime deadline = LocalDateTime.parse(input.nextLine());
                        chosen.getServiceOrder().setDeadline(deadline);
                        break;
                    case 6:
                        serviceOrders.inorder();
                        fileAcess.WriteFile("C:\\Users\\Rock\\IdeaProjects\\Cache-Eviction\\src\\file\\serviceOrders.txt", serviceOrders.getNodeList());
                        System.out.println();
                        done = true;
                        break;
                    default:
                        System.out.println("Invalid number.");
                        break;
                }
            }
        } else {
            System.out.println("\nService Order with id " + choice + " doesn't exist.\n");
        }
    }

    public void serviceOrderForm() throws IOException {

        System.out.println("------- Service Order Form --------\n");

        System.out.print("Id:" );
        int id = input.nextInt();
        input.nextLine();

        System.out.print("Name: ");
        String name = input.nextLine();

        System.out.print("Client: ");
        String client = input.nextLine();

        System.out.print("Description: ");
        String description = input.nextLine();

        System.out.print("Deadline: ");
        LocalDateTime deadline = LocalDateTime.parse(input.nextLine());

        ServiceOrder serviceOrder = new ServiceOrder(id, name, client, description, deadline);
        serviceOrders.insertNode(serviceOrder.getId(), serviceOrder);
        serviceOrders.inorder();
        fileAcess.WriteFile("C:\\Users\\Rock\\IdeaProjects\\Cache-Eviction\\src\\file\\serviceOrders.txt", serviceOrders.getNodeList());
    }

    public void serviceOrderDelete() throws IOException {
        System.out.println("\n------- Service Order Delete --------\n");

        serviceOrders.inorder();
        serviceOrders.showNodeList();

        System.out.print("\nSelect a service order by its id to delete: ");
        int choice = input.nextInt();

        Node chosen = serviceOrders.searchNode(choice);
        if(chosen != null){
            serviceOrders.removeNode(chosen.key, chosen.serviceOrder);
            serviceOrders.inorder();
            fileAcess.WriteFile("C:\\Users\\Rock\\IdeaProjects\\Cache-Eviction\\src\\file\\serviceOrders.txt", serviceOrders.getNodeList());
            System.out.println("Service order deleted.");
        }

        System.out.println();
    }
}
