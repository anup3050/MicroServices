package com.example.rest.websevices.restfullwebservice.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> userList = new ArrayList<>();

	private Integer countUserId = 3;

	static {
		userList.add(new User(1, "Adam", new Date()));
		userList.add(new User(2, "Eve", new Date()));
		userList.add(new User(3, "Jack", new Date()));
	}

	public List<User> findAll() {

		return userList;
	}

	public User save(User user) {
		if (user.getUserId() == null)
			user.setUserId(countUserId++);

		userList.add(user);
		return user;
	}

	public User findOne(Integer id) {

		ListIterator<User> ltr = userList.listIterator();

		while (ltr.hasNext()) {
			User user = null;
			if ((user = ltr.next()).getUserId() == id) {
				return user;
			}
		}
		return null;
	}

	public User deleteUserById(Integer id) {

		ListIterator<User> ltr = userList.listIterator();

		while (ltr.hasNext()) {
			User user = ltr.next();
			if (user.getUserId() == id) {
				ltr.remove();
				return user;
			}
		}
		return null;
	}

}
