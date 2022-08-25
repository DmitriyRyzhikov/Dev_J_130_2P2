
package Dev_J_130;
import Dev_J130.tableModels.Order_positionsTableModel;
import Dev_J130.tableModels.OrdersTableModel;
import Dev_J130.tableModels.ProductsTableModel;
import Dev_J130.util.Utils;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

public class MainFrame extends JFrame{
    
    private final ProductsTableModel ptm = new ProductsTableModel();
    private final OrdersTableModel otm = new OrdersTableModel();
    private final Order_positionsTableModel o_ptm = new Order_positionsTableModel();
    private final JTable propductsTable = new JTable();
    private final JTable ordersTable = new JTable();
    private final JTable order_posTable = new JTable();
    
    
    public MainFrame() {
        super("List of products");
		
	//initLayoutProducts();
        //initLayoutOrders();
        initLayoutOrder_postions();
        closeApp();
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
                 (ordersTable, 1200, 20, 20, 60, 40, 40, 80, 20, 20); 
	add(ordersTable.getTableHeader(), BorderLayout.NORTH);
        JScrollPane scrollPane = new JScrollPane(ordersTable);
        scrollPane.setPreferredSize(new Dimension(1200, 500));
	add(scrollPane, BorderLayout.CENTER);
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
    }
    
    private void closeApp(){
        addWindowListener(new WindowAdapter() { 
            @Override
            public void windowClosing(WindowEvent e) {
                int n = JOptionPane
                        .showConfirmDialog(e.getWindow(), "Closing the app? Are you sure?",
                                "Confirmation of closing", JOptionPane.YES_NO_OPTION,
                                JOptionPane.WARNING_MESSAGE);
                if (n == 0) {
                    e.getWindow().setVisible(false);
                    System.exit(0);
                }
                else
                    setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            }
        });
    }
}

