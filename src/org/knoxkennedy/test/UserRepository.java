package org.knoxkennedy.test;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class UserRepository
{
    @Autowired
    private LocalSessionFactoryBean sessionFactoryBean;
    
    public List<User> getAllUsers()
    {
    	Session session = sessionFactoryBean.getObject().getCurrentSession();
    	
        return session.createQuery("from user").list();
    }
    
    public Integer createUser(User user)
    {
        //User mergeUser = this.hibernateTemplate.merge(user);
        //return mergeUser.getId();
    	return 0;
    }
}