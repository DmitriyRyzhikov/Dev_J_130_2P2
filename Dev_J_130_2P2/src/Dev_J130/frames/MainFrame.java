
package Dev_J130.frames;
import Dev_J130.util.JTextFieldRegularPopupMenu;
import Dev_J130.util.Repository;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.border.BevelBorder;

public class MainFrame extends JFrame{
    
    private static JTextField URLtextField;
    private JComboBox<String> tableNameCombo;
    private static String urlDB;
    private static String tableName = "";
    private ArrayList<String> tableNamesList = new ArrayList<>();
    private ProductsFrame productsFrame;
    private OrdersFrame ordersFrame;
    private Order_postionsFrame order_positionsFrame;

    public static String getUrlDB() {
        return urlDB;
    }
    public static JTextField getURLtextField() {
        return URLtextField;
    }       
    public MainFrame() {
        super("Welcome to our DB");
        initMainFrame();
        closeApp();       
    }
    
    private void initMainFrame() {
        setBounds(100, 200, 700, 250);
        getContentPane().setBackground(Color.WHITE);
        GridLayout gLayout = new GridLayout(0,1);
        getContentPane().setLayout(gLayout); 
        firstRow();
        secondRow(); 
    }
    //обеспечивает закрытие приложения с подтверждением.
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
                    System.exit(0); }          
                else
                    setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            }
        });
    }
    //первый ряд элементов главного окна.
    private void firstRow(){
        
        JPanel firstPane = new JPanel();
        firstPane.setLayout(new BoxLayout(firstPane, BoxLayout.X_AXIS));
        firstPane.setBackground(Color.WHITE);
        firstPane.add(Box.createRigidArea(new Dimension(10,0)));
        JLabel firestLabel = new JLabel("Database URL:");
        firestLabel.setFont(new Font("Arial", Font.BOLD, 20));
        firstPane.add(firestLabel);
        firstPane.add(Box.createRigidArea(new Dimension(5,0)));
        URLtextField = new JTextField();
        JTextFieldRegularPopupMenu.addTo(URLtextField); 
        URLtextField.setMaximumSize(new Dimension(450, 40));
        URLtextField.setFont(new Font("Arial", Font.PLAIN, 20));
        URLtextField.addFocusListener(new FocusListener() { 
            @Override
            public void focusGained(FocusEvent e) {               
                tableNameCombo.removeAllItems();
            }               
            @Override
            public void focusLost(FocusEvent e) {
                if(!URLtextField.getText().equals(""))
                 { urlDB = URLtextField.getText(); 
                   tableNamesList = Repository.getTableNames();                   
                   tableNamesList.forEach(x -> tableNameCombo.addItem(x));                   
                   productsFrame = new ProductsFrame();
                   productsFrame.setVisible(false);
                   ordersFrame = new OrdersFrame();
                   ordersFrame.setVisible(false);
                   order_positionsFrame = new Order_postionsFrame();
                   order_positionsFrame.setVisible(false);}   
            }
        }); 
        firstPane.add(URLtextField);
        firstPane.add(Box.createRigidArea(new Dimension(5,0)));
        JButton clearButton = new JButton("Clear");
        bordersSet(clearButton);
        clearButton.setFont(new Font("Arial", Font.BOLD, 15));
        clearButton.setForeground(Color.red); 
        clearButton.setMaximumSize(new Dimension(80, 35));
        clearButton.setActionCommand("clear DB URL");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableNameCombo.removeAllItems();
                URLtextField.setText("");
            }
        }); 
        firstPane.add(clearButton); 
        firstPane.add(Box.createRigidArea(new Dimension(10,0)));
        add(firstPane);        
    }
    //второй ряд элементов главного окна
    private void secondRow(){

        JPanel secondPane = new JPanel();
        secondPane.setLayout(new BoxLayout(secondPane, BoxLayout.X_AXIS));
        secondPane.setBackground(Color.WHITE);
        secondPane.add(Box.createRigidArea(new Dimension(35,0)));
        JLabel secondLabel = new JLabel("Table name:");
        secondLabel.setFont(new Font("Arial", Font.BOLD, 20));
        secondPane.add(secondLabel);
        secondPane.add(Box.createRigidArea(new Dimension(5,0)));
        tableNameCombo = new JComboBox();
        tableNameCombo.setEditable(false); 
        tableNameCombo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) 
                    tableName = (String) e.getItem();            
            }
        });  
        tableNameCombo.setMaximumSize(new Dimension(450, 40));
        tableNameCombo.setFont(new Font("Arial", Font.PLAIN, 20));
        secondPane.add(tableNameCombo);
        secondPane.add(Box.createRigidArea(new Dimension(5,0)));
        JButton uploadButton = new JButton("Upload");
        bordersSet(uploadButton);
        uploadButton.setFont(new Font("Arial", Font.BOLD, 15));
        uploadButton.setForeground(Color.BLUE);
        uploadButton.setMaximumSize(new Dimension(80, 35));
        uploadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if(!URLtextField.getText().equals("")){ 
               switch(tableName){
                   case "products":
                       productsFrame.setVisible(true); 
                       break;
                   case "orders":
                       ordersFrame.setVisible(true); 
                       break; 
                   case "order_positions":
                       order_positionsFrame.setVisible(true); 
                       break;    
               }
              if(urlDB!=null && (productsFrame.isActive() || ordersFrame.isActive() || order_positionsFrame.isActive()))
                 tableName = "";   
            }
            }
        });
        secondPane.add(uploadButton); 
        secondPane.add(Box.createRigidArea(new Dimension(10,0)));
        add(secondPane);        
    }
    public static void bordersSet(JButton button){
        button.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createBevelBorder(BevelBorder.RAISED),
        BorderFactory.createEmptyBorder(5, 10, 5, 10)));  
    }
}

