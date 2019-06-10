package com.neuedu.hismedicalsystem.model.service;

import com.neuedu.hismedicalsystem.model.mapper.BillMapper;
import com.neuedu.hismedicalsystem.model.po.Bill;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BillService {
    @Resource
    private BillMapper billMapper;

    public List<Bill> getUnpaidBills(Bill bill){
        return billMapper.getUnpaidBills(bill);
    }

    public List<Bill> getUndoneBills(Bill bill){
        return billMapper.getUndoneBills(bill);
    }

    public List<Bill> getBills(Bill bill){
        return billMapper.getBills(bill);
    }

    public void changeStateToPaid(int billId){
        billMapper.changeStateToPaid(billId);
    }

    public void refundBill(int billId){
        billMapper.deleteBill(billId);
    }
}
