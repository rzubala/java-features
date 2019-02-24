package com.zubala.rafal.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.zubala.rafal.model.Address;
import com.zubala.rafal.model.Country;
import com.zubala.rafal.model.User;

//Tests from: https://stackify.com/optional-java/

public class OptionalTest {

	public static final Logger logger = Logger.getLogger("com.zubala.rafal.test.OptionalTest");

	@BeforeAll
	public static void init() throws Exception {
		BasicConfigurator.configure();
	}

	@Test
	public void whenCreateOfNullableOptional_thenOk() {
		String name = "John";
		Optional<String> opt = Optional.ofNullable(name);

		assertEquals("John", opt.get());
	}

	@Test
	public void whenCheckIfPresent_thenOk() {
		User user = new User("john@gmail.com", "1234");
		Optional<User> opt = Optional.ofNullable(user);

		assertTrue(opt.isPresent());
		assertEquals(user.getEmail(), opt.get().getEmail());
		opt.ifPresent(u -> assertEquals(user.getEmail(), u.getEmail()));
	}

	@Test
	public void whenEmptyValue_thenReturnDefault() {
		User user = null;
		User user2 = new User("anna@gmail.com", "1234");
		User result = Optional.ofNullable(user).orElse(user2);

		assertEquals(user2.getEmail(), result.getEmail());
	}

	@Test
	public void whenValueNotNull_thenIgnoreDefault() {
		User user = new User("john@gmail.com", "1234");
		User user2 = new User("anna@gmail.com", "1234");
		User result = Optional.ofNullable(user).orElse(user2);

		assertEquals("john@gmail.com", result.getEmail());
	}

	@Test
	public void givenEmptyValue_whenCompare_thenOk() {
		User user = null;
		logger.debug("Using orElse");
		User result = Optional.ofNullable(user).orElse(createNewUser());
		logger.debug("Using orElseGet");
		User result2 = Optional.ofNullable(user).orElseGet(() -> createNewUser());
	}

	@Test
	public void givenPresentValue_whenCompare_thenOk() {
		User user = new User("john@gmail.com", "1234");
		logger.info("Using orElse");
		User result = Optional.ofNullable(user).orElse(createNewUser()); // launch createNewUser
		logger.info("Using orElseGet");
		User result2 = Optional.ofNullable(user).orElseGet(() -> createNewUser()); // don't launch createNewUser
	}

	private User createNewUser() {
		logger.debug("Creating New User");
		return new User("extra@gmail.com", "1234");
	}

	@Test
	public void whenThrowException_thenOk() {
		User user = null;
		assertThrows(IllegalArgumentException.class, () -> {
			User result = Optional.ofNullable(user).orElseThrow(() -> new IllegalArgumentException());
		});
	}

	@Test
	public void whenMap_thenOk() {
		User user = new User("anna@gmail.com", "1234");
		// map return Optional
		String email = Optional.ofNullable(user).map(u -> u.getEmail()).orElse("default@gmail.com");

		assertEquals(email, user.getEmail());
	}

	@Test
	public void whenFlatMap_thenOk() {
		User user = new User("anna@gmail.com", "1234");
		user.setPosition("Developer");
		// flatMap does not return Optional but getPosition does
		String position = Optional.ofNullable(user).flatMap(u -> u.getPosition()).orElse("default");

		assertEquals(position, user.getPosition().get());
	}

	@Test
	public void whenFilter_thenOk() {
		User user = new User("anna@gmail.com", "1234");
		Optional<User> result = Optional.ofNullable(user)
				.filter(u -> u.getEmail() != null && u.getEmail().contains("@"));

		assertTrue(result.isPresent());
	}

	@Test
	public void whenChaining_thenOk() {
		User user = new User("anna@gmail.com", "1234");

		String result = Optional.ofNullable(user).flatMap(u -> u.getAddress()).flatMap(a -> a.getCountry())
				.map(c -> c.getIsoCode()).orElse("default");

		assertEquals(result, "default");

		String result2 = Optional.ofNullable(user).flatMap(User::getAddress).flatMap(Address::getCountry)
				.map(Country::getIsoCode).orElse("default");
		assertEquals(result2, "default");
	}

	@Test
	public void whenEmptyOptional_thenGetValueFromOr() {
		User user = null;
		User result = Optional.ofNullable(user).or(() -> Optional.of(new User("default", "1234"))).get();

		assertEquals(result.getEmail(), "default");

		Optional.ofNullable(user).ifPresentOrElse(u -> logger.info("User is:" + u.getEmail()),
				() -> logger.info("User not found"));
	}

	@Test
	public void whenGetStream_thenOk() {
		User user = new User("john@gmail.com", "1234");
		List<String> emails = Optional.ofNullable(user)
				.stream()
				.filter(u -> u.getEmail() != null && u.getEmail().contains("@"))
				.map(u -> u.getEmail())
				.collect(Collectors.toList());

		assertTrue(emails.size() == 1);
		assertEquals(emails.get(0), user.getEmail());
	}
	
	@Test
	public void whenEmptyStream_thenReturnDefaultOptional() {
	    List<User> users = new ArrayList<>();
	    User user = users.stream().findFirst().orElse(new User("default", "1234"));
	    
	    assertEquals(user.getEmail(), "default");
	}	
}
