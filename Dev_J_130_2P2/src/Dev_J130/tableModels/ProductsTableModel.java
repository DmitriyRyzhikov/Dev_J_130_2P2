
package Dev_J130.tableModels;

import Dev_J130.lists.ProductList;
import Dev_J130.models.Products;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class ProductsTableModel implements TableModel{
    
    private static final String[] COLUMN_HEADERS = new String[]{
            "Article",
            "Product name",
            "Product color",
            "Product price",
            "Product in stock"
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
			case 1: 
			case 2:
                                return String.class;
                        case 3:
                        case 4:    
				return Integer.class;
		}
		throw new IllegalArgumentException("unknown columnIndex");
	} 

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
	public Object getValueAt(int rowIndex, int columnIndex) {

	    Products prod = ProductList.getProductInstance().getProduct(rowIndex); 
		switch(columnIndex) {
			case 0: return prod.getArticle(); 
			case 1: return prod.getProduct_name();
			case 2: return prod.getProduct_color();
			case 3: return prod.getProduct_price();
                        case 4: return prod.getProduct_in_stock();
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
		return ProductList.getProductInstance().getProductsCount();
	}
}
