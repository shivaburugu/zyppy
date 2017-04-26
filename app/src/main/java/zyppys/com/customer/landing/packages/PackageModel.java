package zyppys.com.customer.landing.packages;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Apple on 4/23/17.
 */

public class PackageModel implements Parcelable{
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

    protected PackageModel(Parcel in) {
        imgURL = in.readString();
        name = in.readString();
        totalAmt = in.readString();
        baseFare = in.readString();
        serviceTax = in.readString();
    }

    public static final Creator<PackageModel> CREATOR = new Creator<PackageModel>() {
        @Override
        public PackageModel createFromParcel(Parcel in) {
            return new PackageModel(in);
        }

        @Override
        public PackageModel[] newArray(int size) {
            return new PackageModel[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(imgURL);
        parcel.writeString(name);
        parcel.writeString(totalAmt);
        parcel.writeString(baseFare);
        parcel.writeString(serviceTax);
    }
}
