/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sarthake
 */
package ambrosia2;
import java.sql.*;
import java.util.*;
public class Food_Menu extends javax.swing.JFrame {
        int prev_day;
        int curr_day;
        int reg;
        float consume;
        float[] meal = new float[3];
        String[] items=new String[50];
        int[] calories=new int[50];
    /**
     * Creates new form Food_Menu
     */
    public Food_Menu()
    {
        initComponents();
    }
    public Food_Menu(float consume) {
        initComponents();
        prev_day=0;
        //reg=regno;
        this.consume=consume;
        meal[0]= (1/2) * this.consume;//breakfast
        meal[1]= (1/3)* this.consume;//lunch
        meal[2]=(1/6) * this.consume;//dinner
    }
        
    public void  main_display()
    {
        try{  
                int[] no_items=new int[15];
                Class.forName("com.mysql.jdbc.Driver");  
                Connection con=DriverManager.getConnection(  
                "jdbc:mysql://localhost:3306/sonoo","root","password");
                java.sql.Statement stmt=con.createStatement();
                Calendar calendar= Calendar.getInstance();
                curr_day=calendar.get(Calendar.DAY_OF_WEEK);
                String days;
                switch(curr_day)
                {
                    case 1: days = "Monday";
                    break;
                    case 2 : days="Tuesday";
                    break;
                    case 3: days = "Wednesday";
                    break;
                    case 4: days = "Thursday";
                    break;
                    case 5: days = "Friday";
                    break;
                    case 6: days = "Saturday";
                    break;
                    case 7: days = "Sunday";
                    break;
                    default : days="";
                }
                ResultSet rs = stmt.executeQuery("select * from menu where day='" + days + "'");
                //ResultSet cs = stmt.executeQuery("select * from calories where day = "+curr_day);
                //retrieve(rs,cs);
                for(int i=2;i<=16;i++)
                {
                    items[i]= rs.getString(i);
                    ResultSet cs= stmt.executeQuery("select * from calories where food = '" + items[i]+"'");
                    calories[i] = cs.getInt("calo");
                }
                
                calculation(no_items);
                jLabel1.setText(items[0]);
                jLabel2.setText(items[1]);
                jLabel3.setText(items[2]);  
                jLabel4.setText(items[3]);
                jLabel5.setText(items[4]);
                jLabel6.setText(String.valueOf(calories[0]));
                jLabel7.setText(String.valueOf(calories[1]));
                jLabel8.setText(String.valueOf(calories[2]));
                jLabel9.setText(String.valueOf(calories[3]));
                jLabel10.setText(String.valueOf(calories[4]));
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
    }

    
    public void calculation(int no_items[])
    {
        int k=0;
        for(int i=0;i<3;i++)// signifies meal
        {
            k= 5 * i;
            int[] counter={0,0,0,0,0};
            int count=0;
            while(meal[i]>0)
            {
                if(calories[k]<meal[i])
                {   
                    meal[i] -= calories[k];
                    no_items[k]++;
                }
                else
                {   
                    counter[k-(i*5)]=1;
                    for(int l=0;l<5;l++)
                    {
                        if(counter[l]==1)
                            count++;
                           
                    }
                    if(count==5)
                        break;
                }
                k = (k+1) % (5 * (i+1));

            }
        
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        jLabel3.setText("jLabel3");

        jLabel4.setText("jLabel4");

        jLabel5.setText("jLabel5");

        jLabel6.setText("jLabel6");

        jLabel7.setText("jLabel7");

        jLabel8.setText("jLabel8");

        jLabel9.setText("jLabel9");

        jLabel10.setText("jLabel10");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(26, 26, 26)
                            .addComponent(jLabel6)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel10)))
                .addGap(119, 181, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel8))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel9))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel10))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) 
    {        
        //function();
            
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Food_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Food_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Food_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Food_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Food_Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
