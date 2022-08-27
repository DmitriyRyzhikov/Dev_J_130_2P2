
package Dev_J130.frames;

import Dev_J130.tableModels.OrdersTableModel;
import Dev_J130.util.Utils;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class OrdersFrame extends JFrame{
    
    private final OrdersTableModel otm = new OrdersTableModel();
    private final JTable ordersTable = new JTable();
     
    public OrdersFrame() {
        super("List of orders");
        initLayoutOrders();
    }
    
    private void initLayoutOrders() {
        setBounds(100, 200, 1200, 500);
	ordersTable.setModel(otm);
	ordersTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        ordersTable.setFont(new Font("Times new roman", 0, 16));
        ordersTable.setIntercellSpacing(new Dimension(5, 5));
        ordersTable.setRowHeight(27);
        Utils.alignCenter(ordersTable, 0);
        Utils.alignCenter(ordersTable, 1);
        Utils.alignCenter(ordersTable, 3);
        Utils.alignCenter(ordersTable, 6);
        Utils.alignCenter(ordersTable, 7);
        Utils.setJTableColumnsWidth
                 (ordersTable, 1200, 20, 20, 60, 40, 40, 70, 20, 30); 
	add(ordersTable.getTableHeader(), BorderLayout.NORTH);
        JScrollPane scrollPane = new JScrollPane(ordersTable);
        scrollPane.setPreferredSize(new Dimension(1200, 500));
	add(scrollPane, BorderLayout.CENTER);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
    }   
}
