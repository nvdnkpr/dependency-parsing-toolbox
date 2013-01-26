package ir.ac.iust.nlp.dependencyparser.training;

import ir.ac.iust.nlp.dependencyparser.BasePanel;
import ir.ac.iust.nlp.dependencyparser.DependencyParser;
import ir.ac.iust.nlp.dependencyparser.utility.ExampleFileFilter;
import ir.ac.iust.nlp.dependencyparser.utility.enumeration.Flowchart;
import ir.ac.iust.nlp.dependencyparser.utility.enumeration.ParserType;
import ir.ac.iust.nlp.dependencyparser.utility.parsing.*;
import java.awt.Color;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.JOptionPane;

/**
 *
 * @author Mojtaba Khallash
 */
public class TrainPanel extends BasePanel {

    boolean isInit = false;
    
    ParserType type = ParserType.MaltParser;
    
    MaltSettingsPanel pnlMalt;
    ClearSettingsPanel pnlClear;
    MSTSettingsPanel pnlMST;
    MateSettingsPanel pnlMate;

    /**
     * Creates new form TrainPanel
     */
    public TrainPanel(String dir) {
        super(dir);
        
        pnlMalt = new ir.ac.iust.nlp.dependencyparser.utility.parsing.MaltSettingsPanel(dir);
        pnlClear = new ClearSettingsPanel(dir, Flowchart.Train);
        pnlMST = new MSTSettingsPanel(Flowchart.Train);
        pnlMate = new MateSettingsPanel(Flowchart.Train);
        
        initComponents();
        
        setDrop();
        
        txtCorpusFile.setText(dir + File.separator + 
                             "Treebank" + File.separator + 
                             "Persian" + File.separator + 
                             "train.conll");
        
        txtModelPath.setText(dir + File.separator + 
                              "Output" + File.separator +
                              "training_model" + File.separator);
                
        lblLess.setVisible(false);
        pnlAdvancedParameter.setVisible(false);
        
        tabSettings.removeAll();
        tabSettings.add(pnlMaltSettings, "MaltParser Settings");
        
        txtMaxRam.setText(getRam(true));
        txtMinRam.setText(getRam(false));
    }
    
    private void setDrop() {
        initDrop(txtCorpusFile, false);
        initDrop(txtModelPath, true);
    }

    @Override
    public boolean canSave() {
        return true;
    }

    @Override
    public void save() {
        ExampleFileFilter filter = new ExampleFileFilter("txt", "Text Files");
        saveText(filter, "train_log.txt", txtLog.getText());
    }

    @Override
    public void saveAs() {
        save();
    }
    
    @Override
    public void threadFinished() {
        btnStartTraining.setEnabled(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlParameter = new javax.swing.JPanel();
        lblCorpusFile = new javax.swing.JLabel();
        txtCorpusFile = new javax.swing.JTextField();
        btnBrowseCorpusFile = new javax.swing.JButton();
        lblModelPath = new javax.swing.JLabel();
        txtModelPath = new javax.swing.JTextField();
        btnBrowseModelPath = new javax.swing.JButton();
        btnStartTraining = new javax.swing.JButton();
        pnlMore = new javax.swing.JPanel();
        lblMore = new javax.swing.JLabel();
        lblLess = new javax.swing.JLabel();
        lblParser = new javax.swing.JLabel();
        cboParser = new javax.swing.JComboBox();
        pnlAdvancedParameter = new javax.swing.JPanel();
        tabSettings = new javax.swing.JTabbedPane();
        pnlMSTSettings = new javax.swing.JPanel();
        lblMSTSettingsL0Place = new javax.swing.JLabel();
        pnlMateSettings = new javax.swing.JPanel();
        lblMSTSettingsL0Place1 = new javax.swing.JLabel();
        pnlMaltSettings = new javax.swing.JPanel();
        lblMaltSettingsPlace = new javax.swing.JLabel();
        pnlClearSettings = new javax.swing.JPanel();
        lblClearSettingsPlace = new javax.swing.JLabel();
        chkMaxRam = new javax.swing.JCheckBox();
        txtMaxRam = new javax.swing.JTextField();
        txtMinRam = new javax.swing.JTextField();
        chkMinRam = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        tabDependencyInfo = new javax.swing.JTabbedPane();
        pnlLog = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtLog = new javax.swing.JTextArea();

        pnlParameter.setBorder(javax.swing.BorderFactory.createTitledBorder("Settings"));

        lblCorpusFile.setText("Corpus File:");

        txtCorpusFile.setEditable(false);

        btnBrowseCorpusFile.setText("...");
        btnBrowseCorpusFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseCorpusFile_Click(evt);
            }
        });

        lblModelPath.setText("Model Path:");

        txtModelPath.setEditable(false);

        btnBrowseModelPath.setText("...");
        btnBrowseModelPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseModelPath_Click(evt);
            }
        });

        btnStartTraining.setText("Start");
        btnStartTraining.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartTraining_Click(evt);
            }
        });

        pnlMore.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 240, 240)));

        lblMore.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblMore.setForeground(new java.awt.Color(153, 153, 153));
        lblMore.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ir/ac/iust/nlp/dependencyparser/evaluation/directional_down.png"))); // NOI18N
        lblMore.setText("  More  ");
        lblMore.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMore_mouseClick(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblMorepnlMore_mouseEnter(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblMorepnlMore_mouseExit(evt);
            }
        });

        lblLess.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblLess.setForeground(new java.awt.Color(153, 153, 153));
        lblLess.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ir/ac/iust/nlp/dependencyparser/evaluation/directional_up.png"))); // NOI18N
        lblLess.setText("  Less");
        lblLess.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLess_mouseClick(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblLesspnlMore_mouseEnter(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblLesspnlMore_mouseExit(evt);
            }
        });

        javax.swing.GroupLayout pnlMoreLayout = new javax.swing.GroupLayout(pnlMore);
        pnlMore.setLayout(pnlMoreLayout);
        pnlMoreLayout.setHorizontalGroup(
            pnlMoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMoreLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(lblMore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLess)
                .addContainerGap())
        );
        pnlMoreLayout.setVerticalGroup(
            pnlMoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblLess, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblMore, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        lblParser.setText("Parser:");

        cboParser.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MaltParser", "ClearParser", "MSTParser", "MateTools" }));
        cboParser.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboParser_stateChanged(evt);
            }
        });

        lblMSTSettingsL0Place.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMSTSettingsL0Place.setText("MSTParser Settings: Appear after running");

        javax.swing.GroupLayout pnlMSTSettingsLayout = new javax.swing.GroupLayout(pnlMSTSettings);
        pnlMSTSettings.setLayout(pnlMSTSettingsLayout);
        pnlMSTSettingsLayout.setHorizontalGroup(
            pnlMSTSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblMSTSettingsL0Place, javax.swing.GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE)
        );
        pnlMSTSettingsLayout.setVerticalGroup(
            pnlMSTSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblMSTSettingsL0Place, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
        );

        tabSettings.addTab("MSTParser Settings", pnlMSTSettings);
        pnlMSTSettings.removeAll();
        pnlMSTSettings.setLayout(new GridLayout());
        pnlMSTSettings.add(pnlMST);
        pnlMSTSettings.revalidate();

        lblMSTSettingsL0Place1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMSTSettingsL0Place1.setText("Mate-Tools Settings: Appear after running");

        javax.swing.GroupLayout pnlMateSettingsLayout = new javax.swing.GroupLayout(pnlMateSettings);
        pnlMateSettings.setLayout(pnlMateSettingsLayout);
        pnlMateSettingsLayout.setHorizontalGroup(
            pnlMateSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblMSTSettingsL0Place1, javax.swing.GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE)
        );
        pnlMateSettingsLayout.setVerticalGroup(
            pnlMateSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblMSTSettingsL0Place1, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
        );

        tabSettings.addTab("Mate-Tools Settings", pnlMateSettings);
        pnlMateSettings.removeAll();
        pnlMateSettings.setLayout(new GridLayout());
        pnlMateSettings.add(pnlMate);
        pnlMateSettings.revalidate();

        lblMaltSettingsPlace.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMaltSettingsPlace.setText("MaltParser Settings: Appear after running");

        javax.swing.GroupLayout pnlMaltSettingsLayout = new javax.swing.GroupLayout(pnlMaltSettings);
        pnlMaltSettings.setLayout(pnlMaltSettingsLayout);
        pnlMaltSettingsLayout.setHorizontalGroup(
            pnlMaltSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblMaltSettingsPlace, javax.swing.GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE)
        );
        pnlMaltSettingsLayout.setVerticalGroup(
            pnlMaltSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblMaltSettingsPlace, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
        );

        tabSettings.addTab("MaltParser Settings", pnlMaltSettings);
        pnlMaltSettings.removeAll();
        pnlMaltSettings.setLayout(new GridLayout());
        pnlMaltSettings.add(pnlMalt);
        pnlMaltSettings.revalidate();

        lblClearSettingsPlace.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblClearSettingsPlace.setText("ClearParser Settings: Appear after running");

        javax.swing.GroupLayout pnlClearSettingsLayout = new javax.swing.GroupLayout(pnlClearSettings);
        pnlClearSettings.setLayout(pnlClearSettingsLayout);
        pnlClearSettingsLayout.setHorizontalGroup(
            pnlClearSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblClearSettingsPlace, javax.swing.GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE)
        );
        pnlClearSettingsLayout.setVerticalGroup(
            pnlClearSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblClearSettingsPlace, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
        );

        tabSettings.addTab("ClearParser Settings", pnlClearSettings);
        pnlClearSettings.removeAll();
        pnlClearSettings.setLayout(new GridLayout());
        pnlClearSettings.add(pnlClear);
        pnlClearSettings.revalidate();

        javax.swing.GroupLayout pnlAdvancedParameterLayout = new javax.swing.GroupLayout(pnlAdvancedParameter);
        pnlAdvancedParameter.setLayout(pnlAdvancedParameterLayout);
        pnlAdvancedParameterLayout.setHorizontalGroup(
            pnlAdvancedParameterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabSettings)
        );
        pnlAdvancedParameterLayout.setVerticalGroup(
            pnlAdvancedParameterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabSettings)
        );

        chkMaxRam.setText("Max Ram");
        chkMaxRam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkMaxRam_Click(evt);
            }
        });

        txtMaxRam.setEditable(false);

        txtMinRam.setEditable(false);

        chkMinRam.setText("Min Ram");
        chkMinRam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkMinRam_Click(evt);
            }
        });

        javax.swing.GroupLayout pnlParameterLayout = new javax.swing.GroupLayout(pnlParameter);
        pnlParameter.setLayout(pnlParameterLayout);
        pnlParameterLayout.setHorizontalGroup(
            pnlParameterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlParameterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlParameterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlAdvancedParameter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlParameterLayout.createSequentialGroup()
                        .addComponent(lblCorpusFile)
                        .addGap(18, 18, 18)
                        .addComponent(txtCorpusFile)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBrowseCorpusFile, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlParameterLayout.createSequentialGroup()
                        .addComponent(lblModelPath)
                        .addGap(18, 18, 18)
                        .addComponent(txtModelPath)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBrowseModelPath, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlParameterLayout.createSequentialGroup()
                        .addComponent(pnlMore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblParser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboParser, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chkMaxRam)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMaxRam, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(chkMinRam)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMinRam, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnStartTraining)))
                .addContainerGap())
        );
        pnlParameterLayout.setVerticalGroup(
            pnlParameterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlParameterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlParameterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCorpusFile)
                    .addComponent(txtCorpusFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBrowseCorpusFile))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlParameterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblModelPath)
                    .addComponent(txtModelPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBrowseModelPath))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlParameterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlParameterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnStartTraining)
                        .addComponent(lblParser)
                        .addComponent(cboParser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(chkMaxRam)
                        .addComponent(txtMaxRam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pnlParameterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chkMinRam)
                            .addComponent(txtMinRam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(pnlMore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlAdvancedParameter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Training");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setPreferredSize(new java.awt.Dimension(380, 2));

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

        txtLog.setColumns(20);
        txtLog.setEditable(false);
        txtLog.setRows(5);
        jScrollPane3.setViewportView(txtLog);

        javax.swing.GroupLayout pnlLogLayout = new javax.swing.GroupLayout(pnlLog);
        pnlLog.setLayout(pnlLogLayout);
        pnlLogLayout.setHorizontalGroup(
            pnlLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 737, Short.MAX_VALUE)
        );
        pnlLogLayout.setVerticalGroup(
            pnlLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        tabDependencyInfo.addTab("Log", pnlLog);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlParameter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(tabDependencyInfo))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlParameter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabDependencyInfo)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBrowseCorpusFile_Click(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseCorpusFile_Click
        txtCorpusFile.setText(showFileDialog(txtCorpusFile.getText(), false));
    }//GEN-LAST:event_btnBrowseCorpusFile_Click

    private void btnStartTraining_Click(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartTraining_Click
        
        btnStartTraining.setEnabled(false);

        try {
            if (isInit == false) {
                isInit = true;

                Settings settings = null;
                
                // Model
                String modelFile = txtModelPath.getText()
                        + "trained_model.mco";
                // Input
                String inputFile = txtCorpusFile.getText();
                
                switch (type) {
                    case MaltParser:
                        MaltSettings malt = new MaltSettings();
                        // Working Directory
                        malt.WorkingDirectory = "tmp" + File.separator;
                        malt.OptionsFile = pnlMalt.getOptionsFile();
                        malt.GuidesFile = pnlMalt.getGuidesFile();
                        settings = malt;
                        break;
                    case MSTParser:
                        MSTSettings mst = new MSTSettings();
                        mst.FileType = pnlMST.getFormat();
                        mst.Iteration = pnlMST.getTrainingIterations();
                        mst.DecodeType = pnlMST.getDecodeType();
                        mst.TrainingK = pnlMST.getTrainingK();
                        mst.LossType = pnlMST.getLossType();
                        mst.Order = pnlMST.getOrder();
                        settings = mst;
                        break;
                    case MateTools:
                        MateSettings mate = new MateSettings();
                        mate.Iteration = pnlMate.getTrainingIterations();
                        mate.DecodeType = pnlMate.getDecodeType();
                        mate.FeatureCreation = pnlMate.getFeatureCreation();
                        mate.Cores = pnlMate.getNumberOfCores();
                        mate.NonProjectivityThreshold = pnlMate.getNonProjectivityThreshold();
                        settings = mate;
                        break;
                    case ClearParser:
                        ClearSettings clear = new ClearSettings();
                        clear.OptionsFile = pnlClear.getOptionsFile();
                        clear.GuidesFile = pnlClear.getGuidesFile();
                        clear.BootstrappingLevel = pnlClear.getBootstrapLevel();
                        settings = clear;
                        break;
                }
                
                settings.Chart = Flowchart.Train;
                settings.Input = inputFile;
                settings.Model = modelFile;
                
                PrintStream out = new PrintStream(new OutputStream() {
                    
                    private StringBuffer buffer = new StringBuffer();

                    @Override
                    public void write(int b)
                            throws IOException {
                        this.buffer.append((char) b);
                        txtLog.setText(buffer.toString());
                        txtLog.setCaretPosition(txtLog.getDocument().getLength() - 1);
                    }
                });
                
                if (chkMaxRam.isSelected()) {
                    DependencyParser.maxRam = txtMaxRam.getText();
                }
                else {
                    DependencyParser.maxRam = "";
                }

                if (chkMinRam.isSelected()) {
                    DependencyParser.minRam = txtMinRam.getText();
                }
                else {
                    DependencyParser.minRam = "";
                }

                // Run in a new thread
                Runnable job = new RunnableTrain(this, type, out, settings);
                ExecutorService threadPool = Executors.newFixedThreadPool(1);
                threadPool.execute(job);
                threadPool.shutdown();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(
                    null,
                    ex.getMessage(),
                    "Reading Error",
                    JOptionPane.ERROR_MESSAGE);
        } finally {
            isInit = false;
        }
    }//GEN-LAST:event_btnStartTraining_Click

    private void btnBrowseModelPath_Click(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseModelPath_Click
        txtModelPath.setText(showFileDialog(txtModelPath.getText(), true));
    }//GEN-LAST:event_btnBrowseModelPath_Click

    private void lblMore_mouseClick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMore_mouseClick
        lblMore.setVisible(false);
        lblLess.setVisible(true);
        pnlAdvancedParameter.setVisible(true);
    }//GEN-LAST:event_lblMore_mouseClick

    private void lblMorepnlMore_mouseEnter(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMorepnlMore_mouseEnter
        pnlMore.setBackground(new Color(235, 232, 232));
        pnlMore.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, false));
    }//GEN-LAST:event_lblMorepnlMore_mouseEnter

    private void lblMorepnlMore_mouseExit(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMorepnlMore_mouseExit
        pnlMore.setBackground(new Color(240, 240, 240));
        pnlMore.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(240, 240, 240), 1, false));
    }//GEN-LAST:event_lblMorepnlMore_mouseExit

    private void lblLess_mouseClick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLess_mouseClick
        pnlAdvancedParameter.setVisible(false);
        lblLess.setVisible(false);
        lblMore.setVisible(true);
    }//GEN-LAST:event_lblLess_mouseClick

    private void lblLesspnlMore_mouseEnter(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLesspnlMore_mouseEnter
        pnlMore.setBackground(new Color(235, 232, 232));
        pnlMore.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, false));
    }//GEN-LAST:event_lblLesspnlMore_mouseEnter

    private void lblLesspnlMore_mouseExit(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLesspnlMore_mouseExit
        pnlMore.setBackground(new Color(240, 240, 240));
        pnlMore.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(240, 240, 240), 1, false));
    }//GEN-LAST:event_lblLesspnlMore_mouseExit

    private void cboParser_stateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboParser_stateChanged
        
        tabSettings.removeAll();

        String text = cboParser.getSelectedItem().toString();
        switch (text) {
            case "MaltParser":
                type = ParserType.MaltParser;
                tabSettings.add(pnlMaltSettings, "MaltParser Settings");
                break;
            case "MSTParser":
                type = ParserType.MSTParser;
                tabSettings.add(pnlMSTSettings, "MSTParser Settings");
                break;
            case "MateTools":
                type = ParserType.MateTools;
                tabSettings.add(pnlMateSettings, "Mate-Tools Settings");
                break;
            case "ClearParser":
                type = ParserType.ClearParser;
                tabSettings.add(pnlClearSettings, "ClearParser Settings");
                break;
        }
    }//GEN-LAST:event_cboParser_stateChanged

    private void chkMaxRam_Click(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkMaxRam_Click
        txtMaxRam.setEditable(chkMaxRam.isSelected());
    }//GEN-LAST:event_chkMaxRam_Click

    private void chkMinRam_Click(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkMinRam_Click
        txtMinRam.setEditable(chkMinRam.isSelected());
    }//GEN-LAST:event_chkMinRam_Click

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBrowseCorpusFile;
    private javax.swing.JButton btnBrowseModelPath;
    private javax.swing.JButton btnStartTraining;
    private javax.swing.JComboBox cboParser;
    private javax.swing.JCheckBox chkMaxRam;
    private javax.swing.JCheckBox chkMinRam;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblClearSettingsPlace;
    private javax.swing.JLabel lblCorpusFile;
    private javax.swing.JLabel lblLess;
    private javax.swing.JLabel lblMSTSettingsL0Place;
    private javax.swing.JLabel lblMSTSettingsL0Place1;
    private javax.swing.JLabel lblMaltSettingsPlace;
    private javax.swing.JLabel lblModelPath;
    private javax.swing.JLabel lblMore;
    private javax.swing.JLabel lblParser;
    private javax.swing.JPanel pnlAdvancedParameter;
    private javax.swing.JPanel pnlClearSettings;
    private javax.swing.JPanel pnlLog;
    private javax.swing.JPanel pnlMSTSettings;
    private javax.swing.JPanel pnlMaltSettings;
    private javax.swing.JPanel pnlMateSettings;
    private javax.swing.JPanel pnlMore;
    private javax.swing.JPanel pnlParameter;
    private javax.swing.JTabbedPane tabDependencyInfo;
    private javax.swing.JTabbedPane tabSettings;
    private javax.swing.JTextField txtCorpusFile;
    private javax.swing.JTextArea txtLog;
    private javax.swing.JTextField txtMaxRam;
    private javax.swing.JTextField txtMinRam;
    private javax.swing.JTextField txtModelPath;
    // End of variables declaration//GEN-END:variables
}