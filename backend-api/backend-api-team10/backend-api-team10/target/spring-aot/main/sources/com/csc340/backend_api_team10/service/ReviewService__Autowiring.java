package com.csc340.backend_api_team10.service;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link ReviewService}.
 */
@Generated
public class ReviewService__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static ReviewService apply(RegisteredBean registeredBean, ReviewService instance) {
    AutowiredFieldValueResolver.forRequiredField("customerRepository").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("subscriptionRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
