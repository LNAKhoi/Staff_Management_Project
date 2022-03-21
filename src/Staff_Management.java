import com.mysql.cj.conf.IntegerProperty;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import java.sql.Date;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Jason Koi
 */
public class Staff_Management extends javax.swing.JFrame {

    /**
     * Creates new form Staff_Management
     */
    private HashMap<Integer,String> hashMap= new HashMap<Integer,String>();
    public Staff_Management() {
        initComponents();
        displayData();
        loadImage();
    }
    private void displayData(){
        List<Staff> staffList= null;
        DefaultTableModel tableModel=  (DefaultTableModel) jTable1.getModel();
        tableModel.setRowCount(0);
        try {
            staffList = dbHandler.getStaff();
            String strArr[];
            String temp;
            for (int i = 0; i < staffList.size(); i++) {
                int ID= staffList.get(i).getID();
                String Name= staffList.get(i).getStaffName();
                Date dob= staffList.get(i).getDateOfBirth();
                Float salary= staffList.get(i).getSalary();
                DecimalFormat df= new DecimalFormat("0.00000000000");
                df.format(salary);
                String gender= staffList.get(i).getGender();
                String address= staffList.get(i).getAddress();
                String position= staffList.get(i).getPosition();
                Date startDate= staffList.get(i).getStartDate();
                String imgPath= staffList.get(i).getImgPath();
                //"ID", "Name", "DOB", "Address","Gender", "Position", "Salary", "StartDate"
                Object[] data= {ID,Name,dob,address,gender,position,startDate,imgPath,salary};
                tableModel.addRow(data);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    private void loadImage(){
        staffImg.setIcon(new ImageIcon("C://Users//Jason Koi//Desktop//Self_Project//StaffManagement_Project//images//prf.png"));
        validate();
    }
    private void convertListToHashMap(){
        List<Staff> staffList= null;
        try {
            staffList = dbHandler.getStaff();
            for(int i=0;i<staffList.size();i++){
                String value=staffList.get(i).getStaffName()+","+staffList.get(i).getDateOfBirth()+","+staffList.get(i).getSalary()+","+staffList.get(i).getGender()
                        +","+staffList.get(i).getAddress()+","+staffList.get(i).getPosition()+","+staffList.get(i).getStartDate()+","+staffList.get(i).getImgPath();
                hashMap.put(staffList.get(i).getID(),value);
            }
        } catch(Exception e){
            e.printStackTrace();
        }

    }

    // formatting user input for date
    private String handleDate(String date){
        if(date.contains("/")){
            date= date.replace("/","-");
            return date;
        }
        return date;
    }
    // clear text field function
    private void clearField(){
        addressInput.setText("");
        dobInput.setText("");
        idInput.setText("");
        nameInput.setText("");
        pathInput.setText("");
        positionInput.setText("");
        startDateInput.setText("");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        uiPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        staffImg = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        idInput = new javax.swing.JTextField();
        nameInput = new javax.swing.JTextField();
        dobInput = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        addressInput = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        positionInput = new javax.swing.JTextField();
        startDateInput = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        delButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        printButton = new javax.swing.JButton();
        genderBox = new javax.swing.JComboBox<>();
        salaryManageButton = new javax.swing.JButton();
        uploadButton = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        pathInput = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        uiPanel.setBackground(new java.awt.Color(135, 206, 250));

        jPanel1.setBackground(new java.awt.Color(215, 221, 232));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 2));
        jPanel1.setToolTipText("");
        jPanel1.setName(""); // NOI18N

        staffImg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        staffImg.setText("IMG");
        staffImg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel2.setText("Name");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel4.setText("Date of birth:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel3.setText("ID:");

        idInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idInputActionPerformed(evt);
            }
        });

        nameInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameInputActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel8.setText("Gender:");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel5.setText("Address:");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel6.setText("Position:");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel7.setText("Start date:");

        startDateInput.setToolTipText("");

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        delButton.setText("Delete");
        delButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delButtonActionPerformed(evt);
            }
        });

        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        printButton.setText("Print");

        genderBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        genderBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genderBoxActionPerformed(evt);
            }
        });

        salaryManageButton.setText("Salary Management");

        uploadButton.setText("Upload");
        uploadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadButtonActionPerformed(evt);
            }
        });
        salaryManageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salaryManageButtonActionPerformed(evt);
            }
        });
        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel10.setText("Image path:");
        jLabel10.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(29, 29, 29)
                                                .addComponent(staffImg, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(52, 52, 52)
                                                .addComponent(uploadButton)))
                                .addGap(68, 68, 68)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel3)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addComponent(jLabel2))
                                                        .addComponent(jLabel8)
                                                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                        .addComponent(genderBox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(dobInput, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                                                                        .addComponent(nameInput, javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(idInput, javax.swing.GroupLayout.Alignment.LEADING))
                                                                .addGap(75, 75, 75)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(jLabel6)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(positionInput, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(jLabel5)
                                                                                .addGap(58, 58, 58)
                                                                                .addComponent(addressInput, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(jLabel7)
                                                                                        .addComponent(jLabel10))
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                        .addComponent(startDateInput, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                                                                                        .addComponent(pathInput)))))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(delButton)
                                                                .addGap(12, 12, 12)
                                                                .addComponent(updateButton)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(printButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addComponent(salaryManageButton))
                                .addContainerGap(65, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addComponent(staffImg, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(uploadButton)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(50, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel3)
                                                        .addComponent(idInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel2)
                                                        .addComponent(nameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel6))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(dobInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jLabel7))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel8)
                                                        .addComponent(genderBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel10)
                                                        .addComponent(pathInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel5)
                                                        .addComponent(addressInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(positionInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(startDateInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(addButton)
                                        .addComponent(delButton)
                                        .addComponent(updateButton)
                                        .addComponent(printButton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(salaryManageButton)
                                .addGap(35, 35, 35))
        );

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel9.setText("Thông tin nhân viên");

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null}
                },
                new String [] {
                        "ID", "Name", "DOB", "Address", "Gender", "Position", "StartDate", "Image path", "Salary"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout uiPanelLayout = new javax.swing.GroupLayout(uiPanel);
        uiPanel.setLayout(uiPanelLayout);
        uiPanelLayout.setHorizontalGroup(
                uiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(uiPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(uiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jScrollPane1)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        uiPanelLayout.setVerticalGroup(
                uiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(uiPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(uiPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(uiPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void genderBoxActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {
        try{
            int ID= Integer.parseInt(idInput.getText());
            String sName= nameInput.getText();
            String address= addressInput.getText();
            Date staffDOB=Date.valueOf(handleDate(dobInput.getText()));
            String Gender=String.valueOf(genderBox.getSelectedItem());
            String Address= addressInput.getText();
            String position= positionInput.getText();
            Date startingDate=Date.valueOf(handleDate(startDateInput.getText()));
            String path= pathInput.getText();
            Staff updateStaff= new Staff(ID,sName,staffDOB,(float)5000000,Gender,Address,position,startingDate,path);
            dbHandler.updateStaff(updateStaff);
            JOptionPane.showMessageDialog(null,"Successfully Updated!");
            clearField();
            displayData();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    private void delButtonActionPerformed(java.awt.event.ActionEvent evt) {
        try{
            int ID= Integer.parseInt(idInput.getText());
            dbHandler.deleteStaff(ID);
            JOptionPane.showMessageDialog(null,"Successfully Deleted!");
            clearField();
            displayData();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {
        try{
            int ID= Integer.parseInt(idInput.getText());
            String sName= nameInput.getText();
            String address= addressInput.getText();
            Date staffDOB=Date.valueOf(handleDate(dobInput.getText()));
            String Gender=String.valueOf(genderBox.getSelectedItem());
            String Address= addressInput.getText();
            String position= positionInput.getText();
            Date startingDate=Date.valueOf(handleDate(startDateInput.getText()));
            String path= pathInput.getText();
            Staff newStaff= new Staff(ID,sName,staffDOB,(float)5000000,Gender,Address,position,startingDate,path);
            dbHandler.addStaff(newStaff);
            JOptionPane.showMessageDialog(null,"Successfully Added!");
            clearField();
            displayData();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void nameInputActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void idInputActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
    private void salaryManageButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        convertListToHashMap();
        String getID= idInput.getText();
        if(getID.equals("")){
            JOptionPane.showMessageDialog(null,"ID not exists!\n");
        }
        else {
            if (hashMap.containsKey(Integer.parseInt(idInput.getText())) == true) {
                new SalaryManagement(Integer.parseInt(idInput.getText())).setVisible(true);
            }
        }
    }

    private void uploadButtonActionPerformed(java.awt.event.ActionEvent evt) {
        try{
            if(idInput.getText()!=null){
                int ID=Integer.parseInt( idInput.getText());

            JFileChooser fileChooser= new JFileChooser();
            FileNameExtensionFilter typeImage= new FileNameExtensionFilter("Supported image type","jpg","png");
            fileChooser.setFileFilter(typeImage);
            int selected= fileChooser.showOpenDialog(null);
                if(selected==JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    String getSelectedImage = file.getAbsolutePath();
                    JOptionPane.showMessageDialog(null, getSelectedImage);
                    ImageIcon ico = new ImageIcon(getSelectedImage);
                    Image getFitImg= ico.getImage();
                    Image fitImg= getFitImg.getScaledInstance(staffImg.getWidth(),staffImg.getHeight(),Image.SCALE_SMOOTH);
                    staffImg.setIcon(new ImageIcon(fitImg));
                    dbHandler.updateStaff(ID,getSelectedImage);
                }
            }
            else{
                JOptionPane.showMessageDialog(null,"Please input ID first!");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Staff_Management.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Staff_Management.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Staff_Management.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Staff_Management.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Staff_Management().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    public Staff currentStaff;
    private javax.swing.JButton addButton;
    private javax.swing.JTextField addressInput;
    private javax.swing.JButton delButton;
    private javax.swing.JTextField dobInput;
    private javax.swing.JComboBox<String> genderBox;
    private javax.swing.JTextField idInput;
    private javax.swing.JLabel staffImg;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField nameInput;
    private javax.swing.JTextField pathInput;
    private javax.swing.JTextField positionInput;
    private javax.swing.JButton printButton;
    private javax.swing.JButton salaryManageButton;
    private javax.swing.JPanel uiPanel;
    private javax.swing.JTextField startDateInput;
    private javax.swing.JButton updateButton;
    private javax.swing.JButton uploadButton;
    // End of variables declaration                   
}
