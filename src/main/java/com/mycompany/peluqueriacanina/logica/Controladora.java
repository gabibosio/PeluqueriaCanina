package com.mycompany.peluqueriacanina.logica;

import com.mycompany.peluqueriacanina.persistencia.ControladoraPersistencia;
import java.util.List;

public class Controladora {
    
    ControladoraPersistencia controladoraPersis = new ControladoraPersistencia();

    public void crear(String nombreMasco, String raza, String color, String aler, String aten, String observaciones, String nombreDuenio,
            int cel, String direccion) {
       Duenio duenio = new Duenio();
        duenio.setNombre(nombreDuenio);
        duenio.setCelular(cel);
        duenio.setDireccion(direccion);
        
        Mascota mascota = new Mascota();
        mascota.setAlergico(aler);
        mascota.setAtencion_especial(aten);
        mascota.setNombre_perro(nombreMasco);
        mascota.setRaza(raza);
        mascota.setObservaciones(observaciones);
        mascota.setDuenio(duenio);
        mascota.setColor(color);
        
        controladoraPersis.crear(duenio,mascota);
        
    }

    
    public List<Mascota> MostrarMascotas() {
       return controladoraPersis.traerMascotas();
    }

    public void eliminarMascota(int id){
        controladoraPersis.eliminarMascota(id);
    }

    

    public Mascota buscarMascota(int num_cliente) {
        return controladoraPersis.traerMascota(num_cliente);
    }

    public void modificarMascota(Mascota mascota, String nombreMasco, String color, String raza, String observaciones, String aler, 
            String aten, String nombreDuenio, int cel, String direccion) {
        
        mascota.setNombre_perro(nombreMasco);
        mascota.setColor(color);
        mascota.setRaza(raza);
        mascota.setObservaciones(observaciones);
        mascota.setAlergico(aler);
        mascota.setAtencion_especial(aten);
        
        controladoraPersis.modificarMascota(mascota);
        
        Duenio duenio = this.buscarDuenio(mascota.getDuenio().getId_duenio());
        
        duenio.setNombre(nombreDuenio);
        duenio.setCelular(cel);
        duenio.setDireccion(direccion);
        
        this.modificarDuenio(duenio);
    }

    private Duenio buscarDuenio(int id_duenio) {
        return controladoraPersis.buscarDuenio(id_duenio);
    }

    private void modificarDuenio(Duenio duenio) {
        controladoraPersis.modificarDuenio(duenio);
    }

    

   
 
    
}
