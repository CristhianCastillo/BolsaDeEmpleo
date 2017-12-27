/**
 * 
 */
package Model;

import java.util.ArrayList;

/**
 * Clase que prepresenta la bolsa de empleo.
 * @author Cristhian Eduardo Castillo Erazo.
 */
public class BolsaEmpleo 
{
    // -------------------------------------------------------------------------
    // Constantes
    // -------------------------------------------------------------------------
    
    // -------------------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------------------
    
    /**
     * Lista que representa la bolsa de Empleo de la aplicación.
     */
    private final ArrayList<Aspirante> bolsaDeEmpleo;
    
    // -------------------------------------------------------------------------
    // Constructores
    // -------------------------------------------------------------------------
    
    /**
     * Construye la bolsa de empleo.
     */
    public BolsaEmpleo()
    {
        this.bolsaDeEmpleo = new ArrayList<>();
    }
    
    // -------------------------------------------------------------------------
    // Metodos
    // -------------------------------------------------------------------------
    
    /**
     * Agregar un aspirante a la bolsa de empleo.
     * @param aspirante Aspirante a agregar. aspirante != null.
     */
    public void agregarAspirante(Aspirante aspirante)
    {
        this.bolsaDeEmpleo.add(aspirante);
    }
    
    /**
     * Busca un aspirante y retorna la posición.
     * @param nombreAspirante Nombre del aspirante. nombreAspirante != null && nombreAspirante != "".
     * @return Posición actual del Aspirante. -1 si no se encuentra Aspirante con ese nombre.
     */
    public int buscarAspirante(String nombreAspirante)
    {
        for(int i = 0; i < bolsaDeEmpleo.size(); i ++)
        {
            Aspirante aspiranteTemp = bolsaDeEmpleo.get(i);
            if(aspiranteTemp.getNombre().equalsIgnoreCase(nombreAspirante))
            {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Obtiene un aspirante en la posición indicada.
     * @param indice Indice del aspirante seleccionado.
     * @return Aspirante seleccionado.
     */
    public Aspirante getAspirante(int indice)
    {
        return bolsaDeEmpleo.get(indice);
    }
    
    /**
     * Obtiene la lista de aspirantes de la bolsa.
     * @return Lista de aspirantes.
     */
    public ArrayList<Aspirante> getLista()
    {
        return this.bolsaDeEmpleo;
    }
    
    /**
     * Ordena los aspiranten por experiencia.
     * Se realiza el ordenamiento por selección.
     */
    public void ordenarExperiencia()
    {
        for(int i = 0; i < bolsaDeEmpleo.size() - 1; i ++)
        {
            Aspirante aspirantePivote = bolsaDeEmpleo.get(i);
            Aspirante aspiranteMenor = aspirantePivote;
            int posicionIntercambio = i;
            for(int j = posicionIntercambio + 1; j < bolsaDeEmpleo.size(); j ++)
            {
                Aspirante aspiranteIteracion = bolsaDeEmpleo.get(j);
                if(aspiranteIteracion.getAniosExperiencia() < aspiranteMenor.getAniosExperiencia())
                {
                    posicionIntercambio = j;
                    aspiranteMenor = aspiranteIteracion; 
                }
            }
            
            //Intercambio de elementos.
            bolsaDeEmpleo.set(i, aspiranteMenor);
            bolsaDeEmpleo.set(posicionIntercambio,aspirantePivote);
        }
    }
    
    /**
     * Ordena los aspirantes por edades.
     * Se realiza el ordenamiento por selección.
     */
    public void ordenarEdad()
    {
        for(int i = 0; i < bolsaDeEmpleo.size() - 1; i ++)
        {
            Aspirante aspirantePivote = bolsaDeEmpleo.get(i);
            Aspirante aspiranteMenor = aspirantePivote;
            int posicionIntercambio = i;
            for(int j = posicionIntercambio + 1; j < bolsaDeEmpleo.size(); j ++)
            {
                Aspirante aspiranteIteracion = bolsaDeEmpleo.get(j);
                if(aspiranteIteracion.getEdad() < aspiranteMenor.getEdad())
                {
                    posicionIntercambio = j;
                    aspiranteMenor = aspiranteIteracion; 
                }
            }
            
            //Intercambio de elementos.
            bolsaDeEmpleo.set(i, aspiranteMenor);
            bolsaDeEmpleo.set(posicionIntercambio,aspirantePivote);
        }
    }
    
    /**
     * Ordena la bolsa de aspirantes por profesión.
     * Se realiza un ordenamiento por selección.
     */
    public void ordenarProfesion()
    {
        for(int i = 0; i < bolsaDeEmpleo.size() - 1; i ++)
        {
            Aspirante aspirantePivote = bolsaDeEmpleo.get(i);
            Aspirante aspiranteMenor = aspirantePivote;
            int posicionIntercambio = i;
            for(int j = posicionIntercambio + 1; j < bolsaDeEmpleo.size(); j ++)
            {
                Aspirante aspiranteIteracion = bolsaDeEmpleo.get(j);
                if(aspiranteIteracion.getProfesion().compareTo(aspiranteMenor.getProfesion()) < 0)
                {
                    posicionIntercambio = j;
                    aspiranteMenor = aspiranteIteracion; 
                }
            }
            
            //Intercambio de elementos.
            bolsaDeEmpleo.set(i, aspiranteMenor);
            bolsaDeEmpleo.set(posicionIntercambio,aspirantePivote);
        }
    }
    
    /**
     * Determina la posición del aspirante más joven.
     * @return Posicion del aspirante más joven.
     */
    public int masJoven()
    {
        int posicionMasJoven = 0;
        Aspirante aspiranteJoven = bolsaDeEmpleo.get(0);
        for(int i = 1; i < bolsaDeEmpleo.size(); i ++)
        {
            Aspirante aspirante = bolsaDeEmpleo.get(i);
            if(aspirante.getEdad() < aspiranteJoven.getEdad())
            {
                aspiranteJoven = aspirante;
                posicionMasJoven = i;
            }
        }
        
        return posicionMasJoven;
    }
    
     /**
     * Determina la posición del aspirante con mayor edad.
     * @return Posicion del aspirante con mayor edad.
     */
    public int mayorEdad()
    {
        int posicionMayorEdad = 0;
        Aspirante aspiranteViejo = bolsaDeEmpleo.get(0);
        for(int i = 1; i < bolsaDeEmpleo.size(); i ++)
        {
            Aspirante aspirante = bolsaDeEmpleo.get(i);
            if(aspirante.getEdad() > aspiranteViejo.getEdad())
            {
                aspiranteViejo = aspirante;
                posicionMayorEdad = i;
            }
        }
        return posicionMayorEdad;
    }
    
    /**
     * Determina la posición del aspirante con mayor experiencia.
     * @return Posicion del aspirante con mayor experiencia.
     */
    public int mayorExperiencia()
    {
        int posicionMayorExperiencia = 0;
        Aspirante aspiranteMayorExperiencia = bolsaDeEmpleo.get(0);
        for(int i = 1; i < bolsaDeEmpleo.size(); i ++)
        {
            Aspirante aspirante = bolsaDeEmpleo.get(i);
            if(aspirante.getEdad() > aspiranteMayorExperiencia.getEdad())
            {
                aspiranteMayorExperiencia = aspirante;
                posicionMayorExperiencia = i;
            }
        }
        return posicionMayorExperiencia;
    }
    
    /**
     * Elimina un aspirante seleccionado.
     * @param index Posición del aspirante a eliminar.
     * @return Aspirante eliminado.
     */
    public Aspirante contratarAspirante(int index)
    {
        return bolsaDeEmpleo.remove(index);
    }
    
    /**
     * Elimina los aspirantes que no cumplen con la experencia minima.
     * @param experienciaMinima  Experiencia minima. experienciaMinima > 0.
     */
    public void eliminarAspirantes(int experienciaMinima)
    {
        int tamanio = bolsaDeEmpleo.size();
        int contador = 0;
        for(int i = 0; i < tamanio; i ++)
        {
            Aspirante aspiranteTemp = bolsaDeEmpleo.get(contador);
            if(aspiranteTemp.getAniosExperiencia() < experienciaMinima)
            {
                bolsaDeEmpleo.remove(contador);
            }
            else
            {
                contador ++;
            }
        }
    }
    
}
