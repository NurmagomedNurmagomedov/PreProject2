package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.sql.ResultSet;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {


   private SessionFactory sessionFactory;

   @Autowired
   public void setSessionFactory(SessionFactory sessionFactory) {
      this.sessionFactory = sessionFactory;
   }

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().persist(user);
   }

   @Override
   public void add(User user, Car car) {
      user.setCar(car);
      car.setUser(user);
      sessionFactory.getCurrentSession().persist(user);
   }

   @Override
   public List<User> findByCar(Car car) {
      String hql="SELECT u FROM User u JOIN u.car c WHERE c.model = :model AND c.series = :series";
      List<User> foundUsers = sessionFactory.getCurrentSession()
              .createQuery(hql)
              .setParameter("model", car.getModel())
              .setParameter("series", car.getSeries())
              .getResultList();

      return foundUsers;
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

}
