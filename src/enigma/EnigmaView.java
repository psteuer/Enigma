package enigma;

import java.awt.Toolkit;
import java.awt.event.ActionListener;

/**
 *
 * @author psteu_000
 */
//This is the View for the MVC model
public class EnigmaView extends javax.swing.JFrame {

    /**
     * Creates new form JFrameWindow
     */
    public EnigmaView() {
        initComponents();
    }

    public void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Lock-Lock-icon.png")));
    }

    public String getentext() {
        return EncryptTextBox.getText();
    }

    public String getdetext() {
        return DecryptTextbox.getText();
    }

    public String getkeytext() {
        return KeyTextBox.getText();
    }

    public void setentext(String entext) {
        EncryptTextBox.setText(entext);
    }

    public void setdetext(String detext) {
        DecryptTextbox.setText(detext);
    }

    public void setkeytext(String keytext) {
        KeyTextBox.setText(keytext);
    }

    public void setIsFileText(String text) {
        isFileUp.setText(text);
    }

    public void setEncryptTextOutput(String text) {
        EncryptTextOutput.setText(text);
    }

    public void setDecryptTextOutput(String text) {
        DecryptTextOutput.setText(text);
    }

    public void btnEnableDisable(boolean a) {
        GoDecryptFile.setEnabled(a);
        GoEncryptFile.setEnabled(a);
    }

    /**
     *
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator5 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        EncryptButton = new javax.swing.JButton();
        EncryptTextBox = new javax.swing.JTextField();
        DecryptButton = new javax.swing.JButton();
        DecryptTextbox = new javax.swing.JTextField();
        KeyTextBox = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        MakePic = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        FileSelector = new javax.swing.JButton();
        isFileUp = new javax.swing.JLabel();
        EncryptTextOutput = new javax.swing.JTextField();
        DecryptTextOutput = new javax.swing.JTextField();
        GoEncryptFile = new javax.swing.JButton();
        GoDecryptFile = new javax.swing.JButton();
        RandomKeyGen = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        OutputFileSelector = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("~Enigma~");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(36, 113, 163));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setForeground(new java.awt.Color(36, 113, 163));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 652));

        EncryptButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        EncryptButton.setText("Encrypt Text");
        EncryptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EncryptButtonActionPerformed(evt);
            }
        });

        EncryptTextBox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        EncryptTextBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EncryptTextBoxActionPerformed(evt);
            }
        });

        DecryptButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        DecryptButton.setText("Decrypt Text");
        DecryptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DecryptButtonActionPerformed(evt);
            }
        });

        DecryptTextbox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        DecryptTextbox.setToolTipText("");

        KeyTextBox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        KeyTextBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KeyTextBoxActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Key - Max 16 Bytes");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Text to Encrypt (Plaintext) - Max 16 Bytes");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Text to Decrypt (Ciphertext) - in Base64");

        MakePic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/enigma/aes-logo.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Advanced Encryption Standard");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Created by Paul Steuer");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Output (Ciphertext) - in Base64");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Output (Plaintext)");

        FileSelector.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        FileSelector.setText("Input File");
        FileSelector.setActionCommand("");
        FileSelector.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FileSelectorMouseClicked(evt);
            }
        });
        FileSelector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FileSelectorActionPerformed(evt);
            }
        });

        isFileUp.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        isFileUp.setForeground(new java.awt.Color(255, 255, 255));
        isFileUp.setText("No File Uploaded");
        isFileUp.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        EncryptTextOutput.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        DecryptTextOutput.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        DecryptTextOutput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DecryptTextOutputActionPerformed(evt);
            }
        });

        GoEncryptFile.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        GoEncryptFile.setText("Encrypt File");

        GoDecryptFile.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        GoDecryptFile.setText("Decrypt File");

        RandomKeyGen.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        RandomKeyGen.setText("Random Key Generator");

        OutputFileSelector.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        OutputFileSelector.setText("Output File");

        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator3)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(EncryptTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EncryptTextOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addComponent(EncryptButton)))
                        .addGap(32, 32, 32)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(DecryptTextbox, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8)
                                    .addComponent(DecryptTextOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(157, 157, 157)
                                .addComponent(DecryptButton))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(MakePic)
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(RandomKeyGen)
                        .addGap(18, 18, 18)
                        .addComponent(KeyTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(277, 277, 277)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(FileSelector)
                                .addGap(66, 66, 66)
                                .addComponent(OutputFileSelector))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(GoEncryptFile)
                                .addGap(50, 50, 50)
                                .addComponent(GoDecryptFile)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(369, 369, 369)
                        .addComponent(isFileUp, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 27, Short.MAX_VALUE)
                        .addComponent(MakePic)
                        .addGap(7, 7, 7)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RandomKeyGen)
                    .addComponent(KeyTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EncryptTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DecryptTextbox, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EncryptTextOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DecryptTextOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(EncryptButton)
                            .addComponent(DecryptButton)))
                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FileSelector)
                    .addComponent(OutputFileSelector, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(isFileUp)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GoEncryptFile)
                    .addComponent(GoDecryptFile))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DecryptTextOutputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DecryptTextOutputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DecryptTextOutputActionPerformed

    private void FileSelectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FileSelectorActionPerformed
        // TODO add your handling code here:
        //acidently changed something
    }//GEN-LAST:event_FileSelectorActionPerformed

    private void FileSelectorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FileSelectorMouseClicked
        // TODO add your handling code here:
        //System.out.println(" HI what Part of the MVC model is this???");
    }//GEN-LAST:event_FileSelectorMouseClicked

    private void KeyTextBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KeyTextBoxActionPerformed

    }//GEN-LAST:event_KeyTextBoxActionPerformed

    private void DecryptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DecryptButtonActionPerformed

    }//GEN-LAST:event_DecryptButtonActionPerformed

    private void EncryptTextBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EncryptTextBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EncryptTextBoxActionPerformed

    private void EncryptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EncryptButtonActionPerformed

    }//GEN-LAST:event_EncryptButtonActionPerformed

    void addEncryptListener(ActionListener listenForEncryptButton) {
        EncryptButton.addActionListener(listenForEncryptButton);
    }

    void addDecryptListener(ActionListener listenForDecryptButton) {
        DecryptButton.addActionListener(listenForDecryptButton);
    }

    void addFileSelector(ActionListener listenForFileSelector) {
        FileSelector.addActionListener(listenForFileSelector);
    }

    void addGoEncryptFile(ActionListener listenForGoEncryptFile) {
        GoEncryptFile.addActionListener(listenForGoEncryptFile);
    }

    void addGoDecryptFile(ActionListener listenForGoDecryptFile) {
        GoDecryptFile.addActionListener(listenForGoDecryptFile);
    }

    void addRand(ActionListener listenForRand) {
        RandomKeyGen.addActionListener(listenForRand);
    }

    void addOutputFileSelector(ActionListener listenForOutputFileSelector) {
        OutputFileSelector.addActionListener(listenForOutputFileSelector);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DecryptButton;
    private javax.swing.JTextField DecryptTextOutput;
    private javax.swing.JTextField DecryptTextbox;
    private javax.swing.JButton EncryptButton;
    private javax.swing.JTextField EncryptTextBox;
    private javax.swing.JTextField EncryptTextOutput;
    private javax.swing.JButton FileSelector;
    private javax.swing.JButton GoDecryptFile;
    private javax.swing.JButton GoEncryptFile;
    private javax.swing.JTextField KeyTextBox;
    private javax.swing.JLabel MakePic;
    private javax.swing.JButton OutputFileSelector;
    private javax.swing.JButton RandomKeyGen;
    private javax.swing.JLabel isFileUp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    // End of variables declaration//GEN-END:variables

}
