package com.gregpechiro.app

import groovy.transform.CompileStatic
import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.web.DefaultRedirectStrategy
import org.springframework.security.web.RedirectStrategy
import org.springframework.security.web.authentication.AuthenticationSuccessHandler
import org.springframework.security.web.savedrequest.HttpSessionRequestCache
import org.springframework.security.web.savedrequest.RequestCache
import org.springframework.security.web.savedrequest.SavedRequest

import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@CompileStatic
class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	RedirectStrategy redirectStrategy = new DefaultRedirectStrategy()

	RequestCache requestCache = new HttpSessionRequestCache()

	void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
								 Authentication authentication) throws IOException, ServletException {

		def successUrl = "/login/success"



		println authentication

		authentication.authorities.each { authority ->
			switch ((authority as GrantedAuthority).authority) {
				case "ROLE_USER":
					successUrl += "?role=user"
					break
				case "ROLE_ADMIN":
					successUrl += "?role=admin"
					break
			}
		}

		if (response.committed) {
			return
		}

		SavedRequest savedRequest = requestCache.getRequest(request, response)

		def redirect = (savedRequest == null) ? "" : savedRequest.redirectUrl

		redirectStrategy.sendRedirect request, response, "${successUrl}&redirect=${redirect}"
	}

}