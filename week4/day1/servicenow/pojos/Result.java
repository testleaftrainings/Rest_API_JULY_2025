package week4.day1.servicenow.pojos;

import com.google.gson.annotations.SerializedName;

public class Result {

	@SerializedName(value = "sys_id")
    private String sysId;
    private String number;
    @SerializedName(value = "short_description")
    private String shortDescription;
    private String description;
    private String category;   

    public String getSysId() {
        return sysId;
    }

    public void setSysId(String sysId) {
        this.sysId = sysId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }    

}