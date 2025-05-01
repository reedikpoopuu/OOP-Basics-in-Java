public class LeaveRequest {
    //Properties
    private int requestId;
    private Employee employee;
    private String startDate;
    private String endDate;
    private String status; //"Pending", "Approved", "Denied"
    private String reason;

    //Constructor
    public LeaveRequest(int requestId, Employee employee, String startDate, String endDate, String reason) {
        this.requestId = requestId;
        this.employee = employee;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = "Pending";
        this.reason = reason;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    //Methods

    public int getDuration() {
        return Integer.parseInt(this.endDate) - Integer.parseInt(this.startDate);
    }
    public boolean processRequest() {
        System.out.println("Processing generic leave request...");
        return true;
    }
}