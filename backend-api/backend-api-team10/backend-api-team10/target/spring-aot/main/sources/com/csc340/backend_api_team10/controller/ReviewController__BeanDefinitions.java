package com.csc340.backend_api_team10.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ReviewController}.
 */
@Generated
public class ReviewController__BeanDefinitions {
  /**
   * Get the bean definition for 'reviewController'.
   */
  public static BeanDefinition getReviewControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ReviewController.class);
    InstanceSupplier<ReviewController> instanceSupplier = InstanceSupplier.using(ReviewController::new);
    instanceSupplier = instanceSupplier.andThen(ReviewController__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
