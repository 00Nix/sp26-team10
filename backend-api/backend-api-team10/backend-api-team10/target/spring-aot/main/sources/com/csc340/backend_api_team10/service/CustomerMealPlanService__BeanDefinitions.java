package com.csc340.backend_api_team10.service;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link CustomerMealPlanService}.
 */
@Generated
public class CustomerMealPlanService__BeanDefinitions {
  /**
   * Get the bean definition for 'customerMealPlanService'.
   */
  public static BeanDefinition getCustomerMealPlanServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(CustomerMealPlanService.class);
    InstanceSupplier<CustomerMealPlanService> instanceSupplier = InstanceSupplier.using(CustomerMealPlanService::new);
    instanceSupplier = instanceSupplier.andThen(CustomerMealPlanService__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
