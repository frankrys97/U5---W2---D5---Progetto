package francescocristiano.U5_W2_D5_Progetto.payloads;

import jakarta.validation.constraints.NotBlank;

public record NewDeviceDTO(
        @NotBlank(message = "Device type cannot be blank")
        String deviceType
) {
}
