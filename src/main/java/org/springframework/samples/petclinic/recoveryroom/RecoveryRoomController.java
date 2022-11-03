package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class RecoveryRoomController {

    @Autowired
    public RecoveryRoomService recoveryRoomService;


    @ModelAttribute (name = "types")
    public List<RecoveryRoomType> populateRecovetyRoomTypes() {
		return recoveryRoomService.getAllRecoveryRoomTypes();
	}


    @GetMapping("/recoveryroom/create")
    public ModelAndView addRecoveryRoom(){
        ModelAndView result = new  ModelAndView("recoveryroom/createOrUpdateRecoveryRoomForm");
        result.addObject("recoveryRoom", new RecoveryRoom());
        result.addObject("types", recoveryRoomService.getAllRecoveryRoomTypes());
        return result;
    }

    @PostMapping("/product/create")
    public ModelAndView saveAddedRecoveryRoom(@Valid RecoveryRoom rroom, BindingResult br){
        ModelAndView result = new ModelAndView("recoveryroom/createOrUpdateRecoveryRoomForm");
        if(br.hasErrors()){
            result.addObject("recoveryRoom", new RecoveryRoom());
        result.addObject("types", recoveryRoomService.getAllRecoveryRoomTypes());
        return result;
    }else{
        result.addObject("message", "Recovery room created sucessfully!");

    }
    return new ModelAndView("welcome");


    }


}
