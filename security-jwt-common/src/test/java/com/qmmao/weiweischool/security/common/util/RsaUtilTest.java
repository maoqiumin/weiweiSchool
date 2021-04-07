package com.qmmao.weiweischool.security.common.util;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RsaUtilTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void generateKey() throws Exception {
        String privateKey = "c:/tools/auth_key/id_key_rsa";
        String publicKey = "c:/tools/auth_key/id_key_rsa.pub";
        RsaUtil.generateKey(publicKey, privateKey, "qmmao", 1024);
    }
}