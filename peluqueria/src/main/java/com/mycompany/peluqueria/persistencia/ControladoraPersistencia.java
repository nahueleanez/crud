package com.mycompany.peluqueria.persistencia;

import com.mycompany.peluqueria.logica.Duenio;
import com.mycompany.peluqueria.logica.Mascota;
import com.mycompany.peluqueria.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {
        
        DuenioJpaController1 duenioJpa = new DuenioJpaController1();
        MascotaJpaController1 mascotaJpa = new MascotaJpaController1();

    public void guardar(Duenio duenio, Mascota masco) {
        
        //Crea en la BD el dueño
        duenioJpa.create(duenio);
        
        //Crea en la BD la mascota
        mascotaJpa.create(masco);
        
           
    }

    public List<Mascota> traerMascotas() {
        
        return mascotaJpa.findMascotaEntities();
        
    }

    public void borrarMascota(int num_cliente) {
            try {
                mascotaJpa.destroy(num_cliente);
            } catch (NonexistentEntityException ex) {
                Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
            }
            {
    }
    }

    public Mascota traerMascota(int num_cliente) {
       return mascotaJpa.findMascota(num_cliente);
    }

    public void modificarMascota(Mascota masco) {
            try {
                mascotaJpa.edit(masco);
            } catch (Exception ex) {
                Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    public Duenio traerDuenio(int id_duenio) {
       return duenioJpa.findDuenio(id_duenio);
    }

    public void modificarDuenio(Duenio dueno) {
            try {
                duenioJpa.edit(dueno);
            } catch (Exception ex) {
                Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
        
}
