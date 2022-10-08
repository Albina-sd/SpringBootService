package com.springservice.services.implementations;

import com.springservice.models.Sweets;
import com.springservice.repositories.SweetsRepository;
import com.springservice.services.SweetsService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SweetsServiceImpl implements SweetsService {
    @Autowired
    private SweetsRepository sweetsRepository;

    private final JdbcTemplate jdbcTemplate;

    public SweetsServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Sweets> findAll(){
        return sweetsRepository.findAll();
    }

    public Sweets findById (Long id){
        return sweetsRepository.getById(id);
    }

    private boolean existsById (Long id){
        return sweetsRepository.existsById(id);
    }

    public void checkFields(Sweets sweet) throws Exception{
        if (StringUtils.isEmpty(sweet.getName())){
            throw new Exception("Name is required");
        }
        if (StringUtils.isEmpty(sweet.getSweets_types_id().toString())){
            throw new Exception("Type of sweet is required");
        }
        if (StringUtils.isEmpty(sweet.getCost().toString())){
            throw new Exception("Cost is required");
        }
        if (StringUtils.isEmpty(sweet.getWeight().toString())){
            throw new Exception("Weight is required");
        }
        if (StringUtils.isEmpty(sweet.getManufacturer_id().toString())){
            throw new Exception("Manufacturer id is required");
        }
        if ((StringUtils.isEmpty(sweet.getExpiration_date().toString())) |
                (StringUtils.isEmpty(sweet.getProduction_date().toString()))){
            throw new Exception("Production and expiration date is required");
        }
        if (StringUtils.isEmpty(sweet.getRequires_freezing().toString())){
            throw new Exception("Requires freezing is required");
        }
    }

    public Sweets save(Sweets sweet) throws Exception{
        checkFields(sweet);

        if (sweet.getId() != null && existsById(sweet.getId())){
            throw new Exception("Sweet with id: " + sweet.getId() + " already exists");
        }

        return sweetsRepository.save(sweet);
    }

    public void update(Sweets sweet) throws Exception{
        checkFields(sweet);

        sweetsRepository.save(sweet);
    }

    public void deleteById(Long id) throws Exception{

        if (!existsById((id))){
            throw new Exception("Can't find sweet with id: "+ id);
        } else {
            sweetsRepository.deleteById(id);
        }
    }

}
