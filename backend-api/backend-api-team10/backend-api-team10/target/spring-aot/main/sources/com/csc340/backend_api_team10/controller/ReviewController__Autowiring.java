package com.csc340.backend_api_team10.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link ReviewController}.
 */
@Generated
public class ReviewController__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static ReviewController apply(RegisteredBean registeredBean, ReviewController instance) {
    AutowiredFieldValueResolver.forRequiredField("reviewService").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
