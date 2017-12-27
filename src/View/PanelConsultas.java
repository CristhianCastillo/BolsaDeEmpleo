/**
 * 
 */
package View;

import Controller.Controlador;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
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
    private final JButton btnMasJoven;
    
    /**
     * Boton Mayor Edad.
     */
    private final JButton btnMayorEdad;
    
    /**
     * Boton Mayor Experiencia;
     */
    private final JButton btnMayorExperiencia;
    
    /**
     * Boton Contratar.
     */
    private final JButton btnContratar;
    
    /**
     * Boton Eliminar por Experiencia.
     */
    private final JButton btnEliminarPorExperiencia;
    
    /**
     * Controlador principal de la aplicación.
     */
    private final Controlador ctrl;
    
    // -------------------------------------------------------------------------
    // Constructores
    // -------------------------------------------------------------------------
    
    /**
     * Construye el Panel Consultas
     * @param ctrl Controlador principal de la aplicación.
     */
    public PanelConsultas (Controlador ctrl)
    {
        this.ctrl = ctrl;
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

    /**
     * Escucha los eventos generados por los botones.
     * @param e Acción que genero el evento. e != null.
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String comando = e.getActionCommand();
        
        if(comando.equalsIgnoreCase(MAS_JOVEN))
        {
            try
            {
                ctrl.aspiranteMasJoven();
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Más joven", JOptionPane.ERROR_MESSAGE);
            }
        }
        else
        {
            if(comando.equalsIgnoreCase(MAYOR_EDAD))
            {
                try
                {
                    ctrl.aspiranteMasViejo();
                }
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Mayor Edad", JOptionPane.ERROR_MESSAGE);
                }
            }
            else
            {
                if(comando.equalsIgnoreCase(MAYOR_EXPERIENCIA))
                {
                    try
                    {
                        ctrl.aspiranteMayorExperiencia();
                    }
                    catch(Exception ex)
                    {
                        JOptionPane.showMessageDialog(this, ex.getMessage(), "Mayor Experiencia", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else
                {
                    if(comando.equalsIgnoreCase(CONTRATAR))
                    {
                        try
                        {
                            ctrl.contratarAspirante();
                        }
                        catch(Exception ex)
                        {
                            JOptionPane.showMessageDialog(this, ex.getMessage(), "Contratar", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    else
                    {
                        if(comando.equalsIgnoreCase(ELIMINAR_POR_EXPERIENCIA))
                        {
                            try
                            {
                                String experienciaStr = JOptionPane.showInputDialog(this, "Ingrese la experiencia minima requerida", "Eliminar por Experiencia", JOptionPane.INFORMATION_MESSAGE);
                                if(experienciaStr == null)
                                    throw new Exception("No se puede completar el proceso.");
                                int experiencia = Integer.parseInt(experienciaStr);
                                if(experiencia > 0)
                                {
                                    ctrl.eliminarAspirantes(experiencia);
                                }
                                else
                                {
                                    throw new Exception("La experiencia minima debe ser mayor a cero.");
                                }
                                
                            }
                            catch(Exception ex)
                            {
                                JOptionPane.showMessageDialog(this, ex.getMessage(), "Contratar", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                }
            }
        }
    }
    
}
