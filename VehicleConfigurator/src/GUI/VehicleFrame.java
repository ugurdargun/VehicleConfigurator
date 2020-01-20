package GUI;

import SystemClassAndMain.VehicleSys;
import VehicleInheritance.Vehicle;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class VehicleFrame extends javax.swing.JFrame {

    private ArrayList<Vehicle> vList= new ArrayList<Vehicle>();
    private static boolean filled = false;
    private static double basePrice;
    public static boolean controlFrame=false;
    
    ConfigureFrame vconF;
    SearchFrame vsearF;
    DisplayFrame vdispF;

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VehicleFrame().setVisible(true);
                VehicleSys.readFromFile();
            }
        });
    }
    
    public VehicleFrame() {
      this.getContentPane().setBackground(Color.gray);
        initComponents();
        setSize(640,540);
        setLocationRelativeTo(null);
        
       ImageIcon mLogo = new ImageIcon("images/mainLogo.png");
       logoArea.setIcon(mLogo);

        vList = VehicleSys.getVehicleList();
        msgLabel.setText("");
        vBasePrice.setText("0$");
        vBrandBox.setEnabled(false);   vModelBox.setEnabled(false);
        
    }

    private boolean validation(){

        boolean status = true;
 
        if(custName.getText().isEmpty() || custSurname.getText().isEmpty() || custPhone.getText().isEmpty() || !VehicleFrame.filled) {
             msgLabel.setText("Fill out all fields");        status = false;
        }
        else if(!custName.getText().matches("^[a-zA-Z]+$")|| custName.getText().length() > 15 || custName.getText().length() < 3){
           msgLabel.setText("Enter a valid Name");           status = false;
        }
        else if(!custSurname.getText().matches("^[a-zA-Z]+$") || custSurname.getText().length() > 15 || custSurname.getText().length() < 3){
           msgLabel.setText("Enter a valid Surname ");       status = false;
        }
        else if(custPhone.getText().equals("   -   -    ")){
           msgLabel.setText("Enter a valid Phone Number");   status = false;
        }
      
        return status;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        confButton = new javax.swing.JButton();
        ordersButton = new javax.swing.JButton();
        searchButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        vTypeBox = new javax.swing.JComboBox<>();
        vBrandBox = new javax.swing.JComboBox<>();
        vModelBox = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        vBasePriceTxt = new javax.swing.JLabel();
        vBasePrice = new javax.swing.JTextField();
        msgLabel = new javax.swing.JLabel();
        custPhone = new javax.swing.JFormattedTextField();
        custName = new javax.swing.JTextField();
        custSurname = new javax.swing.JTextField();
        closeButton = new javax.swing.JButton();
        logoArea = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Vehicle Configurator");
        setAutoRequestFocus(false);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Vehicle Configurator");
        jLabel1.setToolTipText("");

        confButton.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        confButton.setText("CONFIGURE");
        confButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confButtonActionPerformed(evt);
            }
        });

        ordersButton.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        ordersButton.setText("ORDERS");
        ordersButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordersButtonActionPerformed(evt);
            }
        });

        searchButton.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        searchButton.setText("SEARCH");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("Vehicle Type");

        jLabel5.setText("Vehicle Model");

        jLabel6.setText("Vehicle Brand");

        vTypeBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Select a type-", "Car", "Truck", "Bus" }));
        vTypeBox.setToolTipText("");
        vTypeBox.setName(""); // NOI18N
        vTypeBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vTypeBoxActionPerformed(evt);
            }
        });

        vBrandBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vBrandBoxActionPerformed(evt);
            }
        });

        vModelBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vModelBoxActionPerformed(evt);
            }
        });

        jLabel7.setText("Customer Name:");

        jLabel8.setText("Customer Surname:");

        jLabel9.setText("Customer Phone:");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        vBasePriceTxt.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        vBasePriceTxt.setForeground(new java.awt.Color(0, 102, 0));
        vBasePriceTxt.setText("Base Price");

        vBasePrice.setEditable(false);
        vBasePrice.setBackground(new java.awt.Color(51, 204, 0));
        vBasePrice.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N

        msgLabel.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        msgLabel.setForeground(new java.awt.Color(255, 0, 0));
        msgLabel.setText("message");

        try {
            custPhone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-###-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        closeButton.setBackground(new java.awt.Color(0, 0, 0));
        closeButton.setForeground(new java.awt.Color(255, 255, 255));
        closeButton.setText("Close");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(custPhone, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                    .addComponent(custName)
                    .addComponent(custSurname))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(vBasePriceTxt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(vBasePrice)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(vTypeBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(vBrandBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(vModelBox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(73, 73, 73))
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator3)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(logoArea)
                        .addGap(73, 73, 73)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(279, 279, 279)
                        .addComponent(msgLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(confButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ordersButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(closeButton)
                                .addGap(153, 153, 153)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logoArea))
                .addGap(21, 21, 21)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(custName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(custSurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(custPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(vTypeBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(vBrandBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(vModelBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(vBasePriceTxt)
                            .addComponent(vBasePrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(15, 15, 15)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(msgLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ordersButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(closeButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ordersButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordersButtonActionPerformed
   
          if(validation()){
            DisplayFrame.setCustInfo(custName.getText(), custSurname.getText(), custPhone.getText());
       
              if(!(VehicleFrame.controlFrame)){
                vdispF = new DisplayFrame(this);
                vdispF .setVisible(true);
                msgLabel.setText("");
               
               VehicleFrame.controlFrame = true;
           }
           else
              msgLabel.setText("Please, close the page you opened");
        }
        
    }//GEN-LAST:event_ordersButtonActionPerformed

    private void confButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confButtonActionPerformed
         
     if(validation()){
          ConfigureFrame.setVehicleInfo(custName.getText(), custSurname.getText(), custPhone.getText(), 
            vTypeBox.getSelectedItem().toString(), vBrandBox.getSelectedItem().toString(),  vModelBox.getSelectedItem().toString(), VehicleFrame.basePrice);
            
            ConfigureFrame.readCarPackagesFile();
            
           if(!(VehicleFrame.controlFrame)){ // prevent creating multiple frames
               vconF = new ConfigureFrame(this);
               vconF.setVisible(true);
               msgLabel.setText("");
               
               VehicleFrame.controlFrame = true;
           }
           else
               msgLabel.setText("Please, close the page you opened");

     }
        
    }//GEN-LAST:event_confButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        
        if(validation()){
           SearchFrame.setCustInfo(custName.getText(), custSurname.getText(), custPhone.getText());
           
            if(!(VehicleFrame.controlFrame)){
                vsearF = new SearchFrame(this);
                vsearF.setVisible(true);
                msgLabel.setText("");
               
               VehicleFrame.controlFrame = true;
           }
           else
               msgLabel.setText("Please, close the page you opened");
           
        }
       
    }//GEN-LAST:event_searchButtonActionPerformed

    private void vTypeBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vTypeBoxActionPerformed

      vModelBox.removeAllItems();  vModelBox.setEnabled(false);
      vBrandBox.removeAllItems();  vBrandBox.setEnabled(false);
      vBasePrice.setText("0$");

      String selectedType = vTypeBox.getSelectedItem().toString();

       if(vTypeBox.getSelectedIndex() > 0 ) {

        DefaultComboBoxModel<String> ComboBrand = new DefaultComboBoxModel<>();
           Set<String> linkedBrand = new LinkedHashSet<>();

                for(Vehicle v: vList){
                    if(v.getType().equals(selectedType))
                    linkedBrand.add(v.getBrand());
                }

       ComboBrand.addElement("-Select a brand-");
           Iterator<String> itBrand = linkedBrand.iterator();
             while(itBrand.hasNext())
                ComboBrand.addElement(itBrand.next());
             
             vBrandBox.setEnabled(true);
             vBrandBox.setModel(ComboBrand);
      }
     
    }//GEN-LAST:event_vTypeBoxActionPerformed

    private void vModelBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vModelBoxActionPerformed
        
        vBasePrice.setText("0$");
        double price =0.0;
      
            if(vModelBox.getSelectedIndex() != -1 && vModelBox.getSelectedIndex() != 0){
                VehicleFrame.filled = true;
                
                 String selectedType = vTypeBox.getSelectedItem().toString();
                 String selectedBrand = vBrandBox.getSelectedItem().toString();
                 String selectedModel = vModelBox.getSelectedItem().toString();
                 
                    for(Vehicle v: vList)
                      if(v.getType().equals(selectedType) && v.getBrand().equals(selectedBrand) && v.getModel().equals(selectedModel))
                         VehicleFrame.basePrice = v.getBasePrice();
                    price = VehicleFrame.basePrice;
             vBasePrice.setText(String.format("%,.0f", price) + "$");
            }
            else 
                VehicleFrame.filled = false;
    }//GEN-LAST:event_vModelBoxActionPerformed

    private void vBrandBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vBrandBoxActionPerformed
        vModelBox.removeAllItems();  vModelBox.setEnabled(false);
        
         String selectedType = vTypeBox.getSelectedItem().toString();
         vBasePrice.setText("0$");
     
        if(vBrandBox.getSelectedIndex() > 0) {
           DefaultComboBoxModel<String> ComboModel = new DefaultComboBoxModel<>();
           
           String selectedBrand=vBrandBox.getSelectedItem().toString();
           Set<String> linkedModel = new LinkedHashSet<>();

                for(Vehicle v: vList)
                    if(v.getType().equals(selectedType) && v.getBrand().equals(selectedBrand))
                        linkedModel.add(v.getModel());
                
       ComboModel.addElement("-Select a model-");
           Iterator<String> itModel = linkedModel.iterator();
             while(itModel.hasNext())
                ComboModel.addElement(itModel.next());
             
             vModelBox.setEnabled(true);
             vModelBox.setModel(ComboModel);
   
         }
    }//GEN-LAST:event_vBrandBoxActionPerformed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_closeButtonActionPerformed
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton;
    private javax.swing.JButton confButton;
    private javax.swing.JTextField custName;
    private javax.swing.JFormattedTextField custPhone;
    private javax.swing.JTextField custSurname;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel logoArea;
    private javax.swing.JLabel msgLabel;
    private javax.swing.JButton ordersButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField vBasePrice;
    private javax.swing.JLabel vBasePriceTxt;
    private javax.swing.JComboBox<String> vBrandBox;
    private javax.swing.JComboBox<String> vModelBox;
    private javax.swing.JComboBox<String> vTypeBox;
    // End of variables declaration//GEN-END:variables
}
