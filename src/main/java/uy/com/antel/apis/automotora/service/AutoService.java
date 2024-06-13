package uy.com.antel.apis.automotora.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uy.com.antel.apis.automotora.model.Auto;
import uy.com.antel.apis.automotora.service.ColorService;
import uy.com.antel.apis.automotora.exceptions.InvalidColorException;

import java.util.ArrayList;
import java.util.List;


@Service
public class AutoService {

    private final List<Auto> autos = new ArrayList<>();
    private long currentId = 1;
    @Autowired
    private ColorService colorService;

    public Auto createAuto(Auto auto) {
    	if (colorService.isValidColor(auto.getColor().toLowerCase())) {    		
    		auto.setId(currentId++);
        	autos.add(auto);
        	return auto;
    	} else {
    		throw new InvalidColorException("Color no válido: " + auto.getColor());
    	}
    }

    public List<Auto> getAllAutos() {
        return new ArrayList<>(autos);
    }

    public Auto getAutoById(Long id) {    	
    	for (Auto a: autos) {
    		if (a.getId().equals(id)) {
    			return a;
    		}
    	}
    	return null;   	
        
    }

    public Auto updateAuto(Long id, Auto autoDetails) {
        Auto auto = getAutoById(id);
        if (auto != null) {
            auto.setMarca(autoDetails.getMarca());
            auto.setModelo(autoDetails.getModelo());
            auto.setAño(autoDetails.getAño());
            auto.setColor(autoDetails.getColor());
            auto.setPrecio(autoDetails.getPrecio());
        }
        return auto;
    }

    public boolean deleteAuto(Long id) {
        return autos.removeIf(auto -> auto.getId().equals(id));
    }
}