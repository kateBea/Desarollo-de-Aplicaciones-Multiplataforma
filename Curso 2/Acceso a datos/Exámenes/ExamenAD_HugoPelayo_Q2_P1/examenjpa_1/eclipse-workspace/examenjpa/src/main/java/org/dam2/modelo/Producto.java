package org.dam2.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Entity
@Table(name = "PRODUCTO")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@EntityListeners(ProductoListener.class)

public abstract class Producto {
	@NonNull
	@EqualsAndHashCode.Include
	@Id
	@Column(length = 10)
	private String numReferencia;
	
	@Column(length = 30, nullable = false)
	private String nombre;
	
	private int stock;
	
	private int stockMinimo;
	
	@Column(precision = 2)
	private float pvp;
	
	@Column(precision = 2)
	private float pvd;
	
	private int unidadesPorPedido;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Proveedor proveedor;
}
