package com.mycompany.peluqueria.logica;

import com.mycompany.peluqueria.persistencia.ControladoraPersistencia;
import java.util.List;

public class Controladora {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void guardar(String nombreMasco, String nombreRaza, String color, 
            String observaciones, String alergico, String atenEsp, 
            String celDuenio, String nombreDuenio) {
         
        
        Duenio duenio = new Duenio();
        duenio.setNombre(nombreDuenio);
        duenio.setCelDuenio(celDuenio);
        
        
        Mascota masco = new Mascota();
        
        masco.setNombre(nombreMasco);
        masco.setRaza(nombreRaza);
        masco.setColor(color);
        masco.setAlergico(alergico);
        masco.setObservaciones(observaciones);
        masco.setAtencion_especial(atenEsp);
        masco.setUnDuenio(duenio);
        
        controlPersis.guardar(duenio,masco);
        
        
    }

    public List<Mascota> traerMascotas() {
        return controlPersis.traerMascotas();
        
        
        
    }

    public void borrarMascota(int num_cliente) {
        controlPersis.borrarMascota(num_cliente);
    }



    public Mascota traerMascota(int num_cliente) {
        return controlPersis.traerMascota(num_cliente);
    }

    public void modificarMascota(Mascota masco, String nombreMasco, String nombreRaza, 
            String color, String observaciones, String alergico, String atenEsp, 
            String celDuenio, String nombreDuenio) {
        
            masco.setNombre(nombreMasco);
            masco.setRaza(nombreRaza);
            masco.setColor(color);
            masco.setObservaciones(observaciones);
            masco.setAlergico(alergico);
            masco.setAtencion_especial(atenEsp);
            
            controlPersis.modificarMascota(masco);
            
            Duenio dueno = this.buscarDuenio(masco.getUnDuenio().getId_duenio());
            dueno.setCelDuenio(celDuenio);
            dueno.setNombre(nombreDuenio);
            
            this.modificarDuenio(dueno);
            
        
           }

    private Duenio buscarDuenio(int id_duenio) {
    return controlPersis.traerDuenio(id_duenio);
    }

    private void modificarDuenio(Duenio dueno) {
        controlPersis.modificarDuenio(dueno);
    }

       
}
