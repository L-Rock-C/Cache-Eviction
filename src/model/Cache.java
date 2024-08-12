package model;

public class Cache {
    private Queue<ServiceOrder> cacheSO = new Queue<ServiceOrder>(20);

    public void addServiceOrder(ServiceOrder serviceOrder){
        if(cacheSO.isFull()){
            cacheSO.remove();
        }
        cacheSO.add(serviceOrder);
    }

    public ServiceOrder cacheSearch(ServiceOrder serviceOrder){
        Queue<ServiceOrder>.QueueNode search = cacheSO.getHead();
        while (search.next != null){
            if(search.data.getId() == serviceOrder.getId()){
                return search.data;
            }

            search = search.next;
        }

        return null;
    }
}
