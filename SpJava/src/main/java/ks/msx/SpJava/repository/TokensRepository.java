package ks.msx.SpJava.repository;

import ks.msx.SpJava.entity.confirmationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokensRepository extends JpaRepository<confirmationToken, Long> {
    confirmationToken findConfirmationTokenByUserId(int user_id);
}
