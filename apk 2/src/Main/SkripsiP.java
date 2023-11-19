/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Main;

import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author RIGISEFA
 */
public class SkripsiP extends javax.swing.JPanel {
    
        Connection conn = null;
    
    public void peringatan(String pesan) {
        Component rootPane = null;
        JOptionPane.showMessageDialog(rootPane, pesan);
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Akhir", "postgres", "bajumuslim");
        } catch (SQLException ex) {
            Logger.getLogger(PerbaruiSkripsi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    ArrayList<Test> dataTest;

    private int masukkanData(Connection conn, String judul, String pengarang, String tahun, String halaman) throws SQLException {
        PreparedStatement pst = conn.prepareStatement("INSERT INTO SKRIPSI (judul,pengarang,tahun,halaman) VALUES(?,?,?,?)");
        pst.setString(1, judul);
        pst.setString(2, pengarang);
        pst.setString(3, tahun);
        pst.setString(4, halaman);
        return pst.executeUpdate();
    }
    
    private int editData(Connection conn, String judul, String pengarang, String tahun, String halaman) throws SQLException {
        PreparedStatement pst = conn.prepareStatement("UPDATE SKRIPSI set pengarang = ?,tahun = ?,halaman = ?,where judul = ? ");
        pst.setString(4, judul);
        pst.setString(1, pengarang);
        pst.setString(2, tahun);
        pst.setString(3, halaman);
        return pst.executeUpdate();
    }
    
    private int hapusData(Connection conn, String judul) throws SQLException {
        PreparedStatement pst = conn.prepareStatement("DELETE From SKRIPSI where judul = ? ");
        pst.setString(1, judul);
        return pst.executeUpdate();
    }
    
    private void cariData(){
        try {
            String sql = "";
            if(jComboBoxSearch.getSelectedIndex()==0){
                sql = "SELECT * from skripsi WHERE judul ILIKE '%"+jTextFieldSearch.getText()+"%' ";
            }else if(jComboBoxSearch.getSelectedIndex()==1){
                sql = "SELECT * from skripsi WHERE tahun ILIKE '%"+jTextFieldSearch.getText()+"%' ";
            }else if(jComboBoxSearch.getSelectedIndex()==2){
                sql = "SELECT * from skripsi WHERE pengarang ILIKE '%"+jTextFieldSearch.getText()+"%' ";
            }else if(jComboBoxSearch.getSelectedIndex()==3){
                sql = "SELECT * from skripsi WHERE halaman ILIKE '%"+jTextFieldSearch.getText()+"%' ";
            }
            
            Statement rt = conn.createStatement();
            ResultSet st = rt.executeQuery(sql);
            DefaultTableModel tb = (DefaultTableModel) jTableSkripsi.getModel();
            tb.setRowCount(0);
            while(st.next()){
                Object[] ob = new Object[4];
                ob[0] = st.getString("judul");
                ob[1] = st.getString("tahun");
                ob[2] = st.getString("pengarang");
                ob[3] = st.getString("halaman");
                tb.addRow(ob);
                
            }
            jTableSkripsi.setModel(tb);
        } catch (SQLException ex) {
            Logger.getLogger(PerbaruiSkripsi.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    

    private void Tampil(Connection conn) {
        dataTest.clear();
        try {
            String sql = "select * from skripsi";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Test data = new Test();
                data.setJudul(String.valueOf(rs.getObject(1)));
                data.setPengarang(String.valueOf(rs.getObject(2)));
                data.setTahun(String.valueOf(rs.getObject(3)));
                data.setHalaman(String.valueOf(rs.getObject(4)));
                dataTest.add(data);
            }
            DefaultTableModel model = (DefaultTableModel) jTableSkripsi.getModel();
            model.setRowCount(0);
            for (Test data : dataTest) {

                Object[] baris = new Object[4];
                baris[0] = data.getJudul();
                baris[1] = data.getPengarang();
                baris[2] = data.getTahun();
                baris[3] = data.getHalaman();

                model.addRow(baris);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SkripsiP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Creates new form PerbaruiSkripsi
     */
    JPanel Pnutama;
    public SkripsiP(JPanel pn) {
        try {
            dataTest = new ArrayList<>();
            initComponents();
            
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Akhir", "postgres", "bajumuslim");
            Tampil(conn);
        } catch (SQLException ex) {
            Logger.getLogger(SkripsiP.class.getName()).log(Level.SEVERE, null, ex);
        }
        Pnutama = pn;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableSkripsi = new javax.swing.JTable();
        jButtonOtakatik = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jComboBoxSearch = new javax.swing.JComboBox<>();
        jTextFieldSearch = new javax.swing.JTextField();
        jButtonPrint = new javax.swing.JButton();
        jButtonCari = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(153, 102, 0));

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel1.setText("Skripsi");

        jTableSkripsi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "judul", "pengarang", "tahun", "halaman"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableSkripsi);

        jButtonOtakatik.setText("Otak Atik");
        jButtonOtakatik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOtakatikActionPerformed(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        jComboBoxSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "judul", "pengarang", "tahun", "halaman" }));
        jComboBoxSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSearchActionPerformed(evt);
            }
        });

        jButtonPrint.setText("Print");

        jButtonCari.setText("Cari");
        jButtonCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCariActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 722, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonOtakatik)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonPrint)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonCari)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator1))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBoxSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonCari)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonOtakatik)
                    .addComponent(jButtonPrint))
                .addGap(20, 20, 20))
        );

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonOtakatikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOtakatikActionPerformed
        Pnutama.removeAll();
        Pnutama.add(new PerbaruiSkripsi());
        Pnutama.repaint();
        Pnutama.revalidate();
    }//GEN-LAST:event_jButtonOtakatikActionPerformed

    private void jComboBoxSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxSearchActionPerformed

    private void jButtonCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCariActionPerformed
        cariData();
    }//GEN-LAST:event_jButtonCariActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCari;
    private javax.swing.JButton jButtonOtakatik;
    private javax.swing.JButton jButtonPrint;
    private javax.swing.JComboBox<String> jComboBoxSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTableSkripsi;
    private javax.swing.JTextField jTextFieldSearch;
    // End of variables declaration//GEN-END:variables
}
