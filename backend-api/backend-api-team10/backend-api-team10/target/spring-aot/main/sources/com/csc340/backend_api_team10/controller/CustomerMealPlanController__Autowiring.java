package com.csc340.backend_api_team10.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link CustomerMealPlanController}.
 */
@Generated
public class CustomerMealPlanController__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static CustomerMealPlanController apply(RegisteredBean registeredBean,
      CustomerMealPlanController instance) {
    AutowiredFieldValueResolver.forRequiredField("mealPlanService").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
