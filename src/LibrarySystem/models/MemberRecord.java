package LibrarySystem.models;

import java.time.LocalDate;

public class MemberRecord {
    private int memberId;
    private String memberType; // Örneğin: Öğrenci, Öğretim Üyesi, Genel
    private LocalDate dateOfMembership;
    private int noOfBooksIssued;
    private int maxBookLimit;
    private String name;
    private String address;
    private String phoneNo;
    private Reader reader; // İlişkili olduğu Reader nesnesi
    private static int nextMemberId = 1000; // Üye ID için başlangıç değeri


    public MemberRecord(Reader reader, String memberType, String address, String phoneNo, int maxBookLimit) {
        this.memberId = nextMemberId++;
        this.reader = reader;
        this.memberType = memberType;
        this.dateOfMembership = LocalDate.now();
        this.noOfBooksIssued = 0;
        this.maxBookLimit = maxBookLimit;
        this.name = reader.getName();
        this.address = address;
        this.phoneNo = phoneNo;
    }

    public int getMemberId() {
        return memberId;
    }

    public String getMemberType() {
        return memberType;
    }

    public LocalDate getDateOfMembership() {
        return dateOfMembership;
    }

    public int getNoOfBooksIssued() {
        return noOfBooksIssued;
    }

    public int getMaxBookLimit() {
        return maxBookLimit;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public Reader getReader() {
        return reader;
    }

    public void incBookIssued() {
        this.noOfBooksIssued++;
    }

    public void decBookIssued() {
        this.noOfBooksIssued--;
    }

    public void setMaxBookLimit(int maxBookLimit) {
        this.maxBookLimit = maxBookLimit;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Override
    public String toString() {
        return "Member ID: " + memberId + ", Name: " + name + ", Type: " + memberType +
                ", Membership Date: " + dateOfMembership + ", Books Issued: " + noOfBooksIssued +
                ", Max Limit: " + maxBookLimit;
    }

}