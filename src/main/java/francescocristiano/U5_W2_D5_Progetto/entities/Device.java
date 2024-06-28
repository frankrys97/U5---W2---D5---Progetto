package francescocristiano.U5_W2_D5_Progetto.entities;


import francescocristiano.U5_W2_D5_Progetto.enums.DeviceStatus;
import francescocristiano.U5_W2_D5_Progetto.enums.DeviceType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
public class Device {
    @Id
    @GeneratedValue
    private UUID id;
    @Setter
    @Enumerated(EnumType.STRING)
    private DeviceType deviceType;
    @Setter
    @Enumerated(EnumType.STRING)
    private DeviceStatus deviceStatus;
    @Setter
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Employee employee;

    public Device(DeviceType deviceType, DeviceStatus deviceStatus, Employee employee) {
        this.deviceType = deviceType;
        this.deviceStatus = deviceStatus;
        this.employee = employee;
    }


}
