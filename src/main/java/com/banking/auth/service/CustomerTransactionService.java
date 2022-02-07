package com.banking.auth.service;

import com.banking.auth.entities.CustomerTransaction;

public interface CustomerTransactionService {

	CustomerTransaction addsenderlogs(CustomerTransaction senderTransaction);

	CustomerTransaction addreceiverlogs(CustomerTransaction receiverTransaction);

}
