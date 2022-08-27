
package Dev_J130.frames;

import Dev_J130.tableModels.Order_positionsTableModel;
import Dev_J130.util.Utils;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class Order_postionsFrame extends JFrame{
    
    private final Order_positionsTableModel o_ptm = new Order_positionsTableModel();
    private final JTable order_posTable = new JTable();
    
    public Order_postionsFrame() {
        super("List of Order_postions"); 
        initLayoutOrder_postions();
    }
    
    private void initLayoutOrder_postions() {
        setBounds(100, 200, 600, 400);
	order_posTable.setModel(o_ptm);
	order_posTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        order_posTable.setFont(new Font("Times new roman", 0, 16));
        order_posTable.setIntercellSpacing(new Dimension(5, 5));
        order_posTable.setRowHeight(27);
        Utils.alignCenter(order_posTable, 0);
        Utils.alignCenter(order_posTable, 1);
        Utils.alignCenter(order_posTable, 2);
        Utils.alignCenter(order_posTable, 3);
        Utils.setJTableColumnsWidth
                 (order_posTable, 600, 20, 20, 20, 20); 
	add(order_posTable.getTableHeader(), BorderLayout.NORTH);
        JScrollPane scrollPane = new JScrollPane(order_posTable);
        scrollPane.setPreferredSize(new Dimension(600, 400));
	add(scrollPane, BorderLayout.CENTER);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);  
    }
}
