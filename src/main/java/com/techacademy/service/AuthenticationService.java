package com.techacademy.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techacademy.entity.Authentication;
import com.techacademy.repository.AuthenticationRepository;

@Service
public class AuthenticationService {
    private final AuthenticationRepository authenticationRepository;

    public AuthenticationService(AuthenticationRepository repository) {
        this.authenticationRepository = repository;
    }
    /** 全件を検索して返す */
    public List<Authentication> getAuthenticationList() {
        // リポジトリのfindAllメソッドを呼び出す
        return authenticationRepository.findAll();
    }
    /** Authenticationを1件検索して返す */
    public Authentication getAuthentication(Integer id) {
        return authenticationRepository.findById(id).get();
    }

    /** Authenticationの登録を行う */
    @Transactional
    public Authentication saveAuthentication(Authentication authentication) {
        return authenticationRepository.save(authentication);
    }
    /** Authenticationの削除を行う */
    @Transactional
    public void deleteAuthentication(Set<Integer> idck) {
        for(Integer id : idck) {
            authenticationRepository.deleteById(id);
        }
    }
}