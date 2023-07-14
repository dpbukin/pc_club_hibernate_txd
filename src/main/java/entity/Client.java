package entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "clients")
public class Client {
    //    Поля ******************************************************
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clientGenerator")
    @SequenceGenerator(name = "clientGenerator", sequenceName = "client_id_sequence", initialValue = 14, allocationSize = 1)
    @Column(name = "client_id")
    private int clientId;

    @Column(name = "account_score")
    private int accountScore;

    //  Связи с другими таблицами **************************************

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "human_id")
    private Human humanInfo;

    @OneToMany(mappedBy = "client")
    private List<Subscription> subscriptions;

    public Client() {
    }

    public Client(int accountScore) {
        this.accountScore = accountScore;
    }

    //    public void addSubscriptionClient(Client client){
//        if (subscriptions == null){
//            subscriptions = new List<>();
//        }
//        subscriptions.add(client);
//        client.setSubscriptions(this);
//    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getAccountScore() {
        return accountScore;
    }

    public void setAccountScore(int accountScore) {
        this.accountScore = accountScore;
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
        return "Client{" +
                "clientId=" + clientId +
                ", accountScore=" + accountScore +
                '}';
    }
}
