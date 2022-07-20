package com.abc.AssetManagement.UserWeb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abc.AssetManagement.UserEntity.RequestedAssets;
import com.abc.AssetManagement.UserService.RequestService;

@RestController
@RequestMapping("/requests")
public class RequestController {
	
	@Autowired
	RequestService requestService;
	
	
	@GetMapping("/allrequests")
	public List<RequestedAssets> getAllRequests(){
		List<RequestedAssets> requests = requestService.getAllRequests();
		return requests;
		
	}
	
	@PostMapping("/request") 
	public String saveProductFromWeb(@RequestBody RequestedAssets t)
	{
		boolean status =  requestService.AddRequest(t);
		return status == true?"Product Saved ":"Failed to save";
	}
	
	@PutMapping("/product/update")
	public String updated(@RequestParam String name,@RequestParam String updatename) {
		String msg = "request updated";
		boolean result = requestService.updateRequsetDetails(name, updatename);
		return msg;
	}
	@DeleteMapping("/delete/{id}")
	public String deleted(@PathVariable int id) {
		String msg = "request deleted";
		boolean result = requestService.DeleteRequest(id);
		return msg;
	}

}
