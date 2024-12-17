package controllers;
import Security.JwtUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import entities.ERole;
import entities.*;
import entities.RoleEntity;
import payload.request.LoginRequest;
import payload.request.SignupRequest;
import payload.response.JwtResponse;
import payload.response.MessageResponse;
import repositories.RoleRepository;
import repositories.UserRepository;
import services.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;
@ComponentScan
@RestController
@RequestMapping("/api/auth")
@CrossOrigin

public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserRepository PassagerRepository;
    @Autowired
    UserRepository adminRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    JwtUtils jwtUtils;
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";  // Renvoie la page login.html
    }
    @GetMapping("/signup")
    public String showsignupPage() {
        return "signup";  // Renvoie la page signup.html
    }
    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();/**Reçoit une requête POST contenant les username et password.
																					        Valide les informations d'identification via le AuthenticationManager.
																					        Stocke les informations d'authentification dans le SecurityContext.
																					        Génère un JWT pour l'utilisateur authentifié.
																					        Récupère les détails de l'utilisateur (id, nom d'utilisateur, rôles).
																					        Renvoie une réponse avec le token et les informations de l'utilisateur.**/
        Set<String> roles = new HashSet<>();
        userDetails.getAuthorities().forEach(authority -> roles.add(authority.getAuthority()));

        return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), roles));
    }
   @PostMapping(value="/signup",produces = "application/json")
    public ResponseEntity<?> registerUser(@RequestBody SignupRequest signUpRequest) {
        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken"));
        }
        // Create new user's account
        if ("user".equals(signUpRequest.getRole())){
		    Passager user = new Passager();
	        user.setFirstName(signUpRequest.getFirstName());
	        user.setLastName(signUpRequest.getLastName());
	        user.setNationalite(signUpRequest.getNationalite());
	        user.setDateNaissance(signUpRequest.getDateNaissance());
	        user.setCIN(signUpRequest.getCIN());
	        user.setNumPass(signUpRequest.getNumPass());
	        user.setTelephone(signUpRequest.getTelephone());
	        user.setEmail(signUpRequest.getEmail());
	        user.setPassword(encoder.encode(signUpRequest.getPassword()));
	        user.setEmail(signUpRequest.getEmail());
	        PassagerRepository.save(user);
        }
    	if("admin".equals(signUpRequest.getRole())) {
    		administrateur user = new administrateur();
    		user.setFirstName(signUpRequest.getFirstName());
	        user.setLastName(signUpRequest.getLastName());
	        user.setEmail(signUpRequest.getEmail());
	        user.setPassword(encoder.encode(signUpRequest.getPassword()));
	        adminRepository.save(user);

    	}
     
        

        
    /*    Set<String> strRoles = signUpRequest.getRole();
        Set<RoleEntity> roles = new HashSet<>();

        if (strRoles == null) {
            RoleEntity userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                if ("admin".equals(role)) {
                    RoleEntity adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    roles.add(adminRole);
                } else {
                    RoleEntity userRole = roleRepository.findByName(ERole.ROLE_USER)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    roles.add(userRole);
                }
            });
        }
        user.setRoles(roles);*/
	        
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}