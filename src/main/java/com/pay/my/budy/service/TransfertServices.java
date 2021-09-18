package com.pay.my.budy.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pay.my.budy.dto.Mapper;
import com.pay.my.budy.dto.UserDTO;
import com.pay.my.budy.model.Bankaccount;
import com.pay.my.budy.model.Transactions;
import com.pay.my.budy.model.User;
import com.pay.my.budy.repository.BankaccountRepository;
import com.pay.my.budy.repository.PaymentRepository;
import com.pay.my.budy.repository.UserRepository;


@Service
public class TransfertServices {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RelationShipServices relationServices;
	
	@Autowired
	PaymentRepository paymentRepository;
	
	@Autowired
	BankaccountRepository bankRepository;

	@Autowired
	Calcul calcul;
	
	@Autowired
	Mapper mapper;
	
	public UserDTO DisplayInfotransfert(String username) {
		
		UserDTO userDTO = mapper.toDTO(userRepository.findByusername(username));	
		
		System.err.println(userDTO);
				
				return userDTO;
		
	}
	
	
	
	@Transactional
	public void transfertBis(String username, UserDTO transfertDTO) {
		
		
		User userWhopay = userRepository.findByusername(username);
		User userReciep = userRepository.findByusername(transfertDTO.getFriend());
		
		Transactions transac = new Transactions();
		
		Bankaccount bankWhoPay;
		Bankaccount bankReciep;
		
		
			
		for (int i = 0; i < userWhopay.getBankaccount().size(); i++) {
			
			List<Bankaccount> listBankaccount = new ArrayList<Bankaccount>();

			if (transfertDTO.getAmount() <= userWhopay.getBankaccount().get(i).getMoneyAvailable()) {
				
				double sommeLessFivePercent = calcul.fivePercent(transfertDTO.getAmount());
				LocalDate dayPayment = LocalDate.now();
				
				bankWhoPay = userWhopay.getBankaccount().get(i);
				bankReciep = userReciep.getBankaccount().get(i);
				transac = new Transactions();
				
				bankWhoPay.setDate(dayPayment);
				bankWhoPay.setMoneyAvailable(calcul.less(userWhopay.getBankaccount().get(i).getMoneyAvailable(), sommeLessFivePercent));
				
				
				bankReciep.setDate(dayPayment);
				bankReciep.setMoneyAvailable(calcul.add(userReciep.getBankaccount().get(i).getMoneyAvailable(), sommeLessFivePercent));

				
				transac.setAmount(sommeLessFivePercent);
				transac.setRecipient(userReciep.getId());
				transac.setFk_iduser(userWhopay.getId());
				transac.setDate(dayPayment);
				
				listBankaccount.add(bankReciep);
				listBankaccount.add(bankWhoPay);
				
	
			}
			
					paymentRepository.save(transac);
					bankRepository.saveAll(listBankaccount);
			
		}
		
		
	}

}




















