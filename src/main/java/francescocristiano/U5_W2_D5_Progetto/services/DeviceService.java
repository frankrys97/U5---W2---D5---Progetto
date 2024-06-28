package francescocristiano.U5_W2_D5_Progetto.services;

import francescocristiano.U5_W2_D5_Progetto.entities.Device;
import francescocristiano.U5_W2_D5_Progetto.entities.Employee;
import francescocristiano.U5_W2_D5_Progetto.enums.DeviceStatus;
import francescocristiano.U5_W2_D5_Progetto.enums.DeviceType;
import francescocristiano.U5_W2_D5_Progetto.exceptions.NotFoundException;
import francescocristiano.U5_W2_D5_Progetto.payloads.NewDeviceDTO;
import francescocristiano.U5_W2_D5_Progetto.repositories.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    @Autowired
    private EmployeeService employeeService;

    public Device saveDevice(NewDeviceDTO devicePayload) {
        Employee employee = null;
        if (devicePayload.employeeId() != null) {
            employee = employeeService.findEmployeeById(devicePayload.employeeId());
        }
        Device newDevice = new Device(DeviceType.getDeviceType(devicePayload.deviceType()), DeviceStatus.getDeviceStatus(devicePayload.deviceStatus()), employee);
        return deviceRepository.save(newDevice);
    }

    public Device findDeviceById(UUID id) {
        return deviceRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }


    public Page<Device> findAllDevices(int page, int size, String sortBy) {
        if (size > 100) size = 100;
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return deviceRepository.findAll(pageable);
    }

    public Device findDeviceByIdAndUpdate(UUID id, NewDeviceDTO updatedDevicePayload) {
        Device updatedDevice = new Device(DeviceType.getDeviceType(updatedDevicePayload.deviceType()), DeviceStatus.getDeviceStatus(updatedDevicePayload.deviceStatus()), updatedDevicePayload.employeeId() != null ? employeeService.findEmployeeById(updatedDevicePayload.employeeId()) : null);
        Device foundDevice = findDeviceById(id);
        foundDevice.setDeviceType(updatedDevice.getDeviceType());
        foundDevice.setDeviceStatus(updatedDevice.getDeviceStatus());
        foundDevice.setEmployee(updatedDevice.getEmployee());
        return deviceRepository.save(foundDevice);
    }

    public void deleteDeviceById(UUID id) {
        deviceRepository.deleteById(id);
    }
}
