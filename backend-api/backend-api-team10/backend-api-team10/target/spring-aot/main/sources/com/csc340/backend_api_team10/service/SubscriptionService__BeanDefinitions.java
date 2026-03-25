package com.csc340.backend_api_team10.service;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link SubscriptionService}.
 */
@Generated
public class SubscriptionService__BeanDefinitions {
  /**
   * Get the bean definition for 'subscriptionService'.
   */
  public static BeanDefinition getSubscriptionServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SubscriptionService.class);
    InstanceSupplier<SubscriptionService> instanceSupplier = InstanceSupplier.using(SubscriptionService::new);
    instanceSupplier = instanceSupplier.andThen(SubscriptionService__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
