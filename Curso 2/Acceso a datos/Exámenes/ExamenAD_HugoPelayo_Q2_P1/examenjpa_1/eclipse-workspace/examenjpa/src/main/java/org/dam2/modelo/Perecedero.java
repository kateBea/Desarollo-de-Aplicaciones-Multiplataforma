package org.dam2.modelo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@ToString(callSuper = true)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "PRODUCTO_PERECEDERO")
public class Perecedero extends Producto {
	private LocalDate caducidad;
	
	@Column(precision = 2)
	private Float peso;
	
	public boolean estaCaducado() {
		return caducidad.isBefore(LocalDate.now());
	}
}
