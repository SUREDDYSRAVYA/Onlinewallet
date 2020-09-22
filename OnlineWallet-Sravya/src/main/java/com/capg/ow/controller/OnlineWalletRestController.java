package com.capg.ow.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.ow.entity.OnlineWallet;
import com.capg.ow.exception.OnlineWalletNotFoundException;
import com.capg.ow.service.OnlineWalletServiceImpl;

@RestController
@RequestMapping( "/onlinewallet" )
@CrossOrigin("http://localhost:4200")
public class OnlineWalletRestController {
	
		@Autowired
		OnlineWalletServiceImpl service;
		@PutMapping(path = "/add/{customerId}/{accountBalance}")
		public ResponseEntity<Boolean> addAmount(@PathVariable int customerId, @PathVariable int accountBalance)
				 {
			
			OnlineWallet onlinewallet = service.addAmount(customerId,accountBalance);
			ResponseEntity<Boolean> responseEntity = new ResponseEntity(true,HttpStatus.OK);
            System.out.println("response entity=" + responseEntity);
			return responseEntity;
		}
		
		
		@PostMapping(path = "/create")
		public ResponseEntity<OnlineWallet> createOnlineWallet(@RequestBody OnlineWallet onlinewalletbean)
				throws Exception {
			
			OnlineWallet onlinewallet = service.createOnlineWallet(onlinewalletbean);
			if (onlinewallet == null) {
				throw new OnlineWalletNotFoundException("Values should not be null");
			}

			return new ResponseEntity<OnlineWallet>(onlinewallet, new HttpHeaders(), HttpStatus.OK);
		}
		
		/* the findOnlineWalletById method is meant to show details of one particular id */

		@GetMapping(path = "/showBalance/{customerId}")
		public Optional<OnlineWallet> findOnlineWalletById(@PathVariable("customerId") int customerId)
		{
			System.out.println(customerId);
			Optional<OnlineWallet> onlinewallet = service.findOnlineWalletById(customerId);
			if (onlinewallet == null) {
				throw new OnlineWalletNotFoundException("onlinewallet not found for id");
			}else {
			return onlinewallet;
          
		}
			
			}
		@GetMapping(value = "/GetAllDetails")
		public ResponseEntity<List<OnlineWallet>> getAlldetails() {
			
			List<OnlineWallet> onlineewallet = service.getAlldetails();
			
			System.out.println(onlineewallet);
			return new ResponseEntity<List<OnlineWallet>>(onlineewallet, HttpStatus.OK);
}}
