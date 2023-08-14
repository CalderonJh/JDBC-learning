package br.com.alura.tienda.utils;

import javax.persistence.*;

public class JPAUtils {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("main");

    public static EntityManager getEntityManager() {
        return  entityManagerFactory.createEntityManager();
    }
}
