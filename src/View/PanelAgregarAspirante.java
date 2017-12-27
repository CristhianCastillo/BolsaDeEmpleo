/**
 * 
 */
package View;

import Controller.Controlador;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 * Clase que representa el Panel Agregar Aspirante.
 * @author Cristhian Eduardo Castillo Erazo.
 */
public class PanelAgregarAspirante extends JPanel implements ActionListener
{
    // -------------------------------------------------------------------------
    // Constantes
    // -------------------------------------------------------------------------
    
    /**
     * Constante asociada al boton Examinar.
     */
    public static final String EXAMINAR = "ExaminarFoto";
    
    /**
     * Constante asociada al boton Agregar hoja de vida.
     */
    public static final String AGREGAR_HOJA = "AgregarHojaDeVida";
    
    /**
     * Profesiones de la bolsa de empleo.
     */
    public static final String [] PROFESIONES = {"Administrador", "Ingeniero Industrial", "Contador", "Economista"};
    
    // -------------------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------------------
    
    /**
     * Etiqueta Nombre.
     */
    private final JLabel lblNombre;
    
    /**
     * Etiqueta Edad.
     */
    private final JLabel lblEdad;
    
    /**
     * Etiqueta Profesión.
     */
    private final JLabel lblProfesion;
    
    /**
     * Etiqueta Años de Experiencia.
     */
    private final JLabel lblAniosExperiencia;
    
    /**
     * Etiqueta Imagen.
     */
    private final JLabel lblImagen;
    
    /**
     * Etiqueta Teléfono.
     */
    private final JLabel lblTelefono;
    
    /**
     * Campo de texto Nombre.
     */
    private final JTextField txtNombre;
    
    /**
     * Campo de texto Edad.
     */
    private final JTextField txtEdad;
    
    /**
     * ComboBox Profesión.
     */
    private final JComboBox cbmProfesion;
    
    /**
     * Campo de texto Años de experiencia.
     */
    private final JTextField txtAniosExperiencia;
    
    /**
     * Campo de texto ruta de imagen.
     */
    private final JTextField txtImagen;
    
    /**
     * Campo de texto Teléfono.
     */
    private final JTextField txtTelefono;
    
    /**
     * Boton Examinar.
     */
    private final JButton btnExaminar;
    
    /**
     * Boton Agregar hoja de vida.
     */
    private final JButton btnAgregar;
    
    /**
     * Controlador principal de la aplicación.
     */
    private final Controlador ctrl;
    
    // -------------------------------------------------------------------------
    // Constructores
    // -------------------------------------------------------------------------
    
    /**
     * Construye el Panel Agregar Aspirante.
     * @param ctrl Controlador principal de la aplicación.
     */
    public PanelAgregarAspirante(Controlador ctrl)
    {
        this.ctrl = ctrl;
        this.setBorder(new TitledBorder("Agregar Aspirante"));
        this.setLayout(new BorderLayout());
        
        JPanel pnlNorte = new JPanel();
        pnlNorte.setBorder(new EmptyBorder(10,0,0,0));
        GroupLayout grupo = new GroupLayout(pnlNorte);
        pnlNorte.setLayout(grupo);
        
        lblNombre = new JLabel("Nombre:");
        lblEdad = new JLabel("Edad:");
        lblProfesion = new JLabel("Profesión:");
        lblAniosExperiencia = new JLabel("Años experiencia:");
        lblImagen = new JLabel("Imagen:");
        lblTelefono = new JLabel("Teléfono:");
        
        txtNombre = new JTextField();
        txtEdad = new JTextField();
        
        DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>(PROFESIONES);
        cbmProfesion = new JComboBox(modelo);
        lblProfesion.setLabelFor(cbmProfesion);
        
        txtAniosExperiencia = new JTextField();
        
        JPanel pnlImagen = new JPanel();
        pnlImagen.setLayout(new GridLayout(1,2));
        
        txtImagen = new JTextField();
        txtImagen.setEditable(false);
        
        btnExaminar = new JButton("Examinar");
        btnExaminar.setActionCommand(EXAMINAR);
        btnExaminar.addActionListener((ActionListener)this);
        
        pnlImagen.add(txtImagen);
        pnlImagen.add(btnExaminar);
        
        txtTelefono = new JTextField();
        
        //Set Horizontal
        grupo.setHorizontalGroup(
                grupo.createSequentialGroup()
                    .addGroup(grupo.createParallelGroup()
                            .addComponent(lblNombre)
                            .addComponent(lblEdad)
                            .addComponent(lblProfesion)
                            .addComponent(lblAniosExperiencia)
                            .addComponent(lblImagen)
                            .addComponent(lblTelefono)
                    )
                
                    .addGroup(grupo.createParallelGroup()
                            .addComponent(txtNombre)
                            .addComponent(txtEdad)
                            .addComponent(cbmProfesion)
                            .addComponent(txtAniosExperiencia)
                            .addComponent(pnlImagen)
                            .addComponent(txtTelefono)
                    )
        );
        
        //Set Vertical
        grupo.setVerticalGroup(
                grupo.createSequentialGroup()
                    .addGroup(grupo.createParallelGroup()
                            .addComponent(lblNombre)
                            .addComponent(txtNombre)
                    )
                
                    .addGroup(grupo.createParallelGroup()
                                .addComponent(lblEdad)
                                .addComponent(txtEdad)
                    )
                
                .addGroup(grupo.createParallelGroup()
                                .addComponent(lblProfesion)
                                .addComponent(cbmProfesion)
                    )
                
                .addGroup(grupo.createParallelGroup()
                                .addComponent(lblAniosExperiencia)
                                .addComponent(txtAniosExperiencia)
                    )
                
                .addGroup(grupo.createParallelGroup()
                                .addComponent(lblImagen)
                                .addComponent(pnlImagen)
                    )
                
                .addGroup(grupo.createParallelGroup()
                                .addComponent(lblTelefono)
                                .addComponent(txtTelefono)
                    )
        );
        
        btnAgregar = new JButton("Agregar hoja de vida");
        btnAgregar.setActionCommand(AGREGAR_HOJA);
        btnAgregar.addActionListener((ActionListener)this);
        
        JPanel pnlSur = new JPanel();
        pnlSur.add(btnAgregar);
        
        this.add(pnlNorte, BorderLayout.NORTH);
        this.add(pnlSur, BorderLayout.CENTER);
        
        
    }
    // -------------------------------------------------------------------------
    // Metodos
    // -------------------------------------------------------------------------

    /**
     * Escucha los eventos generados por los botones.
     * @param e Acción que genero el evento. e != null.
     */
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        String comando = e.getActionCommand();
        
        if(comando.equalsIgnoreCase(EXAMINAR))
        {
            JFileChooser fc = new JFileChooser("./data");
            fc.setDialogTitle("Buscar imagen de aspirante");
            fc.setMultiSelectionEnabled(false);
            
            int resultado = fc.showOpenDialog(this);
            if(resultado == JFileChooser.APPROVE_OPTION)
            {
                String imagen = fc.getSelectedFile().getAbsolutePath();
                txtImagen.setText(imagen);
            }
        }
        else
        {
            if(comando.equalsIgnoreCase(AGREGAR_HOJA))
            {
                try
                {
                    String nombre = txtNombre.getText();
                    String edadStr = txtEdad.getText();
                    String profesion = cbmProfesion.getSelectedItem().toString();
                    String aniosExperienciaStr = txtAniosExperiencia.getText();
                    String imagen = txtImagen.getText();
                    String telefonoStr = txtTelefono.getText();
                    
                    if(nombre.trim().equals("") || edadStr.trim().equals("") || profesion.trim().equals("") || profesion.trim().equals("")
                           || aniosExperienciaStr.trim().equals("") || imagen.trim().equals("") || telefonoStr.trim().equals(""))
                        
                    {
                        JOptionPane.showMessageDialog(this, "Existen campos vacios.", "Agregar hoja de vida", JOptionPane.ERROR_MESSAGE);
                        txtNombre.requestFocus();
                    }
                    else
                    {
                        int edad = Integer.parseInt(edadStr);
                        if(edad <= 0)
                            throw new Exception("La edad no puede ser menor o igual a cero.");
                        int aniosExperiencia = Integer.parseInt(aniosExperienciaStr);
                        if(aniosExperiencia < 0)
                            throw new Exception("Los años de experiencia no pueden ser negativos.");
                        int telefono = Integer.parseInt(telefonoStr);
                        if(telefono <=0)
                            throw new Exception("El telefono debe ser un numero más grande.");
                        
                       ctrl.agregarAspirante(nombre, edad, profesion, aniosExperiencia, imagen, telefono);
                       limpiarCampos();
                    }
                    
                }
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Agregar Aspirante", JOptionPane.ERROR_MESSAGE);
                }
                
                
            }
        }
        
    }
    
    /**
     * Limpia los campos para el registro de un nuevo aspirante.
     */
    public void limpiarCampos()
    {
        this.txtNombre.setText("");
        this.txtEdad.setText("");
        this.cbmProfesion.setSelectedIndex(0);
        this.txtAniosExperiencia.setText("");
        this.txtImagen.setText("");
        this.txtTelefono.setText("");
    }
    
}
