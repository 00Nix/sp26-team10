package com.csc340.backend_api_team10.service;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link CartService}.
 */
@Generated
public class CartService__BeanDefinitions {
  /**
   * Get the bean definition for 'cartService'.
   */
  public static BeanDefinition getCartServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(CartService.class);
    InstanceSupplier<CartService> instanceSupplier = InstanceSupplier.using(CartService::new);
    instanceSupplier = instanceSupplier.andThen(CartService__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
