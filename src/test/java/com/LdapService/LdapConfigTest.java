package com.LdapService;

import static org.mockito.Mockito.*;
import com.LdapService.LdapConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.test.context.TestPropertySource;
import org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@TestPropertySource(properties = {"{ldap.url}"})
@TestPropertySource(properties = {"{ldap.userDn}"})
@TestPropertySource(properties = {"{ldap.password}"})
public class LdapConfigTest {

	@Mock
	private LdapContextSource ldapContextSource;

	@InjectMocks
	private LdapConfig ldapConfig;

	@Test
	public void testContextSource() {
		// Act
		LdapContextSource result = ldapConfig.contextSource();

		// Assert
		Assertions.assertNotNull(result);

	}
}
