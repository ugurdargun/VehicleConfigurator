package GUI;

import SystemClassAndMain.VehicleSys;
import VehicleInheritance.Vehicle;
import java.awt.Color;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.DefaultComboBoxModel;

public class SearchFrame extends javax.swing.JFrame {

    private static String name;
    private static String phone;
   
    public SearchFrame(VehicleFrame vmf) {
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        initComponents();
        setSize(500, 470);
        setLocationRelativeTo(null);
     
       custNameField.setText(name);
       custPhoneField.setText(phone);
        if(VehicleSys.getVehicleSet().isEmpty())
            dispArea.setText("\nThere is no Vehicle to be searched!");
        
       setIDs();
    }
    public static void setCustInfo (String name, String surname, String phone){
         SearchFrame.name = name + " " + surname;
         SearchFrame.phone = phone;
         
    }
    
    public void setIDs(){
        DefaultComboBoxModel<String> ComboID = new DefaultComboBoxModel<>();
        Set<Vehicle> vehicleSet = new LinkedHashSet<Vehicle>();
       
        IdComboBox.removeAllItems();
       
        vehicleSet = VehicleSys.getVehicleSet();
        TreeSet<Vehicle> ts = new TreeSet<>();
        ts.addAll(vehicleSet);
        ComboID.addElement("-Select an ID-");
        for(Vehicle v: ts)
            ComboID.addElement(v.getId()+"");

        IdComboBox.setModel(ComboID);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        IdComboBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        dispArea = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        removeButton = new javax.swing.JButton();
        menuButton = new javax.swing.JButton();
        custNameField = new javax.swing.JTextField();
        custPhoneField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Search Vehicle");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("SEARCH VEHICLE");

        IdComboBox.setBackground(new java.awt.Color(0, 0, 0));
        IdComboBox.setForeground(new java.awt.Color(255, 255, 0));
        IdComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdComboBoxActionPerformed(evt);
            }
        });

        dispArea.setEditable(false);
        dispArea.setColumns(20);
        dispArea.setRows(5);
        dispArea.setMargin(new java.awt.Insets(0, 150, 0, 0));
        jScrollPane1.setViewportView(dispArea);

        jLabel2.setText("Vehicle ID:");

        removeButton.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        removeButton.setText("REMOVE");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        menuButton.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        menuButton.setText("MENU");
        menuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuButtonActionPerformed(evt);
            }
        });

        custNameField.setEditable(false);
        custNameField.setBackground(new java.awt.Color(255, 255, 0));
        custNameField.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N

        custPhoneField.setEditable(false);
        custPhoneField.setBackground(new java.awt.Color(255, 255, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(custNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(custPhoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(135, 135, 135)
                                .addComponent(removeButton)
                                .addGap(53, 53, 53)
                                .addComponent(menuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 144, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IdComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(custNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(custPhoneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IdComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(removeButton)
                    .addComponent(menuButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IdComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdComboBoxActionPerformed

        if(IdComboBox.getSelectedIndex() > 0){
            int id = Integer.parseInt(IdComboBox.getSelectedItem().toString());
            Vehicle temp = VehicleSys.searchVehicle(id);
            dispArea.setText(temp.toString());
        }
   
        if(VehicleSys.getVehicleSet().isEmpty()){
            dispArea.setText("\nThere is no Vehicle to be searched!");
        }
        else if(IdComboBox.getSelectedIndex() ==0)
            dispArea.setText("");
    }//GEN-LAST:event_IdComboBoxActionPerformed

    private void menuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuButtonActionPerformed
        VehicleFrame.controlFrame = false;
        dispose();
    }//GEN-LAST:event_menuButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        
        if(IdComboBox.getSelectedIndex() > 0){
            int id = Integer.parseInt(IdComboBox.getSelectedItem().toString());
            Vehicle temp = VehicleSys.removeVehicle(id);
            
            IdComboBox.removeItemAt(IdComboBox.getSelectedIndex());
            IdComboBox.setSelectedIndex(0);
            
            dispArea.setText("\n "+temp.getType() + "-" + temp.getBrand() + " " + temp.getModel() +" with ID " +temp.getId()+ " is removed!");
        }
        else
            dispArea.setText(" \nIt cannot be removed!");
    }//GEN-LAST:event_removeButtonActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> IdComboBox;
    private javax.swing.JTextField custNameField;
    private javax.swing.JTextField custPhoneField;
    private javax.swing.JTextArea dispArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton menuButton;
    private javax.swing.JButton removeButton;
    // End of variables declaration//GEN-END:variables
}
