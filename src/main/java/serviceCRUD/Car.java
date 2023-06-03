package serviceCRUD;

import lombok.Data;

@Data
public class Car {

    private int id;
    private String car_model;
    private String car_number;
    private String vin;
    private int production_year;
    private int car_mileage;
    private String customer;
    private String breaking;
    private int service_id;

    public Car(int id, String car_model, String car_number, String vin, int production_year, int car_mileage, String customer, String breaking, int service_id) {
        this.id = id;
        this.car_model = car_model;
        this.car_number = car_number;
        this.vin = vin;
        this.production_year = production_year;
        this.car_mileage = car_mileage;
        this.customer = customer;
        this.breaking = breaking;
        this.service_id = service_id;
    }

    public Car() {
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", car_model='" + car_model + '\'' +
                ", car_number='" + car_number + '\'' +
                ", vin='" + vin + '\'' +
                ", production_year=" + production_year +
                ", car_mileage=" + car_mileage +
                ", customer='" + customer + '\'' +
                ", breaking='" + breaking + '\'' +
                ", service_id=" + service_id +
                '}';
    }
}
