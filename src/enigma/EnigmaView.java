
package enigma;
import java.awt.event.ActionListener;
/**
 *
 * @author psteu_000
 */
//This is the View for the MVC model
public class EnigmaView extends javax.swing.JFrame {

    private String entext, detext, keytext;
    
    /**
     * Creates new form JFrameWindow
     */
    
    public EnigmaView() {
        initComponents();        
    }
    public String getentext(){
        return entext;  
    }
    public String getdetext(){
        return detext;
    }
    public String getkeytext(){
        return keytext;
    }
    public void setentext(String entext){
        //this.entext = entext;
        this.entext = EncryptTextBox.getText();
    }
    public void setdetext(String detext){
        //this.detext = detext;
        this.detext = DecryptTextbox.getText();
    }
    public void setkeytext(String keytext){
        //this.keytext = keytext;
        this.keytext = KeyTextBox.getText();
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
        EncryptButton = new javax.swing.JButton();
        EncryptTextBox = new javax.swing.JTextField();
        DecryptButton = new javax.swing.JButton();
        DecryptTextbox = new javax.swing.JTextField();
        KeyButton = new javax.swing.JButton();
        KeyTextBox = new javax.swing.JTextField();
        IsFileUploaded = new javax.swing.JTextField();
        SelectFileButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(36, 113, 163));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setForeground(new java.awt.Color(36, 113, 163));

        EncryptButton.setText("Encrypt");
        EncryptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EncryptButtonActionPerformed(evt);
            }
        });

        DecryptButton.setText("Decrypt");
        DecryptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DecryptButtonActionPerformed(evt);
            }
        });

        KeyButton.setText("Key");

        KeyTextBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KeyTextBoxActionPerformed(evt);
            }
        });

        IsFileUploaded.setText("File Not Uploaded");
        IsFileUploaded.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IsFileUploadedActionPerformed(evt);
            }
        });

        SelectFileButton.setText("Select File");
        SelectFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectFileButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(KeyButton)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(EncryptButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EncryptTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 249, Short.MAX_VALUE)
                        .addComponent(DecryptTextbox, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DecryptButton)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(KeyTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SelectFileButton)
                    .addComponent(IsFileUploaded, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EncryptButton)
                    .addComponent(EncryptTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DecryptButton)
                    .addComponent(DecryptTextbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(KeyButton)
                    .addComponent(KeyTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(IsFileUploaded, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(SelectFileButton)
                .addContainerGap(78, Short.MAX_VALUE))
        );

        IsFileUploaded.getAccessibleContext().setAccessibleName("");
        IsFileUploaded.getAccessibleContext().setAccessibleDescription("");
        SelectFileButton.getAccessibleContext().setAccessibleDescription("TEST123");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EncryptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EncryptButtonActionPerformed
        setentext(EncryptTextBox.getText());
    }//GEN-LAST:event_EncryptButtonActionPerformed

    private void KeyTextBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KeyTextBoxActionPerformed
        setkeytext(KeyTextBox.getText());
    }//GEN-LAST:event_KeyTextBoxActionPerformed

    private void DecryptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DecryptButtonActionPerformed
        setdetext(DecryptTextbox.getText());
    }//GEN-LAST:event_DecryptButtonActionPerformed

    private void SelectFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectFileButtonActionPerformed
        //Nothing to do here
    }//GEN-LAST:event_SelectFileButtonActionPerformed

    private void IsFileUploadedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IsFileUploadedActionPerformed
         //Will need to change the text at a later date
    }//GEN-LAST:event_IsFileUploadedActionPerformed
  
    void addEncryptListener(ActionListener listenForEncryptButton){
        EncryptButton.addActionListener(listenForEncryptButton);
    }
    void addDecryptListener(ActionListener listenForDecryptButton){
        DecryptButton.addActionListener(listenForDecryptButton);
    }
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DecryptButton;
    private javax.swing.JTextField DecryptTextbox;
    private javax.swing.JButton EncryptButton;
    private javax.swing.JTextField EncryptTextBox;
    private javax.swing.JTextField IsFileUploaded;
    private javax.swing.JButton KeyButton;
    private javax.swing.JTextField KeyTextBox;
    private javax.swing.JButton SelectFileButton;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
