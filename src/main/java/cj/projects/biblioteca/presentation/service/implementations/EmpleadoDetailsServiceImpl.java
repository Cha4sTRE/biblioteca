package cj.projects.biblioteca.presentation.service.implementations;

import cj.projects.biblioteca.persistence.entities.EmpleadoEntity;
import cj.projects.biblioteca.persistence.repositories.EmpleadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class EmpleadoDetailsServiceImpl implements UserDetailsService {

    private EmpleadoRepository empleadoRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        EmpleadoEntity user= empleadoRepository.findByUsername(username)
                .orElseThrow(()->new UsernameNotFoundException("usuario no encontrado"));

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role->
                authorities.add(new SimpleGrantedAuthority("ROLE_".concat(role.getRole().name()))));

        user.getRoles().stream()
                .flatMap(role->role.getPermissions().stream())
                .forEach(permission->authorities.add(new SimpleGrantedAuthority(permission.getName())));
        return new User(user.getUsername(), user.getPassword(), authorities);
    }
}
