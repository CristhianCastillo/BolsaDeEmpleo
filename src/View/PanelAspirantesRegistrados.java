/**
 * 
 */
package View;

import Controller.Controlador;
import Model.Aspirante;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JList;
import javax.swing.JOptionPane;
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
    
    /**
     * Controlador principal de la aplicación.
     */
    private final Controlador ctrl;
    
    // -------------------------------------------------------------------------
    // Constructores
    // -------------------------------------------------------------------------
    
    /**
     * Contruye el Panel Aspirantes Registrados.
     * @param ctrl Controlador principal de la aplicación.
     */
    public PanelAspirantesRegistrados(Controlador ctrl)
    {
        this.ctrl = ctrl;
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

    /**
     * Actualiza la lista con los aspirantes de la bolsa de empleo.
     * @param lista Lista actual de los aspirantes en la bolsa de empleo.
     */
    public void refrescarLista(ArrayList<Aspirante> lista)
    {
        listaAspirantes.setListData(lista.toArray());
    }
    
    /**
     * Selecciona un aspirante de la lista para consultar su información.
     * @param i Posición del aspirante seleccionado.
     */
    public void seleccionarElemento(int i)
    {
        listaAspirantes.setSelectedIndex(i);
        listaAspirantes.ensureIndexIsVisible(i);
    }
    
    /**
     * Obtiene la posición del aspirante seleccionado.
     * @return Posición del aspirante seleccionado.
     */
    public int indiceSeleccionado()
    {
        return listaAspirantes.getSelectedIndex();
    }
    
    /**
     * Metodo que escucha los eventos de la lista de Aspirantes.
     * @param e Acción que genero el evento. e != null.
     */
    @Override
    public void valueChanged(ListSelectionEvent e) 
    {
        try 
        {
            if(listaAspirantes.getSelectedValue() != null)
            {
                int indice = listaAspirantes.getSelectedIndex();
                ctrl.actualizarAspirante(indice);
            }
            else
            {
                ctrl.aspiranteDefecto();
            }
            
        } 
        catch (Exception ex) 
        {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Aspirantes Registrados", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
