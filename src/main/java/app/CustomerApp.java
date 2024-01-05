/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import helper.Cart;
import helper.OrderItem;
import helper.checkSession;
import helper.selectedSeller;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Courrier;
import model.Customer;
import model.Product;
import model.Seller;

/**
 *
 * @author febib
 */
public class CustomerApp extends javax.swing.JFrame {
    DefaultListModel<String> menuListModel = new DefaultListModel<>();
    List<Cart> cartList = new ArrayList<>();
    OrderItem orderItem = new OrderItem();
    JsonObject requestJson = new JsonObject();
    JsonArray orderItemsArray = new JsonArray();
    
    public void showCartToTable(){
        DefaultTableModel tblModel = (DefaultTableModel) cartTable.getModel();
        tblModel.setRowCount(0);
        
        List<Cart> orderItemsList = orderItem.getOrderItems();
        
        if(orderItemsList != null){
            System.out.println("Datanya ada");
            for (Cart productInCart : orderItemsList) {
                String[] tblData = {
                    productInCart.getProductName(),
                    String.valueOf(productInCart.getProductPrice()),
                    String.valueOf(productInCart.getQuantity()),
                    String.valueOf(productInCart.getSubtotal())
                };

                tblModel.addRow(tblData);
            }
        }
        else {
            System.out.println("Masih Kosong");
        }
    }
    
    public void fetchSingleCustomerData(){
        try {
            HttpRequest getRequest = HttpRequest.newBuilder()
                    .uri(new URI("https://foodsenseapi-demo.azuremicroservices.io/foodsense/api/v0.0.1/customer/get/" + checkSession.getId()))
                    .header("Content-Type", "application/json")
                    .build();
            
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpResponse<String> getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());
            
            Gson gson = new Gson();
            Customer customer = gson.fromJson(getResponse.body(), Customer.class);
            
            if(customer != null){
                nameInput.setText(customer.getFullName());
                phoneNumberInput.setText(customer.getPhone_number());
                emailInput.setText(customer.getEmail());
                addressInput.setText(customer.getAddress());
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void fetchAllSellerData(){
        try {
            HttpRequest getRequest = HttpRequest.newBuilder()
                    .uri(new URI("https://foodsenseapi-demo.azuremicroservices.io/foodsense/api/v0.0.1/seller/get"))
                    .header("Content-Type", "application/json")
                    .build();
            
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpResponse<String> getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());
            
            Gson gson = new Gson();
            Seller[] sellers = gson.fromJson(getResponse.body(), Seller[].class);
            
            DefaultTableModel tblModel = (DefaultTableModel) sellerDataTbl.getModel();
            tblModel.setRowCount(0);
            for (Seller seller : sellers) {
                Object[] rowData = {seller.getSellerId(), seller.getFullName()};
                tblModel.addRow(rowData);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void fetchSellerProducts(){
        try {
            HttpRequest getRequest = HttpRequest.newBuilder()
                    .uri(new URI("https://foodsenseapi-demo.azuremicroservices.io/foodsense/api/v0.0.1/seller/get/product/" + selectedSeller.getId()))
                    .header("Content-Type", "application/json")
                    .build();
            
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpResponse<String> getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());
            
            Gson gson = new Gson();
            Product[] products = gson.fromJson(getResponse.body(), Product[].class);
            
            menuListModel.clear();
            if(products != null){
                for (Product product : products) {
                    long productId = product.getProductId();
                    String productName = product.getProductName();
                    menuListModel.addElement(productId + "-" + productName);
                }
            }
            
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public CustomerApp() {
        initComponents();
        menuList.setModel(menuListModel);
        fetchSingleCustomerData();
        fetchAllSellerData();
        showCartToTable();
        customerNamePlaceholder.setText("Hi, " + checkSession.getName());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        cartTable = new javax.swing.JTable();
        deleteBtn = new javax.swing.JButton();
        checkoutBtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        menuList = new javax.swing.JList<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        quantityInput = new javax.swing.JSpinner();
        addToCartBtn = new javax.swing.JButton();
        menuNamePlaceholder = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        menuDescriptionPlaceholder = new javax.swing.JTextArea();
        menuPricePlaceholder = new javax.swing.JSpinner();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        sellerDataTbl = new javax.swing.JTable();
        customerNamePlaceholder = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        phoneNumberInput = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        nameInput = new javax.swing.JTextField();
        saveBtn = new javax.swing.JButton();
        addressInput = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        emailInput = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Restaurant", "Description", "Distance"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.Long.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setCellSelectionEnabled(true);
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 100));
        jPanel1.setForeground(new java.awt.Color(0, 0, 100));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("FoodSense");

        jTabbedPane1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        cartTable.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cartTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Menu", "Price", "Quantity", "Sub Total"
            }
        ));
        jScrollPane5.setViewportView(cartTable);

        deleteBtn.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        checkoutBtn.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        checkoutBtn.setText("Checkout");
        checkoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkoutBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(432, Short.MAX_VALUE)
                .addComponent(checkoutBtn)
                .addGap(18, 18, 18)
                .addComponent(deleteBtn)
                .addGap(384, 384, 384))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(88, 88, 88)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 779, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(121, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(336, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkoutBtn)
                    .addComponent(deleteBtn))
                .addGap(72, 72, 72))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(46, 46, 46)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(129, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Cart", jPanel4);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        menuList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuListMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(menuList);

        jLabel6.setText("Description");

        jLabel7.setText("Price");

        addToCartBtn.setText("Add to Cart");
        addToCartBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToCartBtnActionPerformed(evt);
            }
        });

        menuDescriptionPlaceholder.setColumns(20);
        menuDescriptionPlaceholder.setRows(5);
        jScrollPane7.setViewportView(menuDescriptionPlaceholder);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(18, 230, Short.MAX_VALUE)
                        .addComponent(addToCartBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(quantityInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(235, 235, 235))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(menuNamePlaceholder, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(menuPricePlaceholder, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(menuNamePlaceholder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(menuPricePlaceholder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(quantityInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addToCartBtn))))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Menu", jPanel3);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        sellerDataTbl.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        sellerDataTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Restaurant"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Long.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        sellerDataTbl.setCellSelectionEnabled(true);
        sellerDataTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sellerDataTblMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(sellerDataTbl);
        sellerDataTbl.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (sellerDataTbl.getColumnModel().getColumnCount() > 0) {
            sellerDataTbl.getColumnModel().getColumn(0).setResizable(false);
            sellerDataTbl.getColumnModel().getColumn(1).setResizable(false);
        }

        customerNamePlaceholder.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        customerNamePlaceholder.setText("Hi, (nama cust)");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("What are you craving today?");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Here's a restaurant recommendation for you: ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(customerNamePlaceholder)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(customerNamePlaceholder)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Home", jPanel2);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setBackground(new java.awt.Color(0, 0, 100));
        jLabel18.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 100));
        jPanel5.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 25, -1, -1));
        jPanel5.add(phoneNumberInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 496, -1));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel11.setText("Name");
        jPanel5.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, -1, -1));

        jLabel12.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel12.setText("Phone Number");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, -1, -1));

        jLabel16.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel16.setText("Address");
        jPanel5.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, -1, -1));

        nameInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameInputActionPerformed(evt);
            }
        });
        jPanel5.add(nameInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, 496, -1));

        saveBtn.setText("Save");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });
        jPanel5.add(saveBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 310, -1, -1));
        jPanel5.add(addressInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, 496, 100));

        jLabel24.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel24.setText("Email");
        jPanel5.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, -1, -1));
        jPanel5.add(emailInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 496, -1));

        jTabbedPane1.addTab("Setting", jPanel5);

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Perpetua Titling MT", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Delight Your Senses, Nourish Your Soul");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(416, 416, 416))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(324, 324, 324))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkoutBtnActionPerformed
        List<Cart> orderItemsList = orderItem.getOrderItems();
        for (Cart cart : orderItemsList) {
            JsonObject orderItemJson = new JsonObject();
            orderItemJson.addProperty("productId", cart.getProductId());
            orderItemJson.addProperty("quantity", cart.getQuantity());
            orderItemsArray.add(orderItemJson);
        }

        requestJson.add("orderItems", orderItemsArray);

        Gson gson = new Gson();
        String jsonRequest = gson.toJson(requestJson);

        try {
            HttpRequest getRequest = HttpRequest.newBuilder()
                    .uri(new URI("https://foodsenseapi-demo.azuremicroservices.io/foodsense/api/v0.0.1/order/placeOrder?customerId=" + checkSession.getId()))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonRequest))
                    .build();
            
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpResponse<String> getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());
            
            if(getResponse.statusCode() == 200){
                JOptionPane.showMessageDialog(this, "Berhasil Memesan!");
            }
            else {
                System.out.println(getResponse.body());
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_checkoutBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        Customer customer = new Customer();
        customer.setFullName(nameInput.getText());
        customer.setEmail(emailInput.getText());
        customer.setPhone_number(phoneNumberInput.getText());
        customer.setAddress(addressInput.getText());
        
        Gson gson = new Gson();
        String jsonRequest = gson.toJson(customer);
        
        try {
            HttpRequest getRequest = HttpRequest.newBuilder()
                    .uri(new URI("https://foodsenseapi-demo.azuremicroservices.io/foodsense/api/v0.0.1/customer/update/" + checkSession.getId()))
                    .header("Content-Type", "application/json")
                    .PUT(HttpRequest.BodyPublishers.ofString(jsonRequest))
                    .build();
            
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpResponse<String> getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());
            
            if(getResponse.statusCode() == 200 || getResponse.body().equals("Customer successfully updated")){
                JOptionPane.showMessageDialog(this, "Data Customer Berhasil Diupdate");
            }
            else {
                System.out.println(getResponse.body());
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_saveBtnActionPerformed

    private void nameInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameInputActionPerformed

    private void sellerDataTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sellerDataTblMouseClicked
        DefaultTableModel tblModel = (DefaultTableModel) sellerDataTbl.getModel();
        int selectedRow = sellerDataTbl.getSelectedRow();
        if (selectedRow != -1) {
            selectedSeller.setId(tblModel.getValueAt(selectedRow, 0).toString());
            fetchSellerProducts();
        }
    }//GEN-LAST:event_sellerDataTblMouseClicked

    private void menuListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuListMouseClicked
        String productId = menuList.getSelectedValue().split("-")[0];
        
        try {
            HttpRequest getRequest = HttpRequest.newBuilder()
                    .uri(new URI("https://foodsenseapi-demo.azuremicroservices.io/foodsense/api/v0.0.1/product/get/" + productId))
                    .header("Content-Type", "application/json")
                    .build();
            
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpResponse<String> getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());
            
            Gson gson = new Gson();
            Product product = gson.fromJson(getResponse.body(), Product.class);
            
            if(product != null){
                menuNamePlaceholder.setText(product.getProductName());
                menuDescriptionPlaceholder.setText(product.getProductDescription());
                menuPricePlaceholder.setValue(product.getProductUnitPrice());
            }
            
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_menuListMouseClicked

    private void addToCartBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToCartBtnActionPerformed
        String productId = menuList.getSelectedValue().split("-")[0];
        
        Cart cart = new Cart();
        cart.setProductId(productId);
        cart.setProductName(menuNamePlaceholder.getText());
        cart.setProductPrice((double) menuPricePlaceholder.getValue());
        cart.setQuantity((int) quantityInput.getValue());
        cart.setSubtotal(cart.getProductPrice() * cart.getQuantity());
        cartList.add(cart);
        orderItem.setOrderItems(cartList);
        
        quantityInput.setValue(0);
        
        JOptionPane.showMessageDialog(this, "Berhasil Menambahkan Produk ke Keranjang");
        showCartToTable();
    }//GEN-LAST:event_addToCartBtnActionPerformed

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
            java.util.logging.Logger.getLogger(CustomerApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerApp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addToCartBtn;
    private javax.swing.JTextField addressInput;
    private javax.swing.JTable cartTable;
    private javax.swing.JButton checkoutBtn;
    private javax.swing.JLabel customerNamePlaceholder;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JTextField emailInput;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea menuDescriptionPlaceholder;
    private javax.swing.JList<String> menuList;
    private javax.swing.JTextField menuNamePlaceholder;
    private javax.swing.JSpinner menuPricePlaceholder;
    private javax.swing.JTextField nameInput;
    private javax.swing.JTextField phoneNumberInput;
    private javax.swing.JSpinner quantityInput;
    private javax.swing.JButton saveBtn;
    private javax.swing.JTable sellerDataTbl;
    // End of variables declaration//GEN-END:variables
}
