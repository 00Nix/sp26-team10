package com.csc340.backend_api_team10.service;

import com.csc340.backend_api_team10.repository.ReviewRepository;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ReviewService}.
 */
@Generated
public class ReviewService__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'reviewService'.
   */
  private static BeanInstanceSupplier<ReviewService> getReviewServiceInstanceSupplier() {
    return BeanInstanceSupplier.<ReviewService>forConstructor(ReviewRepository.class)
            .withGenerator((registeredBean, args) -> new ReviewService(args.get(0)));
  }

  /**
   * Get the bean definition for 'reviewService'.
   */
  public static BeanDefinition getReviewServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ReviewService.class);
    InstanceSupplier<ReviewService> instanceSupplier = getReviewServiceInstanceSupplier();
    instanceSupplier = instanceSupplier.andThen(ReviewService__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
