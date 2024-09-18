package model;

import control.FileAccess;

import java.io.File;
import java.io.IOException;

public class Cache {
    File cacheFile = new File("src\\file\\cache.txt");

    private final Queue<ServiceOrder> cacheSO = new Queue<ServiceOrder>(20);
    FileAccess fileAccess = new FileAccess();

    public void addServiceOrder(ServiceOrder serviceOrder){
        if(cacheSO.isFull()){
            cacheSO.remove();
        }
        cacheSO.add(serviceOrder);
    }

    public ServiceOrder cacheSearch(int id){
        if(!cacheSO.isEmpty()){
            Queue<ServiceOrder>.QueueNode search = cacheSO.getHead();
            while (search != null){
                if(search.data.getId() == id){
                    return search.data;
                }

                search = search.next;
            }
        }

        return null;
    }



    public String listCache(){
        String listCacheReturn = "";

        if(!cacheSO.isEmpty()){
            Queue<ServiceOrder>.QueueNode search = cacheSO.getHead();
            while (search != null){
                listCacheReturn += search.data.toString();

                search = search.next;
            }
        }

        return listCacheReturn;
    }

    public void printCache(){
        System.out.println("------- View Cache --------\n");
        String listCacheReturn = "";

        if(!cacheSO.isEmpty()){
            Queue<ServiceOrder>.QueueNode search = cacheSO.getHead();
            while (search != null){
                listCacheReturn += search.data.toString();
                search = search.next;
            }
        }
        System.out.println(listCacheReturn);
    }

    public void updateCache() throws IOException {
        fileAccess.WriteFile(cacheFile, listCache());
    }
}
