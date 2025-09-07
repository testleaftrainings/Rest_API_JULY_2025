package week4.day2.servicenow.pojos;

import com.google.gson.annotations.SerializedName;

public class Root {

	@SerializedName("result")
	private IncidentSysId incidentSysId;

	public IncidentSysId getIncidentSysId() {
		return incidentSysId;
	}

	public void setIncidentSysId(IncidentSysId incidentSysId) {
		this.incidentSysId = incidentSysId;
	}

}