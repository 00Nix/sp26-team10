package com.csc340.backend_api_team10.repository;

import com.csc340.backend_api_team10.entity.CustomerMealPlan;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.lang.String;
import java.util.List;
import org.springframework.aot.generate.Generated;
import org.springframework.data.jpa.repository.aot.AotRepositoryFragmentSupport;
import org.springframework.data.jpa.repository.query.QueryEnhancerSelector;
import org.springframework.data.repository.core.support.RepositoryFactoryBeanSupport;

/**
 * AOT generated JPA repository implementation for {@link CustomerMealPlanRepository}.
 */
@Generated
public class CustomerMealPlanRepositoryImpl__AotRepository extends AotRepositoryFragmentSupport {
  private final RepositoryFactoryBeanSupport.FragmentCreationContext context;

  private final EntityManager entityManager;

  public CustomerMealPlanRepositoryImpl__AotRepository(EntityManager entityManager,
      RepositoryFactoryBeanSupport.FragmentCreationContext context) {
    super(QueryEnhancerSelector.DEFAULT_SELECTOR, context);
    this.entityManager = entityManager;
    this.context = context;
  }

  /**
   * AOT generated implementation of {@link CustomerMealPlanRepository#findByDiet(java.lang.String)}.
   */
  public List<CustomerMealPlan> findByDiet(String diet) {
    String queryString = "SELECT c FROM CustomerMealPlan c WHERE c.diet = :diet";
    Query query = this.entityManager.createQuery(queryString);
    query.setParameter("diet", diet);

    return (List<CustomerMealPlan>) query.getResultList();
  }

  /**
   * AOT generated implementation of {@link CustomerMealPlanRepository#findByIsPremade(boolean)}.
   */
  public List<CustomerMealPlan> findByIsPremade(boolean isPremade) {
    String queryString = "SELECT c FROM CustomerMealPlan c WHERE c.isPremade = :isPremade";
    Query query = this.entityManager.createQuery(queryString);
    query.setParameter("isPremade", isPremade);

    return (List<CustomerMealPlan>) query.getResultList();
  }
}
