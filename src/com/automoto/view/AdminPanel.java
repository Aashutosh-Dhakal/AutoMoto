/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.automoto.view;

import com.automoto.controller.algorithms.BinarySearch;
import com.automoto.controller.algorithms.InsertionSort;
import com.automoto.controller.algorithms.MergeSort;
import com.automoto.controller.algorithms.SelectionSort;
import com.automoto.model.BikeModel;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aashutoshdhakal
 */
public class AdminPanel extends javax.swing.JFrame {

    public LinkedList<BikeModel> bikeList = new LinkedList<>();

    public void addBikes(BikeModel bikes) {
        bikeList.add(bikes);
        DefaultTableModel model = (DefaultTableModel) tblBikeData.getModel();
        Object[] data = new Object[]{
            bikes.getBikeNumber(), bikes.getModel(), bikes.getCondition(),
            bikes.getPrice(), bikes.getType(), bikes.getStatus()
        };
        model.addRow(data);
    }

    private boolean checkBikeNo(BikeModel bikes) {
        for (BikeModel remainingBikes : bikeList) {
            if (remainingBikes.getBikeNumber().equals(bikes.getBikeNumber())) {
                return true;
            }
        }
        return false;
    }

    private boolean deleteBikes(String bikeNumber, int selectedRow) {
        Iterator<BikeModel> iterator = bikeList.iterator();
        while (iterator.hasNext()) {
            BikeModel bikes = iterator.next();
            if (bikes.getBikeNumber().equals(bikeNumber)) {
                // Remove the member from the list
                iterator.remove();

                // Also remove the row from the table
                DefaultTableModel model = (DefaultTableModel) tblBikeData.getModel();
                model.removeRow(selectedRow);
                return true; // Member deleted successfully
            }
        }
        return false; // No member found with the given ID
    }

    private void initialBikes() {
        BikeModel bike1 = new BikeModel("B1234", "Royal Enflied Metor 350", "Good", 6000, "Bike");
        addBikes(bike1);
        BikeModel bike2 = new BikeModel("B1347", "Aprilla 150", "Fair", 3000, "Scooter");
        addBikes(bike2);
        BikeModel bike3 = new BikeModel("B8456", "Honda Shine", "Poor", 2000, "Bike");
        addBikes(bike3);
        BikeModel bike4 = new BikeModel("B7445", "Ntorq 150", "Good", 4000, "Scooter");
        addBikes(bike4);
        BikeModel bike5 = new BikeModel("B3667", "Royal Enflied Classic 350", "Fair", 5000, "Bike");
        addBikes(bike5);
        BikeModel bike6 = new BikeModel("B3656", "Honda Dio 100", "Fair", 1000, "Scooter");
        addBikes(bike6);
        BikeModel bike7 = new BikeModel("B8458", "Duke 300", "Best", 6000, "Bike");
        addBikes(bike7);
        BikeModel bike8 = new BikeModel("B3634", "Hero Super Splender 125", "Fair", 2000, "Bike");
        addBikes(bike8);
        BikeModel bike9 = new BikeModel("B0987", "Vespa 125", "Poor", 3000, "Scooter");
        addBikes(bike9);
        BikeModel bike10 = new BikeModel("B1209", "Hero Pleasure Plus 125", "Good", 3000, "Scooter");
        addBikes(bike10);
    }

    private void updateBikes() {
        DefaultTableModel model = (DefaultTableModel) tblBikeData.getModel();

        // Clear the table before loading new data
        model.setRowCount(0);

        // Iterate through the LinkedList and add each member to the table
        for (BikeModel bike : bikeList) {
            model.addRow(new Object[]{
                bike.getBikeNumber(),
                bike.getModel(),
                bike.getCondition(),
                bike.getPrice(),
                bike.getType(),
                bike.getStatus()

            });
        }
    }

    private void SortedData(List<BikeModel> sortedData) {
        DefaultTableModel model = (DefaultTableModel) tblBikeData.getModel();

        // Clear the table before loading new data
        model.setRowCount(0);

        // Iterate through the LinkedList and add each member to the table
        for (BikeModel bikes : sortedData) {
            model.addRow(new Object[]{
                bikes.getBikeNumber(),
                bikes.getModel(),
                bikes.getCondition(),
                bikes.getPrice(),
                bikes.getType(),
                bikes.getStatus(),});
        }
    }

    /**
     * Creates new form AdminPanel
     */
    public AdminPanel() {
        initComponents();
        panelAdminPanelHome.setVisible(true);
        panelAdminPanelRentalUpdateButton.setVisible(false);
        panelAdminPanelRentalDeleteButton.setVisible(false);
        panelAdminPanelBikeAddButton.setVisible(false);
        panelAdminPanelBikeUpdateButton.setVisible(false);
        panelAdminPanelBikeDeleteButton.setVisible(false);
        panelAdminPanelBike.setVisible(false);
        panelAdminPanelBikeAddBike.setVisible(false);
        labelWarningBikeNo.setVisible(false);
        labelWarningBikeModel.setVisible(false);
        labelWarningBikeCondition.setVisible(false);
        labelWarningBikePrice.setVisible(false);
        panelAdminPanelHomeDesign.setVisible(true);
        panelAdminPanelBikeUpdateBike.setVisible(false);
        labelWarningUpdateBikeNo.setVisible(false);
        labelWarningUpdateBikeModel.setVisible(false);
        labelWarningUpdateBikeCondition.setVisible(false);
        labelWarningUpdateBikePrice.setVisible(false);
        initialBikes();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelAdminPanel = new javax.swing.JPanel();
        labelAdminPanel = new javax.swing.JLabel();
        labelAdmin = new javax.swing.JLabel();
        buttonBikeManagement = new javax.swing.JButton();
        buttonRentalManagement = new javax.swing.JButton();
        buttonAdminPanelBack = new javax.swing.JButton();
        ButtonAdminPanelExit = new javax.swing.JButton();
        panelAdminPanelBikeAddBike = new javax.swing.JPanel();
        panelAdminPanelBikeAddBikePanel = new javax.swing.JPanel();
        labelEnterYourBikeDetail = new javax.swing.JLabel();
        fieldBikeNo = new javax.swing.JTextField();
        fieldBikeModel = new javax.swing.JTextField();
        fieldBikeCondition = new javax.swing.JTextField();
        fieldBikePrice = new javax.swing.JTextField();
        comboBoxBikeType = new javax.swing.JComboBox<>();
        buttonClear = new javax.swing.JButton();
        buttonAdd = new javax.swing.JButton();
        labelWarningBikeNo = new javax.swing.JLabel();
        labelWarningBikeModel = new javax.swing.JLabel();
        labelWarningBikeCondition = new javax.swing.JLabel();
        labelWarningBikePrice = new javax.swing.JLabel();
        labelAdminPanelBikeAddBike = new javax.swing.JLabel();
        panelAdminPanelBikeUpdateBike = new javax.swing.JPanel();
        panelAdminPanelBikeUpdateBikePanel = new javax.swing.JPanel();
        labelUpdateBikeDetail = new javax.swing.JLabel();
        fieldUpdateBikeNo = new javax.swing.JTextField();
        fieldUpdateBikeModel = new javax.swing.JTextField();
        fieldUpdateBikeCondition = new javax.swing.JTextField();
        fieldUpdateBikePrice = new javax.swing.JTextField();
        comboBoxUpdateBikeType = new javax.swing.JComboBox<>();
        buttonUpdateClear = new javax.swing.JButton();
        buttonUpdate = new javax.swing.JButton();
        labelWarningUpdateBikeNo = new javax.swing.JLabel();
        labelWarningUpdateBikeModel = new javax.swing.JLabel();
        labelWarningUpdateBikeCondition = new javax.swing.JLabel();
        labelWarningUpdateBikePrice = new javax.swing.JLabel();
        labelAdminPanelBikeUpdateBike = new javax.swing.JLabel();
        panelAdminPanelBike = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBikeData = new javax.swing.JTable();
        comboBoxAttribute = new javax.swing.JComboBox<>();
        buttonFilterDown = new javax.swing.JButton();
        buttonFilterUp = new javax.swing.JButton();
        textFieldSearch = new javax.swing.JTextField();
        buttonTextFieldSearch = new javax.swing.JButton();
        panelAdminPanelHome = new javax.swing.JPanel();
        iconAdminPanelHomeImage = new javax.swing.JLabel();
        panelAdminPanelHomeDesign = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelAdminPanelBikeAddButton = new javax.swing.JPanel();
        labelAdminPanelBikeAdd = new javax.swing.JLabel();
        panelAdminPanelBikeUpdateButton = new javax.swing.JPanel();
        labelAdminPanelBikeUpdate = new javax.swing.JLabel();
        panelAdminPanelBikeDeleteButton = new javax.swing.JPanel();
        labelAdminPanelBikeDelete = new javax.swing.JLabel();
        panelAdminPanelRentalUpdateButton = new javax.swing.JPanel();
        labelAdminPanelRentalUpdate = new javax.swing.JLabel();
        panelAdminPanelRentalDeleteButton = new javax.swing.JPanel();
        labelAdminPanelRentalDelete = new javax.swing.JLabel();
        iconAdminPanelBase = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1920, 1200));
        setMinimumSize(new java.awt.Dimension(1920, 1200));

        panelAdminPanel.setMaximumSize(new java.awt.Dimension(1920, 1200));
        panelAdminPanel.setMinimumSize(new java.awt.Dimension(1920, 1200));
        panelAdminPanel.setPreferredSize(new java.awt.Dimension(1920, 1200));
        panelAdminPanel.setLayout(null);

        labelAdminPanel.setFont(new java.awt.Font("Arial", 1, 52)); // NOI18N
        labelAdminPanel.setText("Admin Panel");
        panelAdminPanel.add(labelAdminPanel);
        labelAdminPanel.setBounds(840, 80, 350, 50);

        labelAdmin.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        labelAdmin.setText("Admin");
        panelAdminPanel.add(labelAdmin);
        labelAdmin.setBounds(150, 220, 160, 50);

        buttonBikeManagement.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        buttonBikeManagement.setText("Bike");
        buttonBikeManagement.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonBikeManagementMouseClicked(evt);
            }
        });
        panelAdminPanel.add(buttonBikeManagement);
        buttonBikeManagement.setBounds(110, 390, 240, 60);

        buttonRentalManagement.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        buttonRentalManagement.setText("Rental");
        buttonRentalManagement.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonRentalManagementMouseClicked(evt);
            }
        });
        buttonRentalManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRentalManagementActionPerformed(evt);
            }
        });
        panelAdminPanel.add(buttonRentalManagement);
        buttonRentalManagement.setBounds(110, 480, 240, 60);

        buttonAdminPanelBack.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        buttonAdminPanelBack.setText("Back");
        buttonAdminPanelBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonAdminPanelBackMouseClicked(evt);
            }
        });
        buttonAdminPanelBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAdminPanelBackActionPerformed(evt);
            }
        });
        panelAdminPanel.add(buttonAdminPanelBack);
        buttonAdminPanelBack.setBounds(110, 910, 240, 60);

        ButtonAdminPanelExit.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        ButtonAdminPanelExit.setText("Exit");
        ButtonAdminPanelExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonAdminPanelExitMouseClicked(evt);
            }
        });
        ButtonAdminPanelExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAdminPanelExitActionPerformed(evt);
            }
        });
        panelAdminPanel.add(ButtonAdminPanelExit);
        ButtonAdminPanelExit.setBounds(110, 1000, 240, 60);

        panelAdminPanelBikeAddBike.setBackground(new java.awt.Color(245, 245, 245));
        panelAdminPanelBikeAddBike.setMaximumSize(new java.awt.Dimension(1400, 732));
        panelAdminPanelBikeAddBike.setPreferredSize(new java.awt.Dimension(1400, 732));
        panelAdminPanelBikeAddBike.setSize(new java.awt.Dimension(1400, 732));
        panelAdminPanelBikeAddBike.setLayout(null);

        panelAdminPanelBikeAddBikePanel.setBackground(new java.awt.Color(226, 226, 226));
        panelAdminPanelBikeAddBikePanel.setLayout(null);

        labelEnterYourBikeDetail.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        labelEnterYourBikeDetail.setText("Enter Your Bike Detail");
        panelAdminPanelBikeAddBikePanel.add(labelEnterYourBikeDetail);
        labelEnterYourBikeDetail.setBounds(106, 19, 378, 42);

        fieldBikeNo.setBackground(new java.awt.Color(226, 226, 226));
        fieldBikeNo.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        fieldBikeNo.setBorder(javax.swing.BorderFactory.createTitledBorder("BIke No ."));
        panelAdminPanelBikeAddBikePanel.add(fieldBikeNo);
        fieldBikeNo.setBounds(20, 90, 561, 60);

        fieldBikeModel.setBackground(new java.awt.Color(226, 226, 226));
        fieldBikeModel.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        fieldBikeModel.setBorder(javax.swing.BorderFactory.createTitledBorder("Bike Model."));
        panelAdminPanelBikeAddBikePanel.add(fieldBikeModel);
        fieldBikeModel.setBounds(20, 190, 561, 60);

        fieldBikeCondition.setBackground(new java.awt.Color(226, 226, 226));
        fieldBikeCondition.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        fieldBikeCondition.setBorder(javax.swing.BorderFactory.createTitledBorder("Bike Condition"));
        panelAdminPanelBikeAddBikePanel.add(fieldBikeCondition);
        fieldBikeCondition.setBounds(20, 290, 561, 60);

        fieldBikePrice.setBackground(new java.awt.Color(226, 226, 226));
        fieldBikePrice.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        fieldBikePrice.setBorder(javax.swing.BorderFactory.createTitledBorder("Bike Price"));
        panelAdminPanelBikeAddBikePanel.add(fieldBikePrice);
        fieldBikePrice.setBounds(20, 390, 561, 60);

        comboBoxBikeType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bike Type", "Bike", "Scooter" }));
        panelAdminPanelBikeAddBikePanel.add(comboBoxBikeType);
        comboBoxBikeType.setBounds(30, 483, 540, 50);

        buttonClear.setBackground(new java.awt.Color(240, 84, 84));
        buttonClear.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        buttonClear.setText("Clear");
        buttonClear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonClearMouseClicked(evt);
            }
        });
        buttonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClearActionPerformed(evt);
            }
        });
        panelAdminPanelBikeAddBikePanel.add(buttonClear);
        buttonClear.setBounds(310, 560, 240, 51);

        buttonAdd.setBackground(new java.awt.Color(240, 84, 84));
        buttonAdd.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        buttonAdd.setText("Add");
        buttonAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonAddMouseClicked(evt);
            }
        });
        buttonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddActionPerformed(evt);
            }
        });
        panelAdminPanelBikeAddBikePanel.add(buttonAdd);
        buttonAdd.setBounds(50, 560, 240, 51);

        labelWarningBikeNo.setForeground(new java.awt.Color(255, 0, 51));
        labelWarningBikeNo.setText("Warning");
        panelAdminPanelBikeAddBikePanel.add(labelWarningBikeNo);
        labelWarningBikeNo.setBounds(30, 150, 523, 17);

        labelWarningBikeModel.setForeground(new java.awt.Color(255, 0, 51));
        labelWarningBikeModel.setText("Warning");
        panelAdminPanelBikeAddBikePanel.add(labelWarningBikeModel);
        labelWarningBikeModel.setBounds(30, 250, 537, 17);

        labelWarningBikeCondition.setForeground(new java.awt.Color(255, 0, 51));
        labelWarningBikeCondition.setText("Warning");
        panelAdminPanelBikeAddBikePanel.add(labelWarningBikeCondition);
        labelWarningBikeCondition.setBounds(30, 350, 537, 17);

        labelWarningBikePrice.setForeground(new java.awt.Color(255, 0, 51));
        labelWarningBikePrice.setText("Warning");
        panelAdminPanelBikeAddBikePanel.add(labelWarningBikePrice);
        labelWarningBikePrice.setBounds(30, 450, 537, 17);

        panelAdminPanelBikeAddBike.add(panelAdminPanelBikeAddBikePanel);
        panelAdminPanelBikeAddBikePanel.setBounds(110, 60, 600, 620);

        labelAdminPanelBikeAddBike.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/automoto/resources/AddBike.png"))); // NOI18N
        panelAdminPanelBikeAddBike.add(labelAdminPanelBikeAddBike);
        labelAdminPanelBikeAddBike.setBounds(0, 0, 1400, 732);

        panelAdminPanel.add(panelAdminPanelBikeAddBike);
        panelAdminPanelBikeAddBike.setBounds(440, 210, 1400, 732);

        panelAdminPanelBikeUpdateBike.setBackground(new java.awt.Color(245, 245, 245));
        panelAdminPanelBikeUpdateBike.setMaximumSize(new java.awt.Dimension(1400, 732));
        panelAdminPanelBikeUpdateBike.setPreferredSize(new java.awt.Dimension(1400, 732));
        panelAdminPanelBikeUpdateBike.setSize(new java.awt.Dimension(1400, 732));
        panelAdminPanelBikeUpdateBike.setLayout(null);

        panelAdminPanelBikeUpdateBikePanel.setBackground(new java.awt.Color(226, 226, 226));
        panelAdminPanelBikeUpdateBikePanel.setLayout(null);

        labelUpdateBikeDetail.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        labelUpdateBikeDetail.setText("Update Bike Detail");
        panelAdminPanelBikeUpdateBikePanel.add(labelUpdateBikeDetail);
        labelUpdateBikeDetail.setBounds(150, 20, 320, 42);

        fieldUpdateBikeNo.setBackground(new java.awt.Color(226, 226, 226));
        fieldUpdateBikeNo.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        fieldUpdateBikeNo.setBorder(javax.swing.BorderFactory.createTitledBorder("BIke No ."));
        panelAdminPanelBikeUpdateBikePanel.add(fieldUpdateBikeNo);
        fieldUpdateBikeNo.setBounds(20, 90, 561, 60);

        fieldUpdateBikeModel.setBackground(new java.awt.Color(226, 226, 226));
        fieldUpdateBikeModel.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        fieldUpdateBikeModel.setBorder(javax.swing.BorderFactory.createTitledBorder("Bike Model."));
        panelAdminPanelBikeUpdateBikePanel.add(fieldUpdateBikeModel);
        fieldUpdateBikeModel.setBounds(20, 190, 561, 60);

        fieldUpdateBikeCondition.setBackground(new java.awt.Color(226, 226, 226));
        fieldUpdateBikeCondition.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        fieldUpdateBikeCondition.setBorder(javax.swing.BorderFactory.createTitledBorder("Bike Condition"));
        panelAdminPanelBikeUpdateBikePanel.add(fieldUpdateBikeCondition);
        fieldUpdateBikeCondition.setBounds(20, 290, 561, 60);

        fieldUpdateBikePrice.setBackground(new java.awt.Color(226, 226, 226));
        fieldUpdateBikePrice.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        fieldUpdateBikePrice.setBorder(javax.swing.BorderFactory.createTitledBorder("Bike Price"));
        panelAdminPanelBikeUpdateBikePanel.add(fieldUpdateBikePrice);
        fieldUpdateBikePrice.setBounds(20, 390, 561, 60);

        comboBoxUpdateBikeType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bike Type", "Bike", "Scooter" }));
        panelAdminPanelBikeUpdateBikePanel.add(comboBoxUpdateBikeType);
        comboBoxUpdateBikeType.setBounds(30, 483, 540, 50);

        buttonUpdateClear.setBackground(new java.awt.Color(240, 84, 84));
        buttonUpdateClear.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        buttonUpdateClear.setText("Clear");
        buttonUpdateClear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonUpdateClearMouseClicked(evt);
            }
        });
        buttonUpdateClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdateClearActionPerformed(evt);
            }
        });
        panelAdminPanelBikeUpdateBikePanel.add(buttonUpdateClear);
        buttonUpdateClear.setBounds(310, 560, 240, 51);

        buttonUpdate.setBackground(new java.awt.Color(240, 84, 84));
        buttonUpdate.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        buttonUpdate.setText("Update");
        buttonUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonUpdateMouseClicked(evt);
            }
        });
        buttonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdateActionPerformed(evt);
            }
        });
        panelAdminPanelBikeUpdateBikePanel.add(buttonUpdate);
        buttonUpdate.setBounds(50, 560, 240, 51);

        labelWarningUpdateBikeNo.setForeground(new java.awt.Color(255, 0, 51));
        labelWarningUpdateBikeNo.setText("Warning");
        panelAdminPanelBikeUpdateBikePanel.add(labelWarningUpdateBikeNo);
        labelWarningUpdateBikeNo.setBounds(30, 150, 523, 17);

        labelWarningUpdateBikeModel.setForeground(new java.awt.Color(255, 0, 51));
        labelWarningUpdateBikeModel.setText("Warning");
        panelAdminPanelBikeUpdateBikePanel.add(labelWarningUpdateBikeModel);
        labelWarningUpdateBikeModel.setBounds(30, 250, 537, 17);

        labelWarningUpdateBikeCondition.setForeground(new java.awt.Color(255, 0, 51));
        labelWarningUpdateBikeCondition.setText("Warning");
        panelAdminPanelBikeUpdateBikePanel.add(labelWarningUpdateBikeCondition);
        labelWarningUpdateBikeCondition.setBounds(30, 350, 537, 17);

        labelWarningUpdateBikePrice.setForeground(new java.awt.Color(255, 0, 51));
        labelWarningUpdateBikePrice.setText("Warning");
        panelAdminPanelBikeUpdateBikePanel.add(labelWarningUpdateBikePrice);
        labelWarningUpdateBikePrice.setBounds(30, 450, 537, 17);

        panelAdminPanelBikeUpdateBike.add(panelAdminPanelBikeUpdateBikePanel);
        panelAdminPanelBikeUpdateBikePanel.setBounds(110, 60, 600, 620);

        labelAdminPanelBikeUpdateBike.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/automoto/resources/AddBike.png"))); // NOI18N
        panelAdminPanelBikeUpdateBike.add(labelAdminPanelBikeUpdateBike);
        labelAdminPanelBikeUpdateBike.setBounds(0, 0, 1400, 732);

        panelAdminPanel.add(panelAdminPanelBikeUpdateBike);
        panelAdminPanelBikeUpdateBike.setBounds(440, 210, 1400, 732);

        panelAdminPanelBike.setBackground(new java.awt.Color(245, 245, 245));
        panelAdminPanelBike.setMaximumSize(new java.awt.Dimension(1400, 732));
        panelAdminPanelBike.setPreferredSize(new java.awt.Dimension(1400, 732));
        panelAdminPanelBike.setSize(new java.awt.Dimension(1400, 732));
        panelAdminPanelBike.setLayout(null);

        tblBikeData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Bike No", "Bike Model", "Bike Condtion", "Price", "Type", "Rental Status"
            }
        ));
        tblBikeData.setRowHeight(30);
        jScrollPane1.setViewportView(tblBikeData);

        panelAdminPanelBike.add(jScrollPane1);
        jScrollPane1.setBounds(0, 60, 1400, 670);

        comboBoxAttribute.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        comboBoxAttribute.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sort By", "Name", "Price", "Condition" }));
        comboBoxAttribute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxAttributeActionPerformed(evt);
            }
        });
        panelAdminPanelBike.add(comboBoxAttribute);
        comboBoxAttribute.setBounds(1080, 10, 180, 40);

        buttonFilterDown.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/automoto/resources/Arrow_Down.png"))); // NOI18N
        buttonFilterDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFilterDownActionPerformed(evt);
            }
        });
        panelAdminPanelBike.add(buttonFilterDown);
        buttonFilterDown.setBounds(1330, 10, 60, 40);

        buttonFilterUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/automoto/resources/Arrow_Up.png"))); // NOI18N
        buttonFilterUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFilterUpActionPerformed(evt);
            }
        });
        panelAdminPanelBike.add(buttonFilterUp);
        buttonFilterUp.setBounds(1270, 10, 60, 40);

        textFieldSearch.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        textFieldSearch.setText("Search");
        panelAdminPanelBike.add(textFieldSearch);
        textFieldSearch.setBounds(10, 10, 470, 40);

        buttonTextFieldSearch.setBackground(new java.awt.Color(255, 87, 87));
        buttonTextFieldSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/automoto/resources/Search.png"))); // NOI18N
        buttonTextFieldSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonTextFieldSearchMouseClicked(evt);
            }
        });
        panelAdminPanelBike.add(buttonTextFieldSearch);
        buttonTextFieldSearch.setBounds(480, 10, 90, 40);

        panelAdminPanel.add(panelAdminPanelBike);
        panelAdminPanelBike.setBounds(440, 210, 1400, 732);

        panelAdminPanelHome.setBackground(new java.awt.Color(245, 245, 245));
        panelAdminPanelHome.setMaximumSize(new java.awt.Dimension(1400, 732));
        panelAdminPanelHome.setPreferredSize(new java.awt.Dimension(1400, 732));
        panelAdminPanelHome.setSize(new java.awt.Dimension(1400, 732));
        panelAdminPanelHome.setLayout(null);

        iconAdminPanelHomeImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/automoto/resources/WelcomeAdminPanel.png"))); // NOI18N
        panelAdminPanelHome.add(iconAdminPanelHomeImage);
        iconAdminPanelHomeImage.setBounds(10, 0, 1400, 730);

        panelAdminPanel.add(panelAdminPanelHome);
        panelAdminPanelHome.setBounds(440, 210, 1400, 732);

        panelAdminPanelHomeDesign.setMaximumSize(new java.awt.Dimension(1440, 120));
        panelAdminPanelHomeDesign.setMinimumSize(new java.awt.Dimension(1440, 120));
        panelAdminPanelHomeDesign.setPreferredSize(new java.awt.Dimension(1440, 120));
        panelAdminPanelHomeDesign.setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/automoto/resources/AdminPanelFloorDesign.png"))); // NOI18N
        panelAdminPanelHomeDesign.add(jLabel1);
        jLabel1.setBounds(0, 0, 1440, 120);

        panelAdminPanel.add(panelAdminPanelHomeDesign);
        panelAdminPanelHomeDesign.setBounds(420, 1010, 1440, 120);

        panelAdminPanelBikeAddButton.setBackground(new java.awt.Color(245, 245, 245));
        panelAdminPanelBikeAddButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelAdminPanelBikeAddButtonMouseClicked(evt);
            }
        });

        labelAdminPanelBikeAdd.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        labelAdminPanelBikeAdd.setText("Add Bike");

        javax.swing.GroupLayout panelAdminPanelBikeAddButtonLayout = new javax.swing.GroupLayout(panelAdminPanelBikeAddButton);
        panelAdminPanelBikeAddButton.setLayout(panelAdminPanelBikeAddButtonLayout);
        panelAdminPanelBikeAddButtonLayout.setHorizontalGroup(
            panelAdminPanelBikeAddButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAdminPanelBikeAddButtonLayout.createSequentialGroup()
                .addContainerGap(115, Short.MAX_VALUE)
                .addComponent(labelAdminPanelBikeAdd)
                .addGap(67, 67, 67))
        );
        panelAdminPanelBikeAddButtonLayout.setVerticalGroup(
            panelAdminPanelBikeAddButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAdminPanelBikeAddButtonLayout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(labelAdminPanelBikeAdd)
                .addGap(17, 17, 17))
        );

        panelAdminPanel.add(panelAdminPanelBikeAddButton);
        panelAdminPanelBikeAddButton.setBounds(470, 1020, 390, 100);

        panelAdminPanelBikeUpdateButton.setBackground(new java.awt.Color(245, 245, 245));
        panelAdminPanelBikeUpdateButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelAdminPanelBikeUpdateButtonMouseClicked(evt);
            }
        });

        labelAdminPanelBikeUpdate.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        labelAdminPanelBikeUpdate.setText("Update Bike");

        javax.swing.GroupLayout panelAdminPanelBikeUpdateButtonLayout = new javax.swing.GroupLayout(panelAdminPanelBikeUpdateButton);
        panelAdminPanelBikeUpdateButton.setLayout(panelAdminPanelBikeUpdateButtonLayout);
        panelAdminPanelBikeUpdateButtonLayout.setHorizontalGroup(
            panelAdminPanelBikeUpdateButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAdminPanelBikeUpdateButtonLayout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addComponent(labelAdminPanelBikeUpdate)
                .addGap(67, 67, 67))
        );
        panelAdminPanelBikeUpdateButtonLayout.setVerticalGroup(
            panelAdminPanelBikeUpdateButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAdminPanelBikeUpdateButtonLayout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(labelAdminPanelBikeUpdate)
                .addGap(17, 17, 17))
        );

        panelAdminPanel.add(panelAdminPanelBikeUpdateButton);
        panelAdminPanelBikeUpdateButton.setBounds(910, 1020, 390, 100);

        panelAdminPanelBikeDeleteButton.setBackground(new java.awt.Color(255, 87, 87));
        panelAdminPanelBikeDeleteButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelAdminPanelBikeDeleteButtonMouseClicked(evt);
            }
        });

        labelAdminPanelBikeDelete.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        labelAdminPanelBikeDelete.setText("Delete Bike");

        javax.swing.GroupLayout panelAdminPanelBikeDeleteButtonLayout = new javax.swing.GroupLayout(panelAdminPanelBikeDeleteButton);
        panelAdminPanelBikeDeleteButton.setLayout(panelAdminPanelBikeDeleteButtonLayout);
        panelAdminPanelBikeDeleteButtonLayout.setHorizontalGroup(
            panelAdminPanelBikeDeleteButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAdminPanelBikeDeleteButtonLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(labelAdminPanelBikeDelete)
                .addContainerGap(62, Short.MAX_VALUE))
        );
        panelAdminPanelBikeDeleteButtonLayout.setVerticalGroup(
            panelAdminPanelBikeDeleteButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAdminPanelBikeDeleteButtonLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(labelAdminPanelBikeDelete)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        panelAdminPanel.add(panelAdminPanelBikeDeleteButton);
        panelAdminPanelBikeDeleteButton.setBounds(1420, 1020, 390, 100);

        panelAdminPanelRentalUpdateButton.setBackground(new java.awt.Color(245, 245, 245));

        labelAdminPanelRentalUpdate.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        labelAdminPanelRentalUpdate.setText("Update Rental");

        javax.swing.GroupLayout panelAdminPanelRentalUpdateButtonLayout = new javax.swing.GroupLayout(panelAdminPanelRentalUpdateButton);
        panelAdminPanelRentalUpdateButton.setLayout(panelAdminPanelRentalUpdateButtonLayout);
        panelAdminPanelRentalUpdateButtonLayout.setHorizontalGroup(
            panelAdminPanelRentalUpdateButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAdminPanelRentalUpdateButtonLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelAdminPanelRentalUpdate)
                .addGap(240, 240, 240))
        );
        panelAdminPanelRentalUpdateButtonLayout.setVerticalGroup(
            panelAdminPanelRentalUpdateButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAdminPanelRentalUpdateButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelAdminPanelRentalUpdate)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelAdminPanel.add(panelAdminPanelRentalUpdateButton);
        panelAdminPanelRentalUpdateButton.setBounds(730, 1040, 330, 60);

        panelAdminPanelRentalDeleteButton.setBackground(new java.awt.Color(255, 87, 87));

        labelAdminPanelRentalDelete.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        labelAdminPanelRentalDelete.setText("Delete Rent");

        javax.swing.GroupLayout panelAdminPanelRentalDeleteButtonLayout = new javax.swing.GroupLayout(panelAdminPanelRentalDeleteButton);
        panelAdminPanelRentalDeleteButton.setLayout(panelAdminPanelRentalDeleteButtonLayout);
        panelAdminPanelRentalDeleteButtonLayout.setHorizontalGroup(
            panelAdminPanelRentalDeleteButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAdminPanelRentalDeleteButtonLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(labelAdminPanelRentalDelete)
                .addContainerGap(57, Short.MAX_VALUE))
        );
        panelAdminPanelRentalDeleteButtonLayout.setVerticalGroup(
            panelAdminPanelRentalDeleteButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAdminPanelRentalDeleteButtonLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(labelAdminPanelRentalDelete)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        panelAdminPanel.add(panelAdminPanelRentalDeleteButton);
        panelAdminPanelRentalDeleteButton.setBounds(1420, 1020, 390, 100);

        iconAdminPanelBase.setBackground(new java.awt.Color(245, 245, 245));
        iconAdminPanelBase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/automoto/resources/AdminPanel.png"))); // NOI18N
        panelAdminPanel.add(iconAdminPanelBase);
        iconAdminPanelBase.setBounds(0, 0, 1920, 1200);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelAdminPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelAdminPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonRentalManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRentalManagementActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonRentalManagementActionPerformed

    private void buttonAdminPanelBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAdminPanelBackActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonAdminPanelBackActionPerformed

    private void ButtonAdminPanelExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAdminPanelExitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonAdminPanelExitActionPerformed

    private void buttonAdminPanelBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonAdminPanelBackMouseClicked
        // TODO add your handling code here:
        new SelectionOption().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_buttonAdminPanelBackMouseClicked

    private void ButtonAdminPanelExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonAdminPanelExitMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_ButtonAdminPanelExitMouseClicked

    private void buttonBikeManagementMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonBikeManagementMouseClicked
        // TODO add your handling code here:
        panelAdminPanelHome.setVisible(false);
        panelAdminPanelRentalUpdateButton.setVisible(false);
        panelAdminPanelRentalDeleteButton.setVisible(false);
        panelAdminPanelBikeAddButton.setVisible(true);
        panelAdminPanelBikeUpdateButton.setVisible(true);
        panelAdminPanelBikeDeleteButton.setVisible(true);
        panelAdminPanelBike.setVisible(true);
        panelAdminPanelBikeAddBike.setVisible(false);
        panelAdminPanelHomeDesign.setVisible(false);
        panelAdminPanelBikeUpdateBike.setVisible(false);
    }//GEN-LAST:event_buttonBikeManagementMouseClicked

    private void buttonRentalManagementMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonRentalManagementMouseClicked
        // TODO add your handling code here:
        panelAdminPanelHome.setVisible(false);
        panelAdminPanelRentalUpdateButton.setVisible(true);
        panelAdminPanelRentalDeleteButton.setVisible(true);
        panelAdminPanelBikeAddButton.setVisible(false);
        panelAdminPanelBikeUpdateButton.setVisible(false);
        panelAdminPanelBikeDeleteButton.setVisible(false);
        panelAdminPanelBike.setVisible(false);
        panelAdminPanelBikeAddBike.setVisible(false);
        panelAdminPanelHomeDesign.setVisible(false);
        panelAdminPanelBikeUpdateBike.setVisible(false);
    }//GEN-LAST:event_buttonRentalManagementMouseClicked

    private void panelAdminPanelBikeAddButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelAdminPanelBikeAddButtonMouseClicked
        // TODO add your handling code here:
        panelAdminPanelBike.setVisible(false);
        panelAdminPanelBikeAddBike.setVisible(true);
        panelAdminPanelBikeUpdateBike.setVisible(false);
    }//GEN-LAST:event_panelAdminPanelBikeAddButtonMouseClicked

    private void panelAdminPanelBikeUpdateButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelAdminPanelBikeUpdateButtonMouseClicked
        // TODO add your handling code here:
        
        // Here the code is written in such a way that the update panel opens even when the item is not selected for flexibility.
        
        // Retrieve the table model of the bike data table
        DefaultTableModel model = (DefaultTableModel) tblBikeData.getModel();
        int selectedRow = tblBikeData.getSelectedRow();  // Gets the index of the selected row in the table

        if (selectedRow != -1) { // Check if the user has selected a row
            // Retrieve the data from the selected row if a row is selected (when Update button is pressed), 
            String bikeNumber = (String) tblBikeData.getValueAt(selectedRow, 0);
            String bikeModel = (String) tblBikeData.getValueAt(selectedRow, 1);
            String bikeCondition = (String) tblBikeData.getValueAt(selectedRow, 2);
            String bikePrice = tblBikeData.getValueAt(selectedRow, 3).toString();

            // Conformation request for the user if they want to update this bike
            int confirm = JOptionPane.showConfirmDialog(
                    null,
                    "Are you sure you want to Update this Bike?",
                    "Confirm Update", // Title
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE); // Show Conformation Panel for Update.

            if (confirm == JOptionPane.YES_OPTION) {
                // If user confirms then update panel opens with respecive value in the filed.
                panelAdminPanelBike.setVisible(false);
                panelAdminPanelBikeUpdateBike.setVisible(true);
                panelAdminPanelBikeAddBike.setVisible(false);
                fieldUpdateBikeNo.setText(bikeNumber); // Sets the bikeNumber from selected row to UpdateBikeNo Field 
                fieldUpdateBikeModel.setText(bikeModel); // Sets the Model from selected row to UpdateBikeNo Field 
                fieldUpdateBikeCondition.setText(bikeCondition); // Sets the Condition from selected row to UpdateBikeNo Field 
                fieldUpdateBikePrice.setText(bikePrice); // Sets the Price from selected row to UpdateBikeNo Field 
            }
        } else {
            // If user just clicks the Update button without selecting the row then update panel opens without the respecive value in the filed.
            panelAdminPanelBike.setVisible(false);
            panelAdminPanelBikeUpdateBike.setVisible(true);
            panelAdminPanelBikeAddBike.setVisible(false);
        }
    }//GEN-LAST:event_panelAdminPanelBikeUpdateButtonMouseClicked

    private void buttonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonAddActionPerformed

    private void buttonAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonAddMouseClicked
        // TODO add your handling code here:
        JTextField[] fields = {fieldBikeNo, fieldBikeModel, fieldBikeCondition, fieldBikePrice};
        JLabel[] labels = {labelWarningBikeNo, labelWarningBikeModel, labelWarningBikeCondition, labelWarningBikePrice};

        boolean hasEmptyFields = false;

        for (int i = 0; i < fields.length; i++) {
            if (fields[i].getText().isEmpty()) {
                labels[i].setText("This field is required!");
                labels[i].setVisible(true);
                hasEmptyFields = true;
            } else {
                labels[i].setVisible(false);
            }
        }

        // If any field is empty, stop further processing
        if (hasEmptyFields) {
            return;
        }

        ////////////////////////////////
        String bikeNo = (String) fieldBikeNo.getText();
        String bikeModel = fieldBikeModel.getText();
        String bikeCondition = fieldBikeCondition.getText();
        String bikeType = (String) comboBoxBikeType.getSelectedItem();
        double bikePrice;

        try {
            bikePrice = Double.parseDouble(fieldBikePrice.getText());
        } catch (NumberFormatException e) {
            labelWarningBikePrice.setText("Please enter a valid number!");
            labelWarningBikePrice.setVisible(true);
            return;
        }

        if (bikeType.equals("Bike Type")) {
            JOptionPane.showMessageDialog(null, "Please Select your bike type", "Empty Selection", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        boolean isValid = true;

        if (isValid) {
            BikeModel newBike = new BikeModel(bikeNo, bikeModel, bikeCondition, bikePrice, bikeType);
            if (checkBikeNo(newBike)) {
                JOptionPane.showMessageDialog(null, "Duplicate Details.", "Duplicate", JOptionPane.INFORMATION_MESSAGE);

            } else {
                addBikes(newBike);
                JOptionPane.showMessageDialog(null, "Added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);

                for (JTextField field : fields) {
                    field.setText("");
                }
                comboBoxBikeType.setSelectedIndex(0);
            }

        }

        panelAdminPanelBikeAddBike.setVisible(false);
        panelAdminPanelBike.setVisible(true);

    }//GEN-LAST:event_buttonAddMouseClicked

    private void panelAdminPanelBikeDeleteButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelAdminPanelBikeDeleteButtonMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tblBikeData.getModel();
        int selectedRow = tblBikeData.getSelectedRow();

        if (selectedRow != -1) { // Check if a row is selected
            // Extract row data
            String bikeNumber = (String) tblBikeData.getValueAt(selectedRow, 0);
            int confirm = JOptionPane.showConfirmDialog(
                    null, // Parent component
                    "Are you sure you want to delete this Bike?", // Message
                    "Confirm Deletion", // Title
                    JOptionPane.YES_NO_OPTION, // Options
                    JOptionPane.WARNING_MESSAGE);
            if (confirm == JOptionPane.YES_OPTION) {
                boolean deleted = deleteBikes(bikeNumber, selectedRow);
                if (deleted) {
                    JOptionPane.showMessageDialog(null, "Bike deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a Bike to delete.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_panelAdminPanelBikeDeleteButtonMouseClicked

    private void buttonUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonUpdateMouseClicked
        // TODO add your handling code here:

        JTextField[] fields = {fieldUpdateBikeNo, fieldUpdateBikeModel, fieldUpdateBikeCondition, fieldUpdateBikePrice};
        JLabel[] labels = {labelWarningUpdateBikeNo, labelWarningUpdateBikeModel, labelWarningUpdateBikeCondition, labelWarningUpdateBikePrice};

        boolean hasEmptyFields = false;

        for (int i = 0; i < fields.length; i++) {
            if (fields[i].getText().isEmpty()) {
                labels[i].setText("This field is required!");
                labels[i].setVisible(true);
                hasEmptyFields = true;
            } else {
                labels[i].setVisible(false);
            }
        }

        // If any field is empty, stop further processing
        if (hasEmptyFields) {
            return;
        }

        ////////////////////////////////
        String bikeNo = (String) fieldUpdateBikeNo.getText();
        String bikeModel = fieldUpdateBikeModel.getText();
        String bikeCondition = fieldUpdateBikeCondition.getText();
        String bikeType = (String) comboBoxUpdateBikeType.getSelectedItem();
        double bikePrice;

        try {
            bikePrice = Double.parseDouble(fieldUpdateBikePrice.getText());
        } catch (NumberFormatException e) {
            labelWarningUpdateBikePrice.setText("Please enter a valid number!");
            labelWarningUpdateBikePrice.setVisible(true);
            return;
        }

        if (bikeType.equals("Bike Type")) {
            JOptionPane.showMessageDialog(null, "Please Select your bike type", "Empty Selection", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        //////////////////////////////////////////////////
        boolean isValid = true;

        if (isValid) {
            // Locate the bike in the LinkedList and update it
            for (BikeModel bikes : bikeList) {
                if (bikes.getBikeNumber().equals(bikeNo)) {
                    // Update bike details
                    bikes.setModel(bikeModel);
                    bikes.setCondition(bikeCondition);
                    bikes.setPrice(bikePrice);
                    bikes.setType(bikeType);

                    updateBikes();
                    JOptionPane.showMessageDialog(null, "Bike Infomation updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);

                    panelAdminPanelBikeUpdateBike.setVisible(false);
                    panelAdminPanelBike.setVisible(true);

                    return;
                }
            }
        }

        //////////////////////////////////////////////////

    }//GEN-LAST:event_buttonUpdateMouseClicked

    private void buttonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonUpdateActionPerformed

    private void comboBoxAttributeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxAttributeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxAttributeActionPerformed

    private void buttonFilterDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFilterDownActionPerformed
        // TODO add your handling code here:

        SelectionSort selectionSort = new SelectionSort();
        InsertionSort insertionSort = new InsertionSort();
        MergeSort mergeSort = new MergeSort();
        String filterSelection = (String) comboBoxAttribute.getSelectedItem();

        if (filterSelection.equals("Name")) {
            List<BikeModel> sortedList = mergeSort.sortByModel(bikeList, true);
            SortedData(sortedList);
        } else if (filterSelection.equals("Price")) {
            List<BikeModel> sortedList = selectionSort.sortByPrice(bikeList, false);
            SortedData(sortedList);
        } else if (filterSelection.equals("Condition")) {
            List<BikeModel> sortedList = insertionSort.sortByCondition(bikeList, false);
            SortedData(sortedList);
        }
    }//GEN-LAST:event_buttonFilterDownActionPerformed

    private void buttonFilterUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFilterUpActionPerformed
        // TODO add your handling code here:
        SelectionSort selectionSort = new SelectionSort();
        InsertionSort insertionSort = new InsertionSort();
        MergeSort mergeSort = new MergeSort();
        String filterSelection = (String) comboBoxAttribute.getSelectedItem();

        if (filterSelection.equals("Name")) {
            List<BikeModel> sortedList = mergeSort.sortByModel(bikeList, false);
            SortedData(sortedList);
        } else if (filterSelection.equals("Price")) {
            List<BikeModel> sortedList = selectionSort.sortByPrice(bikeList, true);
            SortedData(sortedList);
        } else if (filterSelection.equals("Condition")) {
            List<BikeModel> sortedList = insertionSort.sortByCondition(bikeList, true);
            SortedData(sortedList);
        }
    }//GEN-LAST:event_buttonFilterUpActionPerformed

    private void buttonClearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonClearMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_buttonClearMouseClicked

    private void buttonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClearActionPerformed
        // TODO add your handling code here:
        JTextField[] fields = {fieldBikeNo, fieldBikeModel, fieldBikeCondition, fieldBikePrice};
        for (JTextField field : fields) {
            field.setText("");
        }
        comboBoxBikeType.setSelectedIndex(0);
    }//GEN-LAST:event_buttonClearActionPerformed

    private void buttonUpdateClearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonUpdateClearMouseClicked
        // TODO add your handling code here:
        JTextField[] fields = {fieldUpdateBikeNo, fieldUpdateBikeModel, fieldUpdateBikeCondition, fieldUpdateBikePrice};
        for (JTextField field : fields) {
            field.setText("");
        }
        comboBoxUpdateBikeType.setSelectedIndex(0);
    }//GEN-LAST:event_buttonUpdateClearMouseClicked

    private void buttonUpdateClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateClearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonUpdateClearActionPerformed

    private void buttonTextFieldSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonTextFieldSearchMouseClicked
        // TODO add your handling code here:

        MergeSort mergeSort = new MergeSort(); // Object Creation of MergeSort class
        List<BikeModel> sortedList = mergeSort.sortByModel(bikeList, false);
        BinarySearch search = new BinarySearch(); // Object Creation of BinarySearch class
        BikeModel searchedData = search.searchByName(textFieldSearch.getText().trim().toLowerCase(), sortedList, 0, sortedList.size() - 1);

        if (searchedData != null) { // Checks if the searchData retrived is null or not? //Proceds if not null
            // Gets the table model
            DefaultTableModel model = (DefaultTableModel) tblBikeData.getModel();
            
            model.setRowCount(0); // Clears the table

            // Adding the searched bike in the first row of the table
            model.addRow(new Object[]{
                searchedData.getBikeNumber(), // Assuming these methods exist in BikeModel
                searchedData.getModel(),
                searchedData.getCondition(),
                searchedData.getPrice(),
                searchedData.getType(),
                searchedData.getStatus()
            });

            // Adding the remaining bikes back into the table
            for (BikeModel bike : sortedList) {
                if (!bike.getModel().equalsIgnoreCase(searchedData.getModel())) {
                    model.addRow(new Object[]{
                        bike.getBikeNumber(),
                        bike.getModel(),
                        bike.getCondition(),
                        bike.getPrice(),
                        bike.getType(),
                        bike.getStatus()
                    });
                }
            }

            // Select and highlight the first row if found.
            tblBikeData.setRowSelectionInterval(0, 0);
            tblBikeData.scrollRectToVisible(tblBikeData.getCellRect(0, 0, true));

        } else {
            // Throws an Information Message OptionPane if the search is not found.
            JOptionPane.showMessageDialog(null, "Your search doesn't exist.", "Not Found", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_buttonTextFieldSearchMouseClicked

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
            java.util.logging.Logger.getLogger(AdminPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonAdminPanelExit;
    private javax.swing.JButton buttonAdd;
    private javax.swing.JButton buttonAdminPanelBack;
    private javax.swing.JButton buttonBikeManagement;
    private javax.swing.JButton buttonClear;
    private javax.swing.JButton buttonFilterDown;
    private javax.swing.JButton buttonFilterUp;
    private javax.swing.JButton buttonRentalManagement;
    private javax.swing.JButton buttonTextFieldSearch;
    private javax.swing.JButton buttonUpdate;
    private javax.swing.JButton buttonUpdateClear;
    private javax.swing.JComboBox<String> comboBoxAttribute;
    private javax.swing.JComboBox<String> comboBoxBikeType;
    private javax.swing.JComboBox<String> comboBoxUpdateBikeType;
    private javax.swing.JTextField fieldBikeCondition;
    private javax.swing.JTextField fieldBikeModel;
    private javax.swing.JTextField fieldBikeNo;
    private javax.swing.JTextField fieldBikePrice;
    private javax.swing.JTextField fieldUpdateBikeCondition;
    private javax.swing.JTextField fieldUpdateBikeModel;
    private javax.swing.JTextField fieldUpdateBikeNo;
    private javax.swing.JTextField fieldUpdateBikePrice;
    private javax.swing.JLabel iconAdminPanelBase;
    private javax.swing.JLabel iconAdminPanelHomeImage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelAdmin;
    private javax.swing.JLabel labelAdminPanel;
    private javax.swing.JLabel labelAdminPanelBikeAdd;
    private javax.swing.JLabel labelAdminPanelBikeAddBike;
    private javax.swing.JLabel labelAdminPanelBikeDelete;
    private javax.swing.JLabel labelAdminPanelBikeUpdate;
    private javax.swing.JLabel labelAdminPanelBikeUpdateBike;
    private javax.swing.JLabel labelAdminPanelRentalDelete;
    private javax.swing.JLabel labelAdminPanelRentalUpdate;
    private javax.swing.JLabel labelEnterYourBikeDetail;
    private javax.swing.JLabel labelUpdateBikeDetail;
    private javax.swing.JLabel labelWarningBikeCondition;
    private javax.swing.JLabel labelWarningBikeModel;
    private javax.swing.JLabel labelWarningBikeNo;
    private javax.swing.JLabel labelWarningBikePrice;
    private javax.swing.JLabel labelWarningUpdateBikeCondition;
    private javax.swing.JLabel labelWarningUpdateBikeModel;
    private javax.swing.JLabel labelWarningUpdateBikeNo;
    private javax.swing.JLabel labelWarningUpdateBikePrice;
    private javax.swing.JPanel panelAdminPanel;
    private javax.swing.JPanel panelAdminPanelBike;
    private javax.swing.JPanel panelAdminPanelBikeAddBike;
    private javax.swing.JPanel panelAdminPanelBikeAddBikePanel;
    private javax.swing.JPanel panelAdminPanelBikeAddButton;
    private javax.swing.JPanel panelAdminPanelBikeDeleteButton;
    private javax.swing.JPanel panelAdminPanelBikeUpdateBike;
    private javax.swing.JPanel panelAdminPanelBikeUpdateBikePanel;
    private javax.swing.JPanel panelAdminPanelBikeUpdateButton;
    private javax.swing.JPanel panelAdminPanelHome;
    private javax.swing.JPanel panelAdminPanelHomeDesign;
    private javax.swing.JPanel panelAdminPanelRentalDeleteButton;
    private javax.swing.JPanel panelAdminPanelRentalUpdateButton;
    private javax.swing.JTable tblBikeData;
    private javax.swing.JTextField textFieldSearch;
    // End of variables declaration//GEN-END:variables
}
