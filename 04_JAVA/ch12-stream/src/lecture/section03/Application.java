package lecture.section03;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // 주입
        UserService service = new UserService();

        // 전체조회
        List<User> users = service.getUsers();
//        users.forEach(user -> System.out.println(user));

        // 단일조회
        User user = service.getUserById(1L);
        System.out.println(user);

//        User user2 = service.getUserById(99L);
//        System.out.println(user2);

        service.printIfExist(3L);
        
        /*
        * 이메일
        * */
        
        String email = service.getEmail(1L);
        String email2 = service.getEmail(2L);

        System.out.println("email = " + email);
        System.out.println("email2 = " + email2);
    }
}
