package infinite.HibernateFetching;

public class CR extends subclass{
	private int ComplaintID;
	private String ComplaintType;
	private String CDescription;
	private String Severity;
	public int getComplaintID() {
		return ComplaintID;
	}
	public void setComplaintID(int complaintID) {
		ComplaintID = complaintID;
	}
	public String getComplaintType() {
		return ComplaintType;
	}
	public void setComplaintType(String complaintType) {
		ComplaintType = complaintType;
	}
	public String getCDescription() {
		return CDescription;
	}
	public void setCDescription(String cDescription) {
		CDescription = cDescription;
	}
	public String getSeverity() {
		return Severity;
	}
	public void setSeverity(String severity) {
		Severity = severity;
	}
	
	
}
