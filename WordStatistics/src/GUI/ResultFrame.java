package GUI;

import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author xorigin
 */

public class ResultFrame extends javax.swing.JFrame {

    private volatile static ResultFrame uniqueIstance;
    
    private ResultFrame(){
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    public static ResultFrame getInstance() {
        if(uniqueIstance == null){
            synchronized(ResultFrame.class){
                uniqueIstance = new ResultFrame();
            }
        }
        return uniqueIstance;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DirectoryTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        FileTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Result");
        setMinimumSize(new java.awt.Dimension(1200, 500));
        setResizable(false);
        setSize(new java.awt.Dimension(1200, 500));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("File statistics:");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setText("Directory statistics:");

        DirectoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N", "Directory name", "Number of words", "Latest Longest word", "Latest Shortest word", "Number of 'is'", "Number of 'are'", "Number of 'you'"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.Long.class, java.lang.Long.class, java.lang.Long.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        DirectoryTable.setShowGrid(true);
        DirectoryTable.getTableHeader().setReorderingAllowed(false);
        DirectoryTable.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                DirectoryTablePropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(DirectoryTable);
        if (DirectoryTable.getColumnModel().getColumnCount() > 0) {
            DirectoryTable.getColumnModel().getColumn(0).setMaxWidth(40);
        }

        FileTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N", "File name", "Number of words", "Latest Longest word", "Latest Shortest word", "Number of 'is'", "Number of 'are'", "Number of 'you'"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.Long.class, java.lang.Long.class, java.lang.Long.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        FileTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        FileTable.getTableHeader().setReorderingAllowed(false);
        FileTable.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                FileTablePropertyChange(evt);
            }
        });
        jScrollPane2.setViewportView(FileTable);
        if (FileTable.getColumnModel().getColumnCount() > 0) {
            FileTable.getColumnModel().getColumn(0).setMaxWidth(40);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1167, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DirectoryTablePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_DirectoryTablePropertyChange
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        for(int i=0;i<DirectoryTable.getColumnCount();++i){
            DirectoryTable.getColumnModel().getColumn(i).setCellRenderer( centerRenderer );
        }
    }//GEN-LAST:event_DirectoryTablePropertyChange

    public javax.swing.JTable getDirectoryTable(){
        return DirectoryTable;
    }
    
    private void FileTablePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_FileTablePropertyChange
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        for(int i=0;i<FileTable.getColumnCount();++i){
            FileTable.getColumnModel().getColumn(i).setCellRenderer( centerRenderer );
        }
    }//GEN-LAST:event_FileTablePropertyChange

    public javax.swing.JTable getFileTable(){
        return FileTable;
    }
    
    private static void clear(){
        uniqueIstance = null;
    }
    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                getInstance().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable DirectoryTable;
    private javax.swing.JTable FileTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
