package org.fuzzydb.samples.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import likemynds.db.DbObject;
import likemynds.db.KeyFactory;
import likemynds.db.query.SortableString;

import org.springframework.data.annotation.Id;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.wwm.db.annotations.Key;


public class WhirlwindUserDetails extends DbObject implements UserDetails {

	private static final long serialVersionUID = 1L;

	@Id
	@Key(unique=true)
	private SortableString email;

	private final String firstName;

	private final String lastName;

	private final ArrayList<? extends GrantedAuthority> authorities;

	private final String password;

	private final String username;

	private final boolean accountNonExpired = true;

	private final boolean accountNonLocked = true;

	private boolean credentialsNonExpired;

	private boolean enabled;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public WhirlwindUserDetails(String username, String password,
			String firstName, String lastName,
			Collection<? extends GrantedAuthority> authorities) {
		email = KeyFactory.valueOf(username);
		this.firstName = firstName;
		this.lastName = lastName;
		this.authorities = new ArrayList(authorities);
		this.password = password;
		this.username = username;
	}

	public WhirlwindUserDetails(String username, String password,
			String firstName, String lastName) {
		this(username, password, null, null, Collections.singletonList(new SimpleGrantedAuthority("USER")) );
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	
	public String getEmail() {
		return email.getValue();
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}
	
	public void setEmail(String email) {
		this.email = KeyFactory.valueOf(email);
	}
	
	static public WhirlwindUserDetails createEnabledUser(String email,
			String password) {
		WhirlwindUserDetails userDetails = new WhirlwindUserDetails(email, password, null, null);
		return userDetails;
	}
}
