package com.abc.AssetManagement.UserRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abc.AssetManagement.UserEntity.RequestedAssets;

@Repository
public interface RequestRepository extends JpaRepository< RequestedAssets ,Integer> {

}
