package uy.com.antel.apis.automotora.service;

import org.springframework.stereotype.Service;

import uy.com.antel.apis.automotora.model.Auto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AutoService {

    private final List<Auto> autos = new ArrayList<>();
    private long currentId = 1;

    public Auto createAuto(Auto auto) {
        auto.setId(currentId++);
        autos.add(auto);
        return auto;
    }

    public List<Auto> getAllAutos() {
        return new ArrayList<>(autos);
    }

    public Auto getAutoById(Long id) {
        Optional<Auto> auto = autos.stream().filter(a -> a.getId().equals(id)).findFirst();
        return auto.orElse(null);
    }

    public Auto updateAuto(Long id, Auto autoDetails) {
        Auto auto = getAutoById(id);
        if (auto != null) {
            auto.setMarca(autoDetails.getMarca());
            auto.setModelo(autoDetails.getModelo());
            auto.setAño(autoDetails.getAño());
            auto.setColor(autoDetails.getColor());
        }
        return auto;
    }

    public boolean deleteAuto(Long id) {
        return autos.removeIf(auto -> auto.getId().equals(id));
    }
}