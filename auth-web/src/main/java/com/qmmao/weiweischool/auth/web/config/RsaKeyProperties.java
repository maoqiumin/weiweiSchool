package com.qmmao.weiweischool.auth.web.config;


import com.qmmao.weiweischool.common.util.login.RsaUtil;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.annotation.PostConstruct;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * @author DELL
 */
@ConfigurationProperties(prefix = "rsa.key")
public class RsaKeyProperties {
    private String pubKeyFile;
    private String priKeyFile;

    private PublicKey publicKey;
    private PrivateKey privateKey;

    public String getPubKeyFile() {
        return pubKeyFile;
    }

    public void setPubKeyFile(String pubKeyFile) {
        this.pubKeyFile = pubKeyFile;
    }

    public String getPriKeyFile() {
        return priKeyFile;
    }

    public void setPriKeyFile(String priKeyFile) {
        this.priKeyFile = priKeyFile;
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(PublicKey publicKey) {
        this.publicKey = publicKey;
    }

    public PrivateKey getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(PrivateKey privateKey) {
        this.privateKey = privateKey;
    }

    /**
     * 系统启动的时候触发
     * @throws Exception
     */
    @PostConstruct
    public void createRsaKey() throws Exception {
        publicKey = RsaUtil.getPublicKey(pubKeyFile);
        privateKey = RsaUtil.getPrivateKey(priKeyFile);
    }
}
