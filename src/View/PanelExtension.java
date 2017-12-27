/**
 * 
 */
package View;

import Controller.Controlador;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
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
    private final JButton btnOpcionUno;
    
    /**
     * Boton Opcion 2.
     */
    private final JButton btnOpcionDos;
    
    /**
     * Controlador principal de la aplicación.
     */
    private final Controlador ctrl;
    
    // -------------------------------------------------------------------------
    // Constructores
    // -------------------------------------------------------------------------
    
    /**
     * Construye el Panel Extensión.
     * @param ctrl Controlador principal de la aplicación.
     */
    public PanelExtension(Controlador ctrl)
    {
        this.ctrl = ctrl;
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

    /**
     * Escucha los eventos generados por los botones.
     * @param e Acción que genero el evento. e != null.
     */
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        String comando = e.getActionCommand();
        
        if(comando.equalsIgnoreCase(OPCION_UNO))
        {
            try
            {
                ctrl.opcionUno();
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Opción 1", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else
        {
            if(comando.equalsIgnoreCase(OPCION_DOS))
            {
                try
                {
                    ctrl.opcionDos();
                }
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Opción 2", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
        
    }
    
}
