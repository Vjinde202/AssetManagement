package com.abc.AssetManagement.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.AssetManagement.UserEntity.RequestedAssets;
import com.abc.AssetManagement.UserRepository.RequestRepository;

@Service
public class RequestServiceImpl implements RequestService{
	
	@Autowired
	RequestRepository requestRepository;

	@Override
	public List<RequestedAssets> getAllRequests() {
		List<RequestedAssets> reqlist = requestRepository.findAll();
		return reqlist;
	}

	@Override
	public boolean AddRequest(RequestedAssets req) {
		requestRepository.save(req);
		return true;
	}

	@Override
	public boolean DeleteRequest(int id) {
		requestRepository.deleteById(id);
		return true;
	}

	@Override
	public boolean updateRequsetDetails(String name, String updatename) {
		List<RequestedAssets> reqlist = requestRepository.findAll();
		for(final RequestedAssets req:reqlist) {
			if(req.getProductName()==name) {
				req.setProductName(updatename);
			}
			
			requestRepository.save(req);
			
		}
		
		return true;
	}

}
