package control;

import model.Log;
import model.Server;
import model.Cache;
import model.ServiceOrder;

import java.io.*;
import java.time.LocalTime;
import java.util.LinkedList;

public class FileAccess {

    public void WriteFile(String path, String input) throws IOException
    {
        BufferedWriter bufferedWriter = new BufferedWriter( new FileWriter(path) );
        bufferedWriter.append(input);
        bufferedWriter.close();
    }

    public Server readSOFile(String path) throws IOException {
        Server servicesOrders = new Server();

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

    public Cache readCacheFile(String path) throws IOException {
        Cache cacheSO = new Cache();

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

                cacheSO.addServiceOrder(serviceOrder);
            }
        }

        return cacheSO;
    }

    public LinkedList<Log> readLogFile(String path) throws IOException {
        LinkedList<Log> logs = new LinkedList<Log>();

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
                String action = SOData[0];
                int nodeHeight = Integer.parseInt(SOData[1]);
                String rotation = SOData[2];

                Log log = new Log(action, nodeHeight, rotation);

                logs.add(log);
            }
        }

        return logs;
    }
}
