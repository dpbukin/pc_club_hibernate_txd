package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "subscriptions")
public class Subscription {

//    Поля ******************************************************

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subscriptionIdGenerator")
    @SequenceGenerator(name = "subscriptionIdGenerator", sequenceName = "subscription_id_sequence", initialValue = 14, allocationSize = 1)
    @Column(name = "subscription_id")
    private int subscriptionId;
    @Column(name = "unique_subscription_number")
    private String uniqueSubscriptionNumber;
    @Column(name = "type")
    private String type;
    @Column(name = "cost")
    private int cost;
    @Column(name = "validity_period")
    private String validityPeriod;
    @Column(name = "registration_date")
    private String registrationDate;
    @Column(name = "status")
    private String status;


//  Связи с другими таблицами **************************************

    @OneToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.REMOVE})
    @JoinColumn(name = "computer_id")
    private Computer computer;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private Client client;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.REMOVE})
    @JoinColumn(name = "comp_club_id")
    private ComputerClub computerClub;

    public Subscription() {
    }

    public Subscription(String uniqueSubscriptionNumber, String type, int cost, String validityPeriod, String registrationDate, String status) {
        this.uniqueSubscriptionNumber = uniqueSubscriptionNumber;
        this.type = type;
        this.cost = cost;
        this.validityPeriod = validityPeriod;
        this.registrationDate = registrationDate;
        this.status = status;
    }


    public int getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(int subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public String getUniqueSubscriptionNumber() {
        return uniqueSubscriptionNumber;
    }

    public void setUniqueSubscriptionNumber(String uniqueSubscriptionNumber) {
        this.uniqueSubscriptionNumber = uniqueSubscriptionNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getValidityPeriod() {
        return validityPeriod;
    }

    public void setValidityPeriod(String validityPeriod) {
        this.validityPeriod = validityPeriod;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public ComputerClub getComputerClub() {
        return computerClub;
    }

    public void setComputerClub(ComputerClub computerClub) {
        this.computerClub = computerClub;
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "subscriptionId=" + subscriptionId +
                ", uniqueSubscriptionNumber='" + uniqueSubscriptionNumber + '\'' +
                ", type='" + type + '\'' +
                ", cost=" + cost +
                ", validityPeriod='" + validityPeriod + '\'' +
                ", registrationDate='" + registrationDate + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
