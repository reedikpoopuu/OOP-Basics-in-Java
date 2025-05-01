public class MaternityLeaveRequest extends LeaveRequest {
    private boolean vacationDays;

    public MaternityLeaveRequest(int requestId, Employee employee,
                                String startDate, String endDate) {
        super(requestId, employee, startDate, endDate, "Vacation Leave");
    }
}
