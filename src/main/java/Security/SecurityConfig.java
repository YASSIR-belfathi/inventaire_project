package Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import jakarta.servlet.Filter;
import services.CustomUserDetailsService;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	    private final JwtAuthEntryPoint unauthorizedHandler;
	    private final CustomUserDetailsService userDetailsService;
	    private final JwtAuthTokenFilter jwtAuthTokenFilter;
	    public SecurityConfig(JwtAuthEntryPoint unauthorizedHandler, CustomUserDetailsService userDetailsService, JwtAuthTokenFilter jwtAuthTokenFilter) {
	        this.unauthorizedHandler = unauthorizedHandler;
	        this.userDetailsService = userDetailsService;
	        this.jwtAuthTokenFilter = jwtAuthTokenFilter;
	    }
	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	    @Bean
	    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
	        return authenticationConfiguration.getAuthenticationManager();
	    }
	    @Bean
	    public DaoAuthenticationProvider authenticationProvider() {
	        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	        authProvider.setUserDetailsService(userDetailsService);
	        authProvider.setPasswordEncoder(passwordEncoder());
	        return authProvider;
	    }
	    @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        http.csrf(csrf -> csrf.disable())
	                .exceptionHandling(exceptionHandling -> exceptionHandling.authenticationEntryPoint(unauthorizedHandler))
	                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
	                .authorizeHttpRequests(authorize -> authorize
	                        .requestMatchers("/api/auth/login").permitAll()
	                        .requestMatchers("/api/auth/signup").permitAll()
	                        .requestMatchers("/search-flights").permitAll()
	                        .requestMatchers("/reservations/create").permitAll()
	                        .requestMatchers("/api/passengers/**").permitAll()
	                        .requestMatchers("/api/vols/get-vols").permitAll()
	                        .requestMatchers("/api/vols/add-vols").permitAll()

	                        
	                        .requestMatchers(HttpMethod.DELETE, "/reservations/cancel/**").permitAll()

	                        .anyRequest().authenticated()
	                );
	        http.authenticationProvider(authenticationProvider());
	        http.addFilterBefore((Filter) jwtAuthTokenFilter, UsernamePasswordAuthenticationFilter.class);

	        return http.build();
	    }
}
