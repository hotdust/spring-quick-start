package hello.sub;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import hello.MessageService;

@Configuration
//@ComponentScan
public class NoConfigBean {

	@Bean
	@Scope("prototype")
	MessageService mockMessageService() {
		return new MessageService() {
			public String getMessage() {
				return "Hello world";
			}
		};
	}
}
