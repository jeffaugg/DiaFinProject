package com.jeffaugg.DiaFin.user.service;

import com.jeffaugg.DiaFin.user.dto.UserDTO;
import com.jeffaugg.DiaFin.user.model.User;
import com.jeffaugg.DiaFin.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User createUser(UserDTO userDTO) {
        // Verificar se o email já está registrado
        if (userRepository.findByEmail(userDTO.getEmail()) != null) {
            throw new IllegalArgumentException("Email já cadastrado.");
        }

        // Converter UserDTO para User
        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword()); // Em produção, hash a senha!
        user.setAge(userDTO.getAge());
        user.setWage(userDTO.getWage());
        user.setReserve(userDTO.getReserve());

        // Salvar o usuário no banco de dados
        return userRepository.save(user);
    }
}
