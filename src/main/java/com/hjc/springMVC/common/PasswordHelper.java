package com.hjc.springMVC.common;

import com.hjc.springMVC.persistence.entity.SysUser;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by Bravowhale on 2017/1/5.
 */
@Service
public class PasswordHelper {
    private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

//     @Value("${password.algorithmName}")
    private String algorithmName = "md5";

//    @Value("${password.hashIterations")
    private int hashIterations = 2;

    public void setRandomNumberGenerator(RandomNumberGenerator randomNumberGenerator){
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void setAlgorithmName(String algorithmName){
        this.algorithmName = algorithmName;
    }
    public void setHashIterations(int hashIterations){
        this.hashIterations = hashIterations;
    }

    public void encryptPassword(SysUser user){
        user.setSalt(randomNumberGenerator.nextBytes().toHex());

        String newPassword = new SimpleHash(
                algorithmName,
                user.getPassword(),
                ByteSource.Util.bytes(user.getCredentialsSalt()),
                hashIterations
        ).toHex();

        user.setPassword(newPassword);
    }
}
