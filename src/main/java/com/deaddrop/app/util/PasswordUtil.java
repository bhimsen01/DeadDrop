package com.deaddrop.app.util;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

public class PasswordUtil {
    public static String hashPassword(String plainPassword){
        Argon2 argon2= Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        try {
            return argon2.hash(2,65536,1,plainPassword.toCharArray());
        } finally {
            argon2.wipeArray(plainPassword.toCharArray());
        }
    }

    public static boolean verifyPassword(String hash, String plainPassword){
        Argon2 argon2=Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        return argon2.verify(hash, plainPassword.toCharArray());
    }
}
