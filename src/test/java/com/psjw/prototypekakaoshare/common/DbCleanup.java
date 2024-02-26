package com.psjw.prototypekakaoshare.common;

import org.springframework.beans.factory.InitializingBean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.metamodel.EntityType;
import java.util.List;
import java.util.Set;

public class DbCleanup implements InitializingBean {
    @PersistenceContext
    private EntityManager entityManager;

    private List<String> tableNames;

    @Override
    public void afterPropertiesSet() throws Exception {
        Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();
    }
}
