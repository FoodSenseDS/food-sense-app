/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import app.dialog.editCourrierDialog;
import app.dialog.editSellerDialog;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import com.google.gson.Gson;
import helper.checkSession;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.Seller;
import model.Customer;
import model.Courrier;

/**
 *
 * @author febib
 */
public class AdminApp extends javax.swing.JFrame {
    public String sellerId;
    public String customerId;
    public String courrierId;
    
    public void hideAllButton(){
        editCourrierBtn.setVisible(false);
        editSellerBtn.setVisible(false);
        
        deleteCourrierBtn.setVisible(false);
        deleteCustomerBtn.setVisible(false);
        deleteSellerBtn.setVisible(false);
    }
    public void fetchAllSellerData(){
        try {
            HttpRequest getRequest = HttpRequest.newBuilder()
                    .uri(new URI("https://foodsenseapi-demo.azuremicroservices.io/foodsense/api/v0.0.1/seller/get"))
                    .header("Content-Type", "application/json")
                    .build();
            
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpResponse<String> getResponse = httpClient.send(getRequest, BodyHandlers.ofString());
            
            Gson gson = new Gson();
            Seller[] sellers = gson.fromJson(getResponse.body(), Seller[].class);
            
            DefaultTableModel tblModel = (DefaultTableModel) sellerDataTbl.getModel();
            tblModel.setRowCount(0);
            for (Seller seller : sellers) {
                Object[] rowData = {seller.getSellerId(), seller.getFullName(), seller.getAddress(), seller.getEmail(), seller.getPhoneNumber()};
                tblModel.addRow(rowData);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void fetchAllCustomerData(){
        try {
            HttpRequest getRequest = HttpRequest.newBuilder()
                    .uri(new URI("https://foodsenseapi-demo.azuremicroservices.io/foodsense/api/v0.0.1/customer/get"))
                    .header("Content-Type", "application/json")
                    .build();
            
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpResponse<String> getResponse = httpClient.send(getRequest, BodyHandlers.ofString());
            
            Gson gson = new Gson();
            Customer[] customers = gson.fromJson(getResponse.body(), Customer[].class);
            
            DefaultTableModel tblModel = (DefaultTableModel) customerDataTbl.getModel();
            tblModel.setRowCount(0);
            for (Customer customer : customers) {
                Object[] rowData = {customer.getCustomerId(), customer.getFullName(), customer.getEmail(), customer.getPhone_number(), customer.getAddress()};
                tblModel.addRow(rowData);
            }
            
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void fetchAllCourrierData(){
        try {
            HttpRequest getRequest = HttpRequest.newBuilder()
                    .uri(new URI("https://foodsenseapi-demo.azuremicroservices.io/foodsense/api/v0.0.1/courier/get"))
                    .header("Content-Type", "application/json")
                    .build();
            
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpResponse<String> getResponse = httpClient.send(getRequest, BodyHandlers.ofString());
            
            Gson gson = new Gson();
            Courrier[] courriers = gson.fromJson(getResponse.body(), Courrier[].class);
            
            DefaultTableModel tblModel = (DefaultTableModel) courrierDataTbl.getModel();
            tblModel.setRowCount(0);
            for (Courrier courrier : courriers){
                String status = courrier.isOn_delivery() ? "Sedang Mengantarkan" : "Tidak Sedang Mengantarkan";
                
                Object[] rowData = {courrier.getCourierId(), courrier.getFullName(), courrier.getEmail(), courrier.getPhone_number(),
                status};
                tblModel.addRow(rowData);
            }
            
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public AdminApp() {
        initComponents();
        
        fetchAllSellerData();
        fetchAllCustomerData();
        fetchAllCourrierData();
        
        hideAllButton();
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
        jPanel5 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        sellerDataTbl = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        editSellerBtn = new javax.swing.JButton();
        deleteSellerBtn = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        customerDataTbl = new javax.swing.JTable();
        deleteCustomerBtn = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        courrierDataTbl = new javax.swing.JTable();
        editCourrierBtn = new javax.swing.JButton();
        deleteCourrierBtn = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel10 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jTextField18 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 100));
        jPanel2.setForeground(new java.awt.Color(0, 0, 100));

        jTabbedPane1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setForeground(new java.awt.Color(0, 0, 100));

        sellerDataTbl.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        sellerDataTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Address", "E-mail", "Phone Number"
            }
        ));
        sellerDataTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sellerDataTblMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(sellerDataTbl);

        jLabel16.setBackground(new java.awt.Color(0, 0, 100));
        jLabel16.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 100));
        jLabel16.setText("Seller Data");

        editSellerBtn.setText("Edit");
        editSellerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editSellerBtnActionPerformed(evt);
            }
        });

        deleteSellerBtn.setText("Delete");
        deleteSellerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteSellerBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 869, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(455, 455, 455)
                        .addComponent(jLabel16))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(413, 413, 413)
                        .addComponent(editSellerBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deleteSellerBtn)))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editSellerBtn)
                    .addComponent(deleteSellerBtn))
                .addGap(35, 35, 35))
        );

        jTabbedPane1.addTab("Seller", jPanel7);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jLabel17.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel17.setText("Customer Data");
        jLabel17.setMaximumSize(new java.awt.Dimension(61, 15));
        jLabel17.setMinimumSize(new java.awt.Dimension(61, 15));

        customerDataTbl.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        customerDataTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "E-mail", "Phone Number", "Address"
            }
        ));
        customerDataTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customerDataTblMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(customerDataTbl);

        deleteCustomerBtn.setText("Delete");
        deleteCustomerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteCustomerBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(547, 547, 547))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 930, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(125, 125, 125))))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(439, 439, 439)
                .addComponent(deleteCustomerBtn)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(deleteCustomerBtn)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Customer", jPanel8);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        courrierDataTbl.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        courrierDataTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "E-mail", "Phone Number", "Status"
            }
        ));
        courrierDataTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                courrierDataTblMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(courrierDataTbl);

        editCourrierBtn.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        editCourrierBtn.setText("Edit");
        editCourrierBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editCourrierBtnActionPerformed(evt);
            }
        });

        deleteCourrierBtn.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        deleteCourrierBtn.setText("Delete");
        deleteCourrierBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteCourrierBtnActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel14.setText("Courrier Data");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addGap(556, 556, 556))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(436, 436, 436)
                .addComponent(editCourrierBtn)
                .addGap(18, 18, 18)
                .addComponent(deleteCourrierBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 930, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(133, 133, 133))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel14)
                .addGap(24, 24, 24)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editCourrierBtn)
                    .addComponent(deleteCourrierBtn))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Courrier", jPanel6);

        jTabbedPane2.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane2.setForeground(new java.awt.Color(0, 0, 100));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setForeground(new java.awt.Color(255, 255, 255));

        jLabel3.setText("Seller Name");

        jLabel4.setText("Restaurant");

        jLabel5.setText("Seller Address");

        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });

        jLabel6.setText("Email");

        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });

        jLabel7.setText("Phone Number");

        jTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10ActionPerformed(evt);
            }
        });

        jTextField11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField11ActionPerformed(evt);
            }
        });

        jTextField12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField12ActionPerformed(evt);
            }
        });

        jButton9.setText("Save");

        jButton10.setText("Cancel");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(438, 438, 438)
                        .addComponent(jButton9)
                        .addGap(31, 31, 31)
                        .addComponent(jButton10))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(203, 203, 203)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(49, 49, 49)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(213, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton9)
                    .addComponent(jButton10))
                .addGap(0, 78, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Seller", jPanel10);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setForeground(new java.awt.Color(255, 255, 255));

        jLabel8.setText("Courrier Name");

        jButton11.setText("Save");

        jLabel9.setText("Email");

        jButton12.setText("Cancel");

        jLabel10.setText("Phone Number");

        jTextField13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField13ActionPerformed(evt);
            }
        });

        jTextField14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField14ActionPerformed(evt);
            }
        });

        jTextField18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField18ActionPerformed(evt);
            }
        });

        jTextField15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField15ActionPerformed(evt);
            }
        });

        jLabel13.setText("Status");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(203, 203, 203)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10)
                    .addComponent(jLabel13))
                .addGap(49, 49, 49)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField18, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                    .addComponent(jTextField13, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                    .addComponent(jTextField14, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                    .addComponent(jTextField15, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE))
                .addContainerGap(213, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addComponent(jButton11)
                .addGap(31, 31, 31)
                .addComponent(jButton12)
                .addGap(334, 334, 334))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(107, 107, 107)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton11)
                    .addComponent(jButton12))
                .addGap(0, 60, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Courrier", jPanel11);

        jTabbedPane1.addTab("Setting", jTabbedPane2);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("FoodSense");
        jLabel1.setToolTipText("");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Perpetua Titling MT", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Administrator");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(403, 403, 403)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(435, 435, 435)
                        .addComponent(jLabel2))
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 960, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editCourrierBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editCourrierBtnActionPerformed
        editCourrierDialog editCourrierDialog = new editCourrierDialog(this, true, courrierId);
        editCourrierDialog.setVisible(true);
    }//GEN-LAST:event_editCourrierBtnActionPerformed

    private void jTextField15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField15ActionPerformed

    private void jTextField18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField18ActionPerformed

    private void jTextField14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField14ActionPerformed

    private void jTextField13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField13ActionPerformed

    private void jTextField12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12ActionPerformed

    private void jTextField11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11ActionPerformed

    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10ActionPerformed

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void sellerDataTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sellerDataTblMouseClicked
        DefaultTableModel tblModel = (DefaultTableModel) sellerDataTbl.getModel();
        int selectedRow = sellerDataTbl.getSelectedRow();
        if (selectedRow != -1) {
            editSellerBtn.setVisible(true);
            deleteSellerBtn.setVisible(true);
        
            Object idValue = tblModel.getValueAt(selectedRow, 0);
            if (idValue != null) {
                sellerId = idValue.toString();
            }
        }
        else {
            editSellerBtn.setVisible(false);
            deleteSellerBtn.setVisible(false);
        }
    }//GEN-LAST:event_sellerDataTblMouseClicked

    private void courrierDataTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_courrierDataTblMouseClicked
        DefaultTableModel tblModel = (DefaultTableModel) courrierDataTbl.getModel();
        int selectedRow = courrierDataTbl.getSelectedRow();
        if (selectedRow != -1) {
            editCourrierBtn.setVisible(true);
            deleteCourrierBtn.setVisible(true);
        
            Object idValue = tblModel.getValueAt(selectedRow, 0);
            if (idValue != null) {
                courrierId = idValue.toString();
            }
        }
        else {
            editCourrierBtn.setVisible(false);
            deleteCourrierBtn.setVisible(false);
        }
    }//GEN-LAST:event_courrierDataTblMouseClicked

    private void deleteCourrierBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteCourrierBtnActionPerformed
        DefaultTableModel tblModel = (DefaultTableModel) courrierDataTbl.getModel();
        int selectedRow = courrierDataTbl.getSelectedRow();
        if (selectedRow != -1) {  
            Object idValue = tblModel.getValueAt(selectedRow, 0);
            if (idValue != null) {
                courrierId = idValue.toString();
                
                try {
                    HttpRequest getRequest = HttpRequest.newBuilder()
                            .uri(new URI("https://foodsenseapi-demo.azuremicroservices.io/foodsense/api/v0.0.1/courier/delete/" + courrierId))
                            .DELETE()
                            .build();

                    HttpClient httpClient = HttpClient.newHttpClient();
                    HttpResponse<String> getResponse = httpClient.send(getRequest, BodyHandlers.ofString());

                    if(getResponse.statusCode() == 200 || getResponse.body().equals("Courrier successfully deleted")){
                        JOptionPane.showMessageDialog(this, "Data Courrier Sudah Dihapus");
                        tblModel.setRowCount(0);
                        fetchAllCourrierData();
                    }

                }
                catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }
        else {
            editCourrierBtn.setVisible(false);
            deleteCourrierBtn.setVisible(false);
        }
    }//GEN-LAST:event_deleteCourrierBtnActionPerformed

    private void editSellerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editSellerBtnActionPerformed
        editSellerDialog editSellerDialog = new editSellerDialog(this, true, sellerId);
        editSellerDialog.setVisible(true);
    }//GEN-LAST:event_editSellerBtnActionPerformed

    private void deleteSellerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteSellerBtnActionPerformed
        DefaultTableModel tblModel = (DefaultTableModel) sellerDataTbl.getModel();
        int selectedRow = sellerDataTbl.getSelectedRow();
        if (selectedRow != -1) {  
            Object idValue = tblModel.getValueAt(selectedRow, 0);
            if (idValue != null) {
                sellerId = idValue.toString();
                
                try {
                    HttpRequest getRequest = HttpRequest.newBuilder()
                            .uri(new URI("https://foodsenseapi-demo.azuremicroservices.io/foodsense/api/v0.0.1/seller/delete/" + sellerId))
                            .DELETE()
                            .build();

                    HttpClient httpClient = HttpClient.newHttpClient();
                    HttpResponse<String> getResponse = httpClient.send(getRequest, BodyHandlers.ofString());


                    if(getResponse.statusCode() == 200 || getResponse.body().equals("Seller successfully deleted")){
                        JOptionPane.showMessageDialog(this, "Data Seller Sudah Dihapus");
                        tblModel.setRowCount(0);
                        fetchAllSellerData();
                    }

                }
                catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }
        else {
            editSellerBtn.setVisible(false);
            deleteSellerBtn.setVisible(false);
        }
    }//GEN-LAST:event_deleteSellerBtnActionPerformed

    private void deleteCustomerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteCustomerBtnActionPerformed
        DefaultTableModel tblModel = (DefaultTableModel) customerDataTbl.getModel();
        int selectedRow = customerDataTbl.getSelectedRow();
        if (selectedRow != -1) {
            Object idValue = tblModel.getValueAt(selectedRow, 0);
            if (idValue != null) {
                customerId = idValue.toString();

                try {
                    HttpRequest getRequest = HttpRequest.newBuilder()
                    .uri(new URI("https://foodsenseapi-demo.azuremicroservices.io/foodsense/api/v0.0.1/customer/delete/" + customerId))
                    .DELETE()
                    .build();

                    HttpClient httpClient = HttpClient.newHttpClient();
                    HttpResponse<String> getResponse = httpClient.send(getRequest, BodyHandlers.ofString());

                    if(getResponse.statusCode() == 200 || getResponse.body().equals("Customer successfully deleted")){
                        JOptionPane.showMessageDialog(this, "Data Customer Sudah Dihapus");
                        tblModel.setRowCount(0);
                        fetchAllCustomerData();
                    }

                }
                catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }
        else {
            deleteCustomerBtn.setVisible(false);
        }
    }//GEN-LAST:event_deleteCustomerBtnActionPerformed

    private void customerDataTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerDataTblMouseClicked
        deleteCustomerBtn.setVisible(true);
    }//GEN-LAST:event_customerDataTblMouseClicked

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
            java.util.logging.Logger.getLogger(AdminApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminApp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable courrierDataTbl;
    private javax.swing.JTable customerDataTbl;
    private javax.swing.JButton deleteCourrierBtn;
    private javax.swing.JButton deleteCustomerBtn;
    private javax.swing.JButton deleteSellerBtn;
    private javax.swing.JButton editCourrierBtn;
    private javax.swing.JButton editSellerBtn;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTable sellerDataTbl;
    // End of variables declaration//GEN-END:variables
}
