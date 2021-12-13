/**
 *
 * @author xorigin
 */
package GUI;
import SharedResources.DirectoryContainer;
import Utility.*;
import java.awt.Toolkit;
import java.io.File;
import javax.swing.JFileChooser;
import static javax.swing.JOptionPane.showMessageDialog;

public class MainFrame extends javax.swing.JFrame {
    
    public MainFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        DirPath = new javax.swing.JTextField();
        DirectoryChooser = new javax.swing.JButton();
        SubDirsCheckBox = new javax.swing.JCheckBox();
        ShowBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Word statistics");
        setLocation(new java.awt.Point(0, 0));
        setMaximumSize(new java.awt.Dimension(620, 250));
        setMinimumSize(new java.awt.Dimension(620, 250));
        setPreferredSize(new java.awt.Dimension(620, 250));
        setResizable(false);
        setSize(new java.awt.Dimension(620, 250));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Enter a Directory Path:");

        DirPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DirPathActionPerformed(evt);
            }
        });

        DirectoryChooser.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        DirectoryChooser.setText("Browse");
        DirectoryChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DirectoryChooserActionPerformed(evt);
            }
        });

        SubDirsCheckBox.setFont(new java.awt.Font("Consolas", 0, 16)); // NOI18N
        SubDirsCheckBox.setText("Include subdirectories?");
        SubDirsCheckBox.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SubDirsCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubDirsCheckBoxActionPerformed(evt);
            }
        });

        ShowBtn.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        ShowBtn.setText("Show Statistics");
        ShowBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(SubDirsCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DirPath, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(134, 134, 134)
                                .addComponent(ShowBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(DirectoryChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DirPath, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DirectoryChooser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SubDirsCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ShowBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DirPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DirPathActionPerformed
        
    }//GEN-LAST:event_DirPathActionPerformed

    private void DirectoryChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DirectoryChooserActionPerformed
        JFileChooser folderChooser =new JFileChooser();
        folderChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        folderChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        folderChooser.setAcceptAllFileFilterUsed(false);
        
        if(folderChooser.showOpenDialog(this)== JFileChooser.APPROVE_OPTION){
            File selectedFolder = folderChooser.getSelectedFile();
            DirPath.setText(selectedFolder.getAbsolutePath());
        }
    }//GEN-LAST:event_DirectoryChooserActionPerformed

    private void SubDirsCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubDirsCheckBoxActionPerformed
        
    }//GEN-LAST:event_SubDirsCheckBoxActionPerformed

    private void ShowBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowBtnActionPerformed
        
        String path= DirPath.getText();
        if(Path.isValid(path)){
            
            this.dispose();
            
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    ResultFrame.getInstance().setVisible(true);
                }
            });
            
            DirectoryContainer.add(path);
            
            if(SubDirsCheckBox.isSelected()){
                Thread t = new Thread (new DiscoverSubdirs(path));
                t.start();
            }
            
            Thread t= new Thread (new DiscoverFiles(path));
            t.start();
           
            new Thread(new Runnable() {
                @Override
                public void run() {
                    
                    try {
                        // Wait a bit before consuming
                        Thread.sleep(200);
                    } catch (InterruptedException ex) {
                        
                    }
                    
                    ConsumeFile.consume();
                }
            }).start();
            
        } else {
            Toolkit.getDefaultToolkit().beep();
            showMessageDialog(null,"Please Enter a Correct Path.");
        }
    }//GEN-LAST:event_ShowBtnActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField DirPath;
    private javax.swing.JButton DirectoryChooser;
    private javax.swing.JButton ShowBtn;
    private javax.swing.JCheckBox SubDirsCheckBox;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
