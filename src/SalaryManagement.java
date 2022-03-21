import javax.swing.*;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author Jason Koi
 */
public class SalaryManagement extends javax.swing.JFrame {

    private int staffID;
    /**
     * Creates new form SalaryManagement
     */
    public SalaryManagement() {
        initComponents();
        showStaffInform();
    }

    public SalaryManagement(int ID) {
        this.staffID=ID;
        System.out.println(ID);
        initComponents();
        showStaffInform();
    }

    private void showStaffInform(){
        try{
            if(String.valueOf(this.staffID)!=null){
                Staff staff= new Staff();
                staff=dbHandler.getAStaff(this.staffID);
                displayName.setText(staff.getStaffName());
                displayID.setText(String.valueOf(staff.getID()));
                displayPos.setText(staff.getPosition());
                getCurrentSalary(staff);
                displaySalary.setText(String.valueOf(staff.getSalary()));

            }
            else{
                JOptionPane.showMessageDialog(this,"Error! Staff doesn't exist!");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private void getCurrentSalary(Staff staff){
        try {
            staff= dbHandler.getAStaff(this.staffID);
            Salary s=new Salary();
            s.setHardSalary(staff);
            s.setTaxes(staff);
            s.finalSalaryCalculation(staff);
            displaySalary.setText(String.valueOf(staff.getSalary()));
            taxLabel.setText(String.valueOf(s.getTaxes()));
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        displayID = new javax.swing.JLabel();
        displayName = new javax.swing.JLabel();
        positionLabel = new javax.swing.JLabel();
        displayPos = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        hardSalaryLabel = new javax.swing.JLabel();
        hardSalaryField = new javax.swing.JTextField();
        updateSalaryButton = new javax.swing.JButton();
        bonusLabel = new javax.swing.JLabel();
        bonusField = new javax.swing.JTextField();
        otLabel = new javax.swing.JLabel();
        otField = new javax.swing.JTextField();
        absentLabel = new javax.swing.JLabel();
        absentBox = new javax.swing.JComboBox<>();
        taxLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        displayCurrentSalary = new javax.swing.JLabel();
        displaySalary = new javax.swing.JLabel();
        finalSalaryLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(249, 249, 249));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jPanel2.setBackground(new java.awt.Color(244, 242, 242));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Salary Management");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(255, 255, 255)
                                .addComponent(jLabel1)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jLabel1)
                                .addContainerGap(43, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Staff ID:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Staff name:");

        displayID.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        displayID.setText("display ID");

        displayName.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        displayName.setText("display name");

        positionLabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        positionLabel.setText("Position:");

        displayPos.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        displayPos.setText("display position");

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        hardSalaryLabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        hardSalaryLabel.setText("Hard salary (USD):");

        hardSalaryField.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        updateSalaryButton.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        updateSalaryButton.setText("Update Salary");
        updateSalaryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateSalaryButtonActionPerformed(evt);
            }
        });

        bonusLabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        bonusLabel.setText("Bonus (USD):");

        otLabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        otLabel.setText("Overtime (hours):");

        absentLabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        absentLabel.setText("Absent (days):");

        absentBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0","1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14" }));

        taxLabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        taxLabel.setText("Taxes (%):");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("%");

        displayCurrentSalary.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        displayCurrentSalary.setText("Current salary:");

        displaySalary.setText("display salary");

        finalSalaryLabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        finalSalaryLabel.setText("Final salary = (hardSalary + bonus + otHours * 15 - absentDays * 20) - taxes");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator1)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel3))
                                                .addGap(25, 25, 25)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(displayID)
                                                        .addComponent(displayName))
                                                .addGap(112, 112, 112)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(displayCurrentSalary)
                                                        .addComponent(positionLabel))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(displayPos)
                                                        .addComponent(displaySalary)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(hardSalaryLabel)
                                                        .addComponent(bonusLabel)
                                                        .addComponent(otLabel)
                                                        .addComponent(absentLabel))
                                                .addGap(22, 22, 22)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(absentBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(hardSalaryField, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(bonusField, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addComponent(otField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(76, 76, 76)
                                                                .addComponent(taxLabel)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jLabel4))))
                                        .addComponent(finalSalaryLabel)
                                        .addComponent(updateSalaryButton))
                                .addContainerGap(196, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(displayID)
                                        .addComponent(positionLabel)
                                        .addComponent(displayPos))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(displayName)
                                                .addComponent(displayCurrentSalary)
                                                .addComponent(displaySalary))
                                        .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(hardSalaryLabel)
                                        .addComponent(hardSalaryField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(taxLabel)
                                        .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(bonusLabel)
                                        .addComponent(bonusField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(otLabel)
                                        .addComponent(otField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(absentLabel)
                                        .addComponent(absentBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                .addComponent(updateSalaryButton)
                                .addGap(18, 18, 18)
                                .addComponent(finalSalaryLabel)
                                .addGap(57, 57, 57))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>

    private void updateSalaryButtonActionPerformed(java.awt.event.ActionEvent evt) {
        try{
            Staff currentStaff=dbHandler.getAStaff(this.staffID);
            Salary salary= new Salary();
            if(hardSalaryField.getText()!=null){
                float inputHS= Float.parseFloat(hardSalaryField.getText());
                if(inputHS<currentStaff.getSalary()){
                   int res= JOptionPane.showConfirmDialog(null,"The input salary is lower than current, do you want to update?","Confirm Box",JOptionPane.YES_NO_OPTION);
                   if(res==0){
                       currentStaff.setSalary(inputHS);
                   }
                }
                else{
                    currentStaff.setSalary(inputHS);
                }
                int bonus= Integer.parseInt(bonusField.getText());
                int ot= Integer.parseInt(otField.getText());
                int absentDays= Integer.parseInt((String) absentBox.getSelectedItem());
                salary.setBonus(bonus);
                salary.setOtHours(ot);
                salary.setAbsentDays(absentDays);
                salary.setTaxes(currentStaff);
                taxLabel.setText(String.valueOf(salary.getTaxes()));
                salary.finalSalaryCalculation(currentStaff);
                displaySalary.setText(String.valueOf(currentStaff.getSalary()));
                finalSalaryLabel.setText(String.valueOf(currentStaff.getSalary()));
                dbHandler.updateStaff(currentStaff.getID(),currentStaff.getSalary());
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
            java.util.logging.Logger.getLogger(SalaryManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SalaryManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SalaryManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SalaryManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SalaryManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JComboBox<String> absentBox;
    private javax.swing.JLabel absentLabel;
    private javax.swing.JTextField bonusField;
    private javax.swing.JLabel bonusLabel;
    private javax.swing.JLabel displayCurrentSalary;
    private javax.swing.JLabel displayID;
    private javax.swing.JLabel displayName;
    private javax.swing.JLabel displayPos;
    private javax.swing.JLabel displaySalary;
    private javax.swing.JLabel finalSalaryLabel;
    private javax.swing.JTextField hardSalaryField;
    private javax.swing.JLabel hardSalaryLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField otField;
    private javax.swing.JLabel otLabel;
    private javax.swing.JLabel positionLabel;
    private javax.swing.JLabel taxLabel;
    private javax.swing.JButton updateSalaryButton;
    // End of variables declaration
}
