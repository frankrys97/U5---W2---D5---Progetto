package francescocristiano.U5_W2_D5_Progetto.enums;

import francescocristiano.U5_W2_D5_Progetto.exceptions.BadRequestException;

public enum DeviceStatus {
    ONLINE,
    OFFLINE,
    IN_MAINTENANCE,
    ASSIGNED;

    public static DeviceStatus getDeviceStatus(String deviceStatus) {
        if (deviceStatus.equalsIgnoreCase("online")) {
            return DeviceStatus.ONLINE;
        } else if (deviceStatus.equalsIgnoreCase("offline")) {
            return DeviceStatus.OFFLINE;
        } else if (deviceStatus.equalsIgnoreCase("in_maintenance")) {
            return DeviceStatus.IN_MAINTENANCE;
        } else if (deviceStatus.equalsIgnoreCase("assigned")) {
            return DeviceStatus.ASSIGNED;
        } else {
            throw new BadRequestException("Invalid device status, must be ONLINE, OFFLINE, IN_MAINTENANCE or ASSIGNED");
        }
    }
}
