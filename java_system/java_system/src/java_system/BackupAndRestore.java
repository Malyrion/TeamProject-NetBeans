/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_system;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collectors;
import javax.swing.JFileChooser;
import javax.swing.JSpinner;

/**
 *
 * @author katoj
 */
public class BackupAndRestore extends javax.swing.JFrame {
   
   //!!!!!   set batchFileLoc to the location where you put the back_up_test.bat file"  
   String batchFileLoc = "C:/Users/katoj/Desktop/back_up_test.bat";
   
   
   String crntBackUpFreq = "";
   String backUpTime = "";
   String[] backUpFrequencies = {"Daily","Weekly","Monthly","Hourly","Minute"};
   
   
   /**
     * Creates new form SQLBackupAndRestore
     */
    public BackupAndRestore() {
        initComponents();
        
        
        

         try{
            Runtime rt = Runtime.getRuntime();
            String[] commands = {"schtasks", "/Query", "/TN", "sql_backup2", "/V"};//schtasks /Query /TN sql_backup2 /V
            Process proc = rt.exec(commands);
            BufferedReader stdInput = new BufferedReader(new 
            InputStreamReader(proc.getInputStream()));
            String output = stdInput.lines().collect(Collectors.joining());
            String[] outputs = output.split("\\s+");

            boolean foundFreq = false;
            for(String word: outputs){
                if(foundFreq == false){
                    for(String fr: backUpFrequencies){
                        if(word.equals(fr)){
                            crntBackUpFreq = word;
                            System.out.print(crntBackUpFreq);
                            foundFreq = true;
                            //Arrays.asList(outputs).indexOf(crntBackUpFrequency)+ 1;

                        }
                    }
                }
                else{
                  backUpTime = word;
                  System.out.print(backUpTime);
                  
                  break;
                }
            }
        }
        catch(IOException e){
        e.printStackTrace();
        }
        
     
        jLabel13.setText(crntBackUpFreq + " at " + backUpTime + "(time)");
   
       
    }

    String path = null;
    String filename;
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jSpinner2 = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextField1.setEditable(false);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setText("Browse Path");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Backup");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("...");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jButton3.setText("Browse");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Restore");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel2.setText("...");

        jLabel4.setText("New Backup Frequency :");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Daily", "Weekly", "Monthly", "Hourly", "Minutely" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel6.setText("From (hour:minute) :");

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(8, 0, 23, 1));

        jSpinner2.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 1));

        jLabel7.setFont(new java.awt.Font("MS UI Gothic", 0, 18)); // NOI18N
        jLabel7.setText(":");

        jButton5.setText("Change");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel11.setText("Current Backup Frequency:");

        jLabel13.setText("...");

        jLabel3.setText("...");

        jButton6.setText("Refresh");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Main Page");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addComponent(jButton1))))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(215, 215, 215))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jButton5)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel7)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jButton6)))
                                .addContainerGap(44, Short.MAX_VALUE))))))
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jButton7)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jButton7)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(jButton6)
                                .addGap(28, 28, 28)
                                .addComponent(jLabel12))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(6, 6, 6)
                        .addComponent(jButton4)
                        .addGap(51, 51, 51))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(106, 176, Short.MAX_VALUE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(jLabel4)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        JFileChooser fc = new JFileChooser();
        fc.showOpenDialog(this);
        String date = new SimpleDateFormat("yyyy-MM-dd-hh-mm").format(new Date());
        
        try {
            File f = fc.getSelectedFile();
            path = f.getAbsolutePath();
            path = path.replace('\\', '/');
            path = path+"_" + date + ".sql";
            jTextField1.setText(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Process p=null;
        try{
            Runtime runtime = Runtime.getRuntime();    
            
            //"C:\\xampp\\mysql\\bin"
            p = runtime.exec("C:/xampp/mysql/bin/mysqldump.exe -uroot --add-drop-database -B  java_system_db -r"+path);
            int processComplete = p.waitFor();
            
            if(processComplete == 0){
                jLabel1.setText("Backup Created Success");
        
            }else{
                jLabel1.setText("Backup Unsuccessful");
            }
     
        }catch (Exception e){
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        JFileChooser fc = new JFileChooser();
        fc.showOpenDialog(this);
        
        try{
            File f = fc.getSelectedFile();
            path = f.getAbsolutePath();
            path = path.replace('\\', '/');
            
            jTextField2.setText(path);
        }catch (Exception e){
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        String user = "root";
        //String[] restoreCmd = new String[]{"C:/xampp/mysql/bin/mysql.exe ", "--user=" + user, "-e","source "+path};        
        String[] restoreCmd = new String[]{"C:/xampp/mysql/bin/mysql.exe ", "--user=" + user, "-e","source "+path}; 
        Process process;
       
        try{
            process = Runtime.getRuntime().exec(restoreCmd);
            int procCom = process.waitFor();
            
            if(procCom==0){
                jLabel2.setText("Restored Success!");
            }else{
                jLabel2.setText("Can't Restore");
            }
     
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        Process p=null;
        
        String jSpinner2Val = ""; 
        String jSpinner1Val = "";
        
        if((int)jSpinner2.getValue() < 10){
            jSpinner2Val = "0" + jSpinner2.getValue().toString();
        }else{
            jSpinner2Val = jSpinner2.getValue().toString();
        }
        
        if((int)jSpinner1.getValue()<10){
            jSpinner1Val = "0" + jSpinner1.getValue().toString();
        }else{
            jSpinner1Val = jSpinner1.getValue().toString();
        }
        
        try{
            
    
            Runtime runtime = Runtime.getRuntime();    
//            runtime.exec("schtasks /Delete /TN sql_backup7");
//            System.out.print("schtasks /Change /tn sql_backup7 /sc "
//                    +jComboBox1.getSelectedItem().toString() + " /st "+ 
//                    jSpinner1Val +":" + jSpinner2Val);
//            
            
            //"C:\\xampp\\mysql\\bin"
            //"<nul set /p=\"Y\" |
            
//            p = runtime.exec("schtasks /Change /tn sql_backup7 /sc "
//                    +jComboBox1.getSelectedItem().toString() + " /st "+ 
//                    jSpinner1Val +":" + jSpinner2Val);
//            
           
                    
            p = runtime.exec("schtasks /create /tn sql_backup"
                    + " /tr "+ batchFileLoc + " /F /sc "
                    +jComboBox1.getSelectedItem().toString() + " /st "+ 
                    jSpinner1Val +":" + jSpinner2Val);
            int processComplete = p.waitFor();
            
            if(processComplete == 0){
                jLabel3.setText("Created Successfully");
        
            }else{
                jLabel3.setText("Unsuccessful");
            }
     
        }catch (Exception e){
            e.printStackTrace();
        }
        try{
            Runtime rt = Runtime.getRuntime();
            String[] commands = {"schtasks", "/Query", "/TN", "sql_backup", "/V"};//schtasks /Query /TN sql_backup2 /V
            Process proc = rt.exec(commands);
            BufferedReader stdInput = new BufferedReader(new 
            InputStreamReader(proc.getInputStream()));
            String output = stdInput.lines().collect(Collectors.joining());
            String[] outputs = output.split("\\s+");

            boolean foundFreq = false;
            for(String word: outputs){
                if(foundFreq == false){
                    for(String fr: backUpFrequencies){
                        if(word.equals(fr)){
                            crntBackUpFreq = word;
                            foundFreq = true;
                            //Arrays.asList(outputs).indexOf(crntBackUpFrequency)+ 1;

                        }
                    }
                }
                else{
                  backUpTime = word;
              
                  
                  break;
                }
            }
        }
        catch(IOException e){
        e.printStackTrace();
        }
        
     
        jLabel13.setText(crntBackUpFreq + " at " + backUpTime + "(time)");
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
     
         try{
            Runtime rt = Runtime.getRuntime();
            String[] commands = {"schtasks", "/Query", "/TN", "sql_backup", "/V"};//schtasks /Query /TN sql_backup2 /V
            Process proc = rt.exec(commands);
            BufferedReader stdInput = new BufferedReader(new 
            InputStreamReader(proc.getInputStream()));
            String output = stdInput.lines().collect(Collectors.joining());
            String[] outputs = output.split("\\s+");

            boolean foundFreq = false;
            for(String word: outputs){
                if(foundFreq == false){
                    for(String fr: backUpFrequencies){
                        if(word.equals(fr)){
                            crntBackUpFreq = word;
                            System.out.print(crntBackUpFreq);
                            foundFreq = true;
                            //Arrays.asList(outputs).indexOf(crntBackUpFrequency)+ 1;

                        }
                    }
                }
                else{
                  backUpTime = word;
                  System.out.print(backUpTime);
                  
                  break;
                }
            }
        }
        catch(IOException e){
        e.printStackTrace();
        }
        
     
        jLabel13.setText(crntBackUpFreq + " at " + backUpTime + "(time)");
   
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        systemAdmin om = new systemAdmin();
        om.setVisible(true);
        om.pack();
        om.setLocationRelativeTo(null);
        
        this.dispose();

    }//GEN-LAST:event_jButton7ActionPerformed

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
            java.util.logging.Logger.getLogger(BackupAndRestore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BackupAndRestore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BackupAndRestore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BackupAndRestore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BackupAndRestore().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
