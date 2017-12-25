/**
 * 
 */
package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
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
    private JTextField txtAniosExperiencia;
    
    /**
     * Campo de texto ruta de imagen.
     */
    private JTextField txtImagen;
    
    /**
     * Campo de texto Teléfono.
     */
    private JTextField txtTelefono;
    
    /**
     * Boton Examinar.
     */
    private JButton btnExaminar;
    
    /**
     * Boton Agregar hoja de vida.
     */
    private JButton btnAgregar;
    
    // -------------------------------------------------------------------------
    // Constructores
    // -------------------------------------------------------------------------
    
    /**
     * Construye el Panel Agregar Aspirante.
     */
    public PanelAgregarAspirante()
    {
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

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
}
