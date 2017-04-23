package zyppys.com.customer.landing.packages;

/**
 * Created by Apple on 4/24/17.
 */

public class CarsSelectionModel {
    private int resourceID;
    private String carName;

    public CarsSelectionModel(int resourceID, String carName) {
        this.resourceID = resourceID;
        this.carName = carName;
    }

    public int getResourceID() {
        return resourceID;
    }

    public void setResourceID(int resourceID) {
        this.resourceID = resourceID;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }
}
