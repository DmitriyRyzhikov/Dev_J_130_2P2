
package Dev_J130.tableModels;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import Dev_J130.lists.Order_positionsList;
import Dev_J130.models.Order_positions;

public class Order_positionsTableModel implements TableModel{
    
    private static final String[] COLUMN_HEADERS = new String[]{
            "Order cod",
            "Product article",
            "Order price",
            "Amount"
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
                        case 2:
                        case 3:
                                return Integer.class;
                        case 1: 
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

	    Order_positions order_p = Order_positionsList.getOrder_positionsInstance().getOrder_positions(rowIndex); 
		switch(columnIndex) {
			case 0: return order_p.getOrder_cod(); 
			case 1: return order_p.getProduct_article();
			case 2: return order_p.getOrder_price();
			case 3: return order_p.getAmount();
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
		return Order_positionsList.getOrder_positionsInstance().getOrder_positionsCount();
	}
}


