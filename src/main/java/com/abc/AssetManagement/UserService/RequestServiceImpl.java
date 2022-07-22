package com.abc.AssetManagement.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.AssetManagement.UserEntity.ReleasedAssets;
import com.abc.AssetManagement.UserEntity.RequestedAssets;
import com.abc.AssetManagement.UserRepository.ReleaseRepository;
import com.abc.AssetManagement.UserRepository.RequestRepository;

@Service
public class RequestServiceImpl implements RequestService{
	
	@Autowired
	RequestRepository requestRepository;
	
	@Autowired
	ReleaseRepository releaseRepository;

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
	public boolean DeleteRequest(int id,String Status) {
		RequestedAssets request = requestRepository.findById(id).get();
		ReleasedAssets release = new ReleasedAssets();
		release.setRequestId(request);
		release.setReleaseStatus(Status);
		releaseRepository.save(release);
		
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
