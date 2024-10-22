package JsonAndXml;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.Serializable;

public class JsonTest {
    public static void main(String[] args) {
        // Tạo một đối tượng ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();

        // Tạo một đối tượng Java (POJO)
        User user = new User("John Doe", "john.doe@example.com", 25);

        try {
            // Chuyển đổi đối tượng Java sang JSON
            String jsonString = objectMapper.writeValueAsString(user);
            System.out.println("JSON String: " + jsonString);


            //Chuyển từ json string to Pojo
            User user1 = objectMapper.readValue(jsonString, User.class);
            System.out.println("User Name: " + user.getName());


            //GSON
            // Chuyển đổi đối tượng Java sang JSON
            Gson gson = new Gson();
            String jsonString1 = gson.toJson(user);
            System.out.println("JSON String: " + jsonString);

            //Chuyển từ json string to Pojo
            User user2 = gson.fromJson(jsonString, User.class);
            System.out.println("User Name: " + user.getName());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class User implements Serializable {
    private String name;
    private String email;
    private int age;

    // Constructor, getters, setters, etc.
    public User(){}

    public User(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    // Getters and setters...

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
