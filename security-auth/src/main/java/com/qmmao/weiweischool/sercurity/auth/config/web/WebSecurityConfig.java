package com.qmmao.weiweischool.sercurity.auth.config.web;

import com.qmmao.weiweischool.sercurity.auth.config.code.VerifyCodeFilter;
import com.qmmao.weiweischool.sercurity.auth.config.handle.LoginFailureHandler;
import com.qmmao.weiweischool.sercurity.auth.config.handle.LoginSuccessHandler;
import com.qmmao.weiweischool.sercurity.auth.config.key.JwtAuthorizationTokenFilter;
import com.qmmao.weiweischool.sercurity.auth.config.user.CustomUserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author DELL
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private LoginSuccessHandler successHandler;
    @Autowired
    private LoginFailureHandler failureHandler;
    @Autowired
    private VerifyCodeFilter verifyCodeFilter;

    @Autowired
    private JwtAuthorizationTokenFilter jwtAuthorizationTokenFilter;

    @Autowired
    private CustomUserDetailsServiceImpl customUserDetailsService;

    /**
     * spring5.0之后，spring security必须设置加密方法否则会报
     * There is no PasswordEncoder mapped for the id "null"
     *
     * @return 加密
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //需要授权的请求
        http.authorizeRequests()
                //过滤不需要认证的路径
                .antMatchers("/login", "/home", "/getCode").permitAll()
                //对任何一个请求，都需要认证
                .anyRequest().authenticated()
                // 完成上一个配置，进行下一步配置
                .and()
                //.httpBasic();
                //配置表单登录
                .formLogin()
                // 设置登录页面
                .loginPage("/login")
                //设置成功处理器
                .successHandler(successHandler)
                //设置失败处理器
                .failureHandler(failureHandler)
                .and()
                //登出
                .logout()
                //设置退出页面
                .logoutSuccessUrl("/home");

        //CSRF禁用,因为不使用session
        http.csrf().disable();
        //禁用session
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER);
        //添加验证码过滤器
        http.addFilterBefore(verifyCodeFilter, UsernamePasswordAuthenticationFilter.class);
        //http.addFilterAt(filterSecurityInterceptor, FilterSecurityInterceptor.class);
        http.addFilterBefore(jwtAuthorizationTokenFilter,UsernamePasswordAuthenticationFilter.class);
    }
}
