package ma.xproce.inventoryservice.repositories;

import ma.xproce.inventoryservice.entities.Creator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CreatorRepository extends JpaRepository<Creator,Long> {
}
