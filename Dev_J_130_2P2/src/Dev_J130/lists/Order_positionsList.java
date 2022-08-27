
package Dev_J130.lists;

import java.util.List;

import Dev_J130.models.Order_positions;
import Dev_J130.util.Repository;

public class Order_positionsList {
    
    private static final Order_positionsList order_positionInstance = new Order_positionsList();  
    private final List<Order_positions> order_positionsList;

    private Order_positionsList() {
        order_positionsList = new Repository().getOrder_positionsList();
	}

//Метод возвращает кол-во заказанных позиций, загруженных из базы данных.
    public int getOrder_positionsCount() {
        return order_positionsList.size();
    }
//Метод возвращает данные о заказанной позиции в виде объекта класса Order_positions.
    public Order_positions getOrder_positions(int index) {
        return order_positionsList.get(index);
    }
//Статический метод для доступа к полям класса.
    public static Order_positionsList getOrder_positionsInstance() {
		return order_positionInstance;
	}
//Метод возвращает весь список товаров.
    public List<Order_positions> getOrder_positionsList() {
        return order_positionsList;
    }    
}
