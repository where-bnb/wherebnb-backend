package goorm.wherebnb.repository;

import goorm.wherebnb.domain.dao.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Property, Long> {

    Property findByPropertyId(Long propertyId);
    Property getPropertyByPropertyId(Long propertyId);
}