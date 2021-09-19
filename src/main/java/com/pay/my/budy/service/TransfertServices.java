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

/**
 * <b>Voici la classe TransfertServices </b>
 * 
 *
 * 
 * @author Stevens
 * @version beta
 */
@Service
@Transactional(rollbackOn = Exception.class)
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
	
	
	/**
	 * 
	 * @param username nous permet de retrouver l'utilisateur en cours puis de mapper ses info en userDTO
	 * @return userDTO, retourne notre DTO
	 */
	public UserDTO DisplayInfotransfert(String username) {
		
		UserDTO userDTO = mapper.toDTO(userRepository.findByusername(username));	
		
		System.err.println(userDTO);
				
				return userDTO;
		
	}
	
	
	/**
	 * 
	 * @param username, l'utilisateur qui paye
	 * @param transfertDTO les infos types montant a payer et qui payer ce retrouve dans le transfert DTO
	 * @return  mapper.toDTO(userWhopay);, nous renvoi les infos a jour apres paiement pour la vue.
	 */
	public UserDTO transfertBis(String username, UserDTO transfertDTO) throws Exception {
		
		
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
				
				throw new Exception("just for test");

	
			}
			
					paymentRepository.save(transac);
					bankRepository.saveAll(listBankaccount);
			
		}
			return mapper.toDTO(userWhopay);
		
		
	}

}




















