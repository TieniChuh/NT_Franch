package mic.springdata.jpa.service;

import mic.springdata.jpa.domain.AccountInfo;
import org.springframework.data.domain.Pageable;

import java.util.List;



public interface UserService {
    public AccountInfo createNewAccount(String username, String password, Integer initBalance);

    public AccountInfo findAccountInfoById(Long id);

    public List<AccountInfo> findByBalanceGreaterThan(Integer balance, Pageable pageable);
}
