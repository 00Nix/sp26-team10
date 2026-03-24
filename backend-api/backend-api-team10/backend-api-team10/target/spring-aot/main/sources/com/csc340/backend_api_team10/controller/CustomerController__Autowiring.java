package com.csc340.backend_api_team10.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link CustomerController}.
 */
@Generated
public class CustomerController__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static CustomerController apply(RegisteredBean registeredBean,
      CustomerController instance) {
    AutowiredFieldValueResolver.forRequiredField("customerService").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("subscriptionService").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("reviewService").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
