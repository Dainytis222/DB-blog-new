package dainius.app.blog.configuration;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .authorizeRequests()
        .antMatchers("/login/**", "/public/**").permitAll()
        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
        .antMatchers("/private/**").authenticated()
          .anyRequest().authenticated()
          .and()
        .formLogin()
          .permitAll()
          .loginPage("/login")
          .loginProcessingUrl("/login")
          .defaultSuccessUrl("/posts")
          .failureUrl("/login?error=true")
          .and()
        .logout()
         .permitAll();
  }
}
