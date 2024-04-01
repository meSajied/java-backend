package org.example.collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
  @Autowired
  private HibernateTemplate hibernateTamplet;

  @Transactional
  public int saveUser(User user) {
    int id = (Integer)this.hibernateTamplet.save(user);
    return id;
  }
}