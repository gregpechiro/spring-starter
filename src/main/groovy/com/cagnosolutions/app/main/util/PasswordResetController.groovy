package com.cagnosolutions.app.main.util
import com.cagnosolutions.app.main.email.EmailService
import com.cagnosolutions.app.main.user.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping(value = "/reset/password")
class PasswordResetController {

	@Autowired
	UserService userService

	@Autowired
	EmailService emailService

	@RequestMapping(method = RequestMethod.GET)
	String resetPassword() {
		"reset/password"
	}

	@RequestMapping(method = RequestMethod.POST)
	String resetPasswordAction(@RequestParam String username) {
		def user = userService.findOne username
		def pass = newPasswordHash()
		user.password = new BCryptPasswordEncoder().encode(pass)
		userService.save user
		emailService.send("Password Reset <reset@example.com>", username, "Reset Password Request",
			"A password reset has been requested for this account. You may now login using the temporary password " +
					"listed below:\n\n\t${pass}\n\n" +
			"After logging in, please make sure you reset your password.")
	}

	def newPasswordHash = {
		def pool = ['a'..'z','A'..'Z',0..9].flatten()
		Random rand = new Random(System.currentTimeMillis())
		def passChars = (0..10).collect { pool[rand.nextInt(pool.size())] }
		return passChars.join('')
	}
}
