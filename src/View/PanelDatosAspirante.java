/**
 * 
 */
package View;

import Model.Aspirante;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.Icon;
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
    
    /**
     * Esta constante indica la altura que debe tener la imagen de un individuo
     */
    private static final int ALTURA = 153;

    /**
     * Esta constante indica el ancho que debe tener la imagen de un individuo
     */
    private static final int ANCHO = 200;
    
    // -------------------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------------------
    
    /**
     * Etiqueta Imagen del aspirante.
     */
    private final JLabel lblImagen;
    
    /**
     * Etiquta nombre.
     */
    private final JLabel lblNombre;
    
    /**
     * Etiqueta edad.
     */
    private final JLabel lblEdad;
    
    /**
     * Etiqueta profesión.
     */
    private final JLabel lblProfesion;
    
    /**
     * Etiqueta Experiencia.
     */
    private final JLabel lblExperiencia;
    
    /**
     * Etiqueta Teléfono.
     */
    private final JLabel lblTelefono;
    
    /**
     * Campo de texto nombre.
     */
    private final JTextField txtNombre;
    
    /**
     * Campo de texto edad.
     */
    private final JTextField txtEdad;
    
    /**
     * Campo de texto profesión.
     */
    private final JTextField txtProfesion;
    
    /**
     * Campo de texto experiencia.
     */
    private final JTextField txtExperiencia;
    
    /**
     * Campo de texto teléfono.
     */
    private final JTextField txtTelefono;
    
    /**
     * Imagen del aspirante.
     */
    private Icon icono;
    
    // -------------------------------------------------------------------------
    // Constructores
    // -------------------------------------------------------------------------
    
    /**
     * Constuye el panel Datos del Aspirante.
     */
    public PanelDatosAspirante()
    {
        this.setBorder(new TitledBorder("Datos del aspirante"));
        this.setLayout(new BorderLayout());
        
        JPanel pnlIzquierda = new JPanel();
        pnlIzquierda.setBorder(new EmptyBorder(10,10,10,5));
        pnlIzquierda.setLayout(new BorderLayout());
        
        ImageIcon iconoInicial = new ImageIcon ("data/vacia.jpg");
        lblImagen = new JLabel(iconoInicial);
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
        txtTelefono.setToolTipText("Teléfono aspirante");
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
    
    /**
     * Actualiza el panel Datos del Aspirante, con la información del aspirante
     * seleccionado.
     * @param aspirante Aspirante seleccionado.
     * @throws IOException 
     */
    public void actualizarAspirante(Aspirante aspirante) throws IOException
    {
        txtNombre.setText(aspirante.getNombre());
        txtEdad.setText(aspirante.getEdad() + " años");
        txtProfesion.setText(aspirante.getProfesion());
        txtExperiencia.setText(aspirante.getAniosExperiencia() + " año(s)");
        txtTelefono.setText(aspirante.getTelefono() +"");
        
        String imagen = aspirante.getImagen();
        BufferedImage bImagen = ImageIO.read( new File( imagen ) );
        Image laImagen = bImagen.getScaledInstance( ( int ) ( ANCHO * 0.85 ), ( int ) ( ALTURA * 0.85 ), Image.SCALE_AREA_AVERAGING );
        icono = new ImageIcon(laImagen);
        lblImagen.setIcon(icono);
    }
}
