package hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import hello.MessagePrinter;
import hello.MessageService;

/*
 * 关于@Configuration，和（@Configuration类作为项目的配置主类——可以使用@ImportResource注解加载xml配置文件。）
 * 关于@ComponentScan:Spring提供两种方式将定义在另外一个带有@Configuration的类中的Bean加载，第一种，在Application类中使用@Import指定该类，第二种，让@ComponentScan扫描到该类。大部分情况都会选择第二种。
 * 关于AnnotationConfigApplicationContext
 * 关于@PostContruct和@PreDestroy
 * 少了ComponentScan如何，少了Configuration如何
 * ComponentScan的功能是把所有带有configuration和bean的扫描，并根据@Autowired和类型进行组装和注入
 * ComponentScan的默认路径为当前类目录和当前类子目录下的所有类
 * 为什么AnnotationConfigApplicationContext的参数是Application，
 *  因为在这个类里定义了MessageServiceBean，所以只能从这个类里取出来
 * 
 * 翻译：
 * p>Note that the {@code <context:component-scan>} element has an
 * {@code annotation-config} attribute, however this annotation does not. This is because
 * in almost all cases when using {@code @ComponentScan}, default annotation config
 * processing (e.g. processing {@code @Autowired} and friends) is assumed. Furthermore,
 * when using {@link AnnotationConfigApplicationContext}, annotation config processors are
 * always registered, meaning that any attempt to disable them at the
 * 
 * 关于@Import
 */
@Configuration
@ComponentScan
public class Application {

	@Bean
	@Scope("prototype")
	MessageService mockMessageService() {
		return new MessageService() {
			public String getMessage() {
				return "Hello world";
			}
		};
	}

	public static void main(String[] args) {
		// ApplicationContext context =
		// new AnnotationConfigApplicationContext(Application.class);
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(Application.class);
		MessagePrinter printer = context.getBean(MessagePrinter.class);
		printer.printMessage();
	}
}
