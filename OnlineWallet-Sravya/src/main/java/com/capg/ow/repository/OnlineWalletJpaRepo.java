package com.capg.ow.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.capg.ow.entity.OnlineWallet;

@Repository
public interface OnlineWalletJpaRepo extends JpaRepository<OnlineWallet, Integer>{

	
}
