package az.ingress.turboapi.models.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class CarOptions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean alloyWheels;
    private boolean centralClosure;
    private boolean leatherSalon;
    private boolean seatVentilation;
    private boolean abs;
    private boolean parkingRadar;
    private boolean xenonLamps;
    private boolean luke;
    private boolean conditioners;
    private boolean rearViewCamera;
    private boolean rainSensor;
    private boolean seatHeating;
    private boolean sideCurtains;

}