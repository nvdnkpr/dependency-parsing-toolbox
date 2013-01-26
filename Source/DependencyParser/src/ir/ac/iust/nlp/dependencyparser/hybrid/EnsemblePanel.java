package ir.ac.iust.nlp.dependencyparser.hybrid;

import edu.stanford.nlp.parser.ensemble.utils.Scorer;
import ir.ac.iust.nlp.dependencyparser.BasePanel;
import ir.ac.iust.nlp.dependencyparser.utility.ExampleFileFilter;
import ir.ac.iust.nlp.dependencyparser.utility.enumeration.ReparseType;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Mojtaba Khallash
 */
public class EnsemblePanel extends BasePanel {

    /**
     * Creates new form EnsemblePanel
     */
    public EnsemblePanel(String dir) {
        super(dir);

        initComponents();
        
        setDrop();

        String curDir = dir + File.separator + "Treebank" + File.separator
                + "Persian" + File.separator;
        txtGoldFile.setText(curDir + "test.conll");
        
        curDir += "ensemble" + File.separator;
        DefaultListModel model = (DefaultListModel) lstBaselineParser.getModel();
        model.addElement(curDir + "output.stanford-mst-ord1");
        model.addElement(curDir + "output.stanford-mst-ord2");
        model.addElement(curDir + "output.stanford-nivreeager-ltr");
        model.addElement(curDir + "output.stanford-nivreeager-rtl");
        model.addElement(curDir + "output.stanford-covnonproj-ltr");
        
        String outDir = dir + File.separator + "Output" + File.separator + "ensemble" + File.separator;
        txtOutputPath.setText(outDir);
    }
    
    private void setDrop() {
        initDrop(lstBaselineParser);
        initDrop(txtGoldFile, false);
        initDrop(txtOutputPath, true);
    }

    @Override
    public boolean canSave() {
        return true;
    }

    @Override
    public void save() {
        if (tblResult.getModel().getRowCount() == 0)
            return;
        
        // Output
        StringBuilder result = new StringBuilder("Ensemble (" + cboMethod.getSelectedItem().toString() + ")\n\n");
        int maxLen = 0;
        DefaultTableModel model = (DefaultTableModel)tblResult.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            int len = model.getValueAt(i, 0).toString().length();
            if (len > maxLen)
                maxLen = len;
        }
        int space = 5;
        maxLen+=space;
        
        // Header
        String header = "Parser";
        result.append(header);
        for (int i = 0; i < maxLen - header.length(); i++) { result.append(" "); }
        result.append("LAS ").append("\t");
        result.append("UAS ").append("\n");
        for (int i = 0; i < maxLen - space; i++) { result.append("-"); }
        for (int i = 0; i < space; i++) { result.append(" "); }
        result.append("----").append("\t");
        result.append("----").append("\n");
        
        // Body
        for (int i = 0; i < model.getRowCount(); i++) {
            String path = model.getValueAt(i, 0).toString();
            result.append(path);
            for (int k = 0; k < maxLen - path.length(); k++) { result.append(" "); }
            result.append(model.getValueAt(i, 1).toString()).append("\t");
            result.append(model.getValueAt(i, 2).toString()).append("\n");
        }
        ExampleFileFilter filter = new ExampleFileFilter("txt", "Text Files");
        saveText(filter, "Evaluation_log.txt", result.toString());
    }

    @Override
    public void saveAs() {
        save();
    }
    
    @Override
    public void threadFinished() {
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        separator = new javax.swing.JPanel();
        pnlSettings = new javax.swing.JPanel();
        lblMethodTitle = new javax.swing.JLabel();
        cboMethod = new javax.swing.JComboBox();
        lblBaselineListTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstBaselineParser = new javax.swing.JList(new DefaultListModel());
        btnAddBL = new javax.swing.JButton();
        btnRemoveBL = new javax.swing.JButton();
        lblOutputPath = new javax.swing.JLabel();
        txtOutputPath = new javax.swing.JTextField();
        btnBrowseOutputPath = new javax.swing.JButton();
        btnStart = new javax.swing.JButton();
        btnRemoveAll = new javax.swing.JButton();
        lblGoldFile = new javax.swing.JLabel();
        txtGoldFile = new javax.swing.JTextField();
        btnBrowseGoldFile = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblResult = new javax.swing.JTable(new DefaultTableModel());

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTitle.setText("Ensemble");

        separator.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        separator.setPreferredSize(new java.awt.Dimension(380, 2));

        javax.swing.GroupLayout separatorLayout = new javax.swing.GroupLayout(separator);
        separator.setLayout(separatorLayout);
        separatorLayout.setHorizontalGroup(
            separatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        separatorLayout.setVerticalGroup(
            separatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlSettings.setBorder(javax.swing.BorderFactory.createTitledBorder("Settings"));

        lblMethodTitle.setText("Method:");

        cboMethod.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "majority", "attardi", "eisner", "chu_liu_edmond" }));

        lblBaselineListTitle.setText("List of baseline parser");

        lstBaselineParser.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstBaselineParser_valueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstBaselineParser);

        btnAddBL.setText("Add ...");
        btnAddBL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddBLActionPerformed(evt);
            }
        });

        btnRemoveBL.setText("Remove");
        btnRemoveBL.setEnabled(false);
        btnRemoveBL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveBLActionPerformed(evt);
            }
        });

        lblOutputPath.setText("Output Path:");

        txtOutputPath.setEditable(false);

        btnBrowseOutputPath.setText("...");
        btnBrowseOutputPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseOutputPathActionPerformed(evt);
            }
        });

        btnStart.setText("Start");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartAction_Click(evt);
            }
        });

        btnRemoveAll.setText("Rrmove All");
        btnRemoveAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveAllActionPerformed(evt);
            }
        });

        lblGoldFile.setText("Gold File:");

        txtGoldFile.setEditable(false);

        btnBrowseGoldFile.setText("...");
        btnBrowseGoldFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseGoldFileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSettingsLayout = new javax.swing.GroupLayout(pnlSettings);
        pnlSettings.setLayout(pnlSettingsLayout);
        pnlSettingsLayout.setHorizontalGroup(
            pnlSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSettingsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSettingsLayout.createSequentialGroup()
                        .addComponent(lblBaselineListTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblMethodTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboMethod, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addGroup(pnlSettingsLayout.createSequentialGroup()
                        .addComponent(btnAddBL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemoveBL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemoveAll)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnStart))
                    .addGroup(pnlSettingsLayout.createSequentialGroup()
                        .addGroup(pnlSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblOutputPath)
                            .addComponent(lblGoldFile))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtGoldFile)
                            .addComponent(txtOutputPath))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnBrowseGoldFile, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBrowseOutputPath, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))))
                .addContainerGap())
        );
        pnlSettingsLayout.setVerticalGroup(
            pnlSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSettingsLayout.createSequentialGroup()
                .addGroup(pnlSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMethodTitle)
                    .addComponent(cboMethod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBaselineListTitle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddBL)
                    .addComponent(btnRemoveBL)
                    .addComponent(btnRemoveAll)
                    .addComponent(btnStart))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGoldFile)
                    .addComponent(txtGoldFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBrowseGoldFile))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOutputPath)
                    .addComponent(txtOutputPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBrowseOutputPath))
                .addContainerGap())
        );

        tblResult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Parser", "LAS", "UAS"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblResult);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(separator, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
                    .addComponent(pnlSettings, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTitle)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlSettings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnStartAction_Click(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartAction_Click
        String reparseAlgorithm = cboMethod.getSelectedItem().toString();
        DefaultListModel model = (DefaultListModel) lstBaselineParser.getModel();
        try {
            
            List<String> sysFiles = new LinkedList<>();
            for (int i = 0; i < model.size(); i++) {
                String name = model.get(i).toString();
                
                if (reparseAlgorithm.equals("chu_liu_edmond")) {
                    File from = new File(name).getAbsoluteFile();
                    name = workingDir + File.separator + from.getName();
                    File to = new File(name);
                    if (!from.equals(to)) {
                        FileUtils.copyFile(from, to);
                    }
                    name = "tmp" + File.separator + from.getName();
                }

                sysFiles.add(name);
            }
            
            String goldFile = txtGoldFile.getText();
            if (reparseAlgorithm.equals("chu_liu_edmond")) {
                File from = new File(goldFile).getAbsoluteFile();
                File to = new File(workingDir + File.separator + from.getName());
                if (!from.equals(to)) {
                    FileUtils.copyFile(from, to);
                }
                goldFile = "tmp" + File.separator + from.getName();
            }
            
            String outFile = txtOutputPath.getText() + reparseAlgorithm + ".conll";
            if (reparseAlgorithm.equals("chu_liu_edmond")) {
                File from = new File(outFile).getAbsoluteFile();
                outFile = "tmp" + File.separator + from.getName();
            }

            DefaultTableModel tblModel = (DefaultTableModel)tblResult.getModel();
            tblModel.setRowCount(0);
            
            Runnable run = new RunnableHybrid(null, null, goldFile, sysFiles, 
                    outFile, ReparseType.valueOf(reparseAlgorithm));
            run.run();
            
            // Evaluate
            for (int i = 0; i < model.size(); i++) {
                String parser = model.get(i).toString();
                Scorer.Score s = Scorer.evaluate(parser, goldFile);
                String las = String.format("%.2f", s.las);
                String uas = String.format("%.2f", s.uas);
                tblModel.addRow(new String[] { parser, las, uas });
            }
            Scorer.Score s = Scorer.evaluate(outFile, goldFile);
            String las = String.format("%.2f", s.las);
            String uas = String.format("%.2f", s.uas);
            tblModel.addRow(new String[] { "ensemble result (" + reparseAlgorithm + ")", las, uas });
        } catch (IOException ex) {
        }
        finally {
            if (reparseAlgorithm.equals("chu_liu_edmond")) {
                for (int i = 0; i < model.size(); i++) {
                    String name = model.get(i).toString();

                    File from = new File(name).getAbsoluteFile();
                    name = workingDir + File.separator + from.getName();
                    File to = new File(name);
                    if (!from.equals(to)) {
                        to.delete();
                    }
                }
            
                File from = new File(txtGoldFile.getText()).getAbsoluteFile();
                File to = new File(workingDir + File.separator + from.getName());
                if (!from.equals(to)) {
                    to.delete();
                }
                
                String outFile = txtOutputPath.getText() + reparseAlgorithm + ".conll";
                from = new File(outFile).getAbsoluteFile();
                to = new File(workingDir + File.separator + from.getName());
                if (!from.equals(to)) {
                    try {
                        FileUtils.copyFile(to, from);
                    } catch (IOException ex) {
                    }
                    to.delete();
                }
            }
        }
    }//GEN-LAST:event_btnStartAction_Click
    private String currentDir = "";

    private void btnAddBLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddBLActionPerformed
        String dir = showFileDialog(currentDir, false);
        if (dir != null && dir.length() != 0 && !dir.equals(currentDir)) {
            currentDir = dir;
            DefaultListModel model = (DefaultListModel) lstBaselineParser.getModel();
            model.addElement(dir);
        }
    }//GEN-LAST:event_btnAddBLActionPerformed

    private void btnRemoveAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveAllActionPerformed
        DefaultListModel model = (DefaultListModel) lstBaselineParser.getModel();
        model.removeAllElements();
    }//GEN-LAST:event_btnRemoveAllActionPerformed

    private void lstBaselineParser_valueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstBaselineParser_valueChanged
        if (lstBaselineParser.getSelectedIndices().length == 0) {
            btnRemoveBL.setEnabled(false);
        } else {
            btnRemoveBL.setEnabled(true);
        }
    }//GEN-LAST:event_lstBaselineParser_valueChanged

    private void btnRemoveBLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveBLActionPerformed
        int count = lstBaselineParser.getSelectedIndices().length;
        DefaultListModel model = (DefaultListModel) lstBaselineParser.getModel();
        for (int i = count - 1; i >= 0; i--) {
            model.removeElementAt(lstBaselineParser.getSelectedIndices()[i]);
        }
    }//GEN-LAST:event_btnRemoveBLActionPerformed

    private void btnBrowseGoldFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseGoldFileActionPerformed
        txtGoldFile.setText(showFileDialog(txtGoldFile.getText(), false));
    }//GEN-LAST:event_btnBrowseGoldFileActionPerformed

    private void btnBrowseOutputPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseOutputPathActionPerformed
        txtOutputPath.setText(showFileDialog(txtOutputPath.getText(), true));
    }//GEN-LAST:event_btnBrowseOutputPathActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddBL;
    private javax.swing.JButton btnBrowseGoldFile;
    private javax.swing.JButton btnBrowseOutputPath;
    private javax.swing.JButton btnRemoveAll;
    private javax.swing.JButton btnRemoveBL;
    private javax.swing.JButton btnStart;
    private javax.swing.JComboBox cboMethod;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblBaselineListTitle;
    private javax.swing.JLabel lblGoldFile;
    private javax.swing.JLabel lblMethodTitle;
    private javax.swing.JLabel lblOutputPath;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JList lstBaselineParser;
    private javax.swing.JPanel pnlSettings;
    private javax.swing.JPanel separator;
    private javax.swing.JTable tblResult;
    private javax.swing.JTextField txtGoldFile;
    private javax.swing.JTextField txtOutputPath;
    // End of variables declaration//GEN-END:variables
}