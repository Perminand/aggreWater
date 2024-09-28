package ru.perminov.aggrewater.dto;

public interface UserDetailsService {
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    }
}
