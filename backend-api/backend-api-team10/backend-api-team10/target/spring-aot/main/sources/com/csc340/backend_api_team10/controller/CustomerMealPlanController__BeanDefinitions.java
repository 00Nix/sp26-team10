package com.csc340.backend_api_team10.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link CustomerMealPlanController}.
 */
@Generated
public class CustomerMealPlanController__BeanDefinitions {
  /**
   * Get the bean definition for 'customerMealPlanController'.
   */
  public static BeanDefinition getCustomerMealPlanControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(CustomerMealPlanController.class);
    InstanceSupplier<CustomerMealPlanController> instanceSupplier = InstanceSupplier.using(CustomerMealPlanController::new);
    instanceSupplier = instanceSupplier.andThen(CustomerMealPlanController__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
