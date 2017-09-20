package com.example.diary.config;

import com.example.diary.domain.user.User;
import com.example.diary.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.StringUtils;

import java.util.Collection;

@Slf4j
public class UserAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private UserService userService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String id = authentication.getName();
		String password = (String) authentication.getCredentials();

		Collection<? extends GrantedAuthority> authorities = null;

		if (StringUtils.isEmpty(id) || StringUtils.isEmpty(password)) {
			throw new BadCredentialsException("Invalid Credential");
		}
		//UserDetails userDetails = User.withUsername(id).password(password).build();
		try {
			User user = userService.findOneByIdWithNullCheck(id);
			if (!user.getPasswd().equals(password)) {
				throw new BadCredentialsException("Invalid Credential");
			}
			//authorities = AuthorityUtils.commaSeparatedStringToAuthorityList("");

		} catch (UsernameNotFoundException e) {
			log.error(e.getMessage(),e);
			throw new UsernameNotFoundException(e.getMessage());
		} catch (BadCredentialsException e) {
			log.error(e.getMessage(),e);
			throw new BadCredentialsException(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new RuntimeException(e.getMessage());
		}
		//return new UsernamePasswordAuthenticationToken(id, password, authorities);
		return new UsernamePasswordAuthenticationToken(id, password);
	}

	@Override
	public boolean supports(Class<?> aClass) {
		return true;
	}

}
