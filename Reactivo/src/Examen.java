
import javax.swing.JFrame;
import javax.swing.JScrollPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ELI
 */
public class Examen extends javax.swing.JFrame {
    private Reactivo[] reactivos= new Reactivo[10];
    private int indice;
    private static JFrame examen;
    /**
     * Creates new form Examen
     */
    public Examen() {
        initComponents();
        indice=0;
        Calificar.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        OpcionMultiple = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        Respuesta = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Pregunta = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Ponderacion = new javax.swing.JTextField();
        OpcionMultipleV = new javax.swing.JButton();
        RespuestaDirecta = new javax.swing.JButton();
        RespuestaDirectaN = new javax.swing.JButton();
        Relaciones = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Agregar = new javax.swing.JButton();
        Calificar = new javax.swing.JToggleButton();

        jFrame1.setMinimumSize(new java.awt.Dimension(500, 500));

        OpcionMultiple.setText("Opcion Multiple");
        OpcionMultiple.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpcionMultipleActionPerformed(evt);
            }
        });

        jLabel2.setText("Respuestas (separe por comas en caso de mutliples):");

        jLabel3.setText("Pregunta:");

        jLabel4.setText("Respuestas (separe por comas en caso de mutliples):");

        OpcionMultipleV.setText("Opción Multiple V");
        OpcionMultipleV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpcionMultipleVActionPerformed(evt);
            }
        });

        RespuestaDirecta.setText("Respuesta Directa");
        RespuestaDirecta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RespuestaDirectaActionPerformed(evt);
            }
        });

        RespuestaDirectaN.setText("RespuestaDirectaN");
        RespuestaDirectaN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RespuestaDirectaNActionPerformed(evt);
            }
        });

        Relaciones.setText("Relaciones");
        Relaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelacionesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jFrame1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Ponderacion))
                    .addGroup(jFrame1Layout.createSequentialGroup()
                        .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jFrame1Layout.createSequentialGroup()
                                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Pregunta, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                                    .addComponent(Respuesta)))
                            .addGroup(jFrame1Layout.createSequentialGroup()
                                .addComponent(RespuestaDirecta)
                                .addGap(18, 18, 18)
                                .addComponent(RespuestaDirectaN))
                            .addGroup(jFrame1Layout.createSequentialGroup()
                                .addComponent(OpcionMultiple)
                                .addGap(34, 34, 34)
                                .addComponent(OpcionMultipleV)
                                .addGap(33, 33, 33)
                                .addComponent(Relaciones)))
                        .addGap(1, 1, 1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OpcionMultiple)
                    .addComponent(OpcionMultipleV)
                    .addComponent(Relaciones))
                .addGap(20, 20, 20)
                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RespuestaDirecta)
                    .addComponent(RespuestaDirectaN))
                .addGap(14, 14, 14)
                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Pregunta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Respuesta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Ponderacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(132, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Examen");

        Agregar.setText("Agregar Reactivo");
        Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarActionPerformed(evt);
            }
        });

        Calificar.setText("Calificar");
        Calificar.setEnabled(false);
        Calificar.setFocusable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Agregar)
                        .addGap(27, 27, 27)
                        .addComponent(Calificar)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Agregar)
                    .addComponent(Calificar))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarActionPerformed
        jFrame1.setVisible(true);
    }//GEN-LAST:event_AgregarActionPerformed

    private void OpcionMultipleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpcionMultipleActionPerformed
        try{
        String[] res=Respuesta.getText().split(",");
        String[] aux=Ponderacion.getText().split(",");
        int[] pon= new int[aux.length];
        for(int i=0;i<aux.length;i++){
            pon[i]=Integer.parseInt(aux[i]);
        }
        System.out.println("Pregunta: "+Pregunta.getText()+" Respuesta "+Respuesta.getText());
        reactivos[indice]=new OpcionMultipleU(Pregunta.getText(),res,pon);
        /*reactivos[indice].formaAplicacion(new OpcionMultiple());
        reactivos[indice].aplicacion();
        reactivos[indice].calificacion();*/
        indice++; 
        }catch(Exception e){
                System.out.println(e);
        }
    }//GEN-LAST:event_OpcionMultipleActionPerformed

    private void OpcionMultipleVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpcionMultipleVActionPerformed
        try{
        String[] res=Respuesta.getText().split(",");
        String[] aux=Ponderacion.getText().split(",");
        int[] pon= new int[aux.length];
        for(int i=0;i<aux.length;i++){
            pon[i]=Integer.parseInt(aux[i]);
        }
        System.out.println("Pregunta: "+Pregunta.getText()+" Respuesta "+Respuesta.getText());
        reactivos[indice]=new OpcionMultipleV(Pregunta.getText(),res,pon);
        //reactivos[indice].calificacion();
        indice++;
        }catch(Exception e){
                System.out.println("ponga bien los datos");
        }
    }//GEN-LAST:event_OpcionMultipleVActionPerformed

    private void RelacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelacionesActionPerformed
        try{
        String[] res=Respuesta.getText().split(",");
        String[] aux=Ponderacion.getText().split(",");
        int[] pon= new int[aux.length];
        for(int i=0;i<aux.length;i++){
            pon[i]=Integer.parseInt(aux[i]);
        }
        System.out.println("Pregunta: "+Pregunta.getText()+" Respuesta "+Respuesta.getText());
        reactivos[indice]=new Relaciones(Pregunta.getText(),res,pon);
        //reactivos[indice].calificacion();
        indice++;
        }catch(Exception e){
                System.out.println("ponga bien los datos");
        }
    }//GEN-LAST:event_RelacionesActionPerformed

    private void RespuestaDirectaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RespuestaDirectaActionPerformed
        try{
        String[] res=Respuesta.getText().split(",");
        String[] aux=Ponderacion.getText().split(",");
        int[] pon= new int[aux.length];
        for(int i=0;i<aux.length;i++){
            pon[i]=Integer.parseInt(aux[i]);
        }
        System.out.println("Pregunta: "+Pregunta.getText()+" Respuesta "+Respuesta.getText());
        reactivos[indice]=new RespuestaDirecta(Pregunta.getText(),res,pon);
        //reactivos[indice].calificacion();
        indice++;
        }catch(Exception e){
                System.out.println("ponga bien los datos");
        }
    }//GEN-LAST:event_RespuestaDirectaActionPerformed

    private void RespuestaDirectaNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RespuestaDirectaNActionPerformed
        try{
        String[] res=Respuesta.getText().split(",");
        String[] aux=Ponderacion.getText().split(",");
        int[] pon= new int[aux.length];
        for(int i=0;i<aux.length;i++){
            pon[i]=Integer.parseInt(aux[i]);
        }
        System.out.println("Pregunta: "+Pregunta.getText()+" Respuesta "+Respuesta.getText());
        reactivos[indice]=new RespuestaDirectaN(Pregunta.getText(),res,pon);
        //reactivos[indice].calificacion();
        indice++;
        }catch(Exception e){
                System.out.println("ponga bien los datos");
        }
    }//GEN-LAST:event_RespuestaDirectaNActionPerformed

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
            java.util.logging.Logger.getLogger(Examen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Examen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Examen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Examen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                examen = new Examen();
                examen.setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Agregar;
    private javax.swing.JToggleButton Calificar;
    private javax.swing.JButton OpcionMultiple;
    private javax.swing.JButton OpcionMultipleV;
    private javax.swing.JTextField Ponderacion;
    private javax.swing.JTextField Pregunta;
    private javax.swing.JButton Relaciones;
    private javax.swing.JTextField Respuesta;
    private javax.swing.JButton RespuestaDirecta;
    private javax.swing.JButton RespuestaDirectaN;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
