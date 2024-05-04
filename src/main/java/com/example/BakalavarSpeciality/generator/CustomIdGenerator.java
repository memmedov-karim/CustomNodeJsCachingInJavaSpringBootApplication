package com.example.BakalavarSpeciality.generator;


import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.security.SecureRandom;
import java.util.Base64;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.security.SecureRandom;
import java.util.Base64;

public class CustomIdGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) {
        byte[] randomBytes = new byte[16];
        new SecureRandom().nextBytes(randomBytes);
        String id = Base64.getEncoder().encodeToString(randomBytes).substring(0, 22);
        return id;
    }
}
