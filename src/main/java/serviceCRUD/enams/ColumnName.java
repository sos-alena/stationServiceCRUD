package serviceCRUD.enams;

public enum ColumnName {

    ID ("id"),
    MODEL ("car_model"),
    NUMBER ("car_number"),
    VIN ("vin"),
    YEAR ("production_year"),
    MILEAGE ("car_mileage"),
    CUSTOMER ("customer"),
    BREAKING ("breaking"),
    SERVICE ("services_id");

    private final String title;

    ColumnName(String title) {
        this.title = title;
    }


    public String getTitle() {
        return title;
    }
}
