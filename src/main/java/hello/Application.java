package hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import hello.MessagePrinter;
import hello.MessageService;

@Configuration
@ComponentScan
public class Application {

	// 把下面的类放到NoConfigBean里面为了测试：
	// 1，ComponentScan扫描的范围包不包括子包。
	// 2，是不是只有被AnnotationConfigApplicationContext加载的配置类中有ComponentScan注解，
	//   才会进行Bean扫描。
//	@Bean
//	@Scope("prototype")
//	MessageService mockMessageService() {
//		return new MessageService() {
//			public String getMessage() {
//				return "Hello world";
//			}
//		};
//	}

	public static void main(String[] args) {
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(Application.class);
		// 如果去掉@ComponentScan的话，就得像下面一样，把所有的需要配置的类都加载进来
//		ApplicationContext context = 
//				new AnnotationConfigApplicationContext(Application.class,NoConfigBean.class,MessagePrinter.class);
		MessagePrinter printer = context.getBean(MessagePrinter.class);
		printer.printMessage();
	}
}
