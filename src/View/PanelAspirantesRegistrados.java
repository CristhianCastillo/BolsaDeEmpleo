/**
 * 
 */
package View;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Clase que representa el Panel Aspirantes Registrados en la Bolsa.
 * @author Cristhian Eduardo Castillo Erazo.
 */
public class PanelAspirantesRegistrados extends JPanel implements ListSelectionListener
{
    // -------------------------------------------------------------------------
    // Constantes
    // -------------------------------------------------------------------------
    
    // -------------------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------------------
    
    /**
     * Lista de los aspirantes registrados en la bolsa.
     */
    private final JList listaAspirantes;
    
    // -------------------------------------------------------------------------
    // Constructores
    // -------------------------------------------------------------------------
    
    public PanelAspirantesRegistrados()
    {
        this.setBorder(new TitledBorder("Aspirantes Registrados en la Bolsa"));
        this.setLayout(new BorderLayout());
        
        listaAspirantes = new JList();
        listaAspirantes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaAspirantes.addListSelectionListener((ListSelectionListener)this);
        
        JScrollPane scroll = new JScrollPane(listaAspirantes);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setBorder(new CompoundBorder(new EmptyBorder(5,1,1,1), new LineBorder(Color.BLACK, 1)));

        this.add(scroll, BorderLayout.CENTER);
    }
    
    // -------------------------------------------------------------------------
    // Metodos
    // -------------------------------------------------------------------------

    @Override
    public void valueChanged(ListSelectionEvent e) 
    {
       
    }
    
}
