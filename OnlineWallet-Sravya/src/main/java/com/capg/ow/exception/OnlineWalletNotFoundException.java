package com.capg.ow.exception;

public class OnlineWalletNotFoundException extends RuntimeException {
	 public OnlineWalletNotFoundException(String msg){
	        super(msg);
	    }

	    public OnlineWalletNotFoundException(String msg,Throwable e){
	        super(msg,e);
	    }
}
