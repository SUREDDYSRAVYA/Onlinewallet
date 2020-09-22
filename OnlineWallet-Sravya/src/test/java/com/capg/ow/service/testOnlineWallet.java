package com.capg.ow.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.capg.ow.entity.OnlineWallet;
import com.capg.ow.repository.OnlineWalletJpaRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class testOnlineWallet {
	@Autowired
	 private IOnlineWalletService service;
	@MockBean
	private OnlineWalletJpaRepo repo;
	@Test
	public void walletcreatetest()
	{
		OnlineWallet bean = new OnlineWallet();
	     
	      bean.setCustomerPassword("1234s");
	      bean.setCustomerName("Ravikumar");
	      bean.setAccountBalance(2100);
	      Mockito.when(((IOnlineWalletService) repo).createOnlineWallet(bean)).thenReturn(bean);
	      assertThat(service.createOnlineWallet(bean)).isEqualTo(bean);
		
	}
	@Test
  public void showBalancetest()
  	{
		OnlineWallet bean = new OnlineWallet();
       bean.setCustomerId(188);
	      bean.setAccountBalance(2100);
	      Mockito.when(((IOnlineWalletService) repo).addAmount(bean.getCustomerId(),bean.getAccountBalance())).thenReturn(bean);
	        assertThat(service.addAmount(bean.getCustomerId(),bean.getAccountBalance())).isEqualTo(bean);
		
}
}
