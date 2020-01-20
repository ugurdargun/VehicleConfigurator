package GUI;

import SystemClassAndMain.VehicleSys;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DisplayFrame extends javax.swing.JFrame {

    private  static String name;
    private static String phone;
    
    public DisplayFrame(VehicleFrame vmf) {
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        initComponents();
        setSize(660, 600);
        setLocationRelativeTo(null);

        custNameField.setText(name);
        custPhoneField.setText(phone);
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
        Date today = new Date();  
        dateField.setText(formatter.format(today) +"");
        
        dispArea.setText(VehicleSys.displayAllVehicles());
        
       if(VehicleSys.getVehicleSet().isEmpty())
        dispArea.setText("\nThere is no Vehicle to be displayed!");
    }

     public static void setCustInfo (String name, String surname, String phone){
         DisplayFrame.name = name + " " + surname;
         DisplayFrame.phone = phone;
    }

     public void setDispArea(){
          
        if(dispType1.getSelectedIndex() == 0 && dispType2.getSelectedIndex() == 0){
             dispArea.setText(VehicleSys.displayAllVehicles());
             if(dispArea.getText().equals(""))
                    dispArea.setText("\nThere is no Vehicle in the order list!");
        }
        else if(dispType1.getSelectedIndex() == 1 && dispType2.getSelectedIndex() == 0){
            dispArea.setText(VehicleSys.displayAllVehiclesByPrice());
            if(dispArea.getText().equals(""))
                    dispArea.setText("\nThere is no Vehicle in the order list!");
        }
        else if(dispType1.getSelectedIndex() == 0 && dispType2.getSelectedIndex() > 0){
             String tmp = dispType2.getSelectedItem().toString();
             dispArea.setText(VehicleSys.displayTheVehicle(tmp));
             if(dispArea.getText().equals(""))
                    dispArea.setText("\nThere is no " +tmp+ " in the order list!");
        }
        else if(dispType1.getSelectedIndex() == 1 && dispType2.getSelectedIndex() > 0){
             String tmp = dispType2.getSelectedItem().toString();
             dispArea.setText(VehicleSys.displayTheVehicleByPrice(tmp));
                if(dispArea.getText().equals(""))
                    dispArea.setText("\nThere is no " +tmp+ " in the order list!");
        }
         
     }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        dispArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        custNameField = new javax.swing.JTextField();
        custPhoneField = new javax.swing.JTextField();
        menuButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        dispType1 = new javax.swing.JComboBox<>();
        dateField = new javax.swing.JTextField();
        dispType2 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("All Orders");

        dispArea.setEditable(false);
        dispArea.setColumns(20);
        dispArea.setRows(5);
        dispArea.setMargin(new java.awt.Insets(0, 225, 0, 0));
        jScrollPane1.setViewportView(dispArea);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("ALL ORDERS");

        jLabel2.setText("Customer Name:");

        jLabel3.setText("Telephone:");

        custNameField.setEditable(false);
        custNameField.setBackground(new java.awt.Color(255, 255, 0));
        custNameField.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        custNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custNameFieldActionPerformed(evt);
            }
        });

        custPhoneField.setEditable(false);
        custPhoneField.setBackground(new java.awt.Color(255, 255, 0));

        menuButton.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        menuButton.setText("MENU");
        menuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuButtonActionPerformed(evt);
            }
        });

        dispType1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Display by Insertion Order", "Display by Total Price" }));
        dispType1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dispType1ActionPerformed(evt);
            }
        });

        dateField.setEditable(false);
        dateField.setBackground(new java.awt.Color(255, 255, 0));

        dispType2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All Types", "Car", "Truck", "Bus" }));
        dispType2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dispType2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(dispType2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(dateField, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(dispType1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel2)
                                .addGap(4, 4, 4)
                                .addComponent(custNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(custPhoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addComponent(jLabel1))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(265, 265, 265)
                        .addComponent(menuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(custNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(custPhoneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(dateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dispType1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dispType2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(menuButton, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void custNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_custNameFieldActionPerformed
        
    }//GEN-LAST:event_custNameFieldActionPerformed

    private void dispType1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dispType1ActionPerformed

                setDispArea();
                               
    }//GEN-LAST:event_dispType1ActionPerformed

    private void menuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuButtonActionPerformed
        VehicleFrame.controlFrame = false;
        dispose();
    }//GEN-LAST:event_menuButtonActionPerformed

    private void dispType2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dispType2ActionPerformed
        
                setDispArea();
            
    }//GEN-LAST:event_dispType2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField custNameField;
    private javax.swing.JTextField custPhoneField;
    private javax.swing.JTextField dateField;
    private javax.swing.JTextArea dispArea;
    private javax.swing.JComboBox<String> dispType1;
    private javax.swing.JComboBox<String> dispType2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton menuButton;
    // End of variables declaration//GEN-END:variables
}
