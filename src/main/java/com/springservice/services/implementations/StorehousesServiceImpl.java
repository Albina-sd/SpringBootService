package com.springservice.services.implementations;


import com.springservice.services.StorehousesService;
import org.apache.commons.lang3.StringUtils;
import com.springservice.models.Storehouses;
import com.springservice.repositories.StorehousesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StorehousesServiceImpl implements StorehousesService {
    @Autowired
    private StorehousesRepository storehousesRepository;

    private final JdbcTemplate jdbcTemplate;

    public StorehousesServiceImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Storehouses> findAll() {
        return storehousesRepository.findAll();
    }

    public Storehouses findById (Long id){
        return storehousesRepository.getById(id);
    }

    private boolean existsById(Long id) {
        return storehousesRepository.existsById(id);
    }

    public void checkFields(Storehouses storehouse) throws Exception{
        if (StringUtils.isEmpty(storehouse.getName())){
            throw new Exception("Name is required");
        }

        if (StringUtils.isEmpty(storehouse.getAddress())){
            throw new Exception("Address is required");
        }

        if (StringUtils.isEmpty(storehouse.getCity())){
            throw new Exception("City is required");
        }

        if (StringUtils.isEmpty(storehouse.getCountry())){
            throw new Exception("Country is required");
        }
    }

    public Storehouses save(Storehouses storehouse) throws Exception {
        checkFields(storehouse);

        if (storehouse.getId() != null && existsById(storehouse.getId())) {

            throw new Exception("Storehouse with id: " + storehouse.getId() + " already exists");
        }

        return storehousesRepository.save(storehouse);
    }

    public void update(Storehouses storehouse) throws Exception{

        checkFields(storehouse);

        storehousesRepository.save(storehouse);
    }

    public void deleteById(Long id) throws Exception{

        if (!existsById(id)){
            throw new Exception("Can't find Storehouse with id: "+ id);
        } else {
            storehousesRepository.deleteById(id);
        }
    }
}
