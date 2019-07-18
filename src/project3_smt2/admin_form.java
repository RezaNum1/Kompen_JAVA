/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3_smt2;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import project3_smt2.Kelas.kelasDet_Form;
import project3_smt2.Kelas.kelasDet_update;
import project3_smt2.Kelas.kelasDet_updelete;
import project3_smt2.Kelas.kelas_delete;
import project3_smt2.Kelas.kelas_form;
import project3_smt2.Mahasiswa.Delete_mhs;
import project3_smt2.Mahasiswa.mhs_insert;
import project3_smt2.jumlah_kompen.deletee;
import project3_smt2.jumlah_kompen.kompen_insert;
import project3_smt2.jumlah_kompen.update_kompen;

/**
 *
 * @author Dell
 */
public class admin_form extends javax.swing.JFrame {
    
DefaultTableModel dtm = new DefaultTableModel();

    public admin_form() {
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
        ResultSet rs = state.executeQuery("SELECT * FROM hasil_kompen");
        ResultSetMetaData rsmetadata = rs.getMetaData();
        int columns = rsmetadata.getColumnCount();
            
            DefaultTableModel dtm = new DefaultTableModel();
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
                    Opt_pane1.showMessageDialog(null, "Kesalahan! ("+e+")");
                }
}

public void filter(String query)
    {
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<DefaultTableModel>(dtm);
        jTable1.setRowSorter(trs);
        
        trs.setRowFilter(javax.swing.RowFilter.regexFilter(query));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Opt_pane1 = new javax.swing.JOptionPane();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btn_refresh = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        class_class_insert = new javax.swing.JMenuItem();
        class_class_updelete = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        class_classDet_insert = new javax.swing.JMenuItem();
        class_classDet_updelete = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        komp_insert = new javax.swing.JMenuItem();
        komp_updt = new javax.swing.JMenuItem();
        komp_delete = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mhs_newdata = new javax.swing.JMenuItem();
        mhs_erase = new javax.swing.JMenuItem();

        jMenuItem6.setText("jMenuItem6");

        jMenu4.setText("jMenu4");

        jMenu6.setText("jMenu6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        jLabel1.setText("Cari");

        jButton1.setText("Cari");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Print");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btn_refresh.setText("Refresh");
        btn_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refreshActionPerformed(evt);
            }
        });

        jMenuBar1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Menu"));

        jMenu1.setText("Akun");

        jMenuItem3.setText("Logout");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Kelas");

        jMenu7.setText("Kelas");

        class_class_insert.setText("Insert");
        class_class_insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                class_class_insertActionPerformed(evt);
            }
        });
        jMenu7.add(class_class_insert);

        class_class_updelete.setText("Hapus");
        class_class_updelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                class_class_updeleteActionPerformed(evt);
            }
        });
        jMenu7.add(class_class_updelete);

        jMenu3.add(jMenu7);

        jMenu8.setText("Kelas Detail");

        class_classDet_insert.setText("Insert");
        class_classDet_insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                class_classDet_insertActionPerformed(evt);
            }
        });
        jMenu8.add(class_classDet_insert);

        class_classDet_updelete.setText("Hapus");
        class_classDet_updelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                class_classDet_updeleteActionPerformed(evt);
            }
        });
        jMenu8.add(class_classDet_updelete);

        jMenuItem1.setText("Update");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem1);

        jMenu3.add(jMenu8);

        jMenuBar1.add(jMenu3);

        jMenu5.setText("Kompensasi");

        komp_insert.setText("Insert");
        komp_insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                komp_insertActionPerformed(evt);
            }
        });
        jMenu5.add(komp_insert);

        komp_updt.setText("Perbarui");
        komp_updt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                komp_updtActionPerformed(evt);
            }
        });
        jMenu5.add(komp_updt);

        komp_delete.setText("Hapus");
        komp_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                komp_deleteActionPerformed(evt);
            }
        });
        jMenu5.add(komp_delete);

        jMenuBar1.add(jMenu5);

        jMenu2.setText("Mahasiswa");

        mhs_newdata.setText("Data Baru");
        mhs_newdata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mhs_newdataActionPerformed(evt);
            }
        });
        jMenu2.add(mhs_newdata);

        mhs_erase.setText("Hapus");
        mhs_erase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mhs_eraseActionPerformed(evt);
            }
        });
        jMenu2.add(mhs_erase);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_refresh)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 26, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1)
                    .addComponent(btn_refresh))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        main_form ma = new main_form();
        ma.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void mhs_eraseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mhs_eraseActionPerformed
     project3_smt2.jumlah_kompen.deletee komp = new deletee();
        komp.setVisible(true);
    }//GEN-LAST:event_mhs_eraseActionPerformed

    private void mhs_newdataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mhs_newdataActionPerformed
        project3_smt2.Mahasiswa.mhs_insert mhs = new mhs_insert();
        mhs.setVisible(true);
    }//GEN-LAST:event_mhs_newdataActionPerformed

    private void komp_updtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_komp_updtActionPerformed
        project3_smt2.jumlah_kompen.update_kompen upd = new update_kompen();
        upd.setVisible(true);
    }//GEN-LAST:event_komp_updtActionPerformed

    private void class_class_insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_class_class_insertActionPerformed
       project3_smt2.Kelas.kelas_form kls = new kelas_form();
       kls.setVisible(true);
    }//GEN-LAST:event_class_class_insertActionPerformed

    private void class_class_updeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_class_class_updeleteActionPerformed
        project3_smt2.Kelas.kelas_delete kls = new kelas_delete();
        kls.setVisible(true);
    }//GEN-LAST:event_class_class_updeleteActionPerformed

    private void class_classDet_insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_class_classDet_insertActionPerformed
        project3_smt2.Kelas.kelasDet_Form kls = new kelasDet_Form();
        kls.setVisible(true);
    }//GEN-LAST:event_class_classDet_insertActionPerformed

    private void class_classDet_updeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_class_classDet_updeleteActionPerformed
        project3_smt2.Kelas.kelasDet_updelete kls = new kelasDet_updelete();
        kls.setVisible(true);
    }//GEN-LAST:event_class_classDet_updeleteActionPerformed

    private void komp_insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_komp_insertActionPerformed
        project3_smt2.jumlah_kompen.kompen_insert komp = new kompen_insert();
        komp.setVisible(true);
    }//GEN-LAST:event_komp_insertActionPerformed

    private void komp_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_komp_deleteActionPerformed
        project3_smt2.jumlah_kompen.deletee komp = new deletee();
        komp.setVisible(true);
    }//GEN-LAST:event_komp_deleteActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        project3_smt2.Kelas.kelasDet_update upd = new kelasDet_update();
        upd.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String query = jTextField1.getText();
        filter(query);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        MessageFormat header = new MessageFormat("Data Kompensasi");
                
         MessageFormat footer = new MessageFormat("page{0,,number,integer}");
        try{
            
            jTable1.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        }
        catch(java.awt.print.PrinterException e){
            System.err.format("cannot print",e.getMessage());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btn_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshActionPerformed
        dtm.setRowCount(0);
        table();
    }//GEN-LAST:event_btn_refreshActionPerformed

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
            java.util.logging.Logger.getLogger(admin_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(admin_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(admin_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(admin_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admin_form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JOptionPane Opt_pane1;
    private javax.swing.JButton btn_refresh;
    private javax.swing.JMenuItem class_classDet_insert;
    private javax.swing.JMenuItem class_classDet_updelete;
    private javax.swing.JMenuItem class_class_insert;
    private javax.swing.JMenuItem class_class_updelete;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JMenuItem komp_delete;
    private javax.swing.JMenuItem komp_insert;
    private javax.swing.JMenuItem komp_updt;
    private javax.swing.JMenuItem mhs_erase;
    private javax.swing.JMenuItem mhs_newdata;
    // End of variables declaration//GEN-END:variables
}
