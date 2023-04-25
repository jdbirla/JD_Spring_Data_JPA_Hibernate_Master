package guru.springframework.sdjpainheritence.domain.msuper;

import jakarta.persistence.Entity;

/**
 * Created by jd birla on 25-04-2023 at 15:14
 */
@Entity
public class OrderHeader extends BaseEntity {

    private String customerName;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}