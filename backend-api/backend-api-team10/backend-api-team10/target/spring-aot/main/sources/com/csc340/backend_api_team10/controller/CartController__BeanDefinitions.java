package com.csc340.backend_api_team10.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link CartController}.
 */
@Generated
public class CartController__BeanDefinitions {
  /**
   * Get the bean definition for 'cartController'.
   */
  public static BeanDefinition getCartControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(CartController.class);
    InstanceSupplier<CartController> instanceSupplier = InstanceSupplier.using(CartController::new);
    instanceSupplier = instanceSupplier.andThen(CartController__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
