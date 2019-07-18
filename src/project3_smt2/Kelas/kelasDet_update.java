
package project3_smt2.Kelas;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Dell
 */
public class kelasDet_update extends javax.swing.JFrame {

    DefaultTableModel dtm = new DefaultTableModel();
    
    public kelasDet_update() {
        initComponents();
        table();
         
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
public void filter(String query)
    {
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<DefaultTableModel>(dtm);
        jTable1.setRowSorter(trs);
        
        trs.setRowFilter(javax.swing.RowFilter.regexFilter(query));
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Kelas_ID = new javax.swing.JLabel();
        Kelas_ID1 = new javax.swing.JLabel();
        txt_NIM = new javax.swing.JTextField();
        lbl_ID = new javax.swing.JLabel();
        txt_tahun = new javax.swing.JTextField();
        btn_src = new javax.swing.JButton();
        btn_updt = new javax.swing.JButton();
        txt_tahun1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbl_nameRes = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("NIM");

        jLabel3.setText("ID_Detail");

        Kelas_ID.setText("Kelas_ID");

        Kelas_ID1.setText("Tahun Ajar");

        lbl_ID.setText("[Hasil ID]");

        btn_src.setText("Cari");
        btn_src.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_srcActionPerformed(evt);
            }
        });

        btn_updt.setText("Update");
        btn_updt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updtActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Table"));

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

        jLabel4.setText("Cari");

        jButton1.setText("Cari");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel4)
                .addGap(31, 31, 31)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jButton1)
                .addContainerGap(125, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(65, 65, 65)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jButton2.setText("Tutup");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Update Kelas Detail");

        jLabel5.setText("Nama");

        lbl_nameRes.setText("[Hasil Nama]");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(Kelas_ID)
                                            .addGap(31, 31, 31))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(Kelas_ID1)
                                            .addGap(21, 21, 21)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_tahun, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                                    .addComponent(lbl_ID)
                                    .addComponent(txt_tahun1)
                                    .addComponent(txt_NIM, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(146, 146, 146)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addGap(18, 18, 18)
                                                .addComponent(lbl_nameRes))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btn_src)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btn_updt))))))
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_NIM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_src)
                    .addComponent(btn_updt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lbl_ID)
                    .addComponent(jLabel5)
                    .addComponent(lbl_nameRes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Kelas_ID)
                    .addComponent(txt_tahun1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Kelas_ID1)
                    .addComponent(txt_tahun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jButton2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_updtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updtActionPerformed
      //UPDATE
        if ((txt_NIM.getText().equals("")) && (txt_tahun1.getText().equals("")) && (txt_tahun.getText().equals("")))
       {
          jOptionPane1.showMessageDialog(null, "Mohon isi data dengan benar!");
       }
       else
       {
           try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=KompenPNJ";
            Connection con = DriverManager.getConnection(url,"sa","1234567890");
           
             String sql = "UPDATE kelas_detail SET nim_mhs=?, id_kelas = ?, tahun_ajaran = ? WHERE id_detail ="+lbl_ID.getText();
            PreparedStatement pr = con.prepareStatement(sql);
            int nim = Integer.parseInt(txt_NIM.getText());
            String id_kelas = txt_tahun1.getText();
            String tahun = txt_tahun.getText();
            //int id = Integer.parseInt(lbl_ID.getText());
            pr.setInt(1, nim);
            //pr.setString(1, nim);
            pr.setString(2, id_kelas);
            pr.setString(3, tahun);
            //pr.setInt(4, id);
            
            int i = pr.executeUpdate();
            if (i!=0)
            {
                jOptionPane1.showMessageDialog(null, "Berhasil!");
            }
            else
            {
                jOptionPane1.showMessageDialog(null, "Gagal");
            }
            con.close();
            
        }
        catch(Exception e)
        {
            jOptionPane1.showMessageDialog(null, "Error: "+e);
        }
           txt_tahun.setText("");
           txt_tahun1.setText("");
           lbl_ID.setText("");
           lbl_nameRes.setText("");
           dtm.setRowCount(0);
           table();
       }
        
    }//GEN-LAST:event_btn_updtActionPerformed

    private void btn_srcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_srcActionPerformed
        //SEARCH
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=KompenPNJ";
            Connection con = DriverManager.getConnection(url,"sa","1234567890");
           
            PreparedStatement ps = con.prepareStatement("SELECT * FROM kelas_DetQuery WHERE nim_mhs = ?");
            
            int nim = Integer.parseInt(txt_NIM.getText());
                    ps.setInt(1, nim);
                    ResultSet res = ps.executeQuery();
                    res.next();
                    String nama = res.getString("nama_mhs");
                    String ID = res.getString("id_detail");
                    String kls = res.getString("id_kelas");
                    String tahun = res.getString("tahun_ajar");
                    lbl_nameRes.setText(nama);
                    lbl_ID.setText(ID);
                    txt_tahun1.setText(kls);
                    txt_tahun.setText(tahun);
            
            
        }
        catch(Exception e)
        {
            jOptionPane1.showMessageDialog(null, "Error: "+e);
        }
    }//GEN-LAST:event_btn_srcActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String query = jTextField1.getText();
        filter(query);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(kelasDet_update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(kelasDet_update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(kelasDet_update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(kelasDet_update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new kelasDet_update().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Kelas_ID;
    private javax.swing.JLabel Kelas_ID1;
    private javax.swing.JButton btn_src;
    private javax.swing.JButton btn_updt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lbl_ID;
    private javax.swing.JLabel lbl_nameRes;
    private javax.swing.JTextField txt_NIM;
    private javax.swing.JTextField txt_tahun;
    private javax.swing.JTextField txt_tahun1;
    // End of variables declaration//GEN-END:variables
}
