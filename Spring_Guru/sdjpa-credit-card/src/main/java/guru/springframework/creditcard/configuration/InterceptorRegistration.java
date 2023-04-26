package guru.springframework.creditcard.configuration;

import guru.springframework.creditcard.interceptors.EncryptionInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * Created by jd birla on 26-04-2023 at 07:43
 */
//@Configuration
public class InterceptorRegistration implements HibernatePropertiesCustomizer {

    @Autowired
    //EncryptionInterceptor interceptor;

    @Override
    public void customize(Map<String, Object> hibernateProperties) {
    //    hibernateProperties.put("hibernate.session_factory.interceptor", interceptor);
    }
}