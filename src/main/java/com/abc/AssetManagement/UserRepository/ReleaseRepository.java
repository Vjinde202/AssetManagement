package com.abc.AssetManagement.UserRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abc.AssetManagement.UserEntity.ReleasedAssets;


@Repository
public interface ReleaseRepository extends JpaRepository< ReleasedAssets ,Integer>{
	

}
