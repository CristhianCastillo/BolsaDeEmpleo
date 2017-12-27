/**
 * 
 */
package View;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Clase que representa el Panel que contiene la imagen decorativa de la
 * aplicación.
 * @author Cristhian Eduardo Castillo Erazo.
 */
public class PanelTitulo extends JPanel
{
    // -------------------------------------------------------------------------
    // Constantes
    // -------------------------------------------------------------------------
    
    // -------------------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------------------
    
    /**
     * Etiqueta que con la imagen decorativa.
     */
    private final JLabel imagen;
    
    // -------------------------------------------------------------------------
    // Constructores
    // -------------------------------------------------------------------------
    
    /**
     * Construye el Panel que muestra la imagen decorativa de la aplicación.
     */
    public PanelTitulo()
    {
        setBackground(Color.WHITE);
        setLayout(new BorderLayout( ));
        ImageIcon icono = new ImageIcon ("data/Titulo.png");
        imagen = new JLabel(" ");
        imagen.setIcon(icono);
        imagen.setHorizontalAlignment(JLabel.CENTER);
        add(imagen, BorderLayout.CENTER);
    }
    
    // -------------------------------------------------------------------------
    // Metodos
    // -------------------------------------------------------------------------
    
}
