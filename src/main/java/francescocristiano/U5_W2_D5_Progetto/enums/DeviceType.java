package francescocristiano.U5_W2_D5_Progetto.enums;

import francescocristiano.U5_W2_D5_Progetto.exceptions.BadRequestException;

public enum DeviceType {
    SMARTPHONE,
    TABLET,
    LAPTOP;

    public static DeviceType getDeviceType(String deviceType) {
        if (deviceType.equalsIgnoreCase("smartphone")) {
            return DeviceType.SMARTPHONE;
        } else if (deviceType.equalsIgnoreCase("tablet")) {
            return DeviceType.TABLET;
        } else if (deviceType.equalsIgnoreCase("laptop")) {
            return DeviceType.LAPTOP;
        } else {
            throw new BadRequestException("Invalid device type, must be SMARTPHONE, TABLET or LAPTOP");
        }
    }
}
