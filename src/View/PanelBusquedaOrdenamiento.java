/**
 * 
 */
package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 * Clase que representa el panel Búsqueda y Ordenamiento.
 * @author Cristhian Eduardo Castillo Erazo.
 */
public class PanelBusquedaOrdenamiento extends JPanel implements ActionListener
{
    // -------------------------------------------------------------------------
    // Constantes
    // -------------------------------------------------------------------------
    
    /**
     * Comando enviado por el boton Ordenar por experiencia.
     */
    public static final String ORDENAR_EXPERIENCIA = "Ordenar por experiencia";
    
    /**
     * Comando enviado por el boton Ordenar por Edad.
     */
    public static final String ORDENAR_EDAD = "Ordenar por edad";
    
    /**
     * Comando enviado por el boton Ordenar por Profesion.
     */
    public static final String ORDENAR_PROFESION = "Ordenar por profesion";
    
    /**
     * Comando enviado por el boton Buscar Aspirante.
     */
    public static final String BUSCAR_ASPIRANTE = "Buscar Aspirante";
    
    // -------------------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------------------
    
    /**
     * Boton Ordenar por experiencia.
     */
    private JButton btnOrdenarExperiencia;
    
    /**
     * Boton Ordenar por Edad.
     */
    private JButton btnOrdenarEdad;
    
    /**
     * Boton Ordenar por profesion.
     */
    private JButton btnOrdenarProfesion;
    
    /**
     * Boton Buscar Aspirante.
     */
    private JButton btnBuscarAspirante;
    
    // -------------------------------------------------------------------------
    // Constructores
    // -------------------------------------------------------------------------
    
    /**
     * Construye el Panel Buscar y Ordenamiento.
     */
    public PanelBusquedaOrdenamiento()
    {
        this.setBorder(new TitledBorder("Búsqueda y Ordenamiento"));
        this.setLayout(new BorderLayout());
        
        btnOrdenarExperiencia = new JButton("Ordenar por experiencia");
        btnOrdenarExperiencia.setActionCommand(ORDENAR_EXPERIENCIA);
        btnOrdenarExperiencia.addActionListener((ActionListener)this);
        
        btnOrdenarEdad = new JButton("Ordenar por Edad");
        btnOrdenarEdad.setActionCommand(ORDENAR_EDAD);
        btnOrdenarEdad.addActionListener((ActionListener)this);
        
        btnOrdenarProfesion = new JButton("Ordenar por profesión");
        btnOrdenarProfesion.setActionCommand(ORDENAR_PROFESION);
        btnOrdenarProfesion.addActionListener((ActionListener)this);
        
        btnBuscarAspirante = new JButton("Buscar Aspirante");
        btnBuscarAspirante.setActionCommand(BUSCAR_ASPIRANTE);
        btnBuscarAspirante.addActionListener((ActionListener)this);
        
        JPanel pnlCentroReal = new JPanel();
        pnlCentroReal.setBorder(new EmptyBorder(15,0,20,0));
        pnlCentroReal.setLayout(new FlowLayout());
        
        JPanel pnlCentro = new JPanel();
        GroupLayout grupo = new GroupLayout(pnlCentro);
        pnlCentro.setLayout(grupo);
        
        grupo.setAutoCreateContainerGaps(true);
        grupo.setAutoCreateGaps(true);
        
        //Set Horizontal
        grupo.setHorizontalGroup(
                grupo.createSequentialGroup()
                    .addGroup(grupo.createParallelGroup()
                            .addComponent(btnOrdenarExperiencia)
                            .addComponent(btnOrdenarEdad)
                            .addComponent(btnOrdenarProfesion)
                            .addComponent(btnBuscarAspirante)
                    )
        );
  
        //Set Vertical
        grupo.setVerticalGroup(
                grupo.createSequentialGroup()
                 .addGroup(grupo.createParallelGroup()
                         .addComponent(btnOrdenarExperiencia)
                 )
                
                .addGroup(grupo.createParallelGroup()
                        .addComponent(btnOrdenarEdad)
                )
                
                .addGroup(grupo.createParallelGroup()
                        .addComponent(btnOrdenarProfesion)
                )
                
                .addGroup(grupo.createParallelGroup()
                        .addComponent(btnBuscarAspirante)
                )
        );
        
        grupo.linkSize(SwingConstants.HORIZONTAL, btnOrdenarExperiencia, btnOrdenarEdad, btnOrdenarProfesion, btnBuscarAspirante);
        pnlCentroReal.add(pnlCentro);
        this.add(pnlCentroReal, BorderLayout.CENTER);
        
    }
    // -------------------------------------------------------------------------
    // Metodos
    // -------------------------------------------------------------------------

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
