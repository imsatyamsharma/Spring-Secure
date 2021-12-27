package com.example.practice.services;

import com.example.practice.controller.userController.UserDetailsImpl1;
import com.example.practice.controller.userController.UserRepository;
import com.example.practice.models.User;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;


	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
		return  UserDetailsImpl1.build(user);
	}

//	private List<GrantedAuthority> getUserAuthority(Set<Role> userRoles) {
//		Set<GrantedAuthority> roles = new HashSet<>();
//		userRoles.forEach((role) -> {
//			roles.add(new SimpleGrantedAuthority(role.getRole()));
//		});
//
//		List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
//		return grantedAuthorities;
//	}
//
//	private UserDetails buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
//		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
//	}

}















//	@Autowired
//	public PasswordEncoder passwordEncoder;
//
//	Logger logger = LoggerFactory.getLogger(getClass());
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
//	{
//		List<UserDetails> userDetailsList = populateUserDetails();
//		for (UserDetails u : userDetailsList)
//		{
//
//			//logger.info(u.getUsername());
//			if (u.getUsername().equals (username))
//			{
//	logger.info(u.getUsername());
//				return u;
//			}
//		}
//		return null;
//	}
//
//	public List<UserDetails> populateUserDetails()
//	{
//		List<UserDetails> userDetailsList = new ArrayList<>();
//		userDetailsList
//				.add(User.withUsername("admin").password(passwordEncoder.encode("admin123")).roles("adm").build());
//		userDetailsList
//				.add(User.withUsername("user").password(passwordEncoder.encode("spring123")).roles("usr").build());
//
//		return userDetailsList;

//	public User findUserDetails(String username) {
//		User user = userRepository.findByUsername(username);
//
//		if (user!=null) {
//			return user;
//		} else {
//			throw new UsernameNotFoundException("User not found with username: " + username);
//		}
//	}






//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		return new User("admin","password", new ArrayList<>());
//	}


