package guru.springframework.creditcard.domain;

import guru.springframework.creditcard.configuration.SpringContextHelper;
import guru.springframework.creditcard.service.EncryptionService;
import jakarta.persistence.*;

/**
 * Created by jd birla on 26-04-2023 at 09:13
 */
public class CreditCardJPACallBack {

    @PrePersist
    @PreUpdate
    public void beforeInsertOrUpdate(CreditCard creditCard) {
        System.out.println("before update was called...");
        creditCard.setCreditCardNumber(getEncryptionService().encrypt(creditCard.getCreditCardNumber()));
    }

    @PostPersist
    @PostLoad
    @PostUpdate
    public void postLoad(CreditCard creditCard) {
        System.out.println("Post Load was called...");
        creditCard.setCreditCardNumber(getEncryptionService().decrypt(creditCard.getCreditCardNumber()));
    }

    private EncryptionService getEncryptionService(){
        return SpringContextHelper.getApplicationContext().getBean(EncryptionService.class);
    }

}
