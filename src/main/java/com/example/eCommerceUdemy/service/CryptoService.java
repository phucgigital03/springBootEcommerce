package com.example.eCommerceUdemy.service;

import com.example.eCommerceUdemy.config.DefaultValue;
import com.example.eCommerceUdemy.util.EncodingUtil;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Service
@Slf4j
public class CryptoService {
    private final Mac MAC = Mac.getInstance(DefaultValue.HMAC_SHA512);

    @Value("${payment.vnpay.secret-key}")
    private String secretKey;

    public CryptoService() throws NoSuchAlgorithmException {
    }

    @PostConstruct
    void init() throws InvalidKeyException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), DefaultValue.HMAC_SHA512);
        MAC.init(secretKeySpec);
    }

    public String sign(String data) {
        try {
            return EncodingUtil.toHexString(MAC.doFinal(data.getBytes()));
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}