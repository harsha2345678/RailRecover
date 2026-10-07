package Train.Ticket.Recovery.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Ticket {

    @Id
    private String pnr;

    private String trainNumber;
    private String trainName;
    private String source;
    private String destination;
    private String journeyDate;
    private String passengerName;
    private double fare;
    private String status;

    private String recoveryStatus;

    // Suspicious Recovery Detection
    private int recoveryAttempts;

    public Ticket() {
    }

    public Ticket(String pnr, String trainNumber, String trainName,
                   String source, String destination, String journeyDate,
                   String passengerName, double fare, String status) {

        this.pnr = pnr;
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.source = source;
        this.destination = destination;
        this.journeyDate = journeyDate;
        this.passengerName = passengerName;
        this.fare = fare;
        this.status = status;
    }

    public String getPnr() {
        return pnr;
    }

    public void setPnr(String pnr) {
        this.pnr = pnr;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getJourneyDate() {
        return journeyDate;
    }

    public void setJourneyDate(String journeyDate) {
        this.journeyDate = journeyDate;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRecoveryStatus() {
        return recoveryStatus;
    }

    public void setRecoveryStatus(String recoveryStatus) {
        this.recoveryStatus = recoveryStatus;
    }

    public int getRecoveryAttempts() {
        return recoveryAttempts;
    }

    public void setRecoveryAttempts(int recoveryAttempts) {
        this.recoveryAttempts = recoveryAttempts;
    }
}