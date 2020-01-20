package GUI;

import SystemClassAndMain.VehicleSys;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import javax.swing.ImageIcon;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.DefaultComboBoxModel;
import VehicleHasA.*;
import VehicleInheritance.*;
import java.util.Random;

public class ConfigureFrame extends javax.swing.JFrame {

    private static Set<String> treeList = new TreeSet<>();

    private static String name;
    private static String phone;
    private static String type;
    private static String brand;
    private static String model;
    private static double basePrice;

     public static void setVehicleInfo(String name, String surname, String phone, String type, String brand, String model, Double basePrice){
         ConfigureFrame.name = name + " " + surname;
         ConfigureFrame.phone = phone;
         ConfigureFrame.type = type;
         ConfigureFrame.brand = brand;
         ConfigureFrame.model = model;
         ConfigureFrame.basePrice = basePrice;
    }
    
    public ConfigureFrame(VehicleFrame vmf) {
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        initComponents();
        setSize(1050,680);
        setLocationRelativeTo(null);
       
       ImageIcon cVector = new ImageIcon("images/typeVectors/" + type + ".png");
       vehicleTypeLogo.setIcon(cVector);
       ImageIcon vLogo = new ImageIcon("images/brandLogos/" + brand + ".png");
       vehicleLogo.setIcon(vLogo);
       vModelField.setText(model);
       vBasePriceField.setText(String.format("%,.0f", basePrice) + "$");
       custNameField.setText(name);
       custPhoneField.setText(phone);
       msgLabel1.setText("");   msgLabel2.setText(""); msgLabel3.setText("");
       
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
        Date today = new Date();  
        dateField.setText(formatter.format(today) +"");
        packPriceField.setText("0$");

        if(type.equals("Car")){
             packBox1.setModel(getPack());  packBox2.setModel(getPack());  packBox3.setModel(getPack());  packBox4.setModel(getPack());  packBox5.setModel(getPack());
        }
        else{
          packBox1.setEnabled(false); packBox2.setEnabled(false); packBox3.setEnabled(false); packBox4.setEnabled(false); packBox5.setEnabled(false);
          packPriceField.setVisible(false); extraTxt.setVisible(false);
        }
    
        adjustMidPanel();

    }
    
    private void adjustMidPanel(){
          DefaultComboBoxModel<String> ComboModel1 = new DefaultComboBoxModel<>();
          DefaultComboBoxModel<String> ComboModel2 = new DefaultComboBoxModel<>();
        
        if(type.equals("Car")){
            feature1.setText("Driving Mode");
            ComboModel1.addElement("Comfort"); ComboModel1.addElement("Sport"); ComboModel1.addElement("Eco");
                    comboBox1.setModel(ComboModel1);
            
            feature2.setText("Fuel Type");
            ComboModel2.addElement("Diesel"); ComboModel2.addElement("Gasoline"); ComboModel2.addElement("Electric");
                    comboBox2.setModel(ComboModel2);
      
            feature3.setText("Number of Seats");
            feature4.setText("Sunroof");
            feature5.setText("Spoiler");
        }
        else if(type.equals("Truck")){
            feature1.setText("Trailer");
            ComboModel1.addElement("None"); ComboModel1.addElement("Tank Trailer"); ComboModel1.addElement("Pole Trailer"); 
            ComboModel1.addElement("Tilt Trailer");
                    comboBox1.setModel(ComboModel1);
                    
            feature2.setText("Cabin Type");
            ComboModel2.addElement("Day Cab"); ComboModel2.addElement("Crew Cab"); ComboModel2.addElement("Extended Cab");
                    comboBox2.setModel(ComboModel2);
                    
            feature3.setText("Payload Capacity(ton)");
            feature4.setText("Cabin Bed");
            feature5.setVisible(false); checkBox2.setVisible(false);
        }
        else if(type.equals("Bus")){
            feature1.setText("Number of Floors");
            ComboModel1.addElement("1"); ComboModel1.addElement("2"); ComboModel1.addElement("3");
                    comboBox1.setModel(ComboModel1);
                    
            feature2.setText("Trunk Volume(m^3)");
            ComboModel2.addElement("5"); ComboModel2.addElement("7"); ComboModel2.addElement("9");ComboModel2.addElement("11"); 
            ComboModel2.addElement("15"); ComboModel2.addElement("17");
                    comboBox2.setModel(ComboModel2);
                    
            feature3.setText("Number of Seats");
            feature4.setText("Stretched");
            feature5.setVisible(false); checkBox2.setVisible(false);
        }
    }
    
    private void clear(){
        vIdfield.setText("");
        warrantyCBox.setSelected(false);
        colorBox.setSelectedIndex(0);
        engineTypeBox.setSelectedIndex(0); engineHP.setText(""); engineCap.setText(""); engineTorq.setText("");
        wheelTypeBox.setSelectedIndex(0); wheelInch.setText("");
        gearBox.setSelectedIndex(0);
        comboBox1.setSelectedIndex(0); comboBox2.setSelectedIndex(0);
        textField1.setText("");
        checkBox1.setSelected(false); checkBox2.setSelected(false);
        msgLabel1.setText("");   msgLabel2.setText("");  msgLabel3.setText("");
        packPriceField.setText("0$");
        
         if(type.equals("Car")){
             packBox1.setSelectedIndex(0);  packBox2.setSelectedIndex(0); packBox3.setSelectedIndex(0);  packBox4.setSelectedIndex(0);  packBox5.setSelectedIndex(0);
         }
         
    }
 
      private boolean validation(){

        boolean status = true;
        
        msgLabel1.setText(""); msgLabel2.setText("");  msgLabel3.setText("");  packPriceField.setText("0$");
  
     if(!(engineHP.getText().equals("   ") || engineCap.getText().equals(" . ") || engineTorq.getText().equals("   ") || wheelInch.getText().equals("  ") || textField1.getText().equals("")))
        {
          if(Integer.parseInt(engineHP.getText()) >= Integer.parseInt(engineTorq.getText())){
               msgLabel1.setText("Torque should be greater than Horse Power");  status = false;
          }
           
        if(type.equals("Car")){
     
          try{
            int num = Integer.parseInt(textField1.getText());
            if(Integer.parseInt(textField1.getText()) > 7 || Integer.parseInt(textField1.getText()) < 2){
              msgLabel1.setText("Number of Seats should be [2-7]");  status = false;
            }
           }
          catch(NumberFormatException ex){
            msgLabel1.setText("Enter a Number for # of Seat field");  status = false;
           }
           
          if(Integer.parseInt(engineHP.getText()) > 600|| Integer.parseInt(engineHP.getText()) < 100  ){
            msgLabel1.setText("Horse Power should be between [100-600]"); status = false; }
          else if(Double.parseDouble(engineCap.getText()) > 6.0 || Double.parseDouble(engineCap.getText()) < 1.0  ){ 
            msgLabel1.setText("Capacity should be between [1.0-6.0]"); status = false; }
          else if(Integer.parseInt(engineTorq.getText()) > 700|| Integer.parseInt(engineTorq.getText()) < 150  ){
            msgLabel1.setText("Torque should be between [150-700]"); status = false; }
          else if(Integer.parseInt(wheelInch.getText()) > 21 || Integer.parseInt(wheelInch.getText()) < 14 ){
            msgLabel1.setText("Wheel Inch should be between [14-21]"); status = false; }

        }/////////////////////////////////////////////////////////////////////////////////////////////////////////////
        else if(type.equals("Truck")){
            
          try{
            int num = Integer.parseInt(textField1.getText());
            if(Integer.parseInt(textField1.getText()) > 70 || Integer.parseInt(textField1.getText()) < 10){
              msgLabel1.setText("Payload Capacity should be [10-70] ton");  status = false;
            }
           }
          catch(NumberFormatException ex){
            msgLabel1.setText("Enter a Number for Payload Capacity");  status = false;
          }
            
         if(Integer.parseInt(engineHP.getText()) > 900|| Integer.parseInt(engineHP.getText()) < 250  ){
            msgLabel1.setText("Horse Power should be between [250-900]"); status = false; }
         else if(Double.parseDouble(engineCap.getText()) > 8.5 || Double.parseDouble(engineCap.getText()) < 3.0 ){
            msgLabel1.setText("Capacity should be between [3.0-8.5]"); status = false; }
         else if(Integer.parseInt(engineTorq.getText()) > 999 || Integer.parseInt(engineTorq.getText()) < 300  ){
            msgLabel1.setText("Torque should be between [300-999]"); status = false; }
         else if(Integer.parseInt(wheelInch.getText()) > 30 || Integer.parseInt(wheelInch.getText()) < 22 ){
            msgLabel1.setText("Wheel Inch should be between [22-30]"); status = false; }
           
        }/////////////////////////////////////////////////////////////////////////////////////////////////////////////
        else if(type.equals("Bus")){
            
          try{
            int num = Integer.parseInt(textField1.getText());
            if(Integer.parseInt(textField1.getText()) > 180 || Integer.parseInt(textField1.getText()) < 25){
              msgLabel1.setText("Number of Seats should be [25-180]");  status = false;
            }
           }
          catch(NumberFormatException ex){
            msgLabel1.setText("Enter a Number for # of Seat field");  status = false;
           }
            
           if(Integer.parseInt(engineHP.getText()) > 800|| Integer.parseInt(engineHP.getText()) < 200  ){
            msgLabel1.setText("Horse Power should be between [200-800]"); status = false; }
           else if(Double.parseDouble(engineCap.getText()) > 7.5 || Double.parseDouble(engineCap.getText()) < 2.5  ){
            msgLabel1.setText("Capacity should be between [2.5-7.5]"); status = false; }
           else if(Integer.parseInt(engineTorq.getText()) > 900|| Integer.parseInt(engineTorq.getText()) < 250  ){
            msgLabel1.setText("Torque should be between [250-900]"); status = false;  }
           else if(Integer.parseInt(wheelInch.getText()) > 27 || Integer.parseInt(wheelInch.getText()) < 22 ){
            msgLabel1.setText("Wheel Inch should be between [22-27]"); status = false; }
           
        }

  }  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        if(type.equals("Car")){
            
            if(packBox1.getSelectedIndex() > 0){
              if( packBox1.getSelectedIndex() == packBox2.getSelectedIndex() || packBox1.getSelectedIndex()== packBox3.getSelectedIndex() || packBox1.getSelectedIndex()== packBox4.getSelectedIndex() || packBox1.getSelectedIndex()== packBox5.getSelectedIndex()){
                msgLabel3.setText("Select different package");  status = false;  msgLabel2.setText("");
              }
            }
           if(packBox2.getSelectedIndex() > 0){
              if(packBox2.getSelectedIndex() == packBox3.getSelectedIndex() || packBox2.getSelectedIndex()== packBox4.getSelectedIndex() || packBox2.getSelectedIndex()== packBox5.getSelectedIndex()){
                msgLabel3.setText("Select different package"); status = false;  msgLabel2.setText("");
              }
           }
           if(packBox3.getSelectedIndex() > 0){
               if(packBox3.getSelectedIndex() == packBox4.getSelectedIndex() || packBox3.getSelectedIndex()== packBox5.getSelectedIndex()){
                msgLabel3.setText("Select different package"); status = false;
               msgLabel1.setText("");  msgLabel2.setText("");
               }
           }
           if(packBox4.getSelectedIndex() > 0){
               if(packBox4.getSelectedIndex() == packBox5.getSelectedIndex()){
                msgLabel3.setText("Select different package"); status = false;  msgLabel2.setText("");
               }
            }
        }///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        try{
            int id = Integer.parseInt(vIdfield.getText());
            if(Integer.parseInt(vIdfield.getText()) > 999 || Integer.parseInt(vIdfield.getText()) < 1){
              msgLabel1.setText("Enter an ID between [1-999]");  status = false;
            }
            if(VehicleSys.checkVehicleID(Integer.parseInt(vIdfield.getText()))){
           msgLabel1.setText("The ID is already exists!"); status=false;
            }
        }
        catch(NumberFormatException ex){
            msgLabel1.setText("Enter an valid ID");  status = false;
        }///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        if((engineHP.getText().equals("   ") || engineCap.getText().equals(" . ") || engineTorq.getText().equals("   ") || wheelInch.getText().equals("  ") || textField1.getText().equals(""))){
             msgLabel1.setText("Fill out all fields"); status = false;
        }
        
        return status;
    }
    
    public static void readCarPackagesFile(){
        
        Set<CarPackages> pacSet = new LinkedHashSet<>();
        File vehicleTxt = new File("data/CarPackages.txt");
        Scanner sc=null;
        try{
            
            sc = new Scanner(vehicleTxt);
            
            while(sc.hasNextLine()){
              String [] temp= sc.nextLine().split("\\*"); // packageName * manufacturer * price
              CarPackages cp = new CarPackages(temp[0], temp[1], Double.parseDouble(temp[2]));
              pacSet.add(cp);
            }
 
        }
        catch(FileNotFoundException ex){
           ex.printStackTrace();
        }
        sc.close();

            for(CarPackages v: pacSet) 
                   treeList.add(v.getName() + " | " + v.getManufacturer() + " | " + (v.getPrice()));

    }
    
    private DefaultComboBoxModel<String> getPack(){
        
            DefaultComboBoxModel<String> ComboModel = new DefaultComboBoxModel<>();
        
             ComboModel.addElement("-Select a package-");
              Iterator<String> it = treeList.iterator();
                while(it.hasNext())
                    ComboModel.addElement(it.next() + "$");
          
        return ComboModel;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        vehicleTypeLogo = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        vehicleLogo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        vIdfield = new javax.swing.JTextField();
        warrantyCBox = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        vModelField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        vBasePriceField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        colorBox = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        engineTypeBox = new javax.swing.JComboBox<>();
        wheelTypeBox = new javax.swing.JComboBox<>();
        gearBox = new javax.swing.JComboBox<>();
        jSeparator3 = new javax.swing.JSeparator();
        feature1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        packBox1 = new javax.swing.JComboBox<>();
        packBox2 = new javax.swing.JComboBox<>();
        packBox3 = new javax.swing.JComboBox<>();
        packBox5 = new javax.swing.JComboBox<>();
        feature2 = new javax.swing.JLabel();
        feature3 = new javax.swing.JLabel();
        feature4 = new javax.swing.JLabel();
        feature5 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        comboBox1 = new javax.swing.JComboBox<>();
        checkBox1 = new javax.swing.JCheckBox();
        checkBox2 = new javax.swing.JCheckBox();
        textField1 = new javax.swing.JTextField();
        comboBox2 = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        custNameField = new javax.swing.JTextField();
        custPhoneField = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        dateField = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        extraTxt = new javax.swing.JLabel();
        packPriceField = new javax.swing.JTextField();
        menuButton = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JSeparator();
        genRandButton = new javax.swing.JButton();
        packBox4 = new javax.swing.JComboBox<>();
        engineHP = new javax.swing.JFormattedTextField();
        engineCap = new javax.swing.JFormattedTextField();
        engineTorq = new javax.swing.JFormattedTextField();
        wheelInch = new javax.swing.JFormattedTextField();
        msgLabel2 = new javax.swing.JLabel();
        msgLabel3 = new javax.swing.JLabel();
        msgLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Configure Vehicle");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("CONFIGURE VEHICLE");

        jScrollPane1.setViewportView(vehicleTypeLogo);

        jScrollPane2.setViewportView(vehicleLogo);

        jLabel2.setText("Warranty");

        vIdfield.setBackground(new java.awt.Color(51, 153, 255));
        vIdfield.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N

        jLabel4.setText(" Vehicle Model:");

        vModelField.setEditable(false);
        vModelField.setBackground(new java.awt.Color(51, 153, 255));
        vModelField.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N

        jLabel5.setText("Base Price:");

        vBasePriceField.setEditable(false);
        vBasePriceField.setBackground(new java.awt.Color(51, 153, 255));
        vBasePriceField.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N

        jLabel6.setText("Body Color");

        colorBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "White ", "Black", "Blue", "Yellow", "Red", "Silver", "Gray", "Brown ", "Gold", "Orange", "Green", "Purple", "Pink" }));

        jLabel7.setText("Engine Type");

        jLabel8.setText("Engine Horse Power");

        jLabel9.setText("Engine Torque");

        jLabel10.setText("Wheel Inch");

        jLabel11.setText("Wheel Type");

        jLabel12.setText("Gear");

        jLabel13.setText("Engine Capacity");

        engineTypeBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Class A", "Class B", "Class C", "Class D", "Class E" }));

        wheelTypeBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Classic", "Sports", "Nostalgic" }));

        gearBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Manuel", "Semi-Automatic", "Automatic" }));

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        feature1.setText("Feature1");

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel15.setText("Package-1");

        jLabel16.setText("Package-2");

        jLabel17.setText("Package-3");

        jLabel18.setText("Package-4");

        jLabel19.setText("Package-5");

        packBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                packBox1ActionPerformed(evt);
            }
        });

        packBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                packBox2ActionPerformed(evt);
            }
        });

        packBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                packBox3ActionPerformed(evt);
            }
        });

        packBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                packBox5ActionPerformed(evt);
            }
        });

        feature2.setText("Feature2");

        feature3.setText("Feature3");

        feature4.setText("Feature4");

        feature5.setText("Feature5");

        jLabel14.setText("Customer Name:");

        jLabel23.setText("Customer Phone:");

        custNameField.setEditable(false);
        custNameField.setBackground(new java.awt.Color(255, 255, 0));
        custNameField.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N

        custPhoneField.setEditable(false);
        custPhoneField.setBackground(new java.awt.Color(255, 255, 0));

        jLabel24.setText("Date:");

        dateField.setEditable(false);
        dateField.setBackground(new java.awt.Color(255, 255, 0));

        addButton.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        addButton.setText("CONFIGURE");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        clearButton.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        clearButton.setText("CLEAR");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        extraTxt.setText("Package Price :");

        packPriceField.setEditable(false);
        packPriceField.setBackground(new java.awt.Color(0, 51, 255));
        packPriceField.setForeground(new java.awt.Color(255, 255, 255));

        menuButton.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        menuButton.setText("MENU");
        menuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuButtonActionPerformed(evt);
            }
        });

        genRandButton.setText("Vehicle ID");
        genRandButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genRandButtonActionPerformed(evt);
            }
        });

        packBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                packBox4ActionPerformed(evt);
            }
        });

        try {
            engineHP.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            engineCap.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#.#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            engineTorq.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            wheelInch.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        msgLabel2.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        msgLabel2.setForeground(new java.awt.Color(0, 102, 204));
        msgLabel2.setText("MESSAGE");

        msgLabel3.setForeground(new java.awt.Color(204, 0, 0));
        msgLabel3.setText("MESSAGE");

        msgLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        msgLabel1.setForeground(new java.awt.Color(255, 0, 0));
        msgLabel1.setText("MESSAGE");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel23)
                            .addComponent(jLabel24))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(custNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(custPhoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dateField, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel12))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(warrantyCBox)
                                    .addComponent(colorBox, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(gearBox, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(engineTorq, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(engineCap, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(engineHP, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(engineTypeBox, javax.swing.GroupLayout.Alignment.LEADING, 0, 96, Short.MAX_VALUE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(wheelInch, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(wheelTypeBox, javax.swing.GroupLayout.Alignment.LEADING, 0, 97, Short.MAX_VALUE)))
                                .addGap(36, 36, 36)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(feature2)
                                                    .addComponent(feature1)
                                                    .addComponent(feature3)
                                                    .addComponent(feature4)
                                                    .addComponent(feature5))
                                                .addGap(31, 31, 31)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(checkBox1)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(comboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(comboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(textField1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(checkBox2)))
                                            .addComponent(msgLabel1)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(35, 35, 35)
                                        .addComponent(msgLabel2)))
                                .addGap(30, 30, 30)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel19)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel15)
                                                    .addComponent(jLabel16)
                                                    .addComponent(jLabel17)
                                                    .addComponent(jLabel18))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(packBox5, 0, 376, Short.MAX_VALUE)
                                            .addComponent(packBox4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(packBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(packBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(packBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(extraTxt)
                                        .addGap(18, 18, 18)
                                        .addComponent(packPriceField, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(82, 82, 82))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(136, 136, 136)
                                        .addComponent(msgLabel3)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(genRandButton))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(vIdfield, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(31, 31, 31)
                                        .addComponent(jLabel4)
                                        .addGap(4, 4, 4)
                                        .addComponent(vModelField, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel5)
                                        .addGap(12, 12, 12)
                                        .addComponent(vBasePriceField, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(170, 170, 170)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(15, 15, 15)
                                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                        .addGap(40, 40, 40)))
                .addContainerGap())
            .addComponent(jSeparator8)
            .addComponent(jSeparator7)
            .addGroup(layout.createSequentialGroup()
                .addGap(317, 317, 317)
                .addComponent(addButton)
                .addGap(65, 65, 65)
                .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(menuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(custNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(custPhoneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(dateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel14)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel23))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addGap(6, 6, 6)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10)
                        .addComponent(jLabel24)))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(vIdfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(genRandButton, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(vModelField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vBasePriceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))))
                .addGap(14, 14, 14)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel2)
                                .addGap(25, 25, 25)
                                .addComponent(jLabel6)
                                .addGap(25, 25, 25)
                                .addComponent(jLabel7)
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(engineHP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(engineCap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(engineTorq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23)
                                .addComponent(jLabel11)
                                .addGap(25, 25, 25)
                                .addComponent(jLabel10)
                                .addGap(25, 25, 25)
                                .addComponent(jLabel12))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(warrantyCBox)
                                .addGap(20, 20, 20)
                                .addComponent(colorBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(engineTypeBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(136, 136, 136)
                                .addComponent(wheelTypeBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(wheelInch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)
                                .addComponent(gearBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(comboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(feature1))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(comboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(feature2))
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(feature3)
                                    .addComponent(textField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(feature4)
                                    .addComponent(checkBox1))
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(feature5)
                                    .addComponent(checkBox2))
                                .addGap(18, 18, 18)
                                .addComponent(msgLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(msgLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15)
                                    .addComponent(packBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel16)
                                    .addComponent(packBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel17)
                                    .addComponent(packBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel18)
                                    .addComponent(packBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel19)
                                    .addComponent(packBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34)
                                .addComponent(msgLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(packPriceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(extraTxt))
                                .addGap(31, 31, 31))))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void packBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_packBox1ActionPerformed
    }//GEN-LAST:event_packBox1ActionPerformed
    private void packBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_packBox2ActionPerformed
    }//GEN-LAST:event_packBox2ActionPerformed
    private void packBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_packBox3ActionPerformed
    }//GEN-LAST:event_packBox3ActionPerformed
    private void packBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_packBox5ActionPerformed
    }//GEN-LAST:event_packBox5ActionPerformed
    private void menuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuButtonActionPerformed
        clear();
        VehicleFrame.controlFrame = false;
        dispose();
    }//GEN-LAST:event_menuButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        clear();
    }//GEN-LAST:event_clearButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed

       if(validation()){

         int vId = Integer.parseInt(vIdfield.getText());
         String vType = type;
         String vBrand = brand;
         String vModel = model;
         double vBasePrice = basePrice;

        /////////////////////////////////////////////////////////////////
         boolean warranty =warrantyCBox.isSelected();   
         String color = ((String)colorBox.getSelectedItem());
         String [] engine = new String[4];
            engine[0] = ((String) engineTypeBox.getSelectedItem());
            engine[1] = engineHP.getText(); engine[2] = engineCap.getText();  engine[3] = engineTorq.getText(); 
    
         String [] wheel  = new String[2];
            wheel[0] = ((String) wheelTypeBox.getSelectedItem());
            wheel[1] = wheelInch.getText();
         String gear = ((String) gearBox.getSelectedItem());
       
        if(type.equals("Car")){
            String drivingMode = ((String) comboBox1.getSelectedItem());
            String fuelType = ((String)comboBox2.getSelectedItem());
            int numOfSeats = Integer.parseInt(textField1.getText());
            boolean sunroof = checkBox1.isSelected();
            boolean spoiler = checkBox2.isSelected();
            double packPrice = 0.0;
            ArrayList<CarPackages> cpList = new ArrayList<>();
            
            if(packBox1.getSelectedIndex() > 0){
                  String [] pack1 = packBox1.getSelectedItem().toString().split("\\| ");
                  CarPackages cp1 = new CarPackages(pack1[0], pack1[1], Double.parseDouble(pack1[2].replace("$","")));
                  cpList.add(cp1);
            }
            if(packBox2.getSelectedIndex() > 0){
                  String [] pack2 = packBox2.getSelectedItem().toString().split("\\| ");
                  CarPackages cp2 = new CarPackages(pack2[0], pack2[1], Double.parseDouble(pack2[2].replace("$","")));
                  cpList.add(cp2);
            }
            if(packBox3.getSelectedIndex() > 0){
                  String [] pack3 = packBox3.getSelectedItem().toString().split("\\| ");
                  CarPackages cp3 = new CarPackages(pack3[0], pack3[1], Double.parseDouble(pack3[2].replace("$","")));
                  cpList.add(cp3);
            }
            if(packBox4.getSelectedIndex() > 0){
                  String [] pack4 = packBox4.getSelectedItem().toString().split("\\| ");
                  CarPackages cp4 = new CarPackages(pack4[0], pack4[1], Double.parseDouble(pack4[2].replace("$","")));
                  cpList.add(cp4);
            }
            if(packBox5.getSelectedIndex() > 0){
                  String [] pack5 = packBox5.getSelectedItem().toString().split("\\| ");
                  CarPackages cp5 = new CarPackages(pack5[0], pack5[1], Double.parseDouble(pack5[2].replace("$","")));
                  cpList.add(cp5);
            }
      
            Car c = new Car(vId, vType, vBrand, vModel, vBasePrice, warranty, color, engine, wheel, gear,
                            drivingMode, fuelType, numOfSeats, sunroof, spoiler, cpList);
            
              if(VehicleSys.addVehicle(vId, c, null, null)){
                  msgLabel2.setText(type + "-" + brand + " " + model +  " is added");
                  
                  for(int i=0; i<cpList.size();i++)
                          packPrice += cpList.get(i).getPrice();
                  packPriceField.setText(String.format("%,.0f", packPrice) + "$");
              }
            
        }
        else if(type.equals("Truck")){
            String trailer = ((String) comboBox1.getSelectedItem());
            String cabType = ((String)comboBox2.getSelectedItem());
            int payloadCapacity  = Integer.parseInt(textField1.getText());
            boolean cabinBed = checkBox1.isSelected();

            Truck t = new Truck(vId, vType, vBrand, vModel, vBasePrice, warranty, color, engine, wheel, gear,
                            payloadCapacity, trailer, cabType, cabinBed);
            
            if(VehicleSys.addVehicle(vId, null, t, null)){
                msgLabel2.setText(type + "-" + brand + " " + model +  " is added");
            }
    
        }
        else if(type.equals("Bus")){
            int numOfFloors = Integer.parseInt(comboBox1.getSelectedItem().toString());
            double trunkVolume = Double.parseDouble((comboBox2.getSelectedItem().toString()));
            int numOfSeats = Integer.parseInt(textField1.getText());
            boolean stretched = checkBox1.isSelected();
            
            Bus b = new Bus(vId, vType, vBrand, vModel, vBasePrice, warranty, color, engine, wheel, gear,
                            numOfFloors, stretched, trunkVolume, numOfSeats);
            
            if(VehicleSys.addVehicle(vId, null, null, b)){
                 msgLabel2.setText(type + "-" + brand + " " + model +  " is added");
            }
           
        }
            
      }
       
    }//GEN-LAST:event_addButtonActionPerformed

    private void genRandButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genRandButtonActionPerformed
        Random rand = new Random();
        int randomNum = rand.nextInt((999) + 1) + 1; //ID Generator
        vIdfield.setText(randomNum + "");
    }//GEN-LAST:event_genRandButtonActionPerformed

    private void packBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_packBox4ActionPerformed
         
    }//GEN-LAST:event_packBox4ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JCheckBox checkBox1;
    private javax.swing.JCheckBox checkBox2;
    private javax.swing.JButton clearButton;
    private javax.swing.JComboBox<String> colorBox;
    private javax.swing.JComboBox<String> comboBox1;
    private javax.swing.JComboBox<String> comboBox2;
    private javax.swing.JTextField custNameField;
    private javax.swing.JTextField custPhoneField;
    private javax.swing.JTextField dateField;
    private javax.swing.JFormattedTextField engineCap;
    private javax.swing.JFormattedTextField engineHP;
    private javax.swing.JFormattedTextField engineTorq;
    private javax.swing.JComboBox<String> engineTypeBox;
    private javax.swing.JLabel extraTxt;
    private javax.swing.JLabel feature1;
    private javax.swing.JLabel feature2;
    private javax.swing.JLabel feature3;
    private javax.swing.JLabel feature4;
    private javax.swing.JLabel feature5;
    private javax.swing.JComboBox<String> gearBox;
    private javax.swing.JButton genRandButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JButton menuButton;
    private javax.swing.JLabel msgLabel1;
    private javax.swing.JLabel msgLabel2;
    private javax.swing.JLabel msgLabel3;
    private javax.swing.JComboBox<String> packBox1;
    private javax.swing.JComboBox<String> packBox2;
    private javax.swing.JComboBox<String> packBox3;
    private javax.swing.JComboBox<String> packBox4;
    private javax.swing.JComboBox<String> packBox5;
    private javax.swing.JTextField packPriceField;
    private javax.swing.JTextField textField1;
    private javax.swing.JTextField vBasePriceField;
    private javax.swing.JTextField vIdfield;
    private javax.swing.JTextField vModelField;
    private javax.swing.JLabel vehicleLogo;
    private javax.swing.JLabel vehicleTypeLogo;
    private javax.swing.JCheckBox warrantyCBox;
    private javax.swing.JFormattedTextField wheelInch;
    private javax.swing.JComboBox<String> wheelTypeBox;
    // End of variables declaration//GEN-END:variables
}
