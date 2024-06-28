package francescocristiano.U5_W2_D5_Progetto.payloads;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record NewDeviceDTO(
        @NotBlank(message = "Device type cannot be blank")
        String deviceType,
        @NotBlank(message = "Device status cannot be blank")
        String deviceStatus,

        UUID employeeId
) {
}
