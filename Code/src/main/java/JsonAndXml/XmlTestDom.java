package JsonAndXml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class XmlTestDom {

    public static void main(String[] args) {
        try {
            // Tạo DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Tải và phân tích file XML
            Document document = builder.parse(new File("C:\\Users\\Admin\\Desktop\\KAI_ASIA\\Week3\\bai3\\src\\main\\resources\\user.xml"));

            // Lấy danh sách các phần tử <user>
            NodeList nodeList = document.getElementsByTagName("user");

            // Duyệt qua các phần tử <user>
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element user = (Element) nodeList.item(i);
                String name = user.getElementsByTagName("name").item(0).getTextContent();
                String email = user.getElementsByTagName("email").item(0).getTextContent();
                String age = user.getElementsByTagName("age").item(0).getTextContent();

                System.out.println("User: " + name + ", Email: " + email + ", Age: " + age);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
