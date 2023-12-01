package vn.edu.iuh.fit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.entity.ResponsePages;
import vn.edu.iuh.fit.models.Address;
import vn.edu.iuh.fit.models.Company;
import vn.edu.iuh.fit.models.ResponseCompany;
import vn.edu.iuh.fit.repositories.AddressRepository;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public Address create(Address address){
        return addressRepository.save(address);
    }

    public Address update(Address address){
        return addressRepository.save(address);
    }

    public void delete(long id){
        addressRepository.deleteById(id);
    }

    public Address getByID(long id){
        return addressRepository.findById(id).get();
    }

    public ResponsePages getAll(Pageable pageable){
        ResponsePages responsePages = new ResponsePages(addressRepository.findAll(pageable).getTotalPages(), addressRepository.findAll(pageable).getContent());
        return responsePages;
    }
}
