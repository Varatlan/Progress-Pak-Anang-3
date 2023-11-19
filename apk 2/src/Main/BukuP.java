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
public class BukuP extends javax.swing.JPanel {

        Connection conn = null;
    
    /**
     * Creates new form BukuP
     */public void peringatan(String pesan) {
        Component rootPane = null;
        JOptionPane.showMessageDialog(rootPane, pesan);
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Akhir", "postgres", "bajumuslim");
        } catch (SQLException ex) {
            Logger.getLogger(PerbaruiSkripsi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    ArrayList<Test> dataTest;
    
    private void cariData(){
        try {
            String sql = "";
            if(jComboBoxSearch.getSelectedIndex()==0){
                sql = "SELECT * from buku WHERE isbn ILIKE '%"+jTextFieldSearch.getText()+"%' ";
            }else if(jComboBoxSearch.getSelectedIndex()==1){
                sql = "SELECT * from buku WHERE judul ILIKE '%"+jTextFieldSearch.getText()+"%' ";
            }else if(jComboBoxSearch.getSelectedIndex()==2){
                sql = "SELECT * from buku WHERE subjudul ILIKE '%"+jTextFieldSearch.getText()+"%' ";
            }else if(jComboBoxSearch.getSelectedIndex()==3){
                sql = "SELECT * from buku WHERE pengarang ILIKE '%"+jTextFieldSearch.getText()+"%' ";
            }else if(jComboBoxSearch.getSelectedIndex()==4){
                sql = "SELECT * from buku WHERE tahun ILIKE '%"+jTextFieldSearch.getText()+"%' ";
            }else if(jComboBoxSearch.getSelectedIndex()==5){
                sql = "SELECT * from buku WHERE halaman ILIKE '%"+jTextFieldSearch.getText()+"%' ";
            }else if(jComboBoxSearch.getSelectedIndex()==6){
                sql = "SELECT * from buku WHERE penerbit ILIKE '%"+jTextFieldSearch.getText()+"%' ";
            }
            
            Statement rt = conn.createStatement();
            ResultSet st = rt.executeQuery(sql);
            DefaultTableModel tb = (DefaultTableModel) jTableBuku.getModel();
            tb.setRowCount(0);
            while(st.next()){
                Object[] ob = new Object[7];
                ob[0] = st.getString("isbn");
                ob[1] = st.getString("judul");
                ob[2] = st.getString("subjudul");
                ob[3] = st.getString("pengarang");
                ob[4] = st.getString("tahun");
                ob[5] = st.getString("halaman");
                ob[6] = st.getString("penerbit");
                tb.addRow(ob);
                
            }
            jTableBuku.setModel(tb);
        } catch (SQLException ex) {
            Logger.getLogger(PerbaruiSkripsi.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void Tampil(Connection conn) {
        dataTest.clear();
        try {
            String sql = "select * from buku";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Test data = new Test();
                data.setIsbn(String.valueOf(rs.getObject(1)));
                data.setJudul(String.valueOf(rs.getObject(2)));
                data.setSubjudul(String.valueOf(rs.getObject(3)));
                data.setPengarang(String.valueOf(rs.getObject(4)));
                data.setTahun(String.valueOf(rs.getObject(5)));
                data.setHalaman(String.valueOf(rs.getObject(6)));
                data.setPenerbit(String.valueOf(rs.getObject(7)));
                dataTest.add(data);
            }
            DefaultTableModel model = (DefaultTableModel) jTableBuku.getModel();
            model.setRowCount(0);
            for (Test data : dataTest) {

                Object[] baris = new Object[7];
                baris[0] = data.getIsbn();
                baris[1] = data.getJudul();
                baris[2] = data.getSubjudul();
                baris[3] = data.getPengarang();
                baris[4] = data.getTahun();
                baris[5] = data.getHalaman();
                baris[6] = data.getPenerbit();

                model.addRow(baris);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BukuP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Creates new form BukuP
     */
    JPanel Pnutama;
    public BukuP(JPanel pn) {
        try {
            dataTest = new ArrayList<>();
            initComponents();
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Akhir", "postgres", "bajumuslim");
            Tampil(conn);
        } catch (SQLException ex) {
            Logger.getLogger(BukuP.class.getName()).log(Level.SEVERE, null, ex);
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
        jTableBuku = new javax.swing.JTable();
        InsertOtakatik = new javax.swing.JButton();
        PrintBuku = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jTextFieldSearch = new javax.swing.JTextField();
        jComboBoxSearch = new javax.swing.JComboBox<>();
        jButtonCari = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(153, 102, 0));

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel1.setText("Buku");

        jTableBuku.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "isbn", "judul", "subjudul", "pengarang", "tahun", "halaman", "penerbit"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableBuku);

        InsertOtakatik.setText("Otak Atik");
        InsertOtakatik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertOtakatikActionPerformed(evt);
            }
        });

        PrintBuku.setText("Print");

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        jTextFieldSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSearchActionPerformed(evt);
            }
        });

        jComboBoxSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "isbn", "judul", "subjudul", "pengarang", "tahun", "halaman", "penerbit" }));
        jComboBoxSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSearchActionPerformed(evt);
            }
        });

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
                        .addComponent(InsertOtakatik)
                        .addGap(18, 18, 18)
                        .addComponent(PrintBuku)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCari, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonCari)
                        .addComponent(jComboBoxSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(InsertOtakatik)
                    .addComponent(PrintBuku))
                .addGap(20, 20, 20))
        );

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSearchActionPerformed

    private void InsertOtakatikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertOtakatikActionPerformed
        Pnutama.removeAll();
        Pnutama.add(new PerbaruiBuku());
        Pnutama.repaint();
        Pnutama.revalidate();
    }//GEN-LAST:event_InsertOtakatikActionPerformed

    private void jComboBoxSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxSearchActionPerformed

    private void jButtonCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCariActionPerformed
        cariData();
    }//GEN-LAST:event_jButtonCariActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton InsertOtakatik;
    private javax.swing.JButton PrintBuku;
    private javax.swing.JButton jButtonCari;
    private javax.swing.JComboBox<String> jComboBoxSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTableBuku;
    private javax.swing.JTextField jTextFieldSearch;
    // End of variables declaration//GEN-END:variables
}
