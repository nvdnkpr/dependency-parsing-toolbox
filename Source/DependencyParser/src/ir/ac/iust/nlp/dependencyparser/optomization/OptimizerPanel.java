package ir.ac.iust.nlp.dependencyparser.optomization;

import ir.ac.iust.nlp.dependencyparser.BasePanel;
import ir.ac.iust.nlp.dependencyparser.utility.ExampleFileFilter;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.JOptionPane;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Mojtaba Khallash
 */
public class OptimizerPanel extends BasePanel {

    boolean isInit = false;

    /**
     * Creates new form OptimizerPanel
     */
    public OptimizerPanel(String dir) {
        super(dir);

        initComponents();

        setDrop();

        txtTrainCorpusFile.setText(dir + File.separator
                + "Treebank" + File.separator
                + "Swedish" + File.separator
                + "talbanken05_train.conll");
    }

    private void setDrop() {
        initDrop(txtTrainCorpusFile, false);
    }

    @Override
    public boolean canSave() {
        return true;
    }

    @Override
    public void save() {
        ExampleFileFilter filter = new ExampleFileFilter("txt", "Text Files");
        switch (tabOptimizerPhase.getSelectedIndex()) {
            case 0:
                // Output Phase 1
                saveText(filter, "Phase1_log.txt", txtPhase1.getText());
                break;
            case 1:
                // Output Phase 2
                saveText(filter, "Phase2_log.txt", txtPhase2.getText());
                break;
            case 2:
                // Output Phase 3
                saveText(filter, "Phase3_log.txt", txtPhase3.getText());
                break;
        }
    }

    @Override
    public void saveAs() {
        save();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        lblTrainCorpusFile = new javax.swing.JLabel();
        txtTrainCorpusFile = new javax.swing.JTextField();
        btnBrowseTrainCorpusFile = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        rdbPhase1 = new javax.swing.JRadioButton();
        rdbPhase2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        btnRunOptimizer = new javax.swing.JButton();
        lblParser = new javax.swing.JLabel();
        cboParser = new javax.swing.JComboBox();
        chkCrossVal = new javax.swing.JCheckBox();
        tabOptimizerPhase = new javax.swing.JTabbedPane();
        pnlPhase1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtPhase1 = new javax.swing.JTextArea();
        pnlPhase2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtPhase2 = new javax.swing.JTextArea();
        pnlPhase3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtPhase3 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Settings"));

        lblTrainCorpusFile.setText("Training Corpus File:");

        txtTrainCorpusFile.setEditable(false);

        btnBrowseTrainCorpusFile.setText("...");
        btnBrowseTrainCorpusFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseTrainCorpusFile_Click(evt);
            }
        });

        buttonGroup1.add(rdbPhase1);
        rdbPhase1.setSelected(true);
        rdbPhase1.setText("Phase 1");

        buttonGroup1.add(rdbPhase2);
        rdbPhase2.setText("Phase 2");

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("Phase 3");

        btnRunOptimizer.setText("Run");
        btnRunOptimizer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRunOptimizerActionPerformed(evt);
            }
        });

        lblParser.setText("Parser:");

        cboParser.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MaltParser" }));

        chkCrossVal.setText("5-Fold Cross Validation");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblParser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboParser, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rdbPhase1)
                .addGap(18, 18, 18)
                .addComponent(rdbPhase2)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton3)
                .addGap(18, 18, 18)
                .addComponent(chkCrossVal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRunOptimizer)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbPhase1)
                    .addComponent(rdbPhase2)
                    .addComponent(jRadioButton3)
                    .addComponent(btnRunOptimizer)
                    .addComponent(lblParser)
                    .addComponent(cboParser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkCrossVal))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTrainCorpusFile)
                .addGap(18, 18, 18)
                .addComponent(txtTrainCorpusFile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBrowseTrainCorpusFile, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTrainCorpusFile)
                    .addComponent(txtTrainCorpusFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBrowseTrainCorpusFile))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        txtPhase1.setColumns(20);
        txtPhase1.setEditable(false);
        txtPhase1.setRows(5);
        jScrollPane1.setViewportView(txtPhase1);

        javax.swing.GroupLayout pnlPhase1Layout = new javax.swing.GroupLayout(pnlPhase1);
        pnlPhase1.setLayout(pnlPhase1Layout);
        pnlPhase1Layout.setHorizontalGroup(
            pnlPhase1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
        );
        pnlPhase1Layout.setVerticalGroup(
            pnlPhase1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
        );

        tabOptimizerPhase.addTab("Phase 1 Log", pnlPhase1);

        txtPhase2.setColumns(20);
        txtPhase2.setEditable(false);
        txtPhase2.setRows(5);
        jScrollPane2.setViewportView(txtPhase2);

        javax.swing.GroupLayout pnlPhase2Layout = new javax.swing.GroupLayout(pnlPhase2);
        pnlPhase2.setLayout(pnlPhase2Layout);
        pnlPhase2Layout.setHorizontalGroup(
            pnlPhase2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
        );
        pnlPhase2Layout.setVerticalGroup(
            pnlPhase2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
        );

        tabOptimizerPhase.addTab("Phase 2 Log", pnlPhase2);

        txtPhase3.setColumns(20);
        txtPhase3.setEditable(false);
        txtPhase3.setRows(5);
        jScrollPane3.setViewportView(txtPhase3);

        javax.swing.GroupLayout pnlPhase3Layout = new javax.swing.GroupLayout(pnlPhase3);
        pnlPhase3.setLayout(pnlPhase3Layout);
        pnlPhase3Layout.setHorizontalGroup(
            pnlPhase3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
        );
        pnlPhase3Layout.setVerticalGroup(
            pnlPhase3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPhase3Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabOptimizerPhase.addTab("Phase3 Log", pnlPhase3);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Optimization");

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel8.setPreferredSize(new java.awt.Dimension(380, 2));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabOptimizerPhase, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 637, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabOptimizerPhase)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBrowseTrainCorpusFile_Click(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseTrainCorpusFile_Click
        txtTrainCorpusFile.setText(showFileDialog(txtTrainCorpusFile.getText(), false));
    }//GEN-LAST:event_btnBrowseTrainCorpusFile_Click

    File to = null;
    private void btnRunOptimizerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRunOptimizerActionPerformed

        btnRunOptimizer.setEnabled(false);
        
        if (isInit == false) {
            isInit = true;
            int phase;
            if (rdbPhase1.isSelected() == true) {
                tabOptimizerPhase.setSelectedIndex(0);
                phase = 1;
            } else if (rdbPhase2.isSelected() == true) {
                tabOptimizerPhase.setSelectedIndex(1);
                phase = 2;
            } else {
                tabOptimizerPhase.setSelectedIndex(2);
                phase = 3;
            }

            String inputFile = txtTrainCorpusFile.getText();
            // Ensure have an absolute path
            File from = new File(inputFile).getAbsoluteFile();
            String input = from.getName();

            to = new File(new File(workingDir).getParent() + File.separator + input);

            try {
                // Copy input file to working directory
                if (!from.equals(to)) {
                    FileUtils.copyFile(from, to);
                }
                else {
                    to = null;
                }

                PrintStream out = new PrintStream(new OutputStream() {
                    
                    private StringBuffer buffer = new StringBuffer();

                    @Override
                    public void write(int b)
                            throws IOException {
                        this.buffer.append((char) b);
                        if (rdbPhase1.isSelected() == true) {
                            txtPhase1.setText(buffer.toString());
                            txtPhase1.setCaretPosition(txtPhase1.getDocument().getLength() - 1);
                        } else if (rdbPhase2.isSelected() == true) {
                            txtPhase2.setText(buffer.toString());
                            txtPhase2.setCaretPosition(txtPhase2.getDocument().getLength() - 1);
                        } else {
                            txtPhase3.setText(buffer.toString());
                            txtPhase3.setCaretPosition(txtPhase3.getDocument().getLength() - 1);
                        }
                    }
                });
                optimizer.Optimizer.out = out;
                
                // Run in a new thread
                Runnable job = new RunnableOptimizer(this, phase, input, chkCrossVal.isSelected());
                ExecutorService threadPool = Executors.newFixedThreadPool(1);
                threadPool.execute(job);
                threadPool.shutdown();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(
                        null,
                        ex.getMessage(),
                        "Reading Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnRunOptimizerActionPerformed

    @Override
    public void threadFinished() {
        try {
            if (to != null) {
                FileUtils.forceDelete(to);
            }
        } catch (Exception e) {
        }
        to = null;

        isInit = false;
        btnRunOptimizer.setEnabled(true);
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBrowseTrainCorpusFile;
    private javax.swing.JButton btnRunOptimizer;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cboParser;
    private javax.swing.JCheckBox chkCrossVal;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblParser;
    private javax.swing.JLabel lblTrainCorpusFile;
    private javax.swing.JPanel pnlPhase1;
    private javax.swing.JPanel pnlPhase2;
    private javax.swing.JPanel pnlPhase3;
    private javax.swing.JRadioButton rdbPhase1;
    private javax.swing.JRadioButton rdbPhase2;
    private javax.swing.JTabbedPane tabOptimizerPhase;
    private javax.swing.JTextArea txtPhase1;
    private javax.swing.JTextArea txtPhase2;
    private javax.swing.JTextArea txtPhase3;
    private javax.swing.JTextField txtTrainCorpusFile;
    // End of variables declaration//GEN-END:variables
}