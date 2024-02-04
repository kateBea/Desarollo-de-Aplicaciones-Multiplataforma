package dam2.carreras.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import dam2.carreras.model.Carrera;

@Service
public interface CarreraService {
	// Consultar
	boolean existePorId(String nombre);
	Set<Carrera> buscarTodos();
	Optional<Carrera> buscardPorId(String nombre);
	
	// Insertar
	Optional<Carrera> insertar(Carrera nueva);
	
	// Modificar
	Optional<Carrera> actualizar(Carrera nueva);
	
	// Borrar
	boolean borrarPorId(String nombre);
}
