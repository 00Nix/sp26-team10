package com.csc340.backend_api_team10.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link CustomerController}.
 */
@Generated
public class CustomerController__BeanDefinitions {
  /**
   * Get the bean definition for 'customerController'.
   */
  public static BeanDefinition getCustomerControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(CustomerController.class);
    InstanceSupplier<CustomerController> instanceSupplier = InstanceSupplier.using(CustomerController::new);
    instanceSupplier = instanceSupplier.andThen(CustomerController__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
