package week4.day2.servicenow.pojos;

import com.google.gson.annotations.SerializedName;

public class IncidentSysId {
	
	@SerializedName("sys_id")
	private String sysId;
	private String category;

	public String getSysId() {
		return sysId;
	}	

	public String getCategory() {
		return category;
	}		
	
}