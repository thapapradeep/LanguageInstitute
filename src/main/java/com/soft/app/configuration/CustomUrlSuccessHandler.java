package com.soft.app.configuration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomUrlSuccessHandler extends SimpleUrlAuthenticationSuccessHandler{

	private RedirectStrategy redirectStratergy=new DefaultRedirectStrategy();
	
	protected RedirectStrategy getRedirectStratergy(){
		return redirectStratergy;
	}
	
	protected void setRedirectedStratergy(RedirectStrategy redirectStratergy){
		this.redirectStratergy=redirectStratergy;
	}
	
	@Override
	protected void handle(HttpServletRequest request,HttpServletResponse response,Authentication authentication) throws IOException{
		String targetUrl=determineTargetUrl(authentication);
		if(response.isCommitted()){
			System.out.println("Cannot connect");
			return;
		}
		redirectStratergy.sendRedirect(request, response, targetUrl);
	}
	
	protected String determineTargetUrl(Authentication authentication){
		String url="";
		Collection<? extends GrantedAuthority> authorities=authentication.getAuthorities();
		List<String> roles=new ArrayList<String>();
		
		for(GrantedAuthority a:authorities){
			roles.add(a.getAuthority());
		}
		
		if(isAdmin(roles)){
			url="/admin";
		}
		else if(isManager(roles)){
			url="/manager";
		}
		else if(isAccountant(roles)){
			url="/accountant";
		}
		else if(isReceptionaist(roles)){
			url="/receptionist";
		}
		return url;
	}
	
	private boolean isAdmin(List<String> roles){
		return roles.contains("ROLE_ADMIN");
	}
	
	private boolean isManager(List<String> roles){
		return roles.contains("ROLE_MANAGER");
	}
	
	private boolean isAccountant(List<String> roles){
		
		return roles.contains("ROLE_ACCOUNTANT");
	}
	
	private boolean isReceptionaist(List<String> roles){
		return roles.contains("ROLE_RECEPTIONIST");
	}
}