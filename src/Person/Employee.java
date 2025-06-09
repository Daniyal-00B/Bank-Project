package Person;
import Bank.Branch;
public class Employee extends Person {
    private String employeeCode;
    private long salary;
    private String workplace;
    private static int employeeCounter = 0;

    public Employee(String workplace, int type, int bankCode, int branchCode){
        super(type);
        setEmployeeCode(type, bankCode, branchCode);
        setSalary();
        setWorkplace(workplace);
    }

    // mail
    public void history(){}
    public void handlingRequests(){}

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary() {
        System.out.print("Salary: ");
        salary = scanner.nextInt();
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(int type, int bankCode, int branchCode) {
        employeeCounter++;
        bankCode++;
        branchCode++;
        employeeCode = type + "." +bankCode + "." +branchCode + "." +employeeCounter;
    }

    //    public void printInfo(){
        public String fullName = getFirstName() + " " + getLastName();
    //}

    public void userMenu(){
        int role = Integer.parseInt(getEmployeeCode().substring(0,1));
        int range=1;
        if(role == 3) {
            System.out.println("1. Loan requests\n2. Delete customer account");
            range = 2;
        }
        if (role == 2){
            System.out.println("1. Banking requests");
        }

        if(role ==1) {
            System.out.println("1. Banking Requests\n2. Block customer account\n3. Employee list");
            range = 3;
        }
        System.out.println("0. Exit\nEnter your choice:");
        int choice = scanner.nextInt();
        if (choice<0 || choice>range) {
            System.out.println("Invalid choice");
            userMenu();

        }else {
            choice *= range;
            switch (choice) {
                case 0 ->{}
                case 1 -> {
                    // Assist Banking request
                    handlingRequests();
                }
                case 2-> {
                    // Teller Loan Request
                    handlingRequests();
                }
                case 3 ->{
                    // Manage Banking request
                    handlingRequests();
                }
                case 4 ->{
                    // Teller Deleter customer account

                }
                case 6 ->{
                    //Manage Block customer
                }
                case 9 ->{
                    //Employee list
                }
                default -> System.out.println("Invalid choice");
            }
        }


    }
}