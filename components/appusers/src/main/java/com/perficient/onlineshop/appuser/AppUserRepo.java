package com.perficient.onlineshop.appuser;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AppUserRepo extends CrudRepository<AppUser,Long>
{
    Optional<AppUser> findById(Long id);
}
