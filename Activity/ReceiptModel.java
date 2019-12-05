package com.example.myapplication;

public class ReceiptModel {
    private String FaturaId;
    private String location;
    private String receipt_owner;
    private String receipt_tag_id;
    private String tax;
    private String totalcost;


    public ReceiptModel() {
    }

    public ReceiptModel(String faturaId,String location,String receipt_owner,String receipt_tag_id,String tax,String totalcost) {
        this.FaturaId = faturaId;
        this.location=location;
        this.receipt_owner=receipt_owner;
        this.receipt_tag_id=receipt_tag_id;
        this.tax=tax;
        this.totalcost=totalcost;


    }


    public String getReceipt_owner() {
        return receipt_owner;
    }

    public void setReceipt_owner(String receipt_owner) {
        this.receipt_owner = receipt_owner;
    }


    public String getReceipt_tag_id() {
        return receipt_tag_id;
    }

    public void setReceipt_tag_id(String receipt_tag_id) {
        this.receipt_tag_id = receipt_tag_id;
    }


    public String getTotalcost() {
        return totalcost;
    }

    public void setTotalcost(String totalcost) {
        this.totalcost = totalcost;
    }

    public String getTaxtax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }



    public String getFaturaId() {
        return FaturaId;
    }

    public void setFaturaId(String ReceiptId) {
        this.FaturaId = ReceiptId;
    }

    @Override
    public String toString() {
        return "Fis Fatura{" +
                "FaturaId='" + FaturaId + '\'' +
                ", location='" + location + '\'' +
                ", tag id='" + receipt_tag_id + '\'' +
                ", fatura sahibi=" + receipt_owner +
                ", tax='" + tax + '\'' +
                ", totalcost='" + totalcost + '\'' +
                '}';
    }


}