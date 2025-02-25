package com.coletas.coletas.config;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class KeyManager {
    private static final String KEY_FILE_PATH = "encryption.key";
    private static final String ALGORITHM = "AES";

    public static SecretKey generateKey() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
        keyGenerator.init(128);
        return keyGenerator.generateKey();
    }

    public static void saveKey(SecretKey key) throws IOException {
        byte[] encodedKey = key.getEncoded();
        String encodedKeyString = Base64.getEncoder().encodeToString(encodedKey);
        Files.write(Paths.get(KEY_FILE_PATH), encodedKeyString.getBytes(StandardCharsets.UTF_8));
    }

    public static SecretKey loadKey() throws IOException {
    	if (!Files.exists(Paths.get(KEY_FILE_PATH))) {
            try {
                SecretKey key = generateKey();
                saveKey(key);
                return key;
            } catch (Exception e) {
                throw new IOException("Erro ao gerar e salvar a chave AES", e);
            }
        }

        byte[] encodedKey = Files.readAllBytes(Paths.get(KEY_FILE_PATH));
        String encodedKeyString = new String(encodedKey);
        byte[] decodedKey = Base64.getDecoder().decode(encodedKeyString);
        return new SecretKeySpec(decodedKey, ALGORITHM);
    }
}