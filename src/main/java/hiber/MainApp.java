package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User("User1", "Lastname1", "user1@mail.ru");
      user1.setCar(new Car("Car1", 100));
      userService.add(user1);

      User user2 = new User("User2", "Lastname2", "user2@mail.ru");
      user2.setCar(new Car("Car2", 200));
      userService.add(user2);

      User user3 = new User("User3", "Lastname3", "user3@mail.ru");
      user3.setCar(new Car("Car3", 300));
      userService.add(user3);

      User user4 = new User("User4", "Lastname4", "user4@mail.ru");
      user4.setCar(new Car("Car4", 400));
      userService.add(user4);

      List<User> users = userService.listUsers();
      System.out.println(users);

      List<Car> cars = userService.listCars();
      System.out.println(cars);

      User userWithCar = userService.getUserbyCar("Car2", 200);
      System.out.println(userWithCar);

      context.close();
   }
}
