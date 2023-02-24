package br.com.pokedex.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class MapperService {
    ModelMapper getConverter() {
        return new ModelMapper();
    }
}
