package com.capg.ow.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.ow.entity.OnlineWallet;
import com.capg.ow.repository.OnlineWalletJpaRepo;


@Service
public class OnlineWalletServiceImpl implements IOnlineWalletService {

		@Autowired
		OnlineWalletJpaRepo repository;
		
		@Override
		public OnlineWallet addAmount(int customerId, int accountBalance) {
			Optional<OnlineWallet> onlinewallet=repository.findById(customerId);
			OnlineWallet wallet = new OnlineWallet();
//			int amount= accountBalance+onlinewallet.get().getAccountBalance();
//			onlinewallet.get().setAccountBalance(amount);
			
			wallet.setCustomerId(onlinewallet.get().getCustomerId());
			wallet.setCustomerName(onlinewallet.get().getCustomerName());
			wallet.setAccountBalance(accountBalance+onlinewallet.get().getAccountBalance());
			wallet.setCustomerPassword(onlinewallet.get().getCustomerPassword());
			return repository.saveAndFlush(wallet);
		}
		
		
	    /* Creates the onlinewallet bean by taking the onlinewalletBean*/
		@Override
		public OnlineWallet createOnlineWallet(OnlineWallet onlinewalletbean) {
			// TODO Auto-generated method stub
			return repository.save(onlinewalletbean);
		}
		
	   /* shows the wallet of particular id*/
		@Override
		public Optional<OnlineWallet> findOnlineWalletById(int customerId ) {
			System.out.println(customerId);
			return repository.findById(customerId);
			
		}


		@Override
		public List<OnlineWallet> getAlldetails() {
			// TODO Auto-generated method stub
			return repository.findAll();
		}

		


		

}
