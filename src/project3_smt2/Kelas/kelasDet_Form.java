/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3_smt2.Kelas;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import project3_smt2.jumlah_kompen.kompen_insert;

/**
 *
 * @author Dell
 */
public class kelasDet_Form extends javax.swing.JFrame {

    DefaultTableModel dtm = new DefaultTableModel();
    public kelasDet_Form() {
        initComponents();
        comboItem();
        autonumber();
        autonim();
        table();
        
        
    }

    public void filter(String query)
    {
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<DefaultTableModel>(dtm);
        jTable1.setRowSorter(trs);
        
        trs.setRowFilter(javax.swing.RowFilter.regexFilter(query));
    }
    
    
    public void table()
    {
        try
        {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String stringCon = "jdbc:sqlserver://localhost:1433;databaseName=kompenPNJ;user=sa;password=1234567890";
        Connection con = DriverManager.getConnection(stringCon);
        Statement state = con.createStatement();
        ResultSet rs = state.executeQuery("SELECT * FROM kelas_DetQuery");
        
        ResultSetMetaData rsmetadata = rs.getMetaData();
        int columns = rsmetadata.getColumnCount();
            Vector columns_name = new Vector();
            Vector data_rows = new Vector();
            
            for(int i = 1; i<=columns; i++)
            {
                columns_name.addElement(rsmetadata.getColumnName(i));
            }
            dtm.setColumnIdentifiers(columns_name);
            while(rs.next())
            {
                data_rows = new Vector();
                for(int j=1; j<=columns; j++)
                {
                    data_rows.addElement(rs.getString(j));
                }
                dtm.addRow(data_rows);
            }
           jTable1.setModel(dtm);
                   
        }
        
        
        catch (Exception e)
                {
                    jOptionPane1.showMessageDialog(null, "Kesalahan! ("+e+")");
                }
    }
    public void autonumber()
    {
        String sql = "select max(id_detail) from kelas_detail";
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databaseName=KompenPNJ";
            Connection con = DriverManager.getConnection(url,"sa","1234567890");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next())
            {
                int a = rs.getInt(1);
                lbl_idDEt.setText(""+Integer.toString(a+1));
            }
         
        }
        catch (Exception e)
                {
                    jOptionPane1.showMessageDialog(null, "Error: "+e);
                }
    }
    public void autonim()
    {
        String sql = "select max(nim_mhs) from kelas_detail";
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databaseName=KompenPNJ";
            Connection con = DriverManager.getConnection(url,"sa","1234567890");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next())
            {
                int a = rs.getInt(1);
                txt_NIM.setText(Integer.toString(a));
            }
        }
        catch (Exception e)
        {
              jOptionPane1.showMessageDialog(null, "Error: "+e);
        }
    }
    public void nameResult()
    {
        try
        {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String stringCon = "jdbc:sqlserver://localhost:1433;databaseName=kompenPNJ;user=sa;password=1234567890";
        Connection con = DriverManager.getConnection(stringCon);
        PreparedStatement ps = con.prepareStatement("SELECT nama_mhs FROM data_mhs WHERE nim_mhs = ?");
        int nim = Integer.parseInt(txt_NIM.getText());
        ps.setInt(1, nim);
        ResultSet res = ps.executeQuery();
                    res.next();
                   String nama = res.getString("nama_mhs");
                    lbl_nameRes.setText(nama);
        }
        catch (Exception e)
        {
            lbl_nameRes.setText("Tidak Ditemukan");
        }
    }
    public void comboItem()
    {
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databaseName=KompenPNJ";
            Connection con = DriverManager.getConnection(url,"sa","1234567890");
            String sql = "SELECT id_kelas FROM kelas";
            PreparedStatement prep = con.prepareStatement(sql);
            ResultSet res = prep.executeQuery();
            
            while (res.next()) {                
                String kelas = res.getString("id_kelas");
                cb_Class.addItem(kelas);
            }
                
        }
        catch(Exception e)
        {
            jOptionPane1.showMessageDialog(null, "Error: "+e);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jOptionPane1 = new javax.swing.JOptionPane();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_NIM = new javax.swing.JTextField();
        cb_Class = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        spin_Y2 = new javax.swing.JSpinner();
        spin_Y1 = new javax.swing.JSpinner();
        lbl_idDEt = new javax.swing.JLabel();
        lbl_nameRes = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Input detail kelas baru");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Detail kelas"));

        jButton1.setText("INSERT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("ID_Detail");

        jLabel3.setText("NIM");

        jLabel4.setText("ID_Kelas");

        jLabel5.setText("Tahun Ajar");

        txt_NIM.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txt_NIMInputMethodTextChanged(evt);
            }
        });
        txt_NIM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_NIMKeyReleased(evt);
            }
        });

        cb_Class.setMaximumRowCount(10);

        jLabel6.setText("/");

        spin_Y2.setModel(new javax.swing.SpinnerNumberModel(2017, 2017, null, 1));
        spin_Y2.setToolTipText("");

        spin_Y1.setModel(new javax.swing.SpinnerNumberModel(2016, 2016, null, 1));

        lbl_idDEt.setText("jLabel8");

        lbl_nameRes.setText("[Hasil Nama]");
        lbl_nameRes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lbl_nameResKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cb_Class, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_NIM, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_idDEt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_nameRes)
                    .addComponent(jButton1))
                .addGap(64, 64, 64))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel5)
                .addGap(26, 26, 26)
                .addComponent(spin_Y1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spin_Y2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jButton1)
                    .addComponent(lbl_idDEt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_NIM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_nameRes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cb_Class, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(spin_Y2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spin_Y1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Query"));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel7.setText("Cari");

        jButton3.setText("Cari");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Refresh");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE))
        );

        jButton2.setText("Tutup");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)))
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        if (txt_NIM.getText().equals(""))
        {
            jOptionPane1.showMessageDialog(null, "Harap Masukkan NIM");
        }
        else
        {
           try
        {
             Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=KompenPNJ";
            Connection con = DriverManager.getConnection(url,"sa","1234567890");
            
            String sql = "INSERT kelas_detail VALUES(?,?,?)";
            PreparedStatement pr = con.prepareStatement(sql);
            
            String NIM = txt_NIM.getText();
            String kelas = cb_Class.getItemAt(WIDTH);
            String tahun = spin_Y1.getValue()+"-"+spin_Y2.getValue();
            
            pr.setString(1, NIM);
            pr.setString(2, kelas);
            pr.setString(3, tahun);
            
            int i = pr.executeUpdate();
            if (i!=0)
            {
                jOptionPane1.showMessageDialog(null, "Berhasil!");
            }
            else
                jOptionPane1.showMessageDialog(null, "Gagal!");
        }
        catch (Exception e)
        {
         jOptionPane1.showMessageDialog(null, "Error: "+e);
        } 
        txt_NIM.setText("");
        autonumber();
        dtm.setRowCount(0);
        table();
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       String query = jTextField1.getText();
        filter(query);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        dtm.setRowCount(0);
        try
        {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String stringCon = "jdbc:sqlserver://localhost:1433;databaseName=kompenPNJ;user=sa;password=1234567890";
        Connection con = DriverManager.getConnection(stringCon);
        Statement state = con.createStatement();
        ResultSet rs = state.executeQuery("SELECT * FROM kelas_DetQuery");
        
        ResultSetMetaData rsmetadata = rs.getMetaData();
        int columns = rsmetadata.getColumnCount();
            Vector columns_name = new Vector();
            Vector data_rows = new Vector();
            
            for(int i = 1; i<=columns; i++)
            {
                columns_name.addElement(rsmetadata.getColumnName(i));
            }
            dtm.setColumnIdentifiers(columns_name);
            while(rs.next())
            {
                data_rows = new Vector();
                for(int j=1; j<=columns; j++)
                {
                    data_rows.addElement(rs.getString(j));
                }
                dtm.addRow(data_rows);
            }
           jTable1.setModel(dtm);
                   
        }
        
        
        catch (Exception e)
                {
                    jOptionPane1.showMessageDialog(null, "Kesalahan! ("+e+")");
                }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void lbl_nameResKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lbl_nameResKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_nameResKeyReleased

    private void txt_NIMKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_NIMKeyReleased
        nameResult();
    }//GEN-LAST:event_txt_NIMKeyReleased

    private void txt_NIMInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txt_NIMInputMethodTextChanged
        nameResult();
    }//GEN-LAST:event_txt_NIMInputMethodTextChanged

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
            java.util.logging.Logger.getLogger(kelasDet_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(kelasDet_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(kelasDet_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(kelasDet_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new kelasDet_Form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cb_Class;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lbl_idDEt;
    private javax.swing.JLabel lbl_nameRes;
    private javax.swing.JSpinner spin_Y1;
    private javax.swing.JSpinner spin_Y2;
    private javax.swing.JTextField txt_NIM;
    // End of variables declaration//GEN-END:variables
}
