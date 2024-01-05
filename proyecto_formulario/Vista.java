/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto_formulario;

import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

/**
 *
 * @author Luis Miguel Mesa G.
 */
public class Vista extends javax.swing.JFrame {

    private ArrayList<Persona> Personas = new ArrayList<>();
    float contadorErrores = 0;
    int Contador_Extranjeria = 0;
    int ContadorPasaporte = 0;
    int Contador_Otros = 0;

    /**
     * Creates new form Vista
     */
    public Vista() {
        initComponents();
        setLocationRelativeTo(null);

        //PLACEHOLDERS
        Placeholder pNombre = new Placeholder("minimo dos digitos sin caracteres especiales", txt_nombre);
        Placeholder pApellido = new Placeholder("minimo dos digitos sin caracteres especiales", txt_Apellido);
        Placeholder pDocumento = new Placeholder("Ingrese su numero de documento", txt_Documento);
        Placeholder pTelefono = new Placeholder("Ingrese su numero de telefono", txt_Telefono);
        Placeholder pCorreo = new Placeholder("Ingrese un correo electrónico válido", txt_Correo);
        Placeholder pConfirmarCorreo = new Placeholder("Confirme su correo electrónico", txt_ConfirmarCorreo);
        Placeholder pContraseña = new Placeholder("Mayuscula, Minuscula, Caracter especial (8 digitos)", txt_Contraseña);
        Placeholder pConfirmarContraseña = new Placeholder("Confirme su contraseña", txt_ConfirmarContraseña);

        //QUITAR EL COPIAR Y PEGAR
        disableCopy(txt_Correo);
        disablePaste(txt_Correo);
        disableCopy(txt_ConfirmarCorreo);
        disablePaste(txt_ConfirmarCorreo);
        disableCopy(txt_Contraseña);
        disablePaste(txt_Contraseña);
        disableCopy(txt_ConfirmarContraseña);
        disablePaste(txt_ConfirmarContraseña);

    }

    //QUITAR EL COPIAR Y PEGAR
    private void disableCopy(JComponent component) {
        component.getInputMap().put(KeyStroke.getKeyStroke("control C"), "none");
    }

    private void disablePaste(JComponent component) {
        component.getInputMap().put(KeyStroke.getKeyStroke("control V"), "none");
    }

    //VALIDAR EXPRESIONES REGULARES
    public void Validaciones() {

        //Nombre
        String PatronNombre = "^[A-Za-zÁ-úüÜñÑ]{2,}( [A-Za-zÁ-úüÜñÑ]+)*$";
        if (txt_nombre.getText().isEmpty()) {
            lblNombre_vd.setText("*Campo Requerido*");
        } else if (!txt_nombre.getText().matches(PatronNombre)) {
            lblNombre_vd.setText("*Nombre Inválido*");

        } else {
            lblNombre_vd.setText("");

        }

        //Apellido
        String PatronApellido = "^[A-Za-zÁ-úüÜñÑ]{2,}( [A-Za-zÁ-úüÜñÑ]+)*$";
        if (txt_Apellido.getText().isEmpty()) {
            lblApellido_vd.setText("*Campo Requerido*");
        } else if (!txt_Apellido.getText().matches(PatronApellido)) {
            lblApellido_vd.setText("*Apellido Inválido*");
        } else {
            lblApellido_vd.setText("");
        }

        //Documento
        String PatronCedula = "^[0-9]{6,10}$";
        if (txt_Documento.getText().isEmpty()) {
            lblNumDoc_vd.setText("*Campo Requerido*");
        } else if (!txt_Documento.getText().matches(PatronCedula)) {
            lblNumDoc_vd.setText("*Documento Inválido*");
        } else {
            lblNumDoc_vd.setText("");
        }

        //Celular
        String PatronCelular = "^[0-9]{6,10}$";
        if (txt_Telefono.getText().isEmpty()) {
            lblCelular_vd.setText("*Campo Requerido*");
        } else if (!txt_Telefono.getText().matches(PatronCelular)) {
            lblCelular_vd.setText("*Télefono Inválido*");
        } else {
            lblCelular_vd.setText("");
        }

        //Correo
        String PatronCorreo = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        if (txt_Correo.getText().isEmpty()) {
            lblCorreo_vd.setText("*Campo Requerido*");
        } else if (!txt_Correo.getText().matches(PatronCorreo)) {
            lblCorreo_vd.setText("*Correo Inválido*");
        } else {
            lblCorreo_vd.setText("");
        }

        //Confirmar Correo
        if (txt_ConfirmarCorreo.getText().isEmpty()) {
            lblConfirmarCorreo.setText("*Campo Requerido*");
        } else if (!txt_ConfirmarCorreo.getText().equals(txt_Correo.getText())) {
            lblConfirmarCorreo.setText("*Correo no coincide*");
        } else {
            lblConfirmarCorreo.setText("");
        }

        //Contraseña
        String PatronContraseña = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+{}\\[\\]:;<>,.?~\\\\-]).{8,}$";
        if (txt_Contraseña.getText().isEmpty()) {
            lblContraseña_vd.setText("*Campo Requerido*");
        } else if (!txt_Contraseña.getText().matches(PatronContraseña)) {
            lblContraseña_vd.setText("*Contraseña Inválida*");
        } else {
            lblContraseña_vd.setText("");
        }

        //Confirmar Contraseña
        if (txt_ConfirmarContraseña.getText().isEmpty()) {
            lblConfirmarContraseña.setText("*Campo Requerido*");
        } else if (!txt_ConfirmarContraseña.getText().equals(txt_Contraseña.getText())) {
            lblConfirmarContraseña.setText("*Contraseña no coincide*");
        } else {
            lblConfirmarContraseña.setText("");
        }

        //boton
        if (txt_nombre.getText().isEmpty() || txt_Apellido.getText().isEmpty() || txt_Documento.getText().isEmpty()
                || txt_Telefono.getText().isEmpty() || txt_Correo.getText().isEmpty() || txt_ConfirmarCorreo.getText().isEmpty()
                || txt_Contraseña.getText().isEmpty() || txt_ConfirmarContraseña.getText().isEmpty() || lblNombre_vd.getText().equals("*Nombre Inválido*")
                || lblApellido_vd.getText().equals("*Apellido Inválido*") || lblNumDoc_vd.getText().equals("*Documento Inválido*")
                || lblCelular_vd.getText().equals("*Télefono Inválido*") || lblCorreo_vd.getText().equals("*Correo Inválido*")
                || lblContraseña_vd.getText().equals("*Contraseña Inválida*") || lblConfirmarCorreo.getText().equals("*Correo no coincide*")
                || lblConfirmarContraseña.getText().equals("*Contraseña no coincide*")) {
            BotonIngreso1.setEnabled(false);
        } else {
            BotonIngreso1.setEnabled(true);
        }

    }

    //LIMPIAR ESPACIOS PARA NUEVO INGRESO
    public void Limpiar() {
        txt_nombre.setText("");
        txt_Apellido.setText("");
        txt_Documento.setText("");
        txt_Telefono.setText("");
        txt_Correo.setText("");
        txt_Contraseña.setText("");
        txt_ConfirmarContraseña.setText("");
        txt_ConfirmarCorreo.setText("");
        EleccionNacionalidad.setSelectedItem(0);
        EleccionVivienda.setSelectedItem(0);
        ElecciónDocumento.setSelectedItem(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel_BackGround = new javax.swing.JPanel();
        fondoEdificios = new javax.swing.JLabel();
        Loguito = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        LabelNombre = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        LabelApellido = new javax.swing.JLabel();
        txt_Apellido = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        LabelDocumento = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        ElecciónDocumento = new javax.swing.JComboBox<>();
        LabelNumeroDoc = new javax.swing.JLabel();
        txt_Documento = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        LabelDireccion = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        EleccionVivienda = new javax.swing.JComboBox<>();
        LabelNumeroCel = new javax.swing.JLabel();
        txt_Telefono = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        LabelNacionalidad = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        EleccionNacionalidad = new javax.swing.JComboBox<>();
        LabelCorreo = new javax.swing.JLabel();
        txt_Correo = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        LabelContraseña = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        txt_Contraseña = new javax.swing.JPasswordField();
        jSeparator11 = new javax.swing.JSeparator();
        BotonNuevoIngreso = new javax.swing.JButton();
        lblContraseña_vd = new javax.swing.JLabel();
        lblNombre_vd = new javax.swing.JLabel();
        lblDocumento_vd = new javax.swing.JLabel();
        lblResidencia_vd = new javax.swing.JLabel();
        lblNacionalidad_vd = new javax.swing.JLabel();
        lblApellido_vd = new javax.swing.JLabel();
        lblNumDoc_vd = new javax.swing.JLabel();
        lblCelular_vd = new javax.swing.JLabel();
        lblCorreo_vd = new javax.swing.JLabel();
        LabelCorreo1 = new javax.swing.JLabel();
        txt_ConfirmarCorreo = new javax.swing.JTextField();
        jSeparator12 = new javax.swing.JSeparator();
        lblConfirmarCorreo = new javax.swing.JLabel();
        jSeparator13 = new javax.swing.JSeparator();
        LabelContraseña1 = new javax.swing.JLabel();
        txt_ConfirmarContraseña = new javax.swing.JPasswordField();
        lblConfirmarContraseña = new javax.swing.JLabel();
        BotonIngreso1 = new javax.swing.JButton();
        BotonMostrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Panel_BackGround.setBackground(new java.awt.Color(255, 255, 255));
        Panel_BackGround.setName(""); // NOI18N
        Panel_BackGround.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fondoEdificios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/city.png"))); // NOI18N
        Panel_BackGround.add(fondoEdificios, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 500));

        Loguito.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Loguito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/favicon.png"))); // NOI18N
        Panel_BackGround.add(Loguito, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 60, 70));

        jLabel3.setFont(new java.awt.Font("Roboto Medium", 3, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("REGISTRO DE USUARIO");
        Panel_BackGround.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 350, 50));

        LabelNombre.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        LabelNombre.setForeground(new java.awt.Color(0, 0, 0));
        LabelNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelNombre.setText("NOMBRE");
        Panel_BackGround.add(LabelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 90, -1));

        txt_nombre.setBackground(new java.awt.Color(255, 255, 255));
        txt_nombre.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        txt_nombre.setForeground(new java.awt.Color(0, 0, 0));
        txt_nombre.setBorder(null);
        txt_nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_nombreKeyReleased(evt);
            }
        });
        Panel_BackGround.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 250, -1));
        Panel_BackGround.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, -1, -1));
        Panel_BackGround.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 123, 260, 10));

        LabelApellido.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        LabelApellido.setForeground(new java.awt.Color(0, 0, 0));
        LabelApellido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelApellido.setText("APELLIDO");
        Panel_BackGround.add(LabelApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, 90, -1));

        txt_Apellido.setBackground(new java.awt.Color(255, 255, 255));
        txt_Apellido.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        txt_Apellido.setForeground(new java.awt.Color(0, 0, 0));
        txt_Apellido.setBorder(null);
        txt_Apellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_ApellidoKeyReleased(evt);
            }
        });
        Panel_BackGround.add(txt_Apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 100, 250, -1));
        Panel_BackGround.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 120, 310, 10));

        LabelDocumento.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        LabelDocumento.setForeground(new java.awt.Color(0, 0, 0));
        LabelDocumento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelDocumento.setText("TIPO DE DOCUMENTO");
        Panel_BackGround.add(LabelDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 150, -1));
        Panel_BackGround.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, 260, 10));

        ElecciónDocumento.setBackground(new java.awt.Color(255, 255, 255));
        ElecciónDocumento.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        ElecciónDocumento.setForeground(new java.awt.Color(0, 0, 0));
        ElecciónDocumento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cedula De Ciudadanía", "Cedula De Extranjería", "Pasaporte" }));
        ElecciónDocumento.setBorder(null);
        ElecciónDocumento.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ElecciónDocumentoItemStateChanged(evt);
            }
        });
        ElecciónDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ElecciónDocumentoActionPerformed(evt);
            }
        });
        Panel_BackGround.add(ElecciónDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, 160, -1));

        LabelNumeroDoc.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        LabelNumeroDoc.setForeground(new java.awt.Color(0, 0, 0));
        LabelNumeroDoc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelNumeroDoc.setText("NUMERO DE DOCUMENTO");
        Panel_BackGround.add(LabelNumeroDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 160, 180, -1));

        txt_Documento.setBackground(new java.awt.Color(255, 255, 255));
        txt_Documento.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        txt_Documento.setForeground(new java.awt.Color(0, 0, 0));
        txt_Documento.setBorder(null);
        txt_Documento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_DocumentoKeyReleased(evt);
            }
        });
        Panel_BackGround.add(txt_Documento, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 180, 250, -1));
        Panel_BackGround.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 200, 310, 10));

        LabelDireccion.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        LabelDireccion.setForeground(new java.awt.Color(0, 0, 0));
        LabelDireccion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelDireccion.setText("LUGAR DE RESIDENCIA");
        Panel_BackGround.add(LabelDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, 150, -1));
        Panel_BackGround.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 280, 260, 10));

        EleccionVivienda.setBackground(new java.awt.Color(255, 255, 255));
        EleccionVivienda.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        EleccionVivienda.setForeground(new java.awt.Color(0, 0, 0));
        EleccionVivienda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Antioquia", "Cundinamarca", "Risaralda", "Caldas", "Quíndio", "Bolivar", "Atlántico", "Caquetá", "Putumayo", "Nariño", "Meta", "Villavicencio " }));
        EleccionVivienda.setBorder(null);
        EleccionVivienda.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        EleccionVivienda.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                EleccionViviendaItemStateChanged(evt);
            }
        });
        EleccionVivienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EleccionViviendaActionPerformed(evt);
            }
        });
        Panel_BackGround.add(EleccionVivienda, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, 160, -1));

        LabelNumeroCel.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        LabelNumeroCel.setForeground(new java.awt.Color(0, 0, 0));
        LabelNumeroCel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelNumeroCel.setText("NUMERO DE CELULAR");
        Panel_BackGround.add(LabelNumeroCel, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 240, 180, -1));

        txt_Telefono.setBackground(new java.awt.Color(255, 255, 255));
        txt_Telefono.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        txt_Telefono.setForeground(new java.awt.Color(0, 0, 0));
        txt_Telefono.setBorder(null);
        txt_Telefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_TelefonoKeyReleased(evt);
            }
        });
        Panel_BackGround.add(txt_Telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 260, 250, -1));
        Panel_BackGround.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 280, 310, 10));

        LabelNacionalidad.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        LabelNacionalidad.setForeground(new java.awt.Color(0, 0, 0));
        LabelNacionalidad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelNacionalidad.setText("NACIONALIDAD");
        Panel_BackGround.add(LabelNacionalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 300, 150, -1));
        Panel_BackGround.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 350, 260, 10));

        EleccionNacionalidad.setBackground(new java.awt.Color(255, 255, 255));
        EleccionNacionalidad.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        EleccionNacionalidad.setForeground(new java.awt.Color(0, 0, 0));
        EleccionNacionalidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Colombiano(a)", "Otro(a)" }));
        EleccionNacionalidad.setBorder(null);
        EleccionNacionalidad.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        EleccionNacionalidad.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                EleccionNacionalidadItemStateChanged(evt);
            }
        });
        EleccionNacionalidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EleccionNacionalidadActionPerformed(evt);
            }
        });
        Panel_BackGround.add(EleccionNacionalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 320, 160, -1));

        LabelCorreo.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        LabelCorreo.setForeground(new java.awt.Color(0, 0, 0));
        LabelCorreo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelCorreo.setText("CORREO ELECTRÓNICO");
        Panel_BackGround.add(LabelCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 310, 180, -1));

        txt_Correo.setBackground(new java.awt.Color(255, 255, 255));
        txt_Correo.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        txt_Correo.setForeground(new java.awt.Color(0, 0, 0));
        txt_Correo.setBorder(null);
        txt_Correo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_CorreoKeyReleased(evt);
            }
        });
        Panel_BackGround.add(txt_Correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 330, 250, -1));
        Panel_BackGround.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 420, 310, 10));

        LabelContraseña.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        LabelContraseña.setForeground(new java.awt.Color(0, 0, 0));
        LabelContraseña.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelContraseña.setText("CONTRASEÑA");
        LabelContraseña.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Panel_BackGround.add(LabelContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 380, 180, -1));
        Panel_BackGround.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 430, 260, 0));

        txt_Contraseña.setBackground(new java.awt.Color(255, 255, 255));
        txt_Contraseña.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        txt_Contraseña.setForeground(new java.awt.Color(0, 0, 0));
        txt_Contraseña.setBorder(null);
        txt_Contraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_ContraseñaKeyReleased(evt);
            }
        });
        Panel_BackGround.add(txt_Contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 400, 240, -1));
        Panel_BackGround.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 357, 310, 10));

        BotonNuevoIngreso.setBackground(new java.awt.Color(51, 102, 255));
        BotonNuevoIngreso.setFont(new java.awt.Font("Roboto Thin", 3, 12)); // NOI18N
        BotonNuevoIngreso.setForeground(new java.awt.Color(0, 0, 0));
        BotonNuevoIngreso.setText("NUEVO INGRESO");
        BotonNuevoIngreso.setBorder(null);
        BotonNuevoIngreso.setEnabled(false);
        BotonNuevoIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonNuevoIngresoActionPerformed(evt);
            }
        });
        Panel_BackGround.add(BotonNuevoIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 450, 110, 40));

        lblContraseña_vd.setForeground(new java.awt.Color(255, 0, 0));
        lblContraseña_vd.setName(""); // NOI18N
        Panel_BackGround.add(lblContraseña_vd, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 380, 140, -1));

        lblNombre_vd.setForeground(new java.awt.Color(255, 0, 0));
        lblNombre_vd.setName(""); // NOI18N
        Panel_BackGround.add(lblNombre_vd, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, 110, -1));

        lblDocumento_vd.setForeground(new java.awt.Color(255, 0, 0));
        lblDocumento_vd.setName(""); // NOI18N
        Panel_BackGround.add(lblDocumento_vd, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, 110, -1));

        lblResidencia_vd.setForeground(new java.awt.Color(255, 0, 0));
        lblResidencia_vd.setName(""); // NOI18N
        Panel_BackGround.add(lblResidencia_vd, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 230, 100, -1));

        lblNacionalidad_vd.setForeground(new java.awt.Color(255, 0, 0));
        lblNacionalidad_vd.setName(""); // NOI18N
        Panel_BackGround.add(lblNacionalidad_vd, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 300, 130, -1));

        lblApellido_vd.setForeground(new java.awt.Color(255, 0, 0));
        lblApellido_vd.setName(""); // NOI18N
        Panel_BackGround.add(lblApellido_vd, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 80, 130, -1));

        lblNumDoc_vd.setForeground(new java.awt.Color(255, 0, 0));
        lblNumDoc_vd.setName(""); // NOI18N
        Panel_BackGround.add(lblNumDoc_vd, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 160, 110, -1));

        lblCelular_vd.setForeground(new java.awt.Color(255, 0, 0));
        lblCelular_vd.setName(""); // NOI18N
        Panel_BackGround.add(lblCelular_vd, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 240, 110, -1));

        lblCorreo_vd.setForeground(new java.awt.Color(255, 0, 0));
        lblCorreo_vd.setName(""); // NOI18N
        Panel_BackGround.add(lblCorreo_vd, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 310, 110, -1));

        LabelCorreo1.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        LabelCorreo1.setForeground(new java.awt.Color(0, 0, 0));
        LabelCorreo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelCorreo1.setText("CONFIRMAR CORREO ");
        Panel_BackGround.add(LabelCorreo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 370, 160, -1));

        txt_ConfirmarCorreo.setBackground(new java.awt.Color(255, 255, 255));
        txt_ConfirmarCorreo.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        txt_ConfirmarCorreo.setForeground(new java.awt.Color(0, 0, 0));
        txt_ConfirmarCorreo.setBorder(null);
        txt_ConfirmarCorreo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_ConfirmarCorreoFocusLost(evt);
            }
        });
        txt_ConfirmarCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_ConfirmarCorreoKeyReleased(evt);
            }
        });
        Panel_BackGround.add(txt_ConfirmarCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 390, 270, -1));
        Panel_BackGround.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 420, 260, -1));

        lblConfirmarCorreo.setForeground(new java.awt.Color(255, 0, 0));
        Panel_BackGround.add(lblConfirmarCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 370, 120, -1));
        Panel_BackGround.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 480, 260, 10));

        LabelContraseña1.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        LabelContraseña1.setForeground(new java.awt.Color(0, 0, 0));
        LabelContraseña1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelContraseña1.setText("CONFIRMAR CONTRASEÑA");
        LabelContraseña1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Panel_BackGround.add(LabelContraseña1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 440, 180, -1));

        txt_ConfirmarContraseña.setBackground(new java.awt.Color(255, 255, 255));
        txt_ConfirmarContraseña.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        txt_ConfirmarContraseña.setForeground(new java.awt.Color(0, 0, 0));
        txt_ConfirmarContraseña.setBorder(null);
        txt_ConfirmarContraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_ConfirmarContraseñaKeyReleased(evt);
            }
        });
        Panel_BackGround.add(txt_ConfirmarContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 460, 190, -1));

        lblConfirmarContraseña.setForeground(new java.awt.Color(255, 0, 0));
        Panel_BackGround.add(lblConfirmarContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 440, 170, -1));

        BotonIngreso1.setBackground(new java.awt.Color(51, 102, 255));
        BotonIngreso1.setFont(new java.awt.Font("Roboto Thin", 3, 12)); // NOI18N
        BotonIngreso1.setForeground(new java.awt.Color(0, 0, 0));
        BotonIngreso1.setText("INGRESAR USUARIO");
        BotonIngreso1.setBorder(null);
        BotonIngreso1.setEnabled(false);
        BotonIngreso1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonIngreso1ActionPerformed(evt);
            }
        });
        Panel_BackGround.add(BotonIngreso1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 450, 120, 40));

        BotonMostrar.setBackground(new java.awt.Color(51, 102, 255));
        BotonMostrar.setFont(new java.awt.Font("Roboto Thin", 3, 12)); // NOI18N
        BotonMostrar.setForeground(new java.awt.Color(0, 0, 0));
        BotonMostrar.setText("OTROS...");
        BotonMostrar.setBorder(null);
        BotonMostrar.setEnabled(false);
        BotonMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonMostrarActionPerformed(evt);
            }
        });
        Panel_BackGround.add(BotonMostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 450, 60, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_BackGround, javax.swing.GroupLayout.DEFAULT_SIZE, 878, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_BackGround, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ElecciónDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ElecciónDocumentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ElecciónDocumentoActionPerformed

    private void EleccionViviendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EleccionViviendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EleccionViviendaActionPerformed

    private void EleccionNacionalidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EleccionNacionalidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EleccionNacionalidadActionPerformed

    private void txt_nombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombreKeyReleased
        // TODO add your handling code here:
        Validaciones();
    }//GEN-LAST:event_txt_nombreKeyReleased

    private void txt_ApellidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ApellidoKeyReleased
        // TODO add your handling code here:
        Validaciones();
    }//GEN-LAST:event_txt_ApellidoKeyReleased

    private void txt_DocumentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_DocumentoKeyReleased
        // TODO add your handling code here:
        Validaciones();
    }//GEN-LAST:event_txt_DocumentoKeyReleased

    private void txt_TelefonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_TelefonoKeyReleased
        // TODO add your handling code here:
        Validaciones();
    }//GEN-LAST:event_txt_TelefonoKeyReleased

    private void txt_CorreoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_CorreoKeyReleased
        // TODO add your handling code here:
        Validaciones();
    }//GEN-LAST:event_txt_CorreoKeyReleased

    private void txt_ConfirmarCorreoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ConfirmarCorreoKeyReleased
        // TODO add your handling code here:
        Validaciones();
    }//GEN-LAST:event_txt_ConfirmarCorreoKeyReleased

    private void txt_ContraseñaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ContraseñaKeyReleased
        // TODO add your handling code here:
        Validaciones();
    }//GEN-LAST:event_txt_ContraseñaKeyReleased

    private void txt_ConfirmarContraseñaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ConfirmarContraseñaKeyReleased
        // TODO add your handling code here:
        Validaciones();
    }//GEN-LAST:event_txt_ConfirmarContraseñaKeyReleased

    private void ElecciónDocumentoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ElecciónDocumentoItemStateChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_ElecciónDocumentoItemStateChanged

    private void BotonNuevoIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonNuevoIngresoActionPerformed
        // TODO add your handling code here:
        Limpiar();

    }//GEN-LAST:event_BotonNuevoIngresoActionPerformed

    private void EleccionViviendaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_EleccionViviendaItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_EleccionViviendaItemStateChanged

    private void EleccionNacionalidadItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_EleccionNacionalidadItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_EleccionNacionalidadItemStateChanged

    //CREA EL OBJETO, GUARDA LOS ATRIBUTOS Y AÑADE AL ARRAY. TAMBIÉN AUMENTA LOS CONTADORES.
    private void BotonIngreso1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonIngreso1ActionPerformed
        // TODO add your handling code here:
        Persona p1 = new Persona(txt_nombre.getText(), txt_Apellido.getText(), txt_Documento.getText(), txt_Telefono.getText(), (String) ElecciónDocumento.getSelectedItem(), (String) EleccionVivienda.getSelectedItem(), (String) EleccionNacionalidad.getSelectedItem(), txt_ConfirmarCorreo.getText());
        if (ElecciónDocumento.getSelectedItem().equals("Cedula De Extranjería")) {
            Contador_Extranjeria++;
        }
        if (ElecciónDocumento.getSelectedItem().equals("Pasaporte")) {
            ContadorPasaporte++;
        }
        if (EleccionNacionalidad.getSelectedItem().equals("Otro(a)")) {
            Contador_Otros++;
        }
        Personas.add(p1);

        BotonNuevoIngreso.setEnabled(true);
        BotonMostrar.setEnabled(true);
        JOptionPane.showMessageDialog(null, "Se ha ingresado correctamente la información!");
    }//GEN-LAST:event_BotonIngreso1ActionPerformed

    //BOTON OTROS..
    private void BotonMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonMostrarActionPerformed
        int opt;

        do {
            opt = Integer.parseInt(JOptionPane.showInputDialog("1. Mostrar Personas Ingresadas\n"
                    + "2. Porcentaje de Correos que no coinciden.\n"
                    + "3. Cantidad de Personas con 'Cédula de Extranjería.'\n"
                    + "4. Cantidad de Personas con 'Pasaporte.'\n"
                    + "5. Cantidad de Personas con Nacionalidad 'Otro'.\n"
                    + "0. Salir"));

            switch (opt) {
                case 1:
                    StringBuilder mensaje = new StringBuilder();
                    for (Persona Persona1 : Personas) {
                        mensaje.append("Nombre: ").append(Persona1.getNombre()).append("\n");
                        mensaje.append("Apellido: ").append(Persona1.getApellido()).append("\n");
                        mensaje.append("Numero de Documento: ").append(Persona1.getNumero_Documento()).append("\n");
                        mensaje.append("Tipo de Documento: ").append(Persona1.getTipo_Documento()).append("\n");
                        mensaje.append("Lugar de Residencia: ").append(Persona1.getLugar_Residencia()).append("\n");
                        mensaje.append("Numero de Celular ").append(Persona1.getTelefono()).append("\n");
                        mensaje.append("Nacionalidad: ").append(Persona1.getNacionalidad()).append("\n");
                        mensaje.append("Correo: ").append(Persona1.getCorreo()).append("\n");
                        mensaje.append("\n");
                    }

                    JOptionPane.showMessageDialog(this, mensaje.toString(), "Lista de Personas.", JOptionPane.INFORMATION_MESSAGE);

                    break;
                case 2:
                    float porcentaje = contadorErrores / (contadorErrores + 1) * 100;
                    JOptionPane.showMessageDialog(null, "El Porcentaje de correos que no coinciden es: " + porcentaje + "%");
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "La cantidad de Personas con Cédula de Extranjería es: " + Contador_Extranjeria);

                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "La cantidad de Personas con Pasaporte es: " + ContadorPasaporte);

                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "La cantida de Personas con Nacionalidad 'Otros' es: " + Contador_Otros);
                    break;

                default:
            }
        } while (opt != 0);


    }//GEN-LAST:event_BotonMostrarActionPerformed

    //EVENTO PARA CONTADOR DE CORREO NO COINCIDE
    private void txt_ConfirmarCorreoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_ConfirmarCorreoFocusLost
        // TODO add your handling code here:

        if (lblConfirmarCorreo.getText().equals("*Correo no coincide*")) {
            contadorErrores++;
        }
    }//GEN-LAST:event_txt_ConfirmarCorreoFocusLost

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
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonIngreso1;
    private javax.swing.JButton BotonMostrar;
    private javax.swing.JButton BotonNuevoIngreso;
    private javax.swing.JComboBox<String> EleccionNacionalidad;
    private javax.swing.JComboBox<String> EleccionVivienda;
    private javax.swing.JComboBox<String> ElecciónDocumento;
    private javax.swing.JLabel LabelApellido;
    private javax.swing.JLabel LabelContraseña;
    private javax.swing.JLabel LabelContraseña1;
    private javax.swing.JLabel LabelCorreo;
    private javax.swing.JLabel LabelCorreo1;
    private javax.swing.JLabel LabelDireccion;
    private javax.swing.JLabel LabelDocumento;
    private javax.swing.JLabel LabelNacionalidad;
    private javax.swing.JLabel LabelNombre;
    private javax.swing.JLabel LabelNumeroCel;
    private javax.swing.JLabel LabelNumeroDoc;
    private javax.swing.JLabel Loguito;
    private javax.swing.JPanel Panel_BackGround;
    private javax.swing.JLabel fondoEdificios;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel lblApellido_vd;
    private javax.swing.JLabel lblCelular_vd;
    private javax.swing.JLabel lblConfirmarContraseña;
    private javax.swing.JLabel lblConfirmarCorreo;
    private javax.swing.JLabel lblContraseña_vd;
    private javax.swing.JLabel lblCorreo_vd;
    private javax.swing.JLabel lblDocumento_vd;
    private javax.swing.JLabel lblNacionalidad_vd;
    private javax.swing.JLabel lblNombre_vd;
    private javax.swing.JLabel lblNumDoc_vd;
    private javax.swing.JLabel lblResidencia_vd;
    private javax.swing.JTextField txt_Apellido;
    private javax.swing.JPasswordField txt_ConfirmarContraseña;
    private javax.swing.JTextField txt_ConfirmarCorreo;
    private javax.swing.JPasswordField txt_Contraseña;
    private javax.swing.JTextField txt_Correo;
    private javax.swing.JTextField txt_Documento;
    private javax.swing.JTextField txt_Telefono;
    private javax.swing.JTextField txt_nombre;
    // End of variables declaration//GEN-END:variables
}
