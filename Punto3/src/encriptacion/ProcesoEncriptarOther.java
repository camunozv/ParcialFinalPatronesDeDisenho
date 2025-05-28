package encriptacion;

import java.security.spec.KeySpec;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

public class ProcesoEncriptarOther implements  InterfaceEncriptar{
    @Override
    public String encryptar(String message, String password) throws Exception {
        byte[] keyBytes = new byte[24];
        byte[] passwordBytes = password.getBytes("UTF-8");
        System.arraycopy(passwordBytes, 0, keyBytes, 0, Math.min(passwordBytes.length, 24));

        KeySpec keySpec = new DESedeKeySpec(keyBytes);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
        SecretKey key = keyFactory.generateSecret(keySpec);

        Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key);

        byte[] encrypted = cipher.doFinal(message.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(encrypted);
    }
}
