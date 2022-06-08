package ar.edu.redLink.retailShop.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;



@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="tipo", discriminatorType = DiscriminatorType.INTEGER)
public abstract class Promociones {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	public Integer id;

	public Promociones() {
		super();
		// TODO Auto-generated constructor stub
	}

}
