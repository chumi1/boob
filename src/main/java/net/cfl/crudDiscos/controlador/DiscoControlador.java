package net.cfl.crudDiscos.controlador;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import net.cfl.crudDiscos.dto.DiscoDto;
import net.cfl.crudDiscos.servicios.DiscoServicio;

@AllArgsConstructor
@RestController //Establece la clase como un controlador REST
@RequestMapping("/api/discos")
public class DiscoControlador {
	private DiscoServicio discoServicio;
	
	//REST API: Crear Disco
	@PostMapping
	public ResponseEntity<DiscoDto>crearDisco(@RequestBody DiscoDto discoDto){
		DiscoDto discoGuardado = discoServicio.crearDisco(discoDto);
		return new ResponseEntity<>(discoGuardado, HttpStatus.CREATED);
	}
	//REST API: Consulta Disco Por ID
	@GetMapping("{id}")
	public ResponseEntity<DiscoDto>consultaDiscoPorId(@PathVariable("id")Long discoId){
		DiscoDto discoDto = discoServicio.consultaDiscoPorId(discoId);
		return ResponseEntity.ok(discoDto);
	}
  //REST API: Consulta Todos los discos
	@GetMapping
	public ResponseEntity<List<DiscoDto>> consultaTodosDiscos(){
		List<DiscoDto> discos = discoServicio.consultaTodosDiscos();
		return ResponseEntity.ok(discos);
	}
	@PutMapping("{Id}")
	//REST API: Actualiza Disco
	public ResponseEntity<DiscoDto> actualizaDisco(@RequestBody DiscoDto discoActualizado,
			             @PathVariable("id")Long discoId){
		DiscoDto discoDto = discoServicio.actualizaDisco(discoId, discoActualizado);
		return ResponseEntity.ok(discoDto);
	}
	
}
