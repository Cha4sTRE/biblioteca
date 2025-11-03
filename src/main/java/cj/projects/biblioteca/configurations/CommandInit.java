package cj.projects.biblioteca.configurations;

import cj.projects.biblioteca.persistence.entities.EmpleadoEntity;
import cj.projects.biblioteca.persistence.entities.PermissionEntity;
import cj.projects.biblioteca.persistence.entities.RolEntity;
import cj.projects.biblioteca.persistence.entities.Roles;
import cj.projects.biblioteca.persistence.repositories.EmpleadoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;
@Component
public class CommandInit {

    @Bean
    public CommandLineRunner init(PasswordEncoder passwordEncoder, EmpleadoRepository empleadoRepository) {
        return args -> {

            PermissionEntity createPermission = PermissionEntity.builder().name("CREATE").build();
            PermissionEntity readPermission = PermissionEntity.builder().name("READ").build();
            PermissionEntity updatePermission = PermissionEntity.builder().name("UPDATE").build();
            PermissionEntity deletePermission = PermissionEntity.builder().name("DELETE").build();

            RolEntity rol = RolEntity.builder()
                    .role(Roles.ADMIN)
                    .permissions(Set.of(createPermission, readPermission, updatePermission, deletePermission))
                    .build();

            EmpleadoEntity empleado1 = EmpleadoEntity.builder()
                    .username("jeffer")
                    .email("chaustrejefferson@gmail.com")
                    .telefono(3166846822l)
                    .password(passwordEncoder.encode("milluh123"))
                    .roles(Set.of(rol))
                    .isEnabled(true)
                    .isAccountNonExpired(true)
                    .isAccountNonLocked(true)
                    .isCredentialsNonExpired(true)
                    .build();

            empleadoRepository.save(empleado1);

        };
    }

}
