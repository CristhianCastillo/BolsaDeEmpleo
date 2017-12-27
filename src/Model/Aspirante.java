/**
 * 
 */
package Model;

/**
 * Clase que representa un aspirante de la bolsa de empleo.
 * @author Cristhian Eduardo Castillo Erazo.
 */
public class Aspirante 
{
    // -------------------------------------------------------------------------
    // Constantes
    // -------------------------------------------------------------------------
    
    // -------------------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------------------
    
    /**
     * Nombre del aspirante.
     */
    private String nombre;
    
    /**
     * Edad del aspirante.
     */
    private int edad;
    
    /**
     * Profesión del aspirante.
     */
    private String profesion;
    
    /**
     * Años experiencia del aspirante.
     */
    private int aniosExperiencia;
    
    /**
     * Ruta de la imagen del aspirante.
     */
    private String imagen;
    
    /**
     * Telefono del aspirante.
     */
    private int telefono;
    
    // -------------------------------------------------------------------------
    // Constructores
    // -------------------------------------------------------------------------
    
    /**
     * Crea un nuevo aspirante.
     * @param nombre Nombre del aspirante. nombre != null && nombre != "".
     * @param edad Edad del aspirante. edad > 0.
     * @param profesion Profesión del aspirante. profesion != null && profesion != "".
     * @param aniosExperiencia Años experiencia. aniosExperiencia >=0.
     * @param imagen Ruta de la imagen del aspirante. imagen != null && imagen != "".
     * @param telefono Telefono del aspirante. telefono > 0.
     */
    public Aspirante(String nombre, int edad, String profesion, int aniosExperiencia, String imagen, int telefono)
    {
        this.nombre = nombre;
        this.edad = edad;
        this.profesion = profesion;
        this.aniosExperiencia = aniosExperiencia;
        this.imagen = imagen;
        this.telefono = telefono;
    }
    
    // -------------------------------------------------------------------------
    // Metodos
    // -------------------------------------------------------------------------

    /**
     * Obtiene el nombre del aspirante.
     * @return Nombre del aspirante.
     */
    public String getNombre() 
    {
        return nombre;
    }

    /**
     * Actuliza el nombre del aspirante.
     * @param nombre Nombre del aspirante.
     */
    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }

    /**
     * Obtiene la edad del aspirante.
     * @return Edad del aspirante.
     */
    public int getEdad() 
    {
        return edad;
    }

    /**
     * Actualiza la edad del aspirante.
     * @param edad Edad del aspirante.
     */
    public void setEdad(int edad) 
    {
        this.edad = edad;
    }

    /**
     * Obtiene la profesión del aspirante.
     * @return Profesión del aspirante.
     */
    public String getProfesion()
    {
        return profesion;
    }

    /**
     * Actualiza la profesión del aspirante.
     * @param profesion Profesión del aspirante.
     */
    public void setProfesion(String profesion) 
    {
        this.profesion = profesion;
    }

    /**
     * Obtiene los años de experiencia del aspirante.
     * @return Años de experiencia del aspirante.
     */
    public int getAniosExperiencia() 
    {
        return aniosExperiencia;
    }

    /**
     * Actualiza los años de experiencia del aspirante.
     * @param aniosExperiencia Años de experiencia del aspirante.
     */
    public void setAniosExperiencia(int aniosExperiencia)
    {
        this.aniosExperiencia = aniosExperiencia;
    }

    /**
     * Obtiene la ruta de la imagen del aspirante.
     * @return Ruta de la imagen del aspirante.
     */
    public String getImagen() 
    {
        return imagen;
    }

    /**
     * Actualiza la ruta de la imagen del aspirante.
     * @param imagen Ruta de la imagen del aspirante.
     */
    public void setImagen(String imagen)
    {
        this.imagen = imagen;
    }

    /**
     * Obtiene el teléfono del aspirante.
     * @return teléfono del aspirante.
     */
    public int getTelefono() 
    {
        return telefono;
    }

    /**
     * Actualiza el teléfono del aspirante.
     * @param telefono Teléfono del aspirante.
     */
    public void setTelefono(int telefono) 
    {
        this.telefono = telefono;
    }

    /**
     * Actualiza la vista del aspirante en el panel de aspirantes registrados.
     * @return Aspirante.
     */
    @Override
    public String toString() 
    {
        return nombre + " - " + profesion;
    }
    
    
}
