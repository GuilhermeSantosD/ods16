package com.unijorge.ods16.service;




import com.unijorge.ods16.model.Sos;
import com.unijorge.ods16.repository.SosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.unijorge.ods16.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SosService {

    @Autowired
    private SosRepository sosRepository;
    @Autowired
    private UserRepository userRepository;


    public Sos saveSos(Sos sos) {
        return sosRepository.save(sos);
    }
    //Pegar um SOS pelo ID
    public Sos getSosById(Long id) {
        return sosRepository.findById(id).orElse(null);
    }

    public List<Sos> getAllSos() {
        return sosRepository.findAll();
    }
    public Sos updateSos(Long id, Sos sos) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        boolean isAdmin = authentication.getAuthorities().stream()
                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_ADMIN"));

        Sos existingSos = sosRepository.findById(id).orElse(null);
        if (existingSos != null) {
            existingSos.setNome(sos.getNome());
            existingSos.setDescricao(sos.getDescricao());
            existingSos.setLocalizacao(sos.getLocalizacao());

            return sosRepository.save(existingSos);
        }
        return null;
    }

    public void deleteSos(Long id) {
        sosRepository.deleteById(id);
    }

}
