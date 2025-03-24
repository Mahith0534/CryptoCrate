package encryption;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.FileOutputStream;

public class FileDecryptor {
    private static final String ALGORITHM = "AES";

    public static void decryptFile(String inputFilePath, String outputFilePath, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);

        byte[] encryptedBytes = Files.readAllBytes(Paths.get(inputFilePath));
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);

        try (FileOutputStream fos = new FileOutputStream(outputFilePath)) {
            fos.write(decryptedBytes);
        }
    }

    public static void main(String[] args) throws Exception {
        SecretKey key = KeyGeneratorUtil.loadKey(); // Load the saved AES key
        decryptFile("encrypted.dat", "decrypted.txt", key);
        System.out.println("File decrypted successfully.");
    }
}
