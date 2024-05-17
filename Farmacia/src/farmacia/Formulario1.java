package farmacia;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Denzel Baysa
 */
public class Formulario1 extends javax.swing.JFrame {

    /**
     * Creates new form Formulario1
     */
    public Formulario1() {
        initComponents();

        // Establecer la limitación de longitud del JTextField nombreMedicamento
        PlainDocument doc = new PlainDocument();
        doc.setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                Document document = fb.getDocument();
                int currentLength = document.getLength();
                int insertLength = text.length();
                int overLimit = (currentLength + insertLength) - 20 - length;

                if (overLimit > 0) {
                    text = text.substring(0, text.length() - overLimit);
                    insertLength = text.length();
                }

                if (text.isEmpty() || insertLength > 0) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });
        nombreMedicamento.setDocument(doc);

        // Establecer la limitación de longitud y permitir solo números para el JTextField cantidadMedicamento
        PlainDocument docCantidadMedicamento = new PlainDocument();
        docCantidadMedicamento.setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                Document document = fb.getDocument();
                int currentLength = document.getLength();
                int insertLength = text.length();
                int overLimit = (currentLength + insertLength) - 3 - length;

                // Verificar si el texto insertado es un número
                for (int i = 0; i < insertLength; i++) {
                    if (!Character.isDigit(text.charAt(i))) {
                        return; // Si no es un número, no se permite la inserción
                    }
                }

                if (overLimit > 0) {
                    text = text.substring(0, text.length() - overLimit);
                    insertLength = text.length();
                }

                if (insertLength > 0) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });
        cantidadMedicamento2.setDocument(docCantidadMedicamento);
    }

    private String obtenerDistribuidorSeleccionado() {
        if (distribuidor1.isSelected()) {
            return distribuidor1.getText();
        } else if (distribuidor2.isSelected()) {
            return distribuidor2.getText();
        } else if (distribuidor3.isSelected()) {
            return distribuidor3.getText();
        } else {
            return ""; // Otra acción en caso de que ninguno esté seleccionado
        }
    }

    private String obtenerDireccionSucursalSeleccionada() {
        if (sucursalPrincipal.isSelected()) {
            return "Calle de la Rosa n. 28"; // Dirección de la sucursal principal
        } else if (sucursalSecundaria.isSelected()) {
            return "Calle Alcazabilla n. 3"; // Dirección de la sucursal secundaria
        } else {
            return ""; // Otra acción en caso de que ninguna esté seleccionada
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        distribuidores = new javax.swing.ButtonGroup();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nombreMedicamento = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tipoMedicamento = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cantidadMedicamento2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        distribuidor1 = new javax.swing.JRadioButton();
        distribuidor2 = new javax.swing.JRadioButton();
        distribuidor3 = new javax.swing.JRadioButton();
        confirmarBoton = new javax.swing.JButton();
        borrarBoton = new javax.swing.JButton();
        errorMedicamento = new javax.swing.JLabel();
        errorCantidad = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        sucursalPrincipal = new javax.swing.JCheckBox();
        sucursalSecundaria = new javax.swing.JCheckBox();
        errorTipo = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        errorDistribuidor = new javax.swing.JLabel();
        errorSucursal = new javax.swing.JLabel();

        jLabel6.setText("jLabel6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Formulario de pedidos");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 355, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Medicamento:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, -1, 32));

        nombreMedicamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreMedicamentoActionPerformed(evt);
            }
        });
        getContentPane().add(nombreMedicamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, 149, 32));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Tipo Medicamento:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, -1, 32));

        tipoMedicamento.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        tipoMedicamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccione uno", "Analgésico", "Anestésico", "Ansiolítico", "Antibiótico", "Anticolinérgico", "Anticonceptivo" }));
        tipoMedicamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoMedicamentoActionPerformed(evt);
            }
        });
        getContentPane().add(tipoMedicamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, 112, 32));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Cantidad:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 102, 32));

        cantidadMedicamento2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantidadMedicamento2ActionPerformed(evt);
            }
        });
        getContentPane().add(cantidadMedicamento2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, 149, 32));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("Distribuidor:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 300, 108, 23));

        distribuidores.add(distribuidor1);
        distribuidor1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        distribuidor1.setText("Cofarma");
        distribuidor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                distribuidor1ActionPerformed(evt);
            }
        });
        getContentPane().add(distribuidor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 310, 147, -1));

        distribuidores.add(distribuidor2);
        distribuidor2.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        distribuidor2.setText("Empsephar");
        distribuidor2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                distribuidor2ActionPerformed(evt);
            }
        });
        getContentPane().add(distribuidor2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 330, 147, -1));

        distribuidores.add(distribuidor3);
        distribuidor3.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        distribuidor3.setText("Cemefar");
        distribuidor3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                distribuidor3ActionPerformed(evt);
            }
        });
        getContentPane().add(distribuidor3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 350, 147, -1));

        confirmarBoton.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        confirmarBoton.setText("Confirmar");
        confirmarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarBotonActionPerformed(evt);
            }
        });
        getContentPane().add(confirmarBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 470, 92, 35));

        borrarBoton.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        borrarBoton.setText("Borrar");
        borrarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarBotonActionPerformed(evt);
            }
        });
        getContentPane().add(borrarBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 470, 92, 35));

        errorMedicamento.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        errorMedicamento.setForeground(new java.awt.Color(255, 0, 0));
        errorMedicamento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(errorMedicamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 160, 350, 20));

        errorCantidad.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        errorCantidad.setForeground(new java.awt.Color(255, 0, 0));
        errorCantidad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(errorCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, 350, 20));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setText("Sucursal:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 400, -1, -1));

        sucursalPrincipal.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        sucursalPrincipal.setText("Principal");
        getContentPane().add(sucursalPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, -1, -1));

        sucursalSecundaria.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        sucursalSecundaria.setText("Secundaria");
        getContentPane().add(sucursalSecundaria, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 400, -1, -1));

        errorTipo.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        errorTipo.setForeground(new java.awt.Color(255, 0, 0));
        errorTipo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(errorTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 350, 20));
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 380, 150, -1));

        errorDistribuidor.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        errorDistribuidor.setForeground(new java.awt.Color(255, 0, 0));
        errorDistribuidor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(errorDistribuidor, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, 350, 20));

        errorSucursal.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        errorSucursal.setForeground(new java.awt.Color(255, 0, 0));
        errorSucursal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(errorSucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 420, 360, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tipoMedicamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoMedicamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipoMedicamentoActionPerformed

    private void distribuidor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_distribuidor1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_distribuidor1ActionPerformed

    private void distribuidor2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_distribuidor2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_distribuidor2ActionPerformed

    private void distribuidor3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_distribuidor3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_distribuidor3ActionPerformed

    private void borrarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarBotonActionPerformed
        
        
        // Borrar el texto del JTextField "nombreMedicamento"
        nombreMedicamento.setText("");


        // Borrar el texto del JTextField "cantidadMedicamento"
        cantidadMedicamento2.setText("0");

        // Establecer el JComboBox "tipoMedicamento" en su primer índice (ninguno seleccionado)
        tipoMedicamento.setSelectedIndex(0);
        // Desseleccionar todos los JRadioButton del grupo "distribuidores"
        distribuidor1.setSelected(false);
        distribuidor2.setSelected(false);
        distribuidor3.setSelected(false);

        // Limpiar cualquier selección en el ButtonGroup de los JRadioButton "distribuidores"
        distribuidores.clearSelection();

        // Desseleccionar los JCheckBox "sucursalPrincipal" y "sucursalSecundaria"
        sucursalPrincipal.setSelected(false);
        sucursalSecundaria.setSelected(false);
    }//GEN-LAST:event_borrarBotonActionPerformed

    private void confirmarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarBotonActionPerformed
        // Obtener el texto ingresado en el campo nombreMedicamento
        String nombre = nombreMedicamento.getText();

        // Verificar si el texto contiene caracteres especiales
        boolean contieneCaracteresEspeciales = !nombre.matches("(?!^ )(?=.*[^ ]$)[a-zA-Z0-9ñÑ ]+");

        // Verificar si se ha seleccionado un tipo de medicamento en el JComboBox
        int tipoIndex = tipoMedicamento.getSelectedIndex();
        boolean tipoSeleccionado = tipoIndex != 0;

        // Verificar si se ha ingresado una cantidad válida en el JTextField cantidadMedicamento
        String cantidadText = cantidadMedicamento2.getText();
        boolean cantidadValida = cantidadText.matches("[1-9][0-9]{0,2}");

        // Verificar si se ha seleccionado al menos un distribuidor en el grupo de JRadioButton distribuidor1
        boolean distribuidorSeleccionado = distribuidor1.isSelected() || distribuidor2.isSelected() || distribuidor3.isSelected();

        // Verificar si se ha seleccionado uno de los JCheckBox sucursalPrincipal o sucursalSecundaria
        boolean sucursalPrincipalSeleccionada = sucursalPrincipal.isSelected();
        boolean sucursalSecundariaSeleccionada = sucursalSecundaria.isSelected();

        // Verificar que se haya seleccionado uno de los JCheckBox sucursalPrincipal o sucursalSecundaria y no ambos
        boolean sucursalValida = (sucursalPrincipalSeleccionada || sucursalSecundariaSeleccionada) && !(sucursalPrincipalSeleccionada && sucursalSecundariaSeleccionada);

        // Si el nombre contiene caracteres especiales, no se ha seleccionado un tipo de medicamento, la cantidad no es válida, no se ha seleccionado un distribuidor o la selección de la sucursal no es válida, mostrar mensaje de error
        if (contieneCaracteresEspeciales || !tipoSeleccionado || !cantidadValida || !distribuidorSeleccionado || !sucursalValida) {
            // Mensaje de error para el nombre del medicamento
            if (contieneCaracteresEspeciales) {
                errorMedicamento.setText("El nombre no puede empezar/terminar con espacio ni contener *, :, _, ., etc.");
            } else {
                errorMedicamento.setText("");
            }

            // Mensaje de error para el tipo de medicamento
            if (!tipoSeleccionado) {
                errorTipo.setText("Debe seleccionar un tipo de medicamento");
            } else {
                errorTipo.setText("");
            }

            // Mensaje de error para la cantidad de medicamento
            if (!cantidadValida) {
                errorCantidad.setText("La cantidad debe ser un número entre 1 y 999");
            } else {
                errorCantidad.setText("");
            }

            // Mensaje de error para el distribuidor
            if (!distribuidorSeleccionado) {
                errorDistribuidor.setText("Debe seleccionar un distribuidor");
            } else {
                errorDistribuidor.setText("");
            }

            // Mensaje de error para la sucursal
            if (!sucursalValida) {
                errorSucursal.setText("Debe seleccionar exactamente una sucursal");
            } else {
                errorSucursal.setText("");
            }
        } else {
            // Si no hay errores, limpiar los mensajes de error
            errorMedicamento.setText("");
            errorTipo.setText("");
            errorCantidad.setText("");
            errorDistribuidor.setText("");
            errorSucursal.setText("");

            // Crear e mostrar el formulario Formulario2
            Formulario2 f2 = new Formulario2();
            f2.finMedicamento.setText(nombre);
            f2.finTipo.setText(tipoMedicamento.getSelectedItem().toString());
            f2.finCantidad.setText(cantidadText);
            f2.finDistribuidor.setText(obtenerDistribuidorSeleccionado());
            f2.finSucursal.setText(obtenerDireccionSucursalSeleccionada());
            f2.setSize(495, 620);
            f2.setVisible(true);
        }
    }//GEN-LAST:event_confirmarBotonActionPerformed

    private void nombreMedicamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreMedicamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreMedicamentoActionPerformed

    private void cantidadMedicamento2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantidadMedicamento2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cantidadMedicamento2ActionPerformed

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
            java.util.logging.Logger.getLogger(Formulario1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Formulario1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Formulario1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Formulario1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Formulario1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton borrarBoton;
    private javax.swing.JTextField cantidadMedicamento2;
    private javax.swing.JButton confirmarBoton;
    private javax.swing.JRadioButton distribuidor1;
    private javax.swing.JRadioButton distribuidor2;
    private javax.swing.JRadioButton distribuidor3;
    private javax.swing.ButtonGroup distribuidores;
    private javax.swing.JLabel errorCantidad;
    private javax.swing.JLabel errorDistribuidor;
    private javax.swing.JLabel errorMedicamento;
    private javax.swing.JLabel errorSucursal;
    private javax.swing.JLabel errorTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField nombreMedicamento;
    private javax.swing.JCheckBox sucursalPrincipal;
    private javax.swing.JCheckBox sucursalSecundaria;
    private javax.swing.JComboBox<String> tipoMedicamento;
    // End of variables declaration//GEN-END:variables
}
