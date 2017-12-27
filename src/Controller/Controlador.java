/**
 * 
 */
package Controller;

import Model.Aspirante;
import Model.BolsaEmpleo;
import View.PanelAspirantesRegistrados;
import View.PanelDatosAspirante;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Clase que representa el Controlador principal de la aplicación.
 * @author Cristhian Eduardo Castillo Erazo.
 */
public class Controlador 
{
    // -------------------------------------------------------------------------
    // Constantes
    // -------------------------------------------------------------------------
    
    // -------------------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------------------
    
    /**
     * Bolsa de empleo de la aplicación.
     */
    private final BolsaEmpleo bolsaDeEmpleoPrincipal;
    
    /**
     * Panel que muestra los datos de un aspirante.
     */
    private PanelDatosAspirante pnlDatosAspirante;
    
    /**
     * Panel Aspirantes Registrados.
     */
    private PanelAspirantesRegistrados pnlAspirantesRegistrados;
    
    // -------------------------------------------------------------------------
    // Constructores
    // -------------------------------------------------------------------------
    
    /**
     * Contruye el controlador principal de la aplicación.
     */
    public Controlador ()
    {
        bolsaDeEmpleoPrincipal = new BolsaEmpleo();
    }
    
    // -------------------------------------------------------------------------
    // Metodos
    // -------------------------------------------------------------------------
    
    /**
     * Estable la conmunicacion entre los paneles y el controlador.
     * @param pnlDatosAspirante Panel Datos Aspirante. pnlDatosAspirante != null.
     * @param pnlAspirantesRegistrados  Panel Aspirantes Registrados. pnlAspirantesRegistrados !=  null.
     */
    public void conectar(PanelDatosAspirante pnlDatosAspirante, PanelAspirantesRegistrados pnlAspirantesRegistrados)
    {
        this.pnlDatosAspirante = pnlDatosAspirante;
        this.pnlAspirantesRegistrados = pnlAspirantesRegistrados;
    }
    
    /**
     * Carga la informacion de los aspirantes por medio de un archivo de 
     * propiedades.
     * @param ruta Ruta del archivo de propiedades.
     * @throws Exception 
     */
    public void cargarAspirantes(String ruta) throws Exception
    {
        try
        {
            Properties archivo = new Properties();
            FileInputStream datos = new FileInputStream(ruta);
            archivo.load(datos);
            
            int numeroAspirantes = Integer.parseInt(archivo.getProperty("total.aspirantes"));
            
            for(int i = 1; i <= numeroAspirantes; i ++)
            {
                String nombre = archivo.getProperty("aspirante" + i + ".nombre");
                String profesion = archivo.getProperty("aspirante" + i + ".profesion");
                String experienciaStr = archivo.getProperty("aspirante" + i + ".experiencia");
                String edadStr = archivo.getProperty("aspirante" + i + ".edad");
                String telefonoStr = archivo.getProperty("aspirante" + i + ".telefono");
                String imagen = archivo.getProperty("aspirante" + i + ".imagen");
                
                if(nombre == null)
                    throw new Exception("No se a definido la propiedad aspirante" + i + ".nombre");
                if(profesion == null)
                    throw new Exception("No se a definido la propiedad aspirante" + i + ".profesion");
                if(experienciaStr == null)
                    throw new Exception("No se a definido la propiedad aspirante" + i + ".experiencia");
                if(edadStr == null)
                    throw new Exception("No se a definido la propiedad aspirante" + i + ".edad");
                if(telefonoStr == null)
                    throw new Exception("No se a definido la propiedad aspirante" + i + ".telefono");
                if(imagen == null)
                    throw new Exception("No se a definido la propiedad aspirante" + i + ".imagen");
                
                if(nombre.trim().equals(""))
                    throw new Exception("La propiedad aspirante" + i + ".nombre no puede estar vacia.");
                if(profesion.trim().equals(""))
                    throw new Exception("La propiedad aspirante" + i + ".profesion no puede estar vacia.");
                if(experienciaStr.trim().equals(""))
                    throw new Exception("La propiedad aspirante" + i + ".experiencia no puede estar vacia.");
                if(edadStr.trim().equals(""))
                    throw new Exception("La propiedad aspirante" + i + ".edad no puede estar vacia.");
                if(telefonoStr.trim().equals(""))
                    throw new Exception("La propiedad aspirante" + i + ".telefono no puede estar vacia.");
                if(imagen.trim().equals(""))
                    throw new Exception("La propiedad aspirante" + i + ".imagen no puede estar vacia.");
                
                int experiencia = Integer.parseInt(experienciaStr);
                if(experiencia < 0)
                    throw new Exception("La experiencia del aspirante" + i + "no puede ser negativa.");
                int edad = Integer.parseInt(edadStr);
                if(edad <= 0)
                    throw new Exception("La edad del aspirante" + i + "no puede ser nagativa.");
                int telefono = Integer.parseInt(telefonoStr);
                if(telefono <= 0)
                    throw new Exception("El telefono del aspirante" + i + "no piede ser negativo.");
                
                if(bolsaDeEmpleoPrincipal.buscarAspirante(nombre) == -1)
                {
                    Aspirante aspirante = new Aspirante(nombre, edad, profesion, experiencia, imagen, telefono);
                    bolsaDeEmpleoPrincipal.agregarAspirante(aspirante);
                } 
            }
          
          pnlAspirantesRegistrados.refrescarLista(bolsaDeEmpleoPrincipal.getLista());
          pnlAspirantesRegistrados.seleccionarElemento(0);
            
        }
        catch(Exception ex)
        {
            throw new Exception(ex.getMessage());
        }
        
    }
    
    /**
     * Actualiza el panle Datos del Aspirante con el aspirante seleccionado.
     * @param indice Posición del aspirante seleccionado.
     * @throws IOException 
     */
    public void actualizarAspirante(int indice) throws IOException
    {
        Aspirante aspiranteSeleccionado = bolsaDeEmpleoPrincipal.getAspirante(indice);
        pnlDatosAspirante.actualizarAspirante(aspiranteSeleccionado);
    }
    
    /**
     * Agrega un nuevo aspirante a la bolsa de empleo.
     * @param nombre Nombre del aspirante. nombre != null && nombre != "".
     * @param edad Edad del aspirante. edad > 0.
     * @param profesion Profesión del aspirante. profesion != null && profesion != "".
     * @param aniosExperiencia Años de experiencia. aniosExperiencia >=0.
     * @param imagen Ruta de la imagen del aspirante. imagen != null && imagen != "".
     * @param telefono Teléfono del aspirante. telefono > 0.
     * @throws java.lang.Exception
     */
    public void agregarAspirante(String nombre, int edad, String profesion, int aniosExperiencia, String imagen, int telefono) throws Exception
    {
        if(bolsaDeEmpleoPrincipal.buscarAspirante(nombre) == -1)
        {
            Aspirante aspirante = new Aspirante(nombre, edad, profesion, aniosExperiencia, imagen, telefono);
            bolsaDeEmpleoPrincipal.agregarAspirante(aspirante);
            pnlAspirantesRegistrados.refrescarLista(bolsaDeEmpleoPrincipal.getLista());
            pnlAspirantesRegistrados.seleccionarElemento(0);
        }
        else
        {
            throw new Exception("Ya se encuentra registrado un aspirante con este nombre.");
        }
    }
    
    /**
     * Ordena los aspirantes por experiencia.
     * Refresca la lista de aspirantes.
     * Selecciona un aspirante de la lista.
     */
    public void orderPorExperiencia()
    {
        bolsaDeEmpleoPrincipal.ordenarExperiencia();
        pnlAspirantesRegistrados.refrescarLista(bolsaDeEmpleoPrincipal.getLista());
        pnlAspirantesRegistrados.seleccionarElemento(0);
        
    }
    
    /**
     * Ordena los aspirantes por experiencia.
     * Refresca la lista de aspirantes.
     * Selecciona un aspirante de la lista.
     */
    public void ordenarPorEdad()
    {
        bolsaDeEmpleoPrincipal.ordenarEdad();
        pnlAspirantesRegistrados.refrescarLista(bolsaDeEmpleoPrincipal.getLista());
        pnlAspirantesRegistrados.seleccionarElemento(0);
    }
    
    /**
     * Ordena los aspirantes por experiencia.
     * Refresca la lista de aspirantes.
     * Selecciona un aspirante de la lista.
     */
    public void ordenarPorProfesion()
    {
        bolsaDeEmpleoPrincipal.ordenarProfesion();
        pnlAspirantesRegistrados.refrescarLista(bolsaDeEmpleoPrincipal.getLista());
        pnlAspirantesRegistrados.seleccionarElemento(0);
    }
    
    /**
     * Busca y selecicona un aspirante de la bolsa de empleo.
     * @param nombre Nombre del aspirante a encontrar.
     * @throws Exception 
     */
    public void buscarAspirante(String nombre) throws Exception
    {
        int index = bolsaDeEmpleoPrincipal.buscarAspirante(nombre);
        if(index < 0)
        {
            throw new Exception("No existe aspirante con ese nombre.");
        }
        else
        {
            pnlAspirantesRegistrados.seleccionarElemento(index);
        }
    }
    
    /**
     * Obtiene la posicion del aspirante mas joven en la bolsa de empleo.
     * @throws Exception 
     */
    public void aspiranteMasJoven() throws Exception
    {
        int index = bolsaDeEmpleoPrincipal.masJoven();
        if(bolsaDeEmpleoPrincipal.getAspirante(index) == null)
            throw new Exception("No se puede determinar el aspirante más joven.");
        pnlAspirantesRegistrados.seleccionarElemento(index);
    }
    
    /**
     * Obtiene la posicion del aspirante con mayor edad en la bolsa de empleo.
     * @throws Exception 
     */
    public void aspiranteMasViejo() throws Exception
    {
        int index = bolsaDeEmpleoPrincipal.mayorEdad();
        if(bolsaDeEmpleoPrincipal.getAspirante(index) == null)
            throw new Exception("No se puede determinar el aspirante con mayor edad.");
        pnlAspirantesRegistrados.seleccionarElemento(index);
    }
    
    /**
     * Obtiene la posicion del aspirante con mayor experiencia en la bolsa de empleo.
     * @throws Exception 
     */
    public void aspiranteMayorExperiencia() throws Exception
    {
        int index = bolsaDeEmpleoPrincipal.mayorExperiencia();
        if(bolsaDeEmpleoPrincipal.getAspirante(index) == null)
            throw new Exception("No se puede determinar el aspirante con mayor experiencia.");
        pnlAspirantesRegistrados.seleccionarElemento(index);
    }
    
    /**
     * Elimina el aspirante seleccionado de la lista.
     * @throws Exception 
     */
    public void contratarAspirante() throws Exception
    {
        int indice = pnlAspirantesRegistrados.indiceSeleccionado();
        if(indice < 0)
            throw new Exception("Debe seleccionar un aspirante.");
        
        Aspirante aspirante = bolsaDeEmpleoPrincipal.contratarAspirante(indice);
        
        if(aspirante != null)
        {
            pnlAspirantesRegistrados.refrescarLista(bolsaDeEmpleoPrincipal.getLista());
            pnlAspirantesRegistrados.seleccionarElemento(0);
        }
        else
        {
            throw new Exception("No se puede eliminar el aspirante seleccionado.");
        }
    }
    
    /**
     * Determina los aspirantes que no cumplen con la experiencia y los elimina
     * de la bolsa de empleo.
     * @param experienciaMinima Experiencia minima requerida. experienciaMinima > 0.
     */
    public void eliminarAspirantes(int experienciaMinima)
    {
        bolsaDeEmpleoPrincipal.eliminarAspirantes(experienciaMinima);
        pnlAspirantesRegistrados.refrescarLista(bolsaDeEmpleoPrincipal.getLista());
        pnlAspirantesRegistrados.seleccionarElemento(0);
    }
    
    /**
     * Añade un aspirante por efecto al panel que muestra los datos del aspirante.
     * Este solo sera usado cuando la bolsa de empleo no contiene aspirantes.
     * @throws IOException 
     */
    public void aspiranteDefecto() throws IOException
    {
        Aspirante aspiranteDefecto = new Aspirante("", 0, "", 0, "./data/vacia.jpg", 0);
        pnlDatosAspirante.actualizarAspirante(aspiranteDefecto);
    }
    
    /**
     * Opcion Uno extensión.
     * @throws Exception 
     */
    public void opcionUno() throws Exception
    {
        throw new Exception("Opcion1");
    }
    
    /**
     * Opción Dos extensión.
     * @throws Exception 
     */
    public void opcionDos() throws Exception
    {
        throw new Exception("Opcion2");
    }
}
