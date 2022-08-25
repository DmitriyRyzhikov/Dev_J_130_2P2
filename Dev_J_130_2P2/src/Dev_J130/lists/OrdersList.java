package Dev_J130.lists;

import java.util.List;

import Dev_J130.models.Orders;
import Dev_J_130.Repository;

public class OrdersList {
    
    private static final OrdersList orderInstance = new OrdersList();  
    private final List<Orders> ordersList;

    private OrdersList() {
        ordersList = new Repository().getOrdersList();
	}

//Метод возвращает кол-во заказов, загруженных из базы данных.
    public int getOrdersCount() {
        return ordersList.size();
    }
//Метод возвращает данные о заказе в виде объекта класса Orders.
    public Orders getOrder(int index) {
        return ordersList.get(index);
    }
//Статический метод для доступа к полям класса.
    public static OrdersList getOrderInstance() {
		return orderInstance;
	}
//Метод возвращает весь список товаров.
    public List<Orders> getOrdersList() {
        return ordersList;
    }    
}
