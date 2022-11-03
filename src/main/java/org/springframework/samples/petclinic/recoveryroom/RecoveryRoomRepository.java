package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
public interface RecoveryRoomRepository extends CrudRepository<RecoveryRoom, Integer> {
    
   
    
    List<RecoveryRoom> findAll();
    Optional<RecoveryRoom> findById(int id);
    
    RecoveryRoom save(RecoveryRoom p);

    @Query("SELECT room FROM RecoveryRoomType room")
    List<RecoveryRoomType> findAllRecoveryRoomTypes();


    @Query("SELECT room FROM RecoveryRoomType room WHERE room.name = ?1")
    RecoveryRoomType getRecoveryRoomType(String name);
}
