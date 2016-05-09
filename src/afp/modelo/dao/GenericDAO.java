/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afp.modelo.dao;

import java.io.Serializable;
import java.util.*;
import java.util.Map.*;
 
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
 
abstract class GenericDAO<T> implements Serializable {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("AssistentePessoalPU");
    private EntityManager em;
    
    private EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
    
}