package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class RecoveryRoomService {

    @Autowired
    private RecoveryRoomRepository recoveryRoomRepository;
    
    public List<RecoveryRoom> getAll(){
        return recoveryRoomRepository.findAll();
    }

    public List<RecoveryRoomType> getAllRecoveryRoomTypes(){
        return recoveryRoomRepository.findAllRecoveryRoomTypes();
    }

    public RecoveryRoomType getRecoveryRoomType(String typeName) {
        return recoveryRoomRepository.getRecoveryRoomType(typeName);
    }

    public RecoveryRoom save(RecoveryRoom p) throws DuplicatedRoomNameException {
        return recoveryRoomRepository.save(p);       
    }

    
}
