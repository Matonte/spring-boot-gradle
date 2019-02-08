package com.javainuse;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

//@Repository
public class UserDAO {

	private static final Map<Long,User> USERS = new HashMap<>();
	
	static {
		initUsers();
	}
	
	private static void initUsers() {
		String encryptedSSN = "";
		
		LocalDate now = LocalDate.now();
		LocalDate yesterday = now.minus(Period.ofDays(1));
		String homeAddress = "6400 Shafer Ct; Rosemont, IL 60018";
		String mailAddress = "123 Main Street; Chicago, IL 60606";
		
		User sumeet = new User(1L, "Sumeet", "User1", yesterday, encryptedSSN, "user1@capgemini.com",
				"+15555555555", homeAddress, homeAddress, "Checking", 300, true);
		User chennaiah = new User(2L, "Chennaiah", "User2", now, encryptedSSN, "user2@capgemini.com",
				"+15558675309", homeAddress, mailAddress, "Savings", 200, true);
		User bill = new User(3L, "Bill", "User3", now, encryptedSSN, "user3@capgemini.com",
				"+12345678900", homeAddress, homeAddress, "CD", 2000, true);
		
		USERS.put(sumeet.getUserId(), sumeet);
		USERS.put(chennaiah.getUserId(), chennaiah);
		USERS.put(bill.getUserId(), bill);
	}
	
	public Long getMaxUserId() {
        long max = 0;
        for (Long id : USERS.keySet()) {
            if (id > max) {
                max = id;
            }
        }
        return max;
    }
	
	public User findAppUserByUserName(String userName) {
        Collection<User> appUsers = USERS.values();
        for (User u : appUsers) {
            if (u.getFirstName().equals(userName)) {
                return u;
            }
        }
        return null;
    }
	
	public static List<User> getUsers() {
        List<User> list = new ArrayList<>();
 
        list.addAll(USERS.values());
        return list;
    }
	
	public User createUser(UserForm form) {
        Long userId = this.getMaxUserId() + 1;
        //String encrytedSSN = this.SSNEncoder.encode(form.getSSN());
 
        User user = new User(userId, form.getFirstName(), form.getLastName(), form.getDOB(),
                form.getEncryptedSSN(), form.getEmail(), form.getMobileTelephone(),
                form.getHomeAddress(), form.getMailAddress(), form.getAccountType(),
                determineMinimumBalance(form.getAccountType()), form.isOpenAccount());
 
        USERS.put(userId, user);
        return user;
    }

	private int determineMinimumBalance(String accountType) {
		if(accountType.equals("Savings")) {
			return 200;
		} else if (accountType.equals("Checking")) {
			return 400;
		} else if (accountType.equals("CD")) {
			return 2000;
		} else return 0;
	}
}
