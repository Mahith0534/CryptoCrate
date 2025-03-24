package encryption;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.FileOutputStream;

public class FileEncryptor {
    private static final String ALGORITHM = "AES";

    public static void encryptFile(String inputFilePath, String outputFilePath, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);

        byte[] inputBytes = Files.readAllBytes(Paths.get(inputFilePath));
        byte[] encryptedBytes = cipher.doFinal(inputBytes);

        try (FileOutputStream fos = new FileOutputStream(outputFilePath)) {
            fos.write(encryptedBytes);
        }
    }

    public static void main(String[] args) throws Exception {
        SecretKey key = KeyGeneratorUtil.loadKey(); // Load the saved AES key
        encryptFile("input.txt", "encrypted.dat", key);
        System.out.println("File encrypted successfully.");
    }
}
