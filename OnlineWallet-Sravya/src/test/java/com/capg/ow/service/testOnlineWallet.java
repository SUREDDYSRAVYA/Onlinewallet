package com.capg.ow.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;
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
	 private OnlineWalletServiceImpl service;
	@MockBean
	private OnlineWalletJpaRepo repository;
	@Test
	public void testCreatewallet() {
	
		OnlineWallet bean = new OnlineWallet();
	     bean.setCustomerId(188);
	      bean.setCustomerPassword("123s");
	      bean.setCustomerName("Ravikumar");
	      bean.setAccountBalance(2200);
	      Mockito.when(repository.save(bean)).thenReturn(bean);
	      assertEquals(bean,service.createOnlineWallet(bean));
		
	}
	
	@Test
	public void getAlldetails() {
		OnlineWallet bean1 = new OnlineWallet();
		bean1.setCustomerId(192);
		bean1.setCustomerPassword("siri1234");
		bean1.setCustomerName("Aruna");
		bean1.setAccountBalance(10);
		
		OnlineWallet bean2 = new OnlineWallet();
		bean2.setCustomerId(193);
		bean2.setCustomerPassword("siri1234");
		bean2.setCustomerName("chinnu");
		bean2.setAccountBalance(1440);
		List<OnlineWallet> list= new ArrayList<>();
		list.add(bean1);
		list.add(bean2);
		Mockito.when(repository.findAll()).thenReturn(list);
		assertThat(service.getAlldetails()).isEqualTo(list);
		assertEquals(list.size(),2);
	}
}
