public class DepartmentService {
    private DepartmentDAO departmentDAO;

    public DepartmentService() {
        this.departmentDAO = new DepartmentDAO();
    }

    public void listDepartmentStatistics() {
        try {
            List<DepartmentStatistics> departmentStatisticsList = departmentDAO.getDepartmentStatistics();
            for (DepartmentStatistics departmentStatistics : departmentStatisticsList) {
                System.out.println("Department: " + departmentStatistics.getDepartment().getDname());
                System.out.println("Average Salary: " + departmentStatistics.getAverageSalary());
                System.out.println("Number of Employees: " + departmentStatistics.getNumberOfEmployees());
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle any exceptions or display an error message
        }
    }
}
