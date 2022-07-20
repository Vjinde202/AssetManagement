package com.abc.AssetManagement.UserService;
import java.util.List;

import org.springframework.stereotype.Service;

import com.abc.AssetManagement.UserEntity.*;

@Service
public interface RequestService {
	
	public List<RequestedAssets> getAllRequests();
	public boolean AddRequest(RequestedAssets req);
	public boolean DeleteRequest(int id);
	public boolean updateRequsetDetails(String name,String upadtename);

}
