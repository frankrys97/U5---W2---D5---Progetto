package francescocristiano.U5_W2_D5_Progetto.repositories;

import francescocristiano.U5_W2_D5_Progetto.entities.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DeviceRepository extends JpaRepository<Device, UUID> {
}
