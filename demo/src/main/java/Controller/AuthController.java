package Controller;

import java.net.HttpCookie;
import java.net.http.HttpResponse;

import org.apache.tomcat.util.http.ServerCookie;
import org.hibernate.Internal;
import org.hibernate.Session.LockRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.AbstractPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.web.webauthn.api.AuthenticatorResponse;
import org.springframework.web.bind.annotation.*;

import jakarta.security.auth.message.callback.PasswordValidationCallback;
import repository.UserRepository;
import security.JwtTokenProvider;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private static final String logger = null;

	@Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserRepository userRepository; // If you need to register users

	private Object String;

	private Object Logger_;


    // Login
    @PostMapping("/login")
    public <LoginRequest> BodyBuilder login(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(((User) loginRequest).getUsername(), ((User) loginRequest).getPassword())
        );

        return ResponseEntity.ok();
    }

    // Register
    @PostMapping("/register")
    
    public ResponseEntity<String> register(@RequestBody User user) {
    	 if (!PasswordValidation(user.getPassword())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Password does not meet requirements!");
        }

      
        userRepository.save(user);

        return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully!");
    }

    
    private boolean PasswordValidation(java.lang.String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@PostMapping("/login")
    public <LoginRequest> ResponseEntity<Void> login(@RequestBody LoginRequest loginRequest, HttpResponse response) {
        
		Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        ((User) loginRequest).getUsername(), 
                        ((User) loginRequest).getPassword()
                )
        );

        String token = jwtTokenProvider.generateToken(authentication);

        // Add token as an HTTP-only cookie
        
        HttpCookie cookie = null;
		cookie.setHttpOnly(true);
        cookie.setPath("/");
        

        return ResponseEntity.ok().build();
    }

    public ResponseEntity<String> logout(@RequestHeader("Authorization") String token) {
        String jwt = token.replace("Bearer ", "");
        jwtTokenProvider.invalidateToken(jwt); // Invalidate the token (method to be implemented)
        return ResponseEntity.ok("Logged out successfully.");
    }
    
    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LockRequest loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(((UserDetails) loginRequest).getUsername(), ((User) loginRequest).getPassword())
            );

            String token = jwtTokenProvider.generateToken(authentication);
            return ResponseEntity.ok(new Object());
        } catch (Exception e) {
           
            throw e;
        }
    }
}

