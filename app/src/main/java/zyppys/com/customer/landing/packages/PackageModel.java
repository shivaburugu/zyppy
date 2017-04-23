package zyppys.com.customer.landing.packages;

/**
 * Created by Apple on 4/23/17.
 */

public class PackageModel {
    private String imgURL;
    private String name;
    private String totalAmt;
    private String baseFare;
    private String serviceTax;

    public PackageModel(String imgURL, String name, String totalAmt, String baseFare, String serviceTax) {
        this.imgURL = imgURL;
        this.name = name;
        this.totalAmt = totalAmt;
        this.baseFare = baseFare;
        this.serviceTax = serviceTax;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTotalAmt() {
        return totalAmt;
    }

    public void setTotalAmt(String totalAmt) {
        this.totalAmt = totalAmt;
    }

    public String getBaseFare() {
        return baseFare;
    }

    public void setBaseFare(String baseFare) {
        this.baseFare = baseFare;
    }

    public String getServiceTax() {
        return serviceTax;
    }

    public void setServiceTax(String serviceTax) {
        this.serviceTax = serviceTax;
    }
}
