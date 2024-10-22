package JsonAndXml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.List;

public class XmlTestJaxb {

    public static void main(String[] args) {
        try {
            // Tạo đối tượng User
            UserXml user = new UserXml("John Doe", "john.doe@example.com", 25);

            // Tạo JAXBContext và Marshaller
                JAXBContext context = JAXBContext.newInstance(UserXml.class);
            Marshaller marshaller = context.createMarshaller();

            // Thiết lập format đẹp cho XML
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Chuyển đổi đối tượng Java thành XML và in ra màn hình
            marshaller.marshal(user, System.out);

            Unmarshaller unmarshaller = context.createUnmarshaller();
            UserXml userXmls = (UserXml) unmarshaller.unmarshal(new File("C:\\Users\\Admin\\Desktop\\KAI_ASIA\\Week3\\bai3\\src\\main\\resources\\user1.xml"));
            System.out.println(userXmls.getName());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

}

@XmlRootElement(name = "user")
class UserXml {
    private String name;
    private String email;
    private int age;

    // Constructors, getters, setters

    public UserXml() {}

    public UserXml(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    @XmlElement
    public String getName() {
        return name;
    }

    @XmlElement
    public String getEmail() {
        return email;
    }

    @XmlElement
    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
