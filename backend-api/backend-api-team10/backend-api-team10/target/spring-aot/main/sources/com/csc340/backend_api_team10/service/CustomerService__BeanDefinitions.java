package com.csc340.backend_api_team10.service;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link CustomerService}.
 */
@Generated
public class CustomerService__BeanDefinitions {
  /**
   * Get the bean definition for 'customerService'.
   */
  public static BeanDefinition getCustomerServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(CustomerService.class);
    InstanceSupplier<CustomerService> instanceSupplier = InstanceSupplier.using(CustomerService::new);
    instanceSupplier = instanceSupplier.andThen(CustomerService__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
