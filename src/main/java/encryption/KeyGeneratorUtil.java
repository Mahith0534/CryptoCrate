package encryption;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.util.Base64;

public class KeyGeneratorUtil {
    private static final String ALGORITHM = "AES";
    private static final int KEY_SIZE = 256;
    private static final String KEY_FILE = "secret.key"; // Persistent key storage file

    public static SecretKey generateKey() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
        keyGenerator.init(KEY_SIZE);
        return keyGenerator.generateKey();
    }

    public static void saveKey(SecretKey key) throws Exception {
        byte[] encodedKey = key.getEncoded();
        String keyString = Base64.getEncoder().encodeToString(encodedKey);

        try (FileOutputStream fos = new FileOutputStream(KEY_FILE)) {
            fos.write(keyString.getBytes());
        }
    }

    public static SecretKey loadKey() throws Exception {
        File file = new File(KEY_FILE);
        if (!file.exists()) {
            throw new Exception("Key file not found. Generate and save a key first.");
        }

        byte[] encodedKey = new FileInputStream(file).readAllBytes();
        byte[] decodedKey = Base64.getDecoder().decode(new String(encodedKey));
        return new javax.crypto.spec.SecretKeySpec(decodedKey, ALGORITHM);
    }

    public static void main(String[] args) throws Exception {
        SecretKey key = generateKey();
        saveKey(key);
        System.out.println("AES Key generated and saved.");

        SecretKey loadedKey = loadKey();
        System.out.println("Loaded AES Key: " + Base64.getEncoder().encodeToString(loadedKey.getEncoded()));
    }
}
