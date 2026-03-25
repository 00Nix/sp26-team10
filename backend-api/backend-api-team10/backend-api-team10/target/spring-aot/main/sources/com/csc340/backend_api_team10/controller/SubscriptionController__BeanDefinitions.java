package com.csc340.backend_api_team10.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link SubscriptionController}.
 */
@Generated
public class SubscriptionController__BeanDefinitions {
  /**
   * Get the bean definition for 'subscriptionController'.
   */
  public static BeanDefinition getSubscriptionControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SubscriptionController.class);
    InstanceSupplier<SubscriptionController> instanceSupplier = InstanceSupplier.using(SubscriptionController::new);
    instanceSupplier = instanceSupplier.andThen(SubscriptionController__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
