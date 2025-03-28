import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class StudentJFrame extends javax.swing.JFrame {

    public StudentJFrame() {
        initComponents();
        Connect();
        StudentData();
    }

    Connection con;
    PreparedStatement pst;

    public void Connect(){

        try {
            Class.forName("org.postgresql.Driver");
            con=DriverManager.getConnection("jdbc:postgresql://localhost/UCM_Project","postgres","S1lv3rsn1p3r#");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StudentJFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(StudentJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void StudentData(){
        try {
            int QQ;
            pst =con.prepareStatement("SELECT * FROM students");
            ResultSet Rs =pst.executeQuery();
            ResultSetMetaData RSMD =Rs.getMetaData();
            QQ = RSMD.getColumnCount();
            DefaultTableModel DFG=(DefaultTableModel)table1.getModel();
            DFG.setRowCount(0);

            while(Rs.next()){
                Vector <Object> rowData=new Vector<>();
                rowData.add(Rs.getInt("student_id"));
                rowData.add(Rs.getString("student_name"));
                rowData.add(Rs.getString("email"));
                rowData.add(Rs.getString("address"));
                DFG.addRow(rowData);
            }

        } catch (SQLException ex) {
            Logger.getLogger(StudentJFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error retrieving student data!!: "+ex.getMessage());
        }
    }
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        btnInsert = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel5.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 14)); // NOI18N
        jLabel5.setText("Gender");

        btnInsert.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 14)); // NOI18N
        btnInsert.setText("Insert");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 18)); // NOI18N
        jLabel1.setText("Students");

        jButton1.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 14)); // NOI18N
        jButton1.setText("X");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(240, 240, 240)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1)
                                .addGap(27, 27, 27))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jButton1))
                                .addContainerGap(26, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 14)); // NOI18N
        jLabel2.setText("Student Id");

        jLabel6.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 24)); // NOI18N
        jLabel6.setText("      INSERT PICTURE");
        jLabel6.setMaximumSize(new java.awt.Dimension(736, 736));
        jLabel6.setMinimumSize(new java.awt.Dimension(736, 736));
        jLabel6.setPreferredSize(new java.awt.Dimension(736, 736));

        jLabel3.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 14)); // NOI18N
        jLabel3.setText("Student Name");

        jLabel4.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 14)); // NOI18N
        jLabel4.setText("Email");

        jLabel7.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 14)); // NOI18N
        jLabel7.setText("Address");

        btnUpdate.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 14)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 14)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        table1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "Student Id", "Student Name", "Email", "Address"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table1);

        jButton2.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 14)); // NOI18N
        jButton2.setText("Insert");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addComponent(jLabel4)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addComponent(jLabel3)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addComponent(jLabel2)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(jButton2)
                                                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(21, 21, 21)
                                                                                .addComponent(btnUpdate)
                                                                                .addGap(37, 37, 37)
                                                                                .addComponent(btnDelete)
                                                                                .addGap(0, 0, Short.MAX_VALUE)))))
                                                .addGap(41, 41, 41)
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 633, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(67, 67, 67)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel2)
                                                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel3)
                                                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel4))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel7)
                                                        .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(39, 39, 39)
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnUpdate)
                                        .addComponent(btnDelete)
                                        .addComponent(jButton2))
                                .addGap(31, 31, 31)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        pack();
        setLocationRelativeTo(null);
    }

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {
        try{
        int student_id=Integer.parseInt(txtId.getText());
        String student_name=txtName.getText();
        String email=txtEmail.getText();
        String address=txtAddress.getText();


            pst=con.prepareStatement("INSERT INTO students(student_id,student_name,email,address)VALUES(?,?,?,?)");

            pst.setInt(1,student_id);
            pst.setString(2,student_name);
            pst.setString(3,email);
            pst.setString(4,address);

            int rowsInserted =pst.executeUpdate();
            if (rowsInserted >0) {
                JOptionPane.showMessageDialog(this, "Data Inserted Successfully ");
                StudentData();
            }else{
                JOptionPane.showMessageDialog(this,"Data Insertion failed!!");
            }
        }catch (SQLException ex) {
            Logger.getLogger(StudentJFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this,"Error inserting data:"+ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            DefaultTableModel model1=(DefaultTableModel) table1.getModel();
            int selectIndex=table1.getSelectedRow();
            if (selectIndex==-1){
                JOptionPane.showMessageDialog(this,"Please select the row to be updated. ");
                return;
            }
            String student_id= model1.getValueAt(selectIndex,0).toString();
            String student_name=txtName.getText();
            String email=txtEmail.getText();
            String address=txtAddress.getText();

            pst = con.prepareStatement("UPDATE students SET student_name= ?,email= ?,address= ? where student_id= ?");

            pst.setString(1,student_id);
            pst.setString(2,student_name);
            pst.setString(3,email);
            pst.setString(4,address);

            int rowsUpdated=pst.executeUpdate();
            if (rowsUpdated==1) {
                JOptionPane.showMessageDialog(this, "Data Updated Successfully ");
                StudentData();
            }else{
                JOptionPane.showMessageDialog(this,"Data Update failed!!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentJFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error updating data!!: "+ex.getMessage());
        }
    }
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            DefaultTableModel model1 = (DefaultTableModel) table1.getModel();
            int selectIndex = table1.getSelectedRow();
            if (selectIndex == -1) {
                JOptionPane.showMessageDialog(this, "Please select a row to delete.");
                return;
            }
            int studentId = Integer.parseInt(model1.getValueAt(selectIndex, 0).toString());
            pst = con.prepareStatement("DELETE FROM students WHERE student_id=?");
            pst.setInt(1, studentId);

            int rowsDeleted = pst.executeUpdate();
            if (rowsDeleted == 1) {
                JOptionPane.showMessageDialog(this, "Data Deleted Successfully ");
                StudentData();
            } else {
                JOptionPane.showMessageDialog(this, "Data Deletion failed!!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentJFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error deleting data: " + ex.getMessage());
        }
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        try{
            String studentId=txtId.getText();
            String studentName=txtName.getText();
            String email=txtEmail.getText();
            String address=txtAddress.getText();

            pst =con.prepareStatement("INSERT INTO students (student_id,student_name,email,address) VALUES(?,?,?,?)");
            pst.setInt(1, Integer.parseInt(studentId));
            pst.setString(2,studentName);
            pst.setString(3, email);
            pst.setString(4,address);

            int actionPerformed=pst.executeUpdate();
            if (actionPerformed==1){
                JOptionPane.showMessageDialog(this, "Row added successfully.");
                txtId.setText("");
                txtName.setText("");
                txtEmail.setText("");
                txtAddress.setText("");
                StudentData();
            }else{
                JOptionPane.showMessageDialog(this, "Data failed to be added!!");
            }
        }catch (SQLException ex){
            Logger.getLogger(StudentJFrame.class.getName()).log(Level.SEVERE,null,ex);
            JOptionPane.showMessageDialog(this, "Error!!:"+ex.getMessage());
        }
    }

    public static void main(String []args) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTable table1;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}

