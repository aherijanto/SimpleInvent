package com.example.simpleinvent.model;

import java.util.ArrayList;

public class HeadOrderModel {
    private String noTrans;
    private String dateTrans;
    private ArrayList<DetailOrderModel> orderDetail;

    public HeadOrderModel() {
    }

    public HeadOrderModel(String noTrans, String dateTrans, ArrayList<DetailOrderModel> orderDetail) {
        this.noTrans = noTrans;
        this.dateTrans = dateTrans;
        this.orderDetail = orderDetail;
    }

    public String getNoTrans() {
        return noTrans;
    }

    public void setNoTrans(String noTrans) {
        this.noTrans = noTrans;
    }

    public String getDateTrans() {
        return dateTrans;
    }

    public void setDateTrans(String dateTrans) {
        this.dateTrans = dateTrans;
    }

    public ArrayList<DetailOrderModel> getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(ArrayList<DetailOrderModel> orderDetail) {
        this.orderDetail = orderDetail;
    }
}
