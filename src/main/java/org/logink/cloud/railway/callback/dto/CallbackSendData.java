package org.logink.cloud.railway.callback.dto;

/**
 * 
 * @ClassName: CallbackSendData
 * @Description: Updated Resource information class.
 * @author: yinjd
 * @date: 2017年8月7日 上午8:58:13
 *
 */

public class CallbackSendData {

	private String taskId;
	private String freightTransportBureauName;  //当前到达局
	private String freightTransportStationName; //当前到达站
	private String dateTime;
	private String arrivalMileage;
	
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
	
	public String getFreightTransportBureauName() {
		return freightTransportBureauName;
	}
	public void setFreightTransportBureauName(String freightTransportBureauName) {
		this.freightTransportBureauName = freightTransportBureauName;
	}
	public String getArrivalMileage() {
		return arrivalMileage;
	}
	public void setArrivalMileage(String arrivalMileage) {
		this.arrivalMileage = arrivalMileage;
	}
	@Override
	public String toString() {
		return "CallbackSendData [taskId=" + taskId + ", freightTransportBureauName=" + freightTransportBureauName
				+ ", freightTransportStationName=" + freightTransportStationName + ", dateTime=" + dateTime
				+ ", arrivalMileage=" + arrivalMileage + "]";
	}

}
