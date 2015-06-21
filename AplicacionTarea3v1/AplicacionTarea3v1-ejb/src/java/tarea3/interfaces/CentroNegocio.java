/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tarea3.interfaces;

import java.util.List;
import javax.ejb.Local;
import tarea1.entidades.CentroMedico;

@Local
public interface CentroNegocio {
   
    public static enum ErrorCentro{
        NO_ERROR,
        CENTRO_REPETIDO_NOMBRE,
        CENTRO_REPETIDO_DIRECCION,
        CENTRO_REPETIDO_CODIGO
    };
  
    public List<CentroMedico> listaCentros();
    
    public ErrorCentro agregarCentro(CentroMedico c);
}
