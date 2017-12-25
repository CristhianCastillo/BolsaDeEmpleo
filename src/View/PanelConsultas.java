/**
 * 
 */
package View;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 * Clase que representa el panel Consultas.
 * @author Cristhian Eduardo Castillo Erazo.
 */
public class PanelConsultas extends JPanel implements ActionListener
{
    // -------------------------------------------------------------------------
    // Constantes
    // -------------------------------------------------------------------------
    
    /**
     * Comando enviado por el boton Mas Joven.
     */
    public static final String MAS_JOVEN = "Mas Joven";
    
    /**
     * Comando enviado por el boton Mayor Edad.
     */
    public static final String MAYOR_EDAD = "Mayor Edad";
    
    /**
     * Comando enviado por el boton Mayor Experiencia.
     */
    public static final String MAYOR_EXPERIENCIA = "Mayor Experiencia";
    
    /**
     * Comando enviado por el boton Contratar.
     */
    public static final String CONTRATAR = "Contratar";
    
    /**
     * Comando enviado por el boton Eliminar por Experiencia.
     */
    public static final String ELIMINAR_POR_EXPERIENCIA = "Eliminar por Experiencia";
    
    // -------------------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------------------
    
    /**
     * Boton Mas Joven
     */
    private JButton btnMasJoven;
    
    /**
     * Boton Mayor Edad.
     */
    private JButton btnMayorEdad;
    
    /**
     * Boton Mayor Experiencia;
     */
    private JButton btnMayorExperiencia;
    
    /**
     * Boton Contratar.
     */
    private JButton btnContratar;
    
    /**
     * Boton Eliminar por Experiencia.
     */
    private JButton btnEliminarPorExperiencia;
    
    // -------------------------------------------------------------------------
    // Constructores
    // -------------------------------------------------------------------------
    
    /**
     * Construye el Panel Consultas
     */
    public PanelConsultas ()
    {
        this.setBorder(new TitledBorder("Consultas"));
        this.setLayout(new BorderLayout());
        
        JPanel pnlCentro = new JPanel();
        GroupLayout grupo = new GroupLayout(pnlCentro);
        pnlCentro.setBorder(new EmptyBorder(5,5,5,5));
        pnlCentro.setLayout(grupo);
        
        btnMasJoven = new JButton("Más Joven");
        btnMasJoven.setActionCommand(MAS_JOVEN);
        btnMasJoven.addActionListener((ActionListener)this);
        
        btnMayorEdad = new JButton("Mayor Edad");
        btnMayorEdad.setActionCommand(MAYOR_EDAD);
        btnMayorEdad.addActionListener((ActionListener)this);
        
        btnMayorExperiencia = new JButton("Mayor Experiencia");
        btnMayorExperiencia.setActionCommand(MAYOR_EXPERIENCIA);
        btnMayorExperiencia.addActionListener((ActionListener)this);
        
        btnContratar = new JButton("Contratar");
        btnContratar.setActionCommand(CONTRATAR);
        btnContratar.addActionListener((ActionListener)this);
        
        btnEliminarPorExperiencia = new JButton("Eliminar por Experiencia");
        btnEliminarPorExperiencia.setActionCommand(ELIMINAR_POR_EXPERIENCIA);
        btnEliminarPorExperiencia.addActionListener((ActionListener)this);
        
        grupo.setAutoCreateContainerGaps(true);
        grupo.setAutoCreateGaps(true);
        
        //Set Horizontal
        grupo.setHorizontalGroup(grupo.createSequentialGroup()
                .addGroup(grupo.createParallelGroup()
                        .addComponent(btnMasJoven)
                        .addComponent(btnMayorEdad)
                        .addComponent(btnMayorExperiencia)
                        .addComponent(btnContratar)
                        .addComponent(btnEliminarPorExperiencia)
                )
        );
        
        grupo.linkSize(SwingConstants.HORIZONTAL, btnMasJoven, btnMayorEdad, btnMayorExperiencia, btnContratar, btnEliminarPorExperiencia);
        
        grupo.setVerticalGroup(grupo.createSequentialGroup()
                .addGroup(grupo.createParallelGroup()
                        .addComponent(btnMasJoven)
                )
                
                .addGroup(grupo.createParallelGroup()
                        .addComponent(btnMayorEdad)
                )
                
                .addGroup(grupo.createParallelGroup()
                        .addComponent(btnMayorExperiencia)
                )
                
                .addGroup(grupo.createParallelGroup()
                        .addComponent(btnContratar)
                )
                
                .addGroup(grupo.createParallelGroup()
                        .addComponent(btnEliminarPorExperiencia)
                )
        );
        
        this.add(pnlCentro, BorderLayout.CENTER);
        
        
    }
    // -------------------------------------------------------------------------
    // Metodos
    // -------------------------------------------------------------------------

    @Override
    public void actionPerformed(ActionEvent e)
    {
        
    }
    
}
