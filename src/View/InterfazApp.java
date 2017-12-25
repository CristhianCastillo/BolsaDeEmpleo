/**
 * 
 */
package View;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/******************************************************************************
 * Clase que representa la ventana principal de la aplicación.
 * @author Cristhian Eduardo Castillo Erazo.
 * 
 * 
 ******************************************************************************/
public class InterfazApp extends JFrame
{
    // -------------------------------------------------------------------------
    // Constantes
    // -------------------------------------------------------------------------
    
    // -------------------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------------------
    
    /**
     * Panel Titulo con la imagen decorativa.
     */
    private PanelTitulo pnlTitulo;
    
    /**
     * Panel Aspirantes Registrados en la bolsa.
     */
    private PanelAspirantesRegistrados pnlAspirantesRegistrados;
    
    /**
     * Panel Datos del Aspirante.
     */
    private PanelDatosAspirante pnlDatosAspirante;
    
    /**
     * Panel Agregar Aspirante.
     */
    private PanelAgregarAspirante pnlAgregarAspirante;
    
    /**
     * Panel Busqueda y Ordenamiento.
     */
    private PanelBusquedaOrdenamiento pnlBusquedaOrdenamiento;
    
    /**
     * Panel Consultas.
     */
    private PanelConsultas pnlConsultas;
    
    /**
     * Panel Puntos de Extensión.
     */
    private PanelExtension pnlExtension;
    
    // -------------------------------------------------------------------------
    // Constructores
    // -------------------------------------------------------------------------
    
    /**
     * Construye la ventana principal de la aplicación.
     */
    public InterfazApp()
    {
        this.setTitle("Bolsa de Empleo");
        this.setLayout(new BorderLayout());
        
        pnlTitulo = new PanelTitulo();
        
        JPanel pnlCentro = new JPanel();
        pnlCentro.setLayout(new BorderLayout());
        
        JPanel pnlNorteCentro = new JPanel();
        pnlNorteCentro.setLayout(new BorderLayout());
        
        pnlAspirantesRegistrados = new PanelAspirantesRegistrados();
        pnlDatosAspirante = new PanelDatosAspirante();
        pnlNorteCentro.add(pnlAspirantesRegistrados, BorderLayout.WEST);
        pnlNorteCentro.add(pnlDatosAspirante, BorderLayout.CENTER);
        
        JPanel pnlSurCentro = new JPanel();
        pnlSurCentro.setLayout(new BorderLayout());

        pnlAgregarAspirante = new PanelAgregarAspirante();
        pnlBusquedaOrdenamiento = new PanelBusquedaOrdenamiento();
        pnlConsultas = new PanelConsultas();
        
        pnlSurCentro.add(pnlAgregarAspirante , BorderLayout.WEST);
        pnlSurCentro.add(pnlBusquedaOrdenamiento, BorderLayout.CENTER);
        pnlSurCentro.add(pnlConsultas, BorderLayout.EAST);
        
        pnlCentro.add(pnlNorteCentro, BorderLayout.NORTH);
        pnlCentro.add(pnlSurCentro, BorderLayout.CENTER);
        
        pnlExtension = new PanelExtension();
        
        this.getContentPane().add(pnlTitulo, BorderLayout.NORTH);
        this.getContentPane().add(pnlCentro, BorderLayout.CENTER);
        this.getContentPane().add(pnlExtension, BorderLayout.SOUTH);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(765,570);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }
    // -------------------------------------------------------------------------
    // Metodos
    // -------------------------------------------------------------------------
    
    /**
     * Metodo principal de la aplicación.
     * @param arg0s No son necesarios.
     */
    public static void main(String [] arg0s)
    {
        InterfazApp aplicacion = new InterfazApp();
        aplicacion.setVisible(true);
    }
    
    
    
}
