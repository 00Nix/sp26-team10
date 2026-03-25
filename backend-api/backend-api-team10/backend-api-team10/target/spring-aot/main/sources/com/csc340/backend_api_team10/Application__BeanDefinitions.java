package com.csc340.backend_api_team10;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link Application}.
 */
@Generated
public class Application__BeanDefinitions {
  /**
   * Get the bean definition for 'application'.
   */
  public static BeanDefinition getApplicationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(Application.class);
    beanDefinition.setInstanceSupplier(Application::new);
    return beanDefinition;
  }
}
