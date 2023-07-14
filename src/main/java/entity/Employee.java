package entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "employees")
public class Employee {

    //    Поля ******************************************************
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employeeIdGenerator")
    @SequenceGenerator(name = "employeeIdGenerator", sequenceName = "employee_id_sequence", initialValue = 12, allocationSize = 1)
    @Column(name = "employee_id")
    private int employeeId;
    @Column(name = "contract_number")
    private String contractNumber;
    @Column(name = "position")
    private String position;

    //  Связи с другими таблицами **************************************
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "human_id")
    private Human humanInfo;

    @OneToMany(mappedBy = "employee")
    private List<Subscription> subscriptions;


    public Employee() {
    }

    public Employee(String contractNumber, String position) {
        this.contractNumber = contractNumber;
        this.position = position;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Human getHumanInfo() {
        return humanInfo;
    }
    public void setHumanInfo(Human humanInfo) {
        this.humanInfo = humanInfo;
    }

    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(List<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", contractNumber='" + contractNumber + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
