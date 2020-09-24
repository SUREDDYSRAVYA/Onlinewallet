package com.capg.ow.service;

import java.util.List;
import java.util.Optional;

import com.capg.ow.entity.OnlineWallet;

public interface IOnlineWalletService {
public OnlineWallet createOnlineWallet(OnlineWallet onlinewalletbean);
    public OnlineWallet addAmount(int customerId,int accountBalance);
   public OnlineWallet  findOnlineWalletById(int customerId );
    List<OnlineWallet> getAlldetails();
}


   
