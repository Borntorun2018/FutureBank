package com.eBusiness.persist.repo;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GeneralJpaSpecificationExecutor<ENTITY> extends JpaSpecificationExecutor<ENTITY> {
}
