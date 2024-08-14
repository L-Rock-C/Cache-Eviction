package control;

import model.AVLTree;
import model.ServiceOrder;

import java.io.*;
import java.time.LocalTime;

public class FileAccess {

    public void WriteFile(String path, String input) throws IOException
    {
        BufferedWriter bufferedWriter = new BufferedWriter( new FileWriter(path) );
        bufferedWriter.append(input);
        bufferedWriter.close();
    }

    public AVLTree readSOFile(String path) throws IOException {
        AVLTree servicesOrders = new AVLTree();

        BufferedReader bufferedReader = new BufferedReader( new FileReader(path) );

        StringBuffer sbResult = new StringBuffer();
        String line = "";

        while (line != null)
        {
            sbResult.append(line + "\n");
            line = bufferedReader.readLine();

            if(line != null)
            {
                String[] SOData = line.split(";");
                int id = Integer.parseInt(SOData[0]);
                String name = SOData[1];
                String client = SOData[2];
                String description = SOData[3];
                LocalTime requestData = LocalTime.parse(SOData[4]);

                ServiceOrder serviceOrder = new ServiceOrder(id, name, client, description, requestData);

                servicesOrders.insertNode(id, serviceOrder);
            }
        }
        
        return servicesOrders;
    }

}
