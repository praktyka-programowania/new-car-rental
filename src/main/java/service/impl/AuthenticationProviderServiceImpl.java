package service.impl;


import model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import service.ClientService;
import service.RoleService;

import java.util.ArrayList;
import java.util.List;
import model.Role;

@Service("authenticationProviderServiceImpl")
public class AuthenticationProviderServiceImpl implements AuthenticationProvider
{
    @Autowired
    private ClientService clientService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private BCryptPasswordEncoder encoder;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException
    {

        Client client = clientService.getByUsername(authentication.getName());

        if (client != null)
        {
            if (encoder.matches(authentication.getCredentials().toString(), client.getPassword()))
            {

                List<GrantedAuthority> list = new ArrayList<>();
                Role role = roleService.get(client.getId());

                list.add(new SimpleGrantedAuthority(role.getRole().toString()));
                return new UsernamePasswordAuthenticationToken(client.getUsername(), client.getPassword(), list);
            }
        }

        return null;
    }

    @Override
    public boolean supports(Class<?> aClass)
    {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }
}
