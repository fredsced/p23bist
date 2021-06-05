package fr.formation.authentication.domain.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * An abstract entity to share common JPA mappings. To be extended by concrete
 * entities.
 */
@MappedSuperclass
abstract class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    AbstractEntity() {
	//
    }

    public Long getId() {
	return id;
    }
}
