package com.example.proje.Model;


public class ReceiptModel {
    private String ReceiptId;
    private String ReceiptName;
    private String ReceiptImage;
    private String ReceiptComment;
    private String[] ReceiptTags;
    private String ReceiptCreated;
    private String ReceiptDate;
    private int ReceiptTotal;
    private int ReceiptTax;


    public ReceiptModel() {
    }

    public ReceiptModel(String ReceiptId, String ReceiptName, String ReceiptImage, String ReceiptComment, String[] ReceiptTags, String ReceiptCreated, String ReceiptDate) {
        this.ReceiptId = ReceiptId;
        this.ReceiptName = ReceiptName;
        this.ReceiptImage = ReceiptImage;
        this.ReceiptComment = ReceiptComment;
        this.ReceiptTags = ReceiptTags;
        this.ReceiptCreated = ReceiptCreated;
        this.ReceiptDate = ReceiptDate;

    }

    public int getReceiptTax() {
        return ReceiptTax;
    }

    public int getReceiptTotal() {
        return ReceiptTotal;
    }

    public void setReceiptTax(int receiptTax) {
        ReceiptTax = receiptTax;
    }

    public void setReceiptTotal(int receiptTotal) {
        ReceiptTotal = receiptTotal;
    }

    public String getReceiptId() {
        return ReceiptId;
    }

    public void setReceiptId(String ReceiptId) {
        this.ReceiptId = ReceiptId;
    }

    public String getReceiptName() {
        return ReceiptName;
    }

    public void setReceiptName(String ReceiptName) {
        this.ReceiptName = ReceiptName;
    }

    public String getReceiptImage() {
        return ReceiptImage;
    }

    public void setReceiptImage(String ReceiptImage) {
        this.ReceiptImage = ReceiptImage;
    }

    public String getReceiptComment() {
        return ReceiptComment;
    }

    public void setReceiptComment(String ReceiptComment) {
        this.ReceiptComment = ReceiptComment;
    }

    public String[] getReceiptTags() {
        return ReceiptTags;
    }

    public void setReceiptTags(String[] ReceiptTags) {
        this.ReceiptTags = ReceiptTags;
    }

    public String getReceiptCreated() {
        return ReceiptCreated;
    }

    public void setReceiptCreated(String ReceiptCreated) {
        this.ReceiptCreated = ReceiptCreated;
    }

    public String getReceiptDate() {
        return ReceiptDate;
    }

    public void setReceiptDate(String ReceiptDate) {
        this.ReceiptDate = ReceiptDate;
    }




    @Override
    public String toString() {
        return "FoodReceipt{" +
                "ReceiptId='" + ReceiptId + '\'' +
                ", ReceiptName='" + ReceiptName + '\'' +
                ", ReceiptImage='" + ReceiptImage + '\'' +
                ", ReceiptComment='" + ReceiptComment + '\'' +
                ", ReceiptTags=" + ReceiptTags +
                ", ReceiptCreated='" + ReceiptCreated + '\'' +
                ", ReceiptDate='" + ReceiptDate + '\'' +
                '}';
    }

    public String displayTags(){
        String showTags="";
        for(int i=0;i<ReceiptTags.length;i++)
            showTags += ReceiptTags[i] + " ";
        return showTags;
    }
}