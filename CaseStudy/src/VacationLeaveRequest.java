public class VacationLeaveRequest extends LeaveRequest {
    private int vacationDays;

    public VacationLeaveRequest(int requestId, Employee employee,
                                String startDate, String endDate) {
        super(requestId, employee, startDate, endDate, "Vacation Leave");
        this.vacationDays = employee.getVacationDays();
    }

    @Override
    public boolean processRequest() {
        if (vacationDays > getDuration()) {
            vacationDays -= getDuration();
            System.out.println("Processing vacation leave request for " + getDuration() + "days... (" + vacationDays + " vacation days left)");
            return true;
        }
        System.out.println("You only have " + vacationDays + " left and therefore the request has been denied.");
        return false;
    }
}