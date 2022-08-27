
package Dev_J130.frames;

import Dev_J130.tableModels.ProductsTableModel;
import Dev_J130.util.Utils;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class ProductsFrame extends JFrame{
    
    private final ProductsTableModel ptm = new ProductsTableModel();
    private final JTable propductsTable = new JTable();
    
    public ProductsFrame() {
        super("List of products");		
	initLayoutProducts();
    }
    
    private void initLayoutProducts() {
        setBounds(100, 200, 800, 500);
	propductsTable.setModel(ptm);
	propductsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        propductsTable.setFont(new Font("Times new roman", 0, 16));
        propductsTable.setIntercellSpacing(new Dimension(5, 5));
        propductsTable.setRowHeight(27);
        Utils.alignCenter(propductsTable, 0);
        Utils.alignCenter(propductsTable, 3);
        Utils.alignCenter(propductsTable, 4);
        Utils.setJTableColumnsWidth
                                  (propductsTable, 800, 31, 100, 40, 40, 40); 
	add(propductsTable.getTableHeader(), BorderLayout.NORTH);
        JScrollPane scrollPane = new JScrollPane(propductsTable);
        scrollPane.setPreferredSize(new Dimension(800, 500));
	add(scrollPane, BorderLayout.CENTER);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
    }
}
