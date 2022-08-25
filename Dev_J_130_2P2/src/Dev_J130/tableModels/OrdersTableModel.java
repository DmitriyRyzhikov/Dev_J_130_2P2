
package Dev_J130.tableModels;

import java.time.LocalDate;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import Dev_J130.lists.OrdersList;
import Dev_J130.models.Orders;

public class OrdersTableModel implements TableModel{
    
    private static final String[] COLUMN_HEADERS = new String[]{
            "Order id",
            "Order date",
            "Customer name",
            "Customer phone",
            "Customer email",
            "Shipment address",
            "Order status",
            "Shipment date"
        };

    @Override
    public int getColumnCount() {
        return COLUMN_HEADERS.length;
    }

    @Override
	public String getColumnName(int columnIndex) {
		return COLUMN_HEADERS[columnIndex];
	}

    @Override
	public Class<?> getColumnClass(int columnIndex) {
		switch(columnIndex) {
			case 0:
                                return Integer.class;
			case 1: 
			case 7:
                                return LocalDate.class;
                        case 2:
                        case 3: 
                        case 4: 
                        case 5:
                        case 6:
                                return String.class;
		}
		throw new IllegalArgumentException("unknown columnIndex");
	} 

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
	public Object getValueAt(int rowIndex, int columnIndex) {

	    Orders order = OrdersList.getOrderInstance().getOrder(rowIndex);
		switch(columnIndex) {
			case 0: return order.getOrder_id(); 
			case 1: return order.getOrder_date();
			case 2: return order.getСustomer_name();
			case 3: return order.getСustomer_phone();
                        case 4: return order.getСustomer_email();
                        case 5: return order.getShipment_address();
                        case 6: return order.getOrder_status();
                        case 7: return order.getShipment_date();
		}
		throw new IllegalArgumentException("unknown columnIndex"); 

	}

    @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) 
        { }

    @Override
	public void addTableModelListener(TableModelListener l) 
        { }

    @Override
	public void removeTableModelListener(TableModelListener l) 
        { } 
        
    @Override
	public int getRowCount() {
		return OrdersList.getOrderInstance().getOrdersCount();
	}
}

