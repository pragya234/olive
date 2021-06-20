package com.doctorvinci.doctorvinci.dbservice.repository;

import com.doctorvinci.doctorvinci.dbservice.entity.AddressEntity;
import com.doctorvinci.doctorvinci.dbservice.entity.DoctorDetailsEntity;
import com.doctorvinci.doctorvinci.models.DoctorType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface AddressRepository extends JpaRepository<AddressEntity, Integer> {
    AddressEntity findByAddressId(int addressId);
    List<AddressEntity> findByPinCode(String pinCode);
    @Query(value="select * from address where city=?1 and state=?2", nativeQuery = true)
    List<AddressEntity> findByCityAndState(String city, String state);
    List<AddressEntity> findByAddressIdIn(Set<Integer> addressIds);
    List<AddressEntity> findByCity(String city);
    @Query(value="select * from address where latitude >=?1 and latitude <=?2 and longitude >=?3 and longitude<=?4", nativeQuery = true)
    List<AddressEntity> findAddressWithinLatitudeAndLongitudeRange(double latitudeStart, double latitudeEnd, double longitudeStart,
                                                                               double longitudeEnd);

}

/*
JpaRepository is a generic interface. Whichever interface extends JpaRepository need to pass datatypes also, so that
generic interface can be converted into specific interface
spring data jpa karke ek package humne apne pom me dala hai, that means, spring data jpa is
one of the dependency of the project. what that means our project will need jar of spring data jpa to run

but how will spring data jpa help us?
springdata jpa provides some ready to use function, which we need in our daily life.
ex: insert into address values()--> to do this type of thing, we will need to write a lot of jdbc code, but spring data jpa
or jpa repository provides us save method
 */

/*
public interface Sum<T,V, Z> {
T sum (Z variableName1, V variableName2);
}

public interface Calculator extends Sum<Long, Int, Double>{
}

public class ScCalculator implements Calculator{
Long sum(Double variableName1, Int variableName2){
}
}

 public interface Calculator2 extends Sum<Long, Long, Long>{
}
public class ScCalculator2 implements Calculator2{
Long sum(Long variableName1, Long variableName2){
}
}
 */