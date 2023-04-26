package guru.springframework.creditcard.interceptors;

import java.lang.annotation.*;

/**
 * Created by jd birla on 26-04-2023 at 07:56
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface EncryptedString {
}