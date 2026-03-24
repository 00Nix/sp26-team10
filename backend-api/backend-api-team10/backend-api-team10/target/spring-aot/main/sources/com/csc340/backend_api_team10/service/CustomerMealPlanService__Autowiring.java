package com.csc340.backend_api_team10.service;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link CustomerMealPlanService}.
 */
@Generated
public class CustomerMealPlanService__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static CustomerMealPlanService apply(RegisteredBean registeredBean,
      CustomerMealPlanService instance) {
    AutowiredFieldValueResolver.forRequiredField("mealPlanRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
