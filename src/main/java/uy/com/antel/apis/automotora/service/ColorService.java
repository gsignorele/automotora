package uy.com.antel.apis.automotora.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Service
public class ColorService {

    @Value("${auto.colors}")
    private String colorsString;

    private List<String> validColors;

    
    @PostConstruct
    public void init() {
        validColors = Arrays.asList(colorsString.split(","));
    }

    public boolean isValidColor(String color) {
    	if (validColors.contains(color)) {
    		return true;
    	} else {
    		return false;
    	}
        
    }

    public List<String> getValidColors() {
        return validColors;
    }
}
