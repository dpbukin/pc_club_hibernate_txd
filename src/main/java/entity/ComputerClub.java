package entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "computer_clubs")
public class ComputerClub {

    //    Поля ******************************************************
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clubIdGenerator")
    @SequenceGenerator(name = "clubIdGenerator", sequenceName = "club_id_sequence", initialValue = 8, allocationSize = 1)
    @Column(name = "club_id")
    private int clubId;
    @Column(name = "room_rental_agreement_number")
    private String roomRentalAgreementNumber;
    @Column(name = "region")
    private String region;
    @Column(name = "city")
    private String city;
    @Column(name = "street")
    private String street;
    @Column(name = "building")
    private int building;
    @Column(name = "job_status")
    private String jobStatus;
    @Column(name = "office_number")
    private int officeNumber;

    //  Связи с другими таблицами **************************************

    @OneToMany(mappedBy = "computerClub")
    private List<Computer> computers;

    @OneToMany(mappedBy = "computerClub")
    private List<Subscription> subscriptions;

    public ComputerClub() {
    }

    public ComputerClub(String roomRentalAgreementNumber, String region, String city, String street, int building, String jobStatus, int officeNumber) {
        this.roomRentalAgreementNumber = roomRentalAgreementNumber;
        this.region = region;
        this.city = city;
        this.street = street;
        this.building = building;
        this.jobStatus = jobStatus;
        this.officeNumber = officeNumber;
    }

    public int getClubId() {
        return clubId;
    }

    public void setClubId(int clubId) {
        this.clubId = clubId;
    }

    public String getRoomRentalAgreementNumber() {
        return roomRentalAgreementNumber;
    }

    public void setRoomRentalAgreementNumber(String roomRentalAgreementNumber) {
        this.roomRentalAgreementNumber = roomRentalAgreementNumber;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getBuilding() {
        return building;
    }

    public void setBuilding(int building) {
        this.building = building;
    }

    public String getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

    public int getOfficeNumber() {
        return officeNumber;
    }

    public void setOfficeNumber(int officeNumber) {
        this.officeNumber = officeNumber;
    }


    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public List<Computer> getComputers() {
        return computers;
    }

    public void setComputers(List<Computer> computers) {
        this.computers = computers;
    }

    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(List<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }

    @Override
    public String toString() {
        return "ComputerClub{" +
                "clubId=" + clubId +
                ", roomRentalAgreementNumber='" + roomRentalAgreementNumber + '\'' +
                ", region='" + region + '\'' +
                ", city='" + city + '\'' +
                ", building=" + building +
                ", jobStatus='" + jobStatus + '\'' +
                ", officeNumber=" + officeNumber +
                '}';
    }
}
