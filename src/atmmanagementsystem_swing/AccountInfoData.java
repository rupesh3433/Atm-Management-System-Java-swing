/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atmmanagementsystem_swing;

/**
 *
 * @author Dell
 */
public class AccountInfoData {
    private String accountNumber;
    private String holderName;
    private String address;
    private String email;
    private String phoneNumber;
    private String dateOfBirth;
    private String citizenship;
    private String gender;
    private String accountType;

    // Constructors
    public AccountInfoData(String accountNumber, String holderName, String accountType, String phoneNumber, String address, String email, String citizenship, String dob, String gender) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dob;
        this.citizenship = citizenship;
        this.gender = gender;
        this.accountType = accountType;
    }

    public AccountInfoData() {
        // Default constructor
    }

    // Getter and Setter methods
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

   public String getDateOfBirth() {
       return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    // toString method (optional for debugging purposes)
    @Override
    public String toString() {
        return "AccountInfoData{" +
                "accountNumber='" + accountNumber + '\'' +
                ", holderName='" + holderName + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", citizenship='" + citizenship + '\'' +
                ", gender='" + gender + '\'' +
                ", accountType='" + accountType + '\'' +
                '}';
    }
}
