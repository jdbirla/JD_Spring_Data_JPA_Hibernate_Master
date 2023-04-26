package guru.springframework.creditcard.service;

/**
 * Created by jd birla on 26-04-2023 at 07:12
 */
public interface EncryptionService {

    String encrypt(String freeText);

    String decrypt(String encryptedText);
}
