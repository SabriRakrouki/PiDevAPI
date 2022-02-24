package tn.esprit.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.entities.Domain;
import tn.esprit.entities.Position;
import tn.esprit.services.IPositionService;

@RestController
@RequestMapping("/Position")
public class PositionController {
	
	@Autowired
	IPositionService PositionService;
	
	@PostMapping("/addPosition")
	@ResponseBody
	public Position addPosition(@RequestBody Position p) {
		
			return PositionService.AddPosition(p);
		
	}
	
	@PutMapping("/updatePosition")
	@ResponseBody
	public Position updatePosition( @RequestBody Position d) {
		
			return PositionService.UpdatePosition(d);
		
		
	}
	
	@DeleteMapping("/deletPosition/{id}")
	@ResponseBody
	public Position deletPosition( @PathVariable("id")  int id) {
		
			return PositionService.DeletePosition(id);
		
	}
	
	@RequestMapping("/getallPosition")
	@ResponseBody
	public List<Position> getallPosition( ) {
		
			return PositionService.GetAllPosition();
		
	}
	

}
