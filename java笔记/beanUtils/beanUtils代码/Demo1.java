package Demo2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

public class Demo1 {

    public static void main(String[] args) throws Exception {
	String age = "110";
	String name = "chenqi";
	String salary = "1000";
	String date = "2016-05-23";

//	 注册一个类型转换器
	 ConvertUtils.register(new Converter() {
	
	 @Override
	 public Object convert(Class type, Object value) {
	
	 Date date = null;
	 try {
	 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	 date = dateFormat.parse((String) value);
	 } catch (ParseException e) {
	 // TODO Auto-generated catch block
	 e.printStackTrace();
	 }
	 return date;
	 }
	 }, Date.class);

//	ConvertUtils.register(new Converter() {
//
//	    @Override
//	    public Object convert(Class type, Object value) { // type :
//							      // 目前所遇到的数据类型。
//							      // value :目前参数的值。
//		Date date = null;
//		try {
//		    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		    date = dateFormat.parse((String) value);
//		} catch (Exception e) {
//		    e.printStackTrace();
//		}
//		return date;
//	    }
//
//	}, Date.class);
	Person p = new Person();
	BeanUtils.setProperty(p, "name", name);
	BeanUtils.setProperty(p, "age", age);
	BeanUtils.setProperty(p, "salary", salary);
	BeanUtils.setProperty(p, "date", date);

	System.out.println(p);
    }
}
