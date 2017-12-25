/**
 * 
 */
package View;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * Clase que representa el Panel de los puntos de extensión.
 * @author Cristhian Eduardo Castillo Erazo.
 */
public class PanelExtension extends JPanel implements ActionListener
{
    // -------------------------------------------------------------------------
    // Constantes
    // -------------------------------------------------------------------------
    
    /**
     * Comando enviado por el boton Opcion 1.
     */
    public static final String OPCION_UNO = "Opcion1";
    
    /**
     * Comando enviado por el boton Opcion 2.
     */
    public static final String OPCION_DOS = "Opcion2";

    // -------------------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------------------
    
    /**
     * Boton Opcion 1.
     */
    private JButton btnOpcionUno;
    
    /**
     * Boton Opcion 2.
     */
    private JButton btnOpcionDos;
    
    // -------------------------------------------------------------------------
    // Constructores
    // -------------------------------------------------------------------------
    
    public PanelExtension()
    {
        this.setBorder(new TitledBorder("Puntos de Extensión"));
        this.setLayout(new FlowLayout());
        
        btnOpcionUno = new JButton("Opción 1");
        btnOpcionUno.setActionCommand(OPCION_UNO);
        btnOpcionUno.addActionListener((ActionListener)this);
        
        btnOpcionDos = new JButton("Opción 2");
        btnOpcionDos.setActionCommand(OPCION_DOS);
        btnOpcionDos.addActionListener((ActionListener)this);
        
        this.add(btnOpcionUno);
        this.add(btnOpcionDos);
        
    }
    // -------------------------------------------------------------------------
    // Metodos
    // -------------------------------------------------------------------------

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        
    }
    
}
