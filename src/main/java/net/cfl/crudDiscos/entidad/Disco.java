package net.cfl.crudDiscos.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;				
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity//esta notacion es una entidad
@Table(name="tb_discos")//indica el nombre de la taba en base de datos
/*CREAMOS LA CLASE Discos para JPA
 *
 * */

public class Disco {
	@Id //establecemos el campo id como PK
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	//La notacion @colum indica el nombre del campo en la base de datos
	@Column(name="d_titulo", nullable = false, unique = true)
	private String titulo;
	@Column(name="d_artista")
	private String artista;
	@Column(name="d_cod")
	private String cod;
	@Column(name="d_duracion")
	private int duracion;
	

	
}
