/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.automoto.view;

// Importing necessary pacakges
import com.automoto.controller.algorithms.BinarySearch;
import com.automoto.controller.algorithms.InsertionSort;
import com.automoto.controller.algorithms.MergeSort;
import com.automoto.controller.algorithms.SelectionSort;
import com.automoto.model.BikeModel;
import com.automoto.model.RentalModel;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aashutoshdhakal
 */
public class ActionFrame extends javax.swing.JFrame {

    // List to store all bike data
    public LinkedList<BikeModel> bikeList = new LinkedList<>();
    // List to store all rental data
    public LinkedList<RentalModel> rentalList = new LinkedList<>();

    /**
     * Adds a bike to the bike list and display in the table model.
     *
     * @param bikes the bike model to be added
     */
    public void addBikes(BikeModel bikes) {
        bikeList.add(bikes);
        DefaultTableModel model = (DefaultTableModel) tblBikeData.getModel();
        Object[] data = new Object[]{
            bikes.getBikeNumber(), bikes.getModel(), bikes.getCondition(),
            bikes.getPrice(), bikes.getType(), bikes.getStatus()
        };
        model.addRow(data); //Adding List object in a row
    }

    /**
     * Adds a rental record to the rental list and updates the table model.
     *
     * @param rents the rental model to be added
     */
    public void addRental(RentalModel rents) {
        rentalList.add(rents);
        DefaultTableModel model = (DefaultTableModel) tblRentalData.getModel();
        Object[] data = new Object[]{
            rents.getFirstName(), rents.getLastName(), rents.getDob(),
            rents.getGender(), rents.getBikeModel(), rents.getLicenceNumber(), rents.getDocumentType(), rents.getDocumentNumber(),
            rents.getDurationOfRent(), rents.getMobileNumber(), rents.getStatus()
        };
        model.addRow(data); // adding new RentalModel object to the row of Rental Table with list.
    }

    /**
     * Checks if a bike with the given bike number already exists in the list.
     *
     * @param bikes the bike model to check
     * @return true if a duplicate is found, false otherwise
     */
    private boolean checkBikeNo(BikeModel bikes) {
        for (BikeModel remainingBikes : bikeList) {
            if (remainingBikes.getBikeNumber().equals(bikes.getBikeNumber())) {
                return true; // Bike Number exists
            }
        }
        return false; // Bike Number doesnot exists
    }

    /**
     * Checks if a rental with the given license number already exists and is
     * not returned.
     *
     * @param rents the rental model to check
     * @return true if a duplicate is found, false otherwise
     */
    private boolean checkLicenceNo(RentalModel rents) {
        for (RentalModel rent : rentalList) {
            if (rent.getLicenceNumber() == rents.getLicenceNumber() && !rent.getStatus().equalsIgnoreCase("Returned")) {
                return true; // Duplicate data found if the status is not "Returned"
            }
        }
        return false; // No duplicate data found
    }

    /**
     * Deletes a bike based on its bike number and updates the table model.
     *
     * @param bikeNumber the bike number to delete
     * @param selectedRow the selected row in the table
     * @return true if the bike was successfully deleted, false otherwise
     */
    private boolean deleteBikes(String bikeNumber, int selectedRow) {
        Iterator<BikeModel> iterator = bikeList.iterator();
        while (iterator.hasNext()) {
            BikeModel bikes = iterator.next();
            if (bikes.getBikeNumber().equals(bikeNumber)) {
                // Removeing the member from the list
                iterator.remove();

                // Removeing the row from the table
                DefaultTableModel model = (DefaultTableModel) tblBikeData.getModel();
                model.removeRow(selectedRow);
                return true; // Member deleted successfully
            }
        }
        return false; // No member found with the given ID
    }

    /**
     * Deletes a rental record based on its license number and updates the table
     * model.
     *
     * @param licenceNumber the license number to delete
     * @param selectedRow the selected row in the table
     * @return true if the rental record was successfully deleted, false
     * otherwise
     */
    private boolean deleteRental(Long licenceNumber, int selectedRow) {
        Iterator<RentalModel> iterator = rentalList.iterator();
        while (iterator.hasNext()) {
            RentalModel rents = iterator.next();
            if (licenceNumber.equals(rents.getLicenceNumber())) {
                // Removeing the member from the list
                iterator.remove();

                // Also removeing the row from the table
                DefaultTableModel model = (DefaultTableModel) tblRentalData.getModel();
                model.removeRow(selectedRow);
                return true; // Rental log deleted successfully
            }
        }
        return false;
    }

    /**
     * Initializes a predefined set of bikes and adds them to the list and table
     * model.
     */
    private void initialBikes() {
        // Creating object of BikeModel Class with following paramater properties.
        BikeModel bike1 = new BikeModel("B1234", "Royal Enflied Metor 350", "Good", 6000, "Bike");
        addBikes(bike1); // adding the object of BikeModel class to the list.
        //Similar for others.
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

    /**
     * Updates the bike data table to reflect the current bike list.
     */
    private void updateBikes() {
        DefaultTableModel model = (DefaultTableModel) tblBikeData.getModel();

        // Clearing the table before loading new data
        model.setRowCount(0);

        // Iterating through the LinkedList and adding each member to the table
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

    /**
     * Updates the rental data table to reflect the current rental list.
     */
    private void updateRentals() {
        DefaultTableModel model = (DefaultTableModel) tblRentalData.getModel();

        // Clearing the table before loading new data
        model.setRowCount(0);

        // Iterateing through the LinkedList and add each member to the table
        for (RentalModel rent : rentalList) {
            model.addRow(new Object[]{
                rent.getFirstName(),
                rent.getLastName(),
                rent.getDob(),
                rent.getGender(),
                rent.getBikeModel(),
                rent.getLicenceNumber(),
                rent.getDocumentType(),
                rent.getDocumentNumber(),
                rent.getDurationOfRent(),
                rent.getMobileNumber(),
                rent.getStatus()
            });
        }
    }

    /**
     * Updates the bike data table with a sorted list of bike models.
     *
     * @param sortedData a list of sorted BikeModel objects
     */
    private void sortedData(List<BikeModel> sortedData) {
        DefaultTableModel model = (DefaultTableModel) tblBikeData.getModel();

        // Clearing the table before loading new data
        model.setRowCount(0);

        // Iterating through the LinkedList and add each member to the table
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
     * Populates the appropriate combo box with bike models based on their
     * status.
     *
     * @param status the status of the bikes to filter by (e.g., "Available",
     * "Rented")
     */
    private void populateCheckBox(String status) {
        JComboBox<String> targetComboBox;

        // Assign the appropriate combo box based on the status
        if (status.equalsIgnoreCase("Available")) {
            targetComboBox = comboBoxRentBikeModel;
        } else if (status.equalsIgnoreCase("Rented")) {
            targetComboBox = comboBoxReturnBikeModel;
        } else {
            return; // Exit if the status is invalid
        }

        // Clearing the combo box before populating
        targetComboBox.removeAllItems();
        targetComboBox.addItem("Select Model"); // Default option

        // Iterating through the bike list
        for (BikeModel bike : bikeList) {
            // Only process the bikes that matches the given status
            if (bike.getStatus().equalsIgnoreCase(status)) {
                String bikeDisplay = bike.getBikeNumber() + "_" + bike.getModel(); // Combine bikeNumber and bikeModel

                boolean exists = false;

                // Checking if the combined bike display string already exists in the target combo box
                for (int i = 0; i < targetComboBox.getItemCount(); i++) {
                    if (targetComboBox.getItemAt(i).equals(bikeDisplay)) {
                        exists = true; // Duplicate found
                        break;
                    }
                }

                // Adding the bike display string to the combo box if it doesn't already exist
                if (!exists) {
                    targetComboBox.addItem(bikeDisplay);
                }
            }
        }
    }

    /**
     * Creates new form ActionFrame
     */
    public ActionFrame() {
        initComponents();
        pnlSelectionOption.setVisible(true);
        pnlAdminPanel.setVisible(false);
        pnlQuickAction.setVisible(false);
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

        buttonGroupGender = new javax.swing.ButtonGroup();
        pnlSelectionOption = new javax.swing.JPanel();
        panelAsButtonForQuickAction = new javax.swing.JPanel();
        LabelQuickAction = new javax.swing.JLabel();
        panelAsButtonForAdminPanel = new javax.swing.JPanel();
        labelAdminPanel = new javax.swing.JLabel();
        buttonBack = new javax.swing.JButton();
        buttonExit = new javax.swing.JButton();
        labelChooseAnOption = new javax.swing.JLabel();
        iconBaseSelectionOption = new javax.swing.JLabel();
        pnlAdminPanel = new javax.swing.JPanel();
        labelAdminPanel1 = new javax.swing.JLabel();
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
        panelAdminPanelRental = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblRentalData = new javax.swing.JTable();
        panelAdminPanelHome = new javax.swing.JPanel();
        iconAdminPanelHomeImage = new javax.swing.JLabel();
        panelAdminPanelHomeDesign = new javax.swing.JPanel();
        iconAdminPanelHomeDesign = new javax.swing.JLabel();
        panelAdminPanelBikeAddButton = new javax.swing.JPanel();
        labelAdminPanelBikeAdd = new javax.swing.JLabel();
        panelAdminPanelBikeUpdateButton = new javax.swing.JPanel();
        labelAdminPanelBikeUpdate = new javax.swing.JLabel();
        panelAdminPanelBikeDeleteButton = new javax.swing.JPanel();
        labelAdminPanelBikeDelete = new javax.swing.JLabel();
        panelAdminPanelRentalAddButton = new javax.swing.JPanel();
        labelAdminPanelRentalUpdate = new javax.swing.JLabel();
        panelAdminPanelRentalDeleteButton = new javax.swing.JPanel();
        labelAdminPanelRentalDelete = new javax.swing.JLabel();
        iconAdminPanelBase = new javax.swing.JLabel();
        pnlQuickAction = new javax.swing.JPanel();
        labelQuickAction = new javax.swing.JLabel();
        buttonHome = new javax.swing.JButton();
        buttonRent = new javax.swing.JButton();
        buttonReturn = new javax.swing.JButton();
        buttonBack1 = new javax.swing.JButton();
        buttonExit1 = new javax.swing.JButton();
        panelHome = new javax.swing.JPanel();
        iconQuickActionBase = new javax.swing.JLabel();
        panelRent = new javax.swing.JPanel();
        labelRentTopic = new javax.swing.JLabel();
        fieldRentFirstName = new javax.swing.JTextField();
        labelRentFirstName = new javax.swing.JLabel();
        fieldRentLastName = new javax.swing.JTextField();
        labelRentLastName = new javax.swing.JLabel();
        fieldRentLicenceNo = new javax.swing.JTextField();
        labelRentLicenceNo = new javax.swing.JLabel();
        labelRentDocumentType = new javax.swing.JLabel();
        comboBoxRentDocumentType = new javax.swing.JComboBox<>();
        sliderRentDurationOfRent = new javax.swing.JSlider();
        labelRentDurartionOfRent = new javax.swing.JLabel();
        labelRentGender = new javax.swing.JLabel();
        radioButtonRentMale = new javax.swing.JRadioButton();
        radioButtonRentFemale = new javax.swing.JRadioButton();
        labelRentDateOfBirth = new javax.swing.JLabel();
        labelRentDocumentNo = new javax.swing.JLabel();
        fieldRentDocumentNo = new javax.swing.JTextField();
        comboBoxRentBikeModel = new javax.swing.JComboBox<>();
        labelRentBikeModel = new javax.swing.JLabel();
        fieldRentDateOfBirth = new javax.swing.JTextField();
        labelRentMobileNo = new javax.swing.JLabel();
        fieldRentMobileNo = new javax.swing.JTextField();
        radioButtonRentOthers = new javax.swing.JRadioButton();
        buttonRentBike = new javax.swing.JButton();
        labelRentWarningFirstName = new javax.swing.JLabel();
        labelRentWarningLastName = new javax.swing.JLabel();
        labelRentWarningDateOfBirth = new javax.swing.JLabel();
        labelRentWarningMobileNo = new javax.swing.JLabel();
        labelRentWarningLicenceNo = new javax.swing.JLabel();
        labelRentWarningDocumentNo = new javax.swing.JLabel();
        pnlRentBikePictureDisplay = new javax.swing.JPanel();
        iconRentBanner = new javax.swing.JLabel();
        buttonRentClear = new javax.swing.JButton();
        panelReturn = new javax.swing.JPanel();
        labelRentTopic2 = new javax.swing.JLabel();
        fieldReturnFirstName = new javax.swing.JTextField();
        labelReturnFirstName = new javax.swing.JLabel();
        fieldReturnLastName = new javax.swing.JTextField();
        labelReturnLastName = new javax.swing.JLabel();
        fieldReturnLicenceNo = new javax.swing.JTextField();
        labelReturnLicenceNo = new javax.swing.JLabel();
        labelReturnDocumentType = new javax.swing.JLabel();
        comboBoxReturnDocumentType = new javax.swing.JComboBox<>();
        labelReturnDocumentNo = new javax.swing.JLabel();
        fieldReturnDocumentNo = new javax.swing.JTextField();
        comboBoxReturnBikeModel = new javax.swing.JComboBox<>();
        labelReturnBikeModel = new javax.swing.JLabel();
        labelReturnMobileNo = new javax.swing.JLabel();
        fieldReturnMobileNo = new javax.swing.JTextField();
        labelReturnWarningMobileNo = new javax.swing.JLabel();
        labelReturnWarningFirstName = new javax.swing.JLabel();
        labelReturnWarningLastName = new javax.swing.JLabel();
        labelReturnWarningLicenceNo = new javax.swing.JLabel();
        labelReturnWarningDocumentNo = new javax.swing.JLabel();
        buttonReturnBike = new javax.swing.JButton();
        pnlReturnBannerBase = new javax.swing.JPanel();
        iconReturnBanner = new javax.swing.JLabel();
        buttonReturnClear = new javax.swing.JButton();
        panelDecuration1 = new javax.swing.JPanel();
        panelDecuration2 = new javax.swing.JPanel();
        panelDecuration3 = new javax.swing.JPanel();
        IconQuickActionBaseplate = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1920, 1200));
        getContentPane().setLayout(null);

        pnlSelectionOption.setMaximumSize(new java.awt.Dimension(1920, 1200));
        pnlSelectionOption.setMinimumSize(new java.awt.Dimension(1920, 1200));
        pnlSelectionOption.setLayout(null);

        panelAsButtonForQuickAction.setBackground(new java.awt.Color(240, 84, 84));
        panelAsButtonForQuickAction.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelAsButtonForQuickActionMouseClicked(evt);
            }
        });

        LabelQuickAction.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        LabelQuickAction.setForeground(new java.awt.Color(255, 255, 255));
        LabelQuickAction.setText("Quick Action");

        javax.swing.GroupLayout panelAsButtonForQuickActionLayout = new javax.swing.GroupLayout(panelAsButtonForQuickAction);
        panelAsButtonForQuickAction.setLayout(panelAsButtonForQuickActionLayout);
        panelAsButtonForQuickActionLayout.setHorizontalGroup(
            panelAsButtonForQuickActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAsButtonForQuickActionLayout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(LabelQuickAction)
                .addGap(39, 39, 39))
        );
        panelAsButtonForQuickActionLayout.setVerticalGroup(
            panelAsButtonForQuickActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAsButtonForQuickActionLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(LabelQuickAction)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pnlSelectionOption.add(panelAsButtonForQuickAction);
        panelAsButtonForQuickAction.setBounds(460, 800, 380, 110);

        panelAsButtonForAdminPanel.setBackground(new java.awt.Color(240, 84, 84));
        panelAsButtonForAdminPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelAsButtonForAdminPanelMouseClicked(evt);
            }
        });

        labelAdminPanel.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        labelAdminPanel.setForeground(new java.awt.Color(255, 255, 255));
        labelAdminPanel.setText("Admin Panel");

        javax.swing.GroupLayout panelAsButtonForAdminPanelLayout = new javax.swing.GroupLayout(panelAsButtonForAdminPanel);
        panelAsButtonForAdminPanel.setLayout(panelAsButtonForAdminPanelLayout);
        panelAsButtonForAdminPanelLayout.setHorizontalGroup(
            panelAsButtonForAdminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAsButtonForAdminPanelLayout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addComponent(labelAdminPanel)
                .addGap(42, 42, 42))
        );
        panelAsButtonForAdminPanelLayout.setVerticalGroup(
            panelAsButtonForAdminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAsButtonForAdminPanelLayout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(labelAdminPanel)
                .addGap(26, 26, 26))
        );

        pnlSelectionOption.add(panelAsButtonForAdminPanel);
        panelAsButtonForAdminPanel.setBounds(1080, 800, 380, 110);

        buttonBack.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        buttonBack.setText("Back");
        buttonBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonBackMouseClicked(evt);
            }
        });
        buttonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBackActionPerformed(evt);
            }
        });
        pnlSelectionOption.add(buttonBack);
        buttonBack.setBounds(30, 1100, 120, 60);

        buttonExit.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        buttonExit.setText("Exit");
        buttonExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonExitMouseClicked(evt);
            }
        });
        buttonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExitActionPerformed(evt);
            }
        });
        pnlSelectionOption.add(buttonExit);
        buttonExit.setBounds(1770, 1100, 120, 60);

        labelChooseAnOption.setFont(new java.awt.Font("Skia", 1, 56)); // NOI18N
        labelChooseAnOption.setText("Choose An Option");
        pnlSelectionOption.add(labelChooseAnOption);
        labelChooseAnOption.setBounds(720, 130, 510, 60);

        iconBaseSelectionOption.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/automoto/resources/selectionPage.png"))); // NOI18N
        pnlSelectionOption.add(iconBaseSelectionOption);
        iconBaseSelectionOption.setBounds(0, 0, 1920, 1200);

        getContentPane().add(pnlSelectionOption);
        pnlSelectionOption.setBounds(0, 0, 1920, 1200);

        pnlAdminPanel.setMaximumSize(new java.awt.Dimension(1920, 1200));
        pnlAdminPanel.setMinimumSize(new java.awt.Dimension(1920, 1200));
        pnlAdminPanel.setLayout(null);

        labelAdminPanel1.setFont(new java.awt.Font("Arial", 1, 52)); // NOI18N
        labelAdminPanel1.setText("Admin Panel");
        pnlAdminPanel.add(labelAdminPanel1);
        labelAdminPanel1.setBounds(840, 80, 350, 50);

        labelAdmin.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        labelAdmin.setText("Admin");
        pnlAdminPanel.add(labelAdmin);
        labelAdmin.setBounds(150, 220, 160, 50);

        buttonBikeManagement.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        buttonBikeManagement.setText("Bike");
        buttonBikeManagement.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonBikeManagementMouseClicked(evt);
            }
        });
        buttonBikeManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBikeManagementActionPerformed(evt);
            }
        });
        pnlAdminPanel.add(buttonBikeManagement);
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
        pnlAdminPanel.add(buttonRentalManagement);
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
        pnlAdminPanel.add(buttonAdminPanelBack);
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
        pnlAdminPanel.add(ButtonAdminPanelExit);
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

        pnlAdminPanel.add(panelAdminPanelBikeAddBike);
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

        pnlAdminPanel.add(panelAdminPanelBikeUpdateBike);
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
        textFieldSearch.setToolTipText("");
        textFieldSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldSearchActionPerformed(evt);
            }
        });
        panelAdminPanelBike.add(textFieldSearch);
        textFieldSearch.setBounds(10, 10, 470, 40);

        buttonTextFieldSearch.setBackground(new java.awt.Color(255, 87, 87));
        buttonTextFieldSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/automoto/resources/Search.png"))); // NOI18N
        buttonTextFieldSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonTextFieldSearchMouseClicked(evt);
            }
        });
        buttonTextFieldSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTextFieldSearchActionPerformed(evt);
            }
        });
        panelAdminPanelBike.add(buttonTextFieldSearch);
        buttonTextFieldSearch.setBounds(480, 10, 90, 40);

        pnlAdminPanel.add(panelAdminPanelBike);
        panelAdminPanelBike.setBounds(440, 210, 1400, 732);

        panelAdminPanelRental.setBackground(new java.awt.Color(245, 245, 245));
        panelAdminPanelRental.setMaximumSize(new java.awt.Dimension(1400, 732));
        panelAdminPanelRental.setPreferredSize(new java.awt.Dimension(1400, 732));
        panelAdminPanelRental.setSize(new java.awt.Dimension(1400, 732));
        panelAdminPanelRental.setLayout(null);

        tblRentalData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "First Name", "Last Name", "Date of Birth", "Gender", "Bike Model", "Licence No", "Document Type", "Document No", "Rent Duration", "Mobile No", "Status"
            }
        ));
        tblRentalData.setRowHeight(30);
        jScrollPane2.setViewportView(tblRentalData);

        panelAdminPanelRental.add(jScrollPane2);
        jScrollPane2.setBounds(0, 0, 1400, 730);

        pnlAdminPanel.add(panelAdminPanelRental);
        panelAdminPanelRental.setBounds(440, 210, 1400, 732);

        panelAdminPanelHome.setBackground(new java.awt.Color(245, 245, 245));
        panelAdminPanelHome.setMaximumSize(new java.awt.Dimension(1400, 732));
        panelAdminPanelHome.setPreferredSize(new java.awt.Dimension(1400, 732));
        panelAdminPanelHome.setSize(new java.awt.Dimension(1400, 732));
        panelAdminPanelHome.setLayout(null);

        iconAdminPanelHomeImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/automoto/resources/WelcomeAdminPanel.png"))); // NOI18N
        panelAdminPanelHome.add(iconAdminPanelHomeImage);
        iconAdminPanelHomeImage.setBounds(10, 0, 1400, 730);

        pnlAdminPanel.add(panelAdminPanelHome);
        panelAdminPanelHome.setBounds(440, 210, 1400, 732);

        panelAdminPanelHomeDesign.setMaximumSize(new java.awt.Dimension(1440, 120));
        panelAdminPanelHomeDesign.setMinimumSize(new java.awt.Dimension(1440, 120));
        panelAdminPanelHomeDesign.setLayout(null);

        iconAdminPanelHomeDesign.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/automoto/resources/AdminPanelFloorDesign.png"))); // NOI18N
        panelAdminPanelHomeDesign.add(iconAdminPanelHomeDesign);
        iconAdminPanelHomeDesign.setBounds(0, 0, 1440, 120);

        pnlAdminPanel.add(panelAdminPanelHomeDesign);
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

        pnlAdminPanel.add(panelAdminPanelBikeAddButton);
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

        pnlAdminPanel.add(panelAdminPanelBikeUpdateButton);
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

        pnlAdminPanel.add(panelAdminPanelBikeDeleteButton);
        panelAdminPanelBikeDeleteButton.setBounds(1420, 1020, 390, 100);

        panelAdminPanelRentalAddButton.setBackground(new java.awt.Color(245, 245, 245));
        panelAdminPanelRentalAddButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelAdminPanelRentalAddButtonMouseClicked(evt);
            }
        });

        labelAdminPanelRentalUpdate.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        labelAdminPanelRentalUpdate.setText("                        Add Rental");
        labelAdminPanelRentalUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelAdminPanelRentalUpdateMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelAdminPanelRentalAddButtonLayout = new javax.swing.GroupLayout(panelAdminPanelRentalAddButton);
        panelAdminPanelRentalAddButton.setLayout(panelAdminPanelRentalAddButtonLayout);
        panelAdminPanelRentalAddButtonLayout.setHorizontalGroup(
            panelAdminPanelRentalAddButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAdminPanelRentalAddButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelAdminPanelRentalUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 858, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelAdminPanelRentalAddButtonLayout.setVerticalGroup(
            panelAdminPanelRentalAddButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAdminPanelRentalAddButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelAdminPanelRentalUpdate)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlAdminPanel.add(panelAdminPanelRentalAddButton);
        panelAdminPanelRentalAddButton.setBounds(460, 1040, 870, 60);

        panelAdminPanelRentalDeleteButton.setBackground(new java.awt.Color(255, 87, 87));
        panelAdminPanelRentalDeleteButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelAdminPanelRentalDeleteButtonMouseClicked(evt);
            }
        });

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

        pnlAdminPanel.add(panelAdminPanelRentalDeleteButton);
        panelAdminPanelRentalDeleteButton.setBounds(1420, 1020, 390, 100);

        iconAdminPanelBase.setBackground(new java.awt.Color(245, 245, 245));
        iconAdminPanelBase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/automoto/resources/AdminPanel.png"))); // NOI18N
        pnlAdminPanel.add(iconAdminPanelBase);
        iconAdminPanelBase.setBounds(0, 0, 1920, 1200);

        getContentPane().add(pnlAdminPanel);
        pnlAdminPanel.setBounds(0, 0, 1920, 1200);

        pnlQuickAction.setBackground(new java.awt.Color(48, 71, 94));
        pnlQuickAction.setMaximumSize(new java.awt.Dimension(1920, 1200));
        pnlQuickAction.setMinimumSize(new java.awt.Dimension(1920, 1200));
        pnlQuickAction.setLayout(null);

        labelQuickAction.setFont(new java.awt.Font("Silom", 1, 64)); // NOI18N
        labelQuickAction.setForeground(new java.awt.Color(240, 84, 84));
        labelQuickAction.setText("Quick Action");
        pnlQuickAction.add(labelQuickAction);
        labelQuickAction.setBounds(740, 70, 460, 70);

        buttonHome.setBackground(new java.awt.Color(240, 84, 84));
        buttonHome.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        buttonHome.setForeground(new java.awt.Color(255, 255, 255));
        buttonHome.setText("Home");
        buttonHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonHomeMouseClicked(evt);
            }
        });
        buttonHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHomeActionPerformed(evt);
            }
        });
        pnlQuickAction.add(buttonHome);
        buttonHome.setBounds(110, 250, 220, 100);

        buttonRent.setBackground(new java.awt.Color(240, 84, 84));
        buttonRent.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        buttonRent.setForeground(new java.awt.Color(255, 255, 255));
        buttonRent.setText("Rent");
        buttonRent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonRentMouseClicked(evt);
            }
        });
        buttonRent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRentActionPerformed(evt);
            }
        });
        pnlQuickAction.add(buttonRent);
        buttonRent.setBounds(110, 380, 220, 100);

        buttonReturn.setBackground(new java.awt.Color(240, 84, 84));
        buttonReturn.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        buttonReturn.setForeground(new java.awt.Color(255, 255, 255));
        buttonReturn.setText("Return");
        buttonReturn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonReturnMouseClicked(evt);
            }
        });
        buttonReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonReturnActionPerformed(evt);
            }
        });
        pnlQuickAction.add(buttonReturn);
        buttonReturn.setBounds(110, 510, 220, 100);

        buttonBack1.setBackground(new java.awt.Color(240, 84, 84));
        buttonBack1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        buttonBack1.setForeground(new java.awt.Color(255, 255, 255));
        buttonBack1.setText("Back");
        buttonBack1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonBack1MouseClicked(evt);
            }
        });
        buttonBack1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBack1ActionPerformed(evt);
            }
        });
        pnlQuickAction.add(buttonBack1);
        buttonBack1.setBounds(110, 830, 220, 100);

        buttonExit1.setBackground(new java.awt.Color(240, 84, 84));
        buttonExit1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        buttonExit1.setForeground(new java.awt.Color(255, 255, 255));
        buttonExit1.setText("Exit");
        buttonExit1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonExit1MouseClicked(evt);
            }
        });
        buttonExit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExit1ActionPerformed(evt);
            }
        });
        pnlQuickAction.add(buttonExit1);
        buttonExit1.setBounds(110, 960, 220, 100);

        panelHome.setBackground(new java.awt.Color(245, 245, 245));
        panelHome.setMaximumSize(new java.awt.Dimension(1390, 880));
        panelHome.setLayout(null);

        iconQuickActionBase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/automoto/resources/QuickActionHome.png"))); // NOI18N
        panelHome.add(iconQuickActionBase);
        iconQuickActionBase.setBounds(0, 0, 1390, 880);

        pnlQuickAction.add(panelHome);
        panelHome.setBounds(430, 220, 1390, 880);

        panelRent.setBackground(new java.awt.Color(245, 245, 245));
        panelRent.setMaximumSize(new java.awt.Dimension(1390, 880));
        panelRent.setMinimumSize(new java.awt.Dimension(1390, 880));
        panelRent.setLayout(null);

        labelRentTopic.setFont(new java.awt.Font("PT Mono", 1, 48)); // NOI18N
        labelRentTopic.setText("Enter The Rent Details Here");
        panelRent.add(labelRentTopic);
        labelRentTopic.setBounds(310, 50, 783, 55);

        fieldRentFirstName.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        panelRent.add(fieldRentFirstName);
        fieldRentFirstName.setBounds(380, 170, 341, 38);

        labelRentFirstName.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        labelRentFirstName.setText("First Name :");
        panelRent.add(labelRentFirstName);
        labelRentFirstName.setBounds(110, 170, 149, 36);

        fieldRentLastName.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        panelRent.add(fieldRentLastName);
        fieldRentLastName.setBounds(380, 240, 341, 38);

        labelRentLastName.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        labelRentLastName.setText("Last Name :");
        panelRent.add(labelRentLastName);
        labelRentLastName.setBounds(110, 240, 135, 38);

        fieldRentLicenceNo.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        fieldRentLicenceNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldRentLicenceNoActionPerformed(evt);
            }
        });
        panelRent.add(fieldRentLicenceNo);
        fieldRentLicenceNo.setBounds(380, 500, 340, 40);

        labelRentLicenceNo.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        labelRentLicenceNo.setText("License No :");
        panelRent.add(labelRentLicenceNo);
        labelRentLicenceNo.setBounds(110, 500, 143, 40);

        labelRentDocumentType.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        labelRentDocumentType.setText("Document Type:");
        panelRent.add(labelRentDocumentType);
        labelRentDocumentType.setBounds(110, 580, 188, 28);

        comboBoxRentDocumentType.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        comboBoxRentDocumentType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Citizenship", "National ID" }));
        comboBoxRentDocumentType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxRentDocumentTypeActionPerformed(evt);
            }
        });
        panelRent.add(comboBoxRentDocumentType);
        comboBoxRentDocumentType.setBounds(380, 570, 339, 40);

        sliderRentDurationOfRent.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        sliderRentDurationOfRent.setMajorTickSpacing(2);
        sliderRentDurationOfRent.setMaximum(12);
        sliderRentDurationOfRent.setMinimum(1);
        sliderRentDurationOfRent.setMinorTickSpacing(1);
        sliderRentDurationOfRent.setPaintLabels(true);
        sliderRentDurationOfRent.setPaintTicks(true);
        sliderRentDurationOfRent.setSnapToTicks(true);
        sliderRentDurationOfRent.setValue(1);
        panelRent.add(sliderRentDurationOfRent);
        sliderRentDurationOfRent.setBounds(380, 700, 340, 40);

        labelRentDurartionOfRent.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        labelRentDurartionOfRent.setText("Month Duration :");
        panelRent.add(labelRentDurartionOfRent);
        labelRentDurartionOfRent.setBounds(110, 710, 200, 28);

        labelRentGender.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        labelRentGender.setText("Gender :");
        panelRent.add(labelRentGender);
        labelRentGender.setBounds(110, 370, 99, 40);

        buttonGroupGender.add(radioButtonRentMale);
        radioButtonRentMale.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        radioButtonRentMale.setText("Male");
        radioButtonRentMale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioButtonRentMaleActionPerformed(evt);
            }
        });
        panelRent.add(radioButtonRentMale);
        radioButtonRentMale.setBounds(380, 380, 63, 26);

        buttonGroupGender.add(radioButtonRentFemale);
        radioButtonRentFemale.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        radioButtonRentFemale.setText("Female");
        panelRent.add(radioButtonRentFemale);
        radioButtonRentFemale.setBounds(490, 380, 85, 26);

        labelRentDateOfBirth.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        labelRentDateOfBirth.setText("Date Of Birth :");
        panelRent.add(labelRentDateOfBirth);
        labelRentDateOfBirth.setBounds(110, 320, 163, 28);

        labelRentDocumentNo.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        labelRentDocumentNo.setText("Document No :");
        panelRent.add(labelRentDocumentNo);
        labelRentDocumentNo.setBounds(110, 640, 171, 40);

        fieldRentDocumentNo.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        fieldRentDocumentNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldRentDocumentNoActionPerformed(evt);
            }
        });
        panelRent.add(fieldRentDocumentNo);
        fieldRentDocumentNo.setBounds(380, 640, 340, 40);

        comboBoxRentBikeModel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        comboBoxRentBikeModel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Model" }));
        comboBoxRentBikeModel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxRentBikeModelActionPerformed(evt);
            }
        });
        panelRent.add(comboBoxRentBikeModel);
        comboBoxRentBikeModel.setBounds(380, 430, 340, 39);

        labelRentBikeModel.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        labelRentBikeModel.setText("Bike Model :");
        panelRent.add(labelRentBikeModel);
        labelRentBikeModel.setBounds(110, 430, 142, 41);

        fieldRentDateOfBirth.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        panelRent.add(fieldRentDateOfBirth);
        fieldRentDateOfBirth.setBounds(380, 310, 342, 37);

        labelRentMobileNo.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        labelRentMobileNo.setText("Mobile No :");
        panelRent.add(labelRentMobileNo);
        labelRentMobileNo.setBounds(110, 770, 131, 30);

        fieldRentMobileNo.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        panelRent.add(fieldRentMobileNo);
        fieldRentMobileNo.setBounds(380, 763, 340, 40);

        buttonGroupGender.add(radioButtonRentOthers);
        radioButtonRentOthers.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        radioButtonRentOthers.setText("Others");
        radioButtonRentOthers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioButtonRentOthersActionPerformed(evt);
            }
        });
        panelRent.add(radioButtonRentOthers);
        radioButtonRentOthers.setBounds(610, 380, 81, 26);

        buttonRentBike.setBackground(new java.awt.Color(240, 84, 84));
        buttonRentBike.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        buttonRentBike.setText("Rent");
        buttonRentBike.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonRentBikeMouseClicked(evt);
            }
        });
        buttonRentBike.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRentBikeActionPerformed(evt);
            }
        });
        panelRent.add(buttonRentBike);
        buttonRentBike.setBounds(830, 740, 450, 50);

        labelRentWarningFirstName.setForeground(new java.awt.Color(255, 51, 0));
        labelRentWarningFirstName.setText("Warning");
        panelRent.add(labelRentWarningFirstName);
        labelRentWarningFirstName.setBounds(384, 210, 330, 17);

        labelRentWarningLastName.setForeground(new java.awt.Color(255, 51, 0));
        labelRentWarningLastName.setText("Warning");
        panelRent.add(labelRentWarningLastName);
        labelRentWarningLastName.setBounds(380, 280, 340, 17);

        labelRentWarningDateOfBirth.setForeground(new java.awt.Color(255, 51, 0));
        labelRentWarningDateOfBirth.setText("Warning");
        panelRent.add(labelRentWarningDateOfBirth);
        labelRentWarningDateOfBirth.setBounds(380, 350, 340, 17);

        labelRentWarningMobileNo.setForeground(new java.awt.Color(255, 51, 0));
        labelRentWarningMobileNo.setText("Warning");
        panelRent.add(labelRentWarningMobileNo);
        labelRentWarningMobileNo.setBounds(380, 800, 340, 20);

        labelRentWarningLicenceNo.setForeground(new java.awt.Color(255, 51, 0));
        labelRentWarningLicenceNo.setText("Warning");
        panelRent.add(labelRentWarningLicenceNo);
        labelRentWarningLicenceNo.setBounds(380, 540, 340, 17);

        labelRentWarningDocumentNo.setForeground(new java.awt.Color(255, 51, 0));
        labelRentWarningDocumentNo.setText("Warning");
        panelRent.add(labelRentWarningDocumentNo);
        labelRentWarningDocumentNo.setBounds(380, 680, 340, 17);

        pnlRentBikePictureDisplay.setBackground(new java.awt.Color(255, 255, 255));
        pnlRentBikePictureDisplay.setMaximumSize(new java.awt.Dimension(450, 560));
        pnlRentBikePictureDisplay.setMinimumSize(new java.awt.Dimension(450, 560));
        pnlRentBikePictureDisplay.setLayout(null);

        iconRentBanner.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/automoto/resources/RentBanner.png"))); // NOI18N
        pnlRentBikePictureDisplay.add(iconRentBanner);
        iconRentBanner.setBounds(0, 0, 450, 560);

        panelRent.add(pnlRentBikePictureDisplay);
        pnlRentBikePictureDisplay.setBounds(830, 180, 450, 560);

        buttonRentClear.setBackground(new java.awt.Color(240, 84, 84));
        buttonRentClear.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        buttonRentClear.setText("Clear");
        buttonRentClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRentClearActionPerformed(evt);
            }
        });
        panelRent.add(buttonRentClear);
        buttonRentClear.setBounds(1270, 0, 120, 50);

        pnlQuickAction.add(panelRent);
        panelRent.setBounds(430, 220, 1390, 880);

        panelReturn.setBackground(new java.awt.Color(245, 245, 245));
        panelReturn.setMaximumSize(new java.awt.Dimension(1390, 880));
        panelReturn.setMinimumSize(new java.awt.Dimension(1390, 880));
        panelReturn.setPreferredSize(new java.awt.Dimension(1390, 880));
        panelReturn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelRentTopic2.setFont(new java.awt.Font("PT Mono", 1, 48)); // NOI18N
        labelRentTopic2.setText("Enter The Return Details Here");
        panelReturn.add(labelRentTopic2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, -1, -1));

        fieldReturnFirstName.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        panelReturn.add(fieldReturnFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 190, 341, 38));

        labelReturnFirstName.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        labelReturnFirstName.setText("First Name :");
        panelReturn.add(labelReturnFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 149, 36));

        fieldReturnLastName.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        panelReturn.add(fieldReturnLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 280, 341, 38));

        labelReturnLastName.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        labelReturnLastName.setText("Last Name :");
        panelReturn.add(labelReturnLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, -1, 38));

        fieldReturnLicenceNo.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        fieldReturnLicenceNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldReturnLicenceNoActionPerformed(evt);
            }
        });
        panelReturn.add(fieldReturnLicenceNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 460, 340, 40));

        labelReturnLicenceNo.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        labelReturnLicenceNo.setText("License No :");
        panelReturn.add(labelReturnLicenceNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 460, -1, 40));

        labelReturnDocumentType.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        labelReturnDocumentType.setText("Document Type:");
        panelReturn.add(labelReturnDocumentType, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 560, -1, -1));

        comboBoxReturnDocumentType.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        comboBoxReturnDocumentType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Citizenship", "National ID" }));
        panelReturn.add(comboBoxReturnDocumentType, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 550, 339, 40));

        labelReturnDocumentNo.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        labelReturnDocumentNo.setText("Document No :");
        panelReturn.add(labelReturnDocumentNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 640, -1, 40));

        fieldReturnDocumentNo.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        fieldReturnDocumentNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldReturnDocumentNoActionPerformed(evt);
            }
        });
        panelReturn.add(fieldReturnDocumentNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 640, 340, 38));

        comboBoxReturnBikeModel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        comboBoxReturnBikeModel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose Model" }));
        panelReturn.add(comboBoxReturnBikeModel, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 370, 340, 39));

        labelReturnBikeModel.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        labelReturnBikeModel.setText("Bike Model :");
        panelReturn.add(labelReturnBikeModel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, -1, 41));

        labelReturnMobileNo.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        labelReturnMobileNo.setText("Mobile No :");
        panelReturn.add(labelReturnMobileNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 740, -1, 30));

        fieldReturnMobileNo.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        panelReturn.add(fieldReturnMobileNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 730, 340, 40));

        labelReturnWarningMobileNo.setForeground(new java.awt.Color(255, 0, 0));
        labelReturnWarningMobileNo.setText("Warning");
        panelReturn.add(labelReturnWarningMobileNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 770, 340, -1));

        labelReturnWarningFirstName.setForeground(new java.awt.Color(255, 0, 0));
        labelReturnWarningFirstName.setText("Warning");
        panelReturn.add(labelReturnWarningFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 230, 340, -1));

        labelReturnWarningLastName.setForeground(new java.awt.Color(255, 0, 0));
        labelReturnWarningLastName.setText("Warning");
        panelReturn.add(labelReturnWarningLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 320, 340, -1));

        labelReturnWarningLicenceNo.setForeground(new java.awt.Color(255, 0, 0));
        labelReturnWarningLicenceNo.setText("Warning");
        panelReturn.add(labelReturnWarningLicenceNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 500, 340, -1));

        labelReturnWarningDocumentNo.setForeground(new java.awt.Color(255, 0, 0));
        labelReturnWarningDocumentNo.setText("Warning");
        panelReturn.add(labelReturnWarningDocumentNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 680, 340, -1));

        buttonReturnBike.setBackground(new java.awt.Color(240, 84, 84));
        buttonReturnBike.setFont(new java.awt.Font("Helvetica Neue", 1, 36)); // NOI18N
        buttonReturnBike.setText("Return");
        buttonReturnBike.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonReturnBikeMouseClicked(evt);
            }
        });
        buttonReturnBike.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonReturnBikeActionPerformed(evt);
            }
        });
        panelReturn.add(buttonReturnBike, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 740, 450, 50));

        pnlReturnBannerBase.setBackground(new java.awt.Color(255, 255, 255));
        pnlReturnBannerBase.setMaximumSize(new java.awt.Dimension(450, 560));
        pnlReturnBannerBase.setMinimumSize(new java.awt.Dimension(450, 560));

        iconReturnBanner.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/automoto/resources/ReturnBanner.png"))); // NOI18N

        javax.swing.GroupLayout pnlReturnBannerBaseLayout = new javax.swing.GroupLayout(pnlReturnBannerBase);
        pnlReturnBannerBase.setLayout(pnlReturnBannerBaseLayout);
        pnlReturnBannerBaseLayout.setHorizontalGroup(
            pnlReturnBannerBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(iconReturnBanner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlReturnBannerBaseLayout.setVerticalGroup(
            pnlReturnBannerBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(iconReturnBanner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panelReturn.add(pnlReturnBannerBase, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 180, -1, -1));

        buttonReturnClear.setBackground(new java.awt.Color(240, 84, 84));
        buttonReturnClear.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        buttonReturnClear.setText("Clear");
        buttonReturnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonReturnClearActionPerformed(evt);
            }
        });
        panelReturn.add(buttonReturnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(1265, 0, 130, 50));

        pnlQuickAction.add(panelReturn);
        panelReturn.setBounds(430, 220, 1390, 880);

        panelDecuration1.setBackground(new java.awt.Color(245, 245, 245));

        javax.swing.GroupLayout panelDecuration1Layout = new javax.swing.GroupLayout(panelDecuration1);
        panelDecuration1.setLayout(panelDecuration1Layout);
        panelDecuration1Layout.setHorizontalGroup(
            panelDecuration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        panelDecuration1Layout.setVerticalGroup(
            panelDecuration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );

        pnlQuickAction.add(panelDecuration1);
        panelDecuration1.setBounds(360, 240, 50, 120);

        panelDecuration2.setBackground(new java.awt.Color(245, 245, 245));

        javax.swing.GroupLayout panelDecuration2Layout = new javax.swing.GroupLayout(panelDecuration2);
        panelDecuration2.setLayout(panelDecuration2Layout);
        panelDecuration2Layout.setHorizontalGroup(
            panelDecuration2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        panelDecuration2Layout.setVerticalGroup(
            panelDecuration2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );

        pnlQuickAction.add(panelDecuration2);
        panelDecuration2.setBounds(360, 370, 50, 120);

        panelDecuration3.setBackground(new java.awt.Color(245, 245, 245));

        javax.swing.GroupLayout panelDecuration3Layout = new javax.swing.GroupLayout(panelDecuration3);
        panelDecuration3.setLayout(panelDecuration3Layout);
        panelDecuration3Layout.setHorizontalGroup(
            panelDecuration3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        panelDecuration3Layout.setVerticalGroup(
            panelDecuration3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );

        pnlQuickAction.add(panelDecuration3);
        panelDecuration3.setBounds(360, 500, 50, 120);

        IconQuickActionBaseplate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/automoto/resources/QuickActionBasePlate.png"))); // NOI18N
        pnlQuickAction.add(IconQuickActionBaseplate);
        IconQuickActionBaseplate.setBounds(0, 0, 1920, 1200);

        getContentPane().add(pnlQuickAction);
        pnlQuickAction.setBounds(0, 0, 1920, 1200);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void panelAsButtonForQuickActionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelAsButtonForQuickActionMouseClicked
        // TODO add your handling code here:
        pnlSelectionOption.setVisible(false);
        pnlQuickAction.setVisible(true);
        panelDecuration1.setVisible(true);
        panelDecuration2.setVisible(false);
        panelDecuration3.setVisible(false);
        panelRent.setVisible(false);
        panelReturn.setVisible(false);
        labelRentWarningFirstName.setVisible(false);
        labelRentWarningLastName.setVisible(false);
        labelRentWarningDateOfBirth.setVisible(false);
        labelRentWarningLicenceNo.setVisible(false);
        labelRentWarningDocumentNo.setVisible(false);
        labelRentWarningMobileNo.setVisible(false);
        labelReturnWarningFirstName.setVisible(false);
        labelReturnWarningLastName.setVisible(false);
        labelReturnWarningLicenceNo.setVisible(false);
        labelReturnWarningDocumentNo.setVisible(false);
        labelReturnWarningMobileNo.setVisible(false);
        panelHome.setVisible(true);
    }//GEN-LAST:event_panelAsButtonForQuickActionMouseClicked

    private void panelAsButtonForAdminPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelAsButtonForAdminPanelMouseClicked
        // TODO add your handling code here:
        pnlSelectionOption.setVisible(false);
        pnlAdminPanel.setVisible(true);
        panelAdminPanelHome.setVisible(true);
        panelAdminPanelRentalAddButton.setVisible(false);
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
        panelAdminPanelRental.setVisible(false);
//        initialRentLogs();
    }//GEN-LAST:event_panelAsButtonForAdminPanelMouseClicked

    private void buttonBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonBackMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonBackMouseClicked

    private void buttonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBackActionPerformed
        // TODO add your handling code here:
        this.setVisible(false); // Visibility of current frame (ActionFrame) is False when back button is pressed.
        new Home().setVisible(true); // new object of Home Frame class is created and its visible is set to true.
    }//GEN-LAST:event_buttonBackActionPerformed

    private void buttonExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonExitMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonExitMouseClicked

    private void buttonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExitActionPerformed
        // TODO add your handling code here:
        System.exit(0); // Exits the system
    }//GEN-LAST:event_buttonExitActionPerformed

    private void buttonBikeManagementMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonBikeManagementMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonBikeManagementMouseClicked

    private void buttonRentalManagementMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonRentalManagementMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonRentalManagementMouseClicked

    private void buttonRentalManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRentalManagementActionPerformed
        // TODO add your handling code here:
        panelAdminPanelRental.setVisible(true);
        panelAdminPanelHome.setVisible(false);
        panelAdminPanelRentalAddButton.setVisible(true);
        panelAdminPanelRentalDeleteButton.setVisible(true);
        panelAdminPanelBikeAddButton.setVisible(false);
        panelAdminPanelBikeUpdateButton.setVisible(false);
        panelAdminPanelBikeDeleteButton.setVisible(false);
        panelAdminPanelBike.setVisible(false);
        panelAdminPanelBikeAddBike.setVisible(false);
        panelAdminPanelHomeDesign.setVisible(false);
        panelAdminPanelBikeUpdateBike.setVisible(false);
    }//GEN-LAST:event_buttonRentalManagementActionPerformed

    private void buttonAdminPanelBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonAdminPanelBackMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonAdminPanelBackMouseClicked

    private void buttonAdminPanelBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAdminPanelBackActionPerformed
        // TODO add your handling code here:
        pnlSelectionOption.setVisible(true);
        pnlAdminPanel.setVisible(false);
    }//GEN-LAST:event_buttonAdminPanelBackActionPerformed

    private void ButtonAdminPanelExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonAdminPanelExitMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonAdminPanelExitMouseClicked

    private void ButtonAdminPanelExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAdminPanelExitActionPerformed
        // TODO add your handling code here:
        System.exit(0); //Exits the system
    }//GEN-LAST:event_ButtonAdminPanelExitActionPerformed

    private void buttonClearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonClearMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonClearMouseClicked

    private void buttonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClearActionPerformed
        // TODO add your handling code here:
        JTextField[] fields = {fieldBikeNo, fieldBikeModel, fieldBikeCondition, fieldBikePrice};
        for (JTextField field : fields) {
            field.setText(""); // Clearing the field.
        }
        comboBoxBikeType.setSelectedIndex(0); // Resets the combo box to its first index selection
    }//GEN-LAST:event_buttonClearActionPerformed

    private void buttonAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonAddMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonAddMouseClicked

    private void buttonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddActionPerformed
        // TODO add your handling code here:
        // Initalizing arrays for input fields and its warning labels.
        JTextField[] fields = {fieldBikeNo, fieldBikeModel, fieldBikeCondition, fieldBikePrice};
        JLabel[] labels = {labelWarningBikeNo, labelWarningBikeModel, labelWarningBikeCondition, labelWarningBikePrice};

        boolean hasEmptyFields = false;

        // Validation for empty fields
        for (int i = 0; i < fields.length; i++) {
            if (fields[i].getText().isEmpty()) {
                labels[i].setText("This field is required!");
                labels[i].setVisible(true);
                hasEmptyFields = true;
            } else {
                labels[i].setVisible(false);
            }
        }

        // If any field is empty, the logic exits.
        if (hasEmptyFields) {
            return;
        }

        // Retrieving values from input components
        String bikeNo = (String) fieldBikeNo.getText();
        String bikeModel = fieldBikeModel.getText();
        String bikeCondition = fieldBikeCondition.getText();
        String bikeType = (String) comboBoxBikeType.getSelectedItem();
        double bikePrice;

//        Bike Price Validation
        try {
            bikePrice = Double.parseDouble(fieldBikePrice.getText());
        } catch (NumberFormatException e) {
            labelWarningBikePrice.setText("Please enter a valid number!");
            labelWarningBikePrice.setVisible(true);
            return;
        }

        // Check whether the bike type is selected or not.
        if (bikeType.equals("Bike Type")) {
            JOptionPane.showMessageDialog(null, "Please Select your bike type", "Empty Selection", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // Bike Condition Validation
        if (bikeCondition.equals("Best") || bikeCondition.equals("Good") || bikeCondition.equals("Fair") || bikeCondition.equals("Poor")) {
            boolean isValid = true;

            if (isValid) {
                BikeModel newBike = new BikeModel(bikeNo, bikeModel, bikeCondition, bikePrice, bikeType);
                // Checking duplicate bike number
                if (checkBikeNo(newBike)) {
                    JOptionPane.showMessageDialog(null, "Duplicate Details.", "Duplicate", JOptionPane.INFORMATION_MESSAGE);

                } else {
                    // Adding the new bike data to the list
                    addBikes(newBike);
                    JOptionPane.showMessageDialog(null, "Added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);

                    // Clearing the field after completion
                    for (JTextField field : fields) {
                        field.setText("");
                    }
                    comboBoxBikeType.setSelectedIndex(0);
                }

            }

            panelAdminPanelBikeAddBike.setVisible(false);
            panelAdminPanelBike.setVisible(true);
        } else {
            labelWarningBikeCondition.setText("Select Either Best, Good, Fair or Poor");
            labelWarningBikeCondition.setVisible(true);
        }
    }//GEN-LAST:event_buttonAddActionPerformed

    
    private void buttonUpdateClearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonUpdateClearMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonUpdateClearMouseClicked

    private void buttonUpdateClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateClearActionPerformed
        // TODO add your handling code here:
        // logic for clearing the fields
        JTextField[] fields = {fieldUpdateBikeNo, fieldUpdateBikeModel, fieldUpdateBikeCondition, fieldUpdateBikePrice};
        for (JTextField field : fields) {
            field.setText("");
        }
        comboBoxUpdateBikeType.setSelectedIndex(0);
    }//GEN-LAST:event_buttonUpdateClearActionPerformed

    private void buttonUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonUpdateMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonUpdateMouseClicked

    private void buttonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateActionPerformed
        // TODO add your handling code here:
        // Initalizing arrays for input fields and its warning labels.
        JTextField[] fields = {fieldUpdateBikeNo, fieldUpdateBikeModel, fieldUpdateBikeCondition, fieldUpdateBikePrice};
        JLabel[] labels = {labelWarningUpdateBikeNo, labelWarningUpdateBikeModel, labelWarningUpdateBikeCondition, labelWarningUpdateBikePrice};

        boolean hasEmptyFields = false;

        // Empty field Validation
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

        // Retrieving values from input components
        String bikeNo = (String) fieldUpdateBikeNo.getText();
        String bikeModel = fieldUpdateBikeModel.getText();
        String bikeCondition = fieldUpdateBikeCondition.getText();
        String bikeType = (String) comboBoxUpdateBikeType.getSelectedItem();
        double bikePrice;

        // Bike Price Validation for invalid number
        try {
            bikePrice = Double.parseDouble(fieldUpdateBikePrice.getText());
        } catch (NumberFormatException e) {
            labelWarningUpdateBikePrice.setText("Please enter a valid number!");
            labelWarningUpdateBikePrice.setVisible(true);
            return;
        }

        // Bike Type Validation for empty selection
        if (bikeType.equals("Bike Type")) {
            JOptionPane.showMessageDialog(null, "Please Select your bike type", "Empty Selection", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // Bike Conditon Validation for incorrect credentials.
        if (bikeCondition.equals("Best") || bikeCondition.equals("Good") || bikeCondition.equals("Fair") || bikeCondition.equals("Poor")) {
            boolean isValid = true;

            if (isValid) {
                // Locateing the bike in the LinkedList and updating it
                for (BikeModel bikes : bikeList) {
                    if (bikes.getBikeNumber().equals(bikeNo)) {
                        // Updating bike details
                        bikes.setModel(bikeModel);
                        bikes.setCondition(bikeCondition);
                        bikes.setPrice(bikePrice);
                        bikes.setType(bikeType);

                        updateBikes(); // updating to the table.
                        
                        JOptionPane.showMessageDialog(null, "Bike Infomation updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);

                        panelAdminPanelBikeUpdateBike.setVisible(false);
                        panelAdminPanelBike.setVisible(true);

                        return;
                    }
                }
            }

        } else {
            labelWarningUpdateBikeCondition.setText("Select Either Best, Good, Fair or Poor");
            labelWarningUpdateBikeCondition.setVisible(true);
        }
    }//GEN-LAST:event_buttonUpdateActionPerformed

    private void comboBoxAttributeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxAttributeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxAttributeActionPerformed

    private void buttonFilterDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFilterDownActionPerformed
        // TODO add your handling code here:
        // Initializing sorting Algorithms
        SelectionSort selectionSort = new SelectionSort();
        InsertionSort insertionSort = new InsertionSort();
        MergeSort mergeSort = new MergeSort();
        
        // Selection of sorting via respecitve combobox attributes (Name, Price, Condition)
        String filterSelection = (String) comboBoxAttribute.getSelectedItem();

        // Sorting in descending order based on the selected attribute
        if (filterSelection.equals("Name")) {
            List<BikeModel> sortedList = mergeSort.sortByModel(bikeList, true);
            sortedData(sortedList);
        } else if (filterSelection.equals("Price")) {
            List<BikeModel> sortedList = selectionSort.sortByPrice(bikeList, false);
            sortedData(sortedList);
        } else if (filterSelection.equals("Condition")) {
            List<BikeModel> sortedList = insertionSort.sortByCondition(bikeList, false);
            sortedData(sortedList);
        }
    }//GEN-LAST:event_buttonFilterDownActionPerformed

    private void buttonFilterUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFilterUpActionPerformed
        // TODO add your handling code here:
        // Initializing sorting Algorithms
        SelectionSort selectionSort = new SelectionSort();
        InsertionSort insertionSort = new InsertionSort();
        MergeSort mergeSort = new MergeSort();
        
        // Selection of sorting via respecitve combobox attributes (Name, Price, Condition)
        String filterSelection = (String) comboBoxAttribute.getSelectedItem();

        // Sorting in ascending order based on the selected attribute
        if (filterSelection.equals("Name")) {
            List<BikeModel> sortedList = mergeSort.sortByModel(bikeList, false);
            sortedData(sortedList);
        } else if (filterSelection.equals("Price")) {
            List<BikeModel> sortedList = selectionSort.sortByPrice(bikeList, true);
            sortedData(sortedList);
        } else if (filterSelection.equals("Condition")) {
            List<BikeModel> sortedList = insertionSort.sortByCondition(bikeList, true);
            sortedData(sortedList);
        }
    }//GEN-LAST:event_buttonFilterUpActionPerformed

    private void buttonTextFieldSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonTextFieldSearchMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonTextFieldSearchMouseClicked

    private void panelAdminPanelBikeAddButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelAdminPanelBikeAddButtonMouseClicked
        // TODO add your handling code here:
        panelAdminPanelBike.setVisible(false);
        panelAdminPanelBikeAddBike.setVisible(true);
        panelAdminPanelBikeUpdateBike.setVisible(false);
    }//GEN-LAST:event_panelAdminPanelBikeAddButtonMouseClicked

    private void panelAdminPanelBikeUpdateButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelAdminPanelBikeUpdateButtonMouseClicked
        // TODO add your handling code here:

        // Here the code is written in such a way that the update panel opens even when the item is not selected for flexibility.
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

    private void panelAdminPanelBikeDeleteButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelAdminPanelBikeDeleteButtonMouseClicked
        // TODO add your handling code here:
        int selectedRow = tblBikeData.getSelectedRow();

        if (selectedRow != -1) { // Checking if a row is selected
            // Extracting the row data
            String bikeNumber = (String) tblBikeData.getValueAt(selectedRow, 0);
            int confirm = JOptionPane.showConfirmDialog(
                    null, // Parent component
                    "Are you sure you want to delete this Bike?",
                    "Confirm Deletion",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE);
            if (confirm == JOptionPane.YES_OPTION) {
                // Attempting to delete the file
                boolean deleted = deleteBikes(bikeNumber, selectedRow);
                if (deleted) { // if deleted
                    JOptionPane.showMessageDialog(null, "Bike deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } else {
            // showing an error message to select a Bike to delete.
            JOptionPane.showMessageDialog(null, "Please select a Bike to delete.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_panelAdminPanelBikeDeleteButtonMouseClicked

    private void panelAdminPanelRentalAddButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelAdminPanelRentalAddButtonMouseClicked
        // TODO add your handling code here:
        panelAdminPanelRental.setVisible(false);
    }//GEN-LAST:event_panelAdminPanelRentalAddButtonMouseClicked

    private void panelAdminPanelRentalDeleteButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelAdminPanelRentalDeleteButtonMouseClicked
        // TODO add your handling code here:
        int selectedRow = tblRentalData.getSelectedRow();

        if (selectedRow != -1) { // Checking if a row is selected
            try {
                // Extracting licence number
                long licenceNumber = Long.parseLong(tblRentalData.getValueAt(selectedRow, 5).toString());

                int confirm = JOptionPane.showConfirmDialog(
                        null, // Parent component
                        "Are you sure you want to delete this Rental Log?",
                        "Confirm Deletion",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE);

                if (confirm == JOptionPane.YES_OPTION) {
                    // Attempting to delete the file
                    boolean deleted = deleteRental(licenceNumber, selectedRow);
                    if (deleted) { // if deleted
                        JOptionPane.showMessageDialog(null, "Rental Log deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    } else { // if not deleted
                        JOptionPane.showMessageDialog(null, "Rental Log not found.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid Licence Number format.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a Rental Log to delete.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_panelAdminPanelRentalDeleteButtonMouseClicked

    private void buttonHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonHomeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonHomeMouseClicked

    private void buttonHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHomeActionPerformed
        // TODO add your handling code here:
        panelDecuration1.setVisible(true);
        panelDecuration2.setVisible(false);
        panelDecuration3.setVisible(false);
        panelHome.setVisible(true);
        panelRent.setVisible(false);
        panelReturn.setVisible(false);
    }//GEN-LAST:event_buttonHomeActionPerformed

    private void buttonRentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonRentMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonRentMouseClicked

    private void buttonRentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRentActionPerformed
        // TODO add your handling code here:
        panelDecuration2.setVisible(true);
        panelDecuration1.setVisible(false);
        panelDecuration3.setVisible(false);
        panelHome.setVisible(false);
        panelRent.setVisible(true);
        panelReturn.setVisible(false);
        populateCheckBox("Available");
    }//GEN-LAST:event_buttonRentActionPerformed

    private void buttonReturnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonReturnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonReturnMouseClicked

    private void buttonReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonReturnActionPerformed
        // TODO add your handling code here:
        panelDecuration3.setVisible(true);
        panelDecuration1.setVisible(false);
        panelDecuration2.setVisible(false);
        panelHome.setVisible(false);
        panelRent.setVisible(false);
        panelReturn.setVisible(true);
        populateCheckBox("Rented");
    }//GEN-LAST:event_buttonReturnActionPerformed

    private void buttonBack1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonBack1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonBack1MouseClicked

    private void buttonBack1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBack1ActionPerformed
        // TODO add your handling code here:
        pnlQuickAction.setVisible(false);
        pnlSelectionOption.setVisible(true);
    }//GEN-LAST:event_buttonBack1ActionPerformed

    private void buttonExit1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonExit1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonExit1MouseClicked

    private void buttonExit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExit1ActionPerformed
        // TODO add your handling code here:
        System.exit(0); // Exits the system
    }//GEN-LAST:event_buttonExit1ActionPerformed

    private void fieldRentLicenceNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldRentLicenceNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldRentLicenceNoActionPerformed

    private void comboBoxRentDocumentTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxRentDocumentTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxRentDocumentTypeActionPerformed

    private void radioButtonRentMaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioButtonRentMaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioButtonRentMaleActionPerformed

    private void fieldRentDocumentNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldRentDocumentNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldRentDocumentNoActionPerformed

    private void radioButtonRentOthersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioButtonRentOthersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioButtonRentOthersActionPerformed

    private void buttonRentBikeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonRentBikeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonRentBikeMouseClicked

    private void buttonRentBikeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRentBikeActionPerformed
        // TODO add your handling code here:
        // Initalizing arrays for input fields and its warning labels.
        JTextField[] fields = {fieldRentFirstName, fieldRentLastName, fieldRentDateOfBirth, fieldRentLicenceNo, fieldRentDocumentNo, fieldRentMobileNo};
        JLabel[] labels = {labelRentWarningFirstName, labelRentWarningLastName, labelRentWarningDateOfBirth, labelRentWarningLicenceNo, labelRentWarningDocumentNo, labelRentWarningMobileNo};

        boolean hasEmptyFields = false;

        // Empty field Validation
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

        // Extracting Input Values
        String firstName = fieldRentFirstName.getText();
        String lastName = fieldRentLastName.getText();
        String dOB = fieldRentDateOfBirth.getText();
        long documentNo;
        long licenceNo;
        long mobileNo;
        String documentType = (String) comboBoxRentDocumentType.getSelectedItem();
        String gender = "Not Defined";
        String bikeNumberModel = (String) comboBoxRentBikeModel.getSelectedItem();
        int durationOfRent = sliderRentDurationOfRent.getValue();

        // Validating licence No based on datatypes
        try {
            licenceNo = Long.parseLong(fieldRentLicenceNo.getText());
        } catch (NumberFormatException e) {
            labelRentWarningLicenceNo.setText("Please enter a valid number!");
            labelRentWarningLicenceNo.setVisible(true);
            return;
        }

        // Validating Document No based on datatypes
        try {
            documentNo = Long.parseLong(fieldRentDocumentNo.getText());
        } catch (NumberFormatException e) {
            labelRentWarningDocumentNo.setText("Please enter a valid number!");
            labelRentWarningDocumentNo.setVisible(true);
            return;
        }

        // Validating Mobile No based on datatypes
        try {
            mobileNo = Long.parseLong(fieldRentMobileNo.getText());
        } catch (NumberFormatException e) {
            labelRentWarningMobileNo.setText("Please enter a valid number!");
            labelRentWarningMobileNo.setVisible(true);
            return;
        }

        // Empty selection Validating for Gender Selection
        if (!radioButtonRentMale.isSelected() && !radioButtonRentFemale.isSelected() && !radioButtonRentOthers.isSelected()) {
            JOptionPane.showMessageDialog(null, "Gender is not selected. Please select a gender!", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        } else {
            if (radioButtonRentMale.isSelected()) {
                gender = "Male";
            } else if (radioButtonRentFemale.isSelected()) {
                gender = "Female";
            } else if (radioButtonRentOthers.isSelected()) {
                gender = "Others";
            }
        }

        // Empty selection validation for combobox Select Model
        if (comboBoxRentBikeModel.getSelectedItem().toString().equals("Select Model")) {
            JOptionPane.showMessageDialog(null, "Please Select the Bike Model", "Model Not Selected!", JOptionPane.WARNING_MESSAGE);
            return;
        }

        boolean isValid = true;

        if (isValid) {
            String bikeNumber = bikeNumberModel.split("_")[0]; // spliting and retriving the forward value from "_"
            double basePrice = 0;

            // Fetch the base price from the BikeModel object
            for (BikeModel bike : bikeList) {
                if (bike.getBikeNumber().equals(bikeNumber)) {
                    basePrice = bike.getPrice(); // Use the getPrice() method
                    break;
                }
            }

            // Price Validation
            if (basePrice == 0) {
                JOptionPane.showMessageDialog(null, "Error: Bike price not found!", "Warning", JOptionPane.ERROR_MESSAGE);
                return;
            }

            double totalPrice = basePrice * durationOfRent;

            // Showing confirmation pane before proceeding
            int confirm = JOptionPane.showConfirmDialog(
                    null,
                    "Confirm Renting?\n"
                    + "Bike Model: " + bikeNumberModel + "\n"
                    + "Customer: " + firstName + " " + lastName + "\n"
                    + "Duration: " + durationOfRent + " month(s)\n"
                    + "Total Price: $" + totalPrice,
                    "Confirm Rental",
                    JOptionPane.YES_NO_OPTION
            );

            if (confirm == JOptionPane.YES_OPTION) {
                RentalModel newRent = new RentalModel(firstName, lastName, dOB, gender, bikeNumberModel, licenceNo, documentType, documentNo, durationOfRent, mobileNo);

                if (checkLicenceNo(newRent)) {
                    JOptionPane.showMessageDialog(null, "Duplicate Details.", "Duplicate", JOptionPane.WARNING_MESSAGE);
                } else {
                    addRental(newRent);

                    for (BikeModel bike : bikeList) {
                        if (bike.getBikeNumber().equals(bikeNumber)) {
                            bike.setStatus("Rented");
                            break;
                        }
                    }

                    updateBikes();

                    // Print the bill and other details in an option pane
                    String bill = "===== Rental Bill =====\n"
                            + "Customer Name: " + firstName + " " + lastName + "\n"
                            + "Date of Birth: " + dOB + "\n"
                            + "Gender: " + gender + "\n"
                            + "Bike Model: " + bikeNumberModel + "\n"
                            + "Licence No: " + licenceNo + "\n"
                            + "Document Type: " + documentType + "\n"
                            + "Document No: " + documentNo + "\n"
                            + "Mobile No: " + mobileNo + "\n"
                            + "Duration: " + durationOfRent + " month(s)\n"
                            + "Total Price: $" + totalPrice + "\n"
                            + "======================";

                    JOptionPane.showMessageDialog(null, bill, "Rental Successful", JOptionPane.INFORMATION_MESSAGE);

                    populateCheckBox("Available");

                    // Clearing the fields
                    for (JTextField field : fields) {
                        field.setText("");
                    }
                    // Assigning dafualt or particular value to the component as defualt
                    comboBoxRentBikeModel.setSelectedIndex(0);
                    comboBoxRentDocumentType.setSelectedIndex(0);
                    sliderRentDurationOfRent.setValue(1);
                    buttonGroupGender.clearSelection();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Rental Cancelled.", "Cancelled", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_buttonRentBikeActionPerformed

    private void fieldReturnLicenceNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldReturnLicenceNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldReturnLicenceNoActionPerformed

    private void fieldReturnDocumentNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldReturnDocumentNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldReturnDocumentNoActionPerformed

    private void buttonReturnBikeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonReturnBikeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonReturnBikeMouseClicked

    private void buttonReturnBikeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonReturnBikeActionPerformed
        // TODO add your handling code here:
        JTextField[] fields = {fieldReturnFirstName, fieldReturnLastName, fieldReturnLicenceNo, fieldReturnDocumentNo, fieldReturnMobileNo};
        JLabel[] labels = {labelReturnWarningFirstName, labelReturnWarningLastName, labelReturnWarningLicenceNo, labelReturnWarningDocumentNo, labelReturnWarningMobileNo};

        boolean hasEmptyFields = false;

        // Validate if fields are empty
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
        String firstName = fieldReturnFirstName.getText();
        String lastName = fieldReturnLastName.getText();
        long documentNo;
        long licenceNo;
        long mobileNo;

        // Validating document Type selection
        String documentType = (String) comboBoxReturnDocumentType.getSelectedItem();
        if (documentType == null || documentType.equals("Select Document Type")) {
            JOptionPane.showMessageDialog(null, "Please select a valid document type.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Validating bikeNumberModel selection
        String bikeNumberModel = (String) comboBoxReturnBikeModel.getSelectedItem();
        if (bikeNumberModel == null || bikeNumberModel.equals("Select Model")) {
            JOptionPane.showMessageDialog(null, "Please select a valid bike model.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Licence no validation for data types
        try {
            licenceNo = Long.parseLong(fieldReturnLicenceNo.getText());
        } catch (NumberFormatException e) {
            labelReturnWarningLicenceNo.setText("Please enter a valid number!");
            labelReturnWarningLicenceNo.setVisible(true);
            return;
        }

        // document no validation for data types
        try {
            documentNo = Long.parseLong(fieldReturnDocumentNo.getText());
        } catch (NumberFormatException e) {
            labelReturnWarningDocumentNo.setText("Please enter a valid number!");
            labelReturnWarningDocumentNo.setVisible(true);
            return;
        }

        // mobile no validation for data types
        try {
            mobileNo = Long.parseLong(fieldReturnMobileNo.getText());
        } catch (NumberFormatException e) {
            labelReturnWarningMobileNo.setText("Please enter a valid number!");
            labelReturnWarningMobileNo.setVisible(true);
            return;
        }

        boolean isValid = false;

        // Validating with the rentalList
        RentalModel matchingRental = null;
        for (RentalModel rental : rentalList) {
            // Checks if all the provided details match with the current rental records.
            if (rental.getLicenceNumber() == licenceNo
                    && rental.getFirstName().equals(firstName)
                    && rental.getLastName().equals(lastName)
                    && rental.getDocumentNumber() == documentNo
                    && rental.getMobileNumber() == mobileNo
                    && rental.getDocumentType().equals(documentType)
                    && rental.getStatus().equals("Rented")) {
                isValid = true;
                matchingRental = rental;
                break;
            }
        }

        if (!isValid) {
            JOptionPane.showMessageDialog(null, "No matching rental record found", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Proceed with the return process
        if (isValid) {
            String bikeNumber = bikeNumberModel.split("_")[0]; // Extract bike number

            // Updateing bike status to "Available" via looping
            for (BikeModel bike : bikeList) {
                if (bike.getBikeNumber().equals(bikeNumber)) {
                    bike.setStatus("Available");
                    break;
                }
            }

            updateBikes(); //Calling the updateBike Method to update the data in table

            // Updates rental status to "Returned"
            if (matchingRental != null) {
                matchingRental.setStatus("Returned");
            }

            updateRentals(); // Calling the updateRentals method to update the data in table

            JOptionPane.showMessageDialog(null, "Bike Returned Successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            populateCheckBox("Rented");

            // Clear all fields and reset combo boxes
            for (JTextField field : fields) {
                field.setText("");
            }
            comboBoxReturnBikeModel.setSelectedIndex(0);
            comboBoxReturnDocumentType.setSelectedIndex(0);
        }
    }//GEN-LAST:event_buttonReturnBikeActionPerformed

    private void comboBoxRentBikeModelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxRentBikeModelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxRentBikeModelActionPerformed

    private void labelAdminPanelRentalUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelAdminPanelRentalUpdateMouseClicked
        // TODO add your handling code here:
        pnlAdminPanel.setVisible(false);
        pnlQuickAction.setVisible(true);
        panelDecuration1.setVisible(false);
        panelDecuration2.setVisible(true);
        panelDecuration3.setVisible(false);
        panelHome.setVisible(false);
        panelRent.setVisible(true);
        panelReturn.setVisible(false);
        labelRentWarningFirstName.setVisible(false);
        labelRentWarningLastName.setVisible(false);
        labelRentWarningDateOfBirth.setVisible(false);
        labelRentWarningLicenceNo.setVisible(false);
        labelRentWarningDocumentNo.setVisible(false);
        labelRentWarningMobileNo.setVisible(false);
        labelReturnWarningFirstName.setVisible(false);
        labelReturnWarningLastName.setVisible(false);
        labelReturnWarningLicenceNo.setVisible(false);
        labelReturnWarningDocumentNo.setVisible(false);
        labelReturnWarningMobileNo.setVisible(false);
        populateCheckBox("Available");
    }//GEN-LAST:event_labelAdminPanelRentalUpdateMouseClicked

    private void textFieldSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldSearchActionPerformed

    private void buttonBikeManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBikeManagementActionPerformed
        // TODO add your handling code here:
        panelAdminPanelHome.setVisible(false);
        panelAdminPanelRentalAddButton.setVisible(false);
        panelAdminPanelRentalDeleteButton.setVisible(false);
        panelAdminPanelBikeAddButton.setVisible(true);
        panelAdminPanelBikeUpdateButton.setVisible(true);
        panelAdminPanelBikeDeleteButton.setVisible(true);
        panelAdminPanelBike.setVisible(true);
        panelAdminPanelBikeAddBike.setVisible(false);
        panelAdminPanelHomeDesign.setVisible(false);
        panelAdminPanelBikeUpdateBike.setVisible(false);
        panelAdminPanelRental.setVisible(false);
    }//GEN-LAST:event_buttonBikeManagementActionPerformed

    private void buttonTextFieldSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTextFieldSearchActionPerformed
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
    }//GEN-LAST:event_buttonTextFieldSearchActionPerformed

    private void buttonRentClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRentClearActionPerformed
        // TODO add your handling code here:
        JTextField[] fields = {fieldRentFirstName, fieldRentLastName, fieldRentDateOfBirth, fieldRentLicenceNo, fieldRentDocumentNo, fieldRentMobileNo};

        for (JTextField field : fields) {
            field.setText("");
        }

        comboBoxRentBikeModel.setSelectedIndex(0);
        comboBoxRentDocumentType.setSelectedIndex(0);
        sliderRentDurationOfRent.setValue(1);
        buttonGroupGender.clearSelection();
    }//GEN-LAST:event_buttonRentClearActionPerformed

    private void buttonReturnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonReturnClearActionPerformed
        // TODO add your handling code here:
        JTextField[] fields = {fieldReturnFirstName, fieldReturnLastName, fieldReturnLicenceNo, fieldReturnDocumentNo, fieldReturnMobileNo};

        for (JTextField field : fields) {
            field.setText("");
        }

        comboBoxReturnBikeModel.setSelectedIndex(0);
        comboBoxReturnDocumentType.setSelectedIndex(0);
    }//GEN-LAST:event_buttonReturnClearActionPerformed

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
            java.util.logging.Logger.getLogger(ActionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ActionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ActionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ActionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ActionFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonAdminPanelExit;
    private javax.swing.JLabel IconQuickActionBaseplate;
    private javax.swing.JLabel LabelQuickAction;
    private javax.swing.JButton buttonAdd;
    private javax.swing.JButton buttonAdminPanelBack;
    private javax.swing.JButton buttonBack;
    private javax.swing.JButton buttonBack1;
    private javax.swing.JButton buttonBikeManagement;
    private javax.swing.JButton buttonClear;
    private javax.swing.JButton buttonExit;
    private javax.swing.JButton buttonExit1;
    private javax.swing.JButton buttonFilterDown;
    private javax.swing.JButton buttonFilterUp;
    private javax.swing.ButtonGroup buttonGroupGender;
    private javax.swing.JButton buttonHome;
    private javax.swing.JButton buttonRent;
    private javax.swing.JButton buttonRentBike;
    private javax.swing.JButton buttonRentClear;
    private javax.swing.JButton buttonRentalManagement;
    private javax.swing.JButton buttonReturn;
    private javax.swing.JButton buttonReturnBike;
    private javax.swing.JButton buttonReturnClear;
    private javax.swing.JButton buttonTextFieldSearch;
    private javax.swing.JButton buttonUpdate;
    private javax.swing.JButton buttonUpdateClear;
    private javax.swing.JComboBox<String> comboBoxAttribute;
    private javax.swing.JComboBox<String> comboBoxBikeType;
    private javax.swing.JComboBox<String> comboBoxRentBikeModel;
    private javax.swing.JComboBox<String> comboBoxRentDocumentType;
    private javax.swing.JComboBox<String> comboBoxReturnBikeModel;
    private javax.swing.JComboBox<String> comboBoxReturnDocumentType;
    private javax.swing.JComboBox<String> comboBoxUpdateBikeType;
    private javax.swing.JTextField fieldBikeCondition;
    private javax.swing.JTextField fieldBikeModel;
    private javax.swing.JTextField fieldBikeNo;
    private javax.swing.JTextField fieldBikePrice;
    private javax.swing.JTextField fieldRentDateOfBirth;
    private javax.swing.JTextField fieldRentDocumentNo;
    private javax.swing.JTextField fieldRentFirstName;
    private javax.swing.JTextField fieldRentLastName;
    private javax.swing.JTextField fieldRentLicenceNo;
    private javax.swing.JTextField fieldRentMobileNo;
    private javax.swing.JTextField fieldReturnDocumentNo;
    private javax.swing.JTextField fieldReturnFirstName;
    private javax.swing.JTextField fieldReturnLastName;
    private javax.swing.JTextField fieldReturnLicenceNo;
    private javax.swing.JTextField fieldReturnMobileNo;
    private javax.swing.JTextField fieldUpdateBikeCondition;
    private javax.swing.JTextField fieldUpdateBikeModel;
    private javax.swing.JTextField fieldUpdateBikeNo;
    private javax.swing.JTextField fieldUpdateBikePrice;
    private javax.swing.JLabel iconAdminPanelBase;
    private javax.swing.JLabel iconAdminPanelHomeDesign;
    private javax.swing.JLabel iconAdminPanelHomeImage;
    private javax.swing.JLabel iconBaseSelectionOption;
    private javax.swing.JLabel iconQuickActionBase;
    private javax.swing.JLabel iconRentBanner;
    private javax.swing.JLabel iconReturnBanner;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelAdmin;
    private javax.swing.JLabel labelAdminPanel;
    private javax.swing.JLabel labelAdminPanel1;
    private javax.swing.JLabel labelAdminPanelBikeAdd;
    private javax.swing.JLabel labelAdminPanelBikeAddBike;
    private javax.swing.JLabel labelAdminPanelBikeDelete;
    private javax.swing.JLabel labelAdminPanelBikeUpdate;
    private javax.swing.JLabel labelAdminPanelBikeUpdateBike;
    private javax.swing.JLabel labelAdminPanelRentalDelete;
    private javax.swing.JLabel labelAdminPanelRentalUpdate;
    private javax.swing.JLabel labelChooseAnOption;
    private javax.swing.JLabel labelEnterYourBikeDetail;
    private javax.swing.JLabel labelQuickAction;
    private javax.swing.JLabel labelRentBikeModel;
    private javax.swing.JLabel labelRentDateOfBirth;
    private javax.swing.JLabel labelRentDocumentNo;
    private javax.swing.JLabel labelRentDocumentType;
    private javax.swing.JLabel labelRentDurartionOfRent;
    private javax.swing.JLabel labelRentFirstName;
    private javax.swing.JLabel labelRentGender;
    private javax.swing.JLabel labelRentLastName;
    private javax.swing.JLabel labelRentLicenceNo;
    private javax.swing.JLabel labelRentMobileNo;
    private javax.swing.JLabel labelRentTopic;
    private javax.swing.JLabel labelRentTopic2;
    private javax.swing.JLabel labelRentWarningDateOfBirth;
    private javax.swing.JLabel labelRentWarningDocumentNo;
    private javax.swing.JLabel labelRentWarningFirstName;
    private javax.swing.JLabel labelRentWarningLastName;
    private javax.swing.JLabel labelRentWarningLicenceNo;
    private javax.swing.JLabel labelRentWarningMobileNo;
    private javax.swing.JLabel labelReturnBikeModel;
    private javax.swing.JLabel labelReturnDocumentNo;
    private javax.swing.JLabel labelReturnDocumentType;
    private javax.swing.JLabel labelReturnFirstName;
    private javax.swing.JLabel labelReturnLastName;
    private javax.swing.JLabel labelReturnLicenceNo;
    private javax.swing.JLabel labelReturnMobileNo;
    private javax.swing.JLabel labelReturnWarningDocumentNo;
    private javax.swing.JLabel labelReturnWarningFirstName;
    private javax.swing.JLabel labelReturnWarningLastName;
    private javax.swing.JLabel labelReturnWarningLicenceNo;
    private javax.swing.JLabel labelReturnWarningMobileNo;
    private javax.swing.JLabel labelUpdateBikeDetail;
    private javax.swing.JLabel labelWarningBikeCondition;
    private javax.swing.JLabel labelWarningBikeModel;
    private javax.swing.JLabel labelWarningBikeNo;
    private javax.swing.JLabel labelWarningBikePrice;
    private javax.swing.JLabel labelWarningUpdateBikeCondition;
    private javax.swing.JLabel labelWarningUpdateBikeModel;
    private javax.swing.JLabel labelWarningUpdateBikeNo;
    private javax.swing.JLabel labelWarningUpdateBikePrice;
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
    private javax.swing.JPanel panelAdminPanelRental;
    private javax.swing.JPanel panelAdminPanelRentalAddButton;
    private javax.swing.JPanel panelAdminPanelRentalDeleteButton;
    private javax.swing.JPanel panelAsButtonForAdminPanel;
    private javax.swing.JPanel panelAsButtonForQuickAction;
    private javax.swing.JPanel panelDecuration1;
    private javax.swing.JPanel panelDecuration2;
    private javax.swing.JPanel panelDecuration3;
    private javax.swing.JPanel panelHome;
    private javax.swing.JPanel panelRent;
    private javax.swing.JPanel panelReturn;
    private javax.swing.JPanel pnlAdminPanel;
    private javax.swing.JPanel pnlQuickAction;
    private javax.swing.JPanel pnlRentBikePictureDisplay;
    private javax.swing.JPanel pnlReturnBannerBase;
    private javax.swing.JPanel pnlSelectionOption;
    private javax.swing.JRadioButton radioButtonRentFemale;
    private javax.swing.JRadioButton radioButtonRentMale;
    private javax.swing.JRadioButton radioButtonRentOthers;
    private javax.swing.JSlider sliderRentDurationOfRent;
    private javax.swing.JTable tblBikeData;
    private javax.swing.JTable tblRentalData;
    private javax.swing.JTextField textFieldSearch;
    // End of variables declaration//GEN-END:variables
}
