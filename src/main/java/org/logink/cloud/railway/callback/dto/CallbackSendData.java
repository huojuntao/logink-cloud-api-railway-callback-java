package org.logink.cloud.railway.callback.dto;

public class CallbackSendData {

	private String taskId;
	private String freightTransportStationName; //当前到站
	private String dateTime;
	
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public String getFreightTransportStationName() {
		return freightTransportStationName;
	}
	public void setFreightTransportStationName(String freightTransportStationName) {
		this.freightTransportStationName = freightTransportStationName;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	@Override
	public String toString() {
		return "CallbackSendData [taskId=" + taskId + ", freightTransportStationName=" + freightTransportStationName
				+ ", dateTime=" + dateTime + "]";
	}
	
}
