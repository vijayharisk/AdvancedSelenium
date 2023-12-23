package fileutility;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
	public String getDataFromProperty(String key) throws IOException {	
		FileInputStream fis = new FileInputStream("C:\\Users\\vijayh\\Desktop\\workspace java\\ShoppersStack\\src\\test\\resources\\Shoppersstack.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		String data = pObj.getProperty(key);
		return data;
	}
}
