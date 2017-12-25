/**
 * 
 */
package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 * Clase que representa el panel Datos del Aspirante.
 * @author Cristhian Eduardo Castillo Erazo.
 */
public class PanelDatosAspirante extends JPanel
{
    // -------------------------------------------------------------------------
    // Constantes
    // -------------------------------------------------------------------------
    
    // -------------------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------------------
    
    /**
     * Etiqueta Imagen del aspirante.
     */
    private JLabel lblImagen;
    
    /**
     * Etiquta nombre.
     */
    private JLabel lblNombre;
    
    /**
     * Etiqueta edad.
     */
    private JLabel lblEdad;
    
    /**
     * Etiqueta profesión.
     */
    private JLabel lblProfesion;
    
    /**
     * Etiqueta Experiencia.
     */
    private JLabel lblExperiencia;
    
    /**
     * Etiqueta Teléfono.
     */
    private JLabel lblTelefono;
    
    /**
     * Campo de texto nombre.
     */
    private JTextField txtNombre;
    
    /**
     * Campo de texto edad.
     */
    private JTextField txtEdad;
    
    /**
     * Campo de texto profesión.
     */
    private JTextField txtProfesion;
    
    /**
     * Campo de texto experiencia.
     */
    private JTextField txtExperiencia;
    
    /**
     * Campo de texto teléfono.
     */
    private JTextField txtTelefono;
    
    // -------------------------------------------------------------------------
    // Constructores
    // -------------------------------------------------------------------------
    
    /**
     * Constuye el panel Datos del Aspirante
     */
    public PanelDatosAspirante()
    {
        this.setBorder(new TitledBorder("Datos del aspirante"));
        this.setLayout(new BorderLayout());
        
        JPanel pnlIzquierda = new JPanel();
        pnlIzquierda.setBorder(new EmptyBorder(10,10,10,5));
        pnlIzquierda.setLayout(new BorderLayout());
        
        ImageIcon icono = new ImageIcon ("data/pilar.jpg");
        lblImagen = new JLabel(icono);
        lblImagen.setBorder(new LineBorder(Color.BLACK, 1));
        lblImagen.setMinimumSize(new Dimension(250, 80));
        lblImagen.setMaximumSize(new Dimension(250, 80));
        
        pnlIzquierda.add(lblImagen, BorderLayout.CENTER);
        
        JPanel pnlDerecha = new JPanel();
        GroupLayout grupo = new GroupLayout(pnlDerecha);
        pnlDerecha.setLayout(grupo);
        
        lblNombre = new JLabel("Nombre:");
        lblEdad = new JLabel("Edad:");
        lblProfesion = new JLabel("Profesión:");
        lblExperiencia = new JLabel("Experiencia:");
        lblTelefono = new JLabel("Teléfono:");
        
        txtNombre = new JTextField();
        txtNombre.setEditable(false);
        
        txtEdad = new JTextField();
        txtEdad.setEditable(false);
        
        txtProfesion = new JTextField();
        txtProfesion.setEditable(false);
        
        txtExperiencia = new JTextField();
        txtExperiencia.setEditable(false);
        
        txtTelefono = new JTextField();
        txtTelefono.setEditable(false);
        
        grupo.setAutoCreateContainerGaps(true);
        grupo.setAutoCreateGaps(true);
        
        //Set Horizontal
        grupo.setHorizontalGroup(grupo.createSequentialGroup()
                .addGroup(grupo.createParallelGroup()
                        .addComponent(lblNombre)
                        .addComponent(lblEdad)
                        .addComponent(lblProfesion)
                        .addComponent(lblExperiencia)
                        .addComponent(lblTelefono)
                )
                
                .addGroup(grupo.createParallelGroup()
                        .addComponent(txtNombre)
                        .addComponent(txtEdad)
                        .addComponent(txtProfesion)
                        .addComponent(txtExperiencia)
                        .addComponent(txtTelefono)
                )
        );
        
        //Set Vertical
        grupo.setVerticalGroup(grupo.createSequentialGroup()
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
                        .addComponent(txtProfesion)
                )
                
                .addGroup(grupo.createParallelGroup()
                        .addComponent(lblExperiencia)
                        .addComponent(txtExperiencia)
                )
                
                .addGroup(grupo.createParallelGroup()
                        .addComponent(lblTelefono)
                        .addComponent(txtTelefono)
                )
        );
        
        this.add(pnlIzquierda, BorderLayout.WEST);
        this.add(pnlDerecha, BorderLayout.CENTER);
    }
    // -------------------------------------------------------------------------
    // Metodos
    // -------------------------------------------------------------------------
}
