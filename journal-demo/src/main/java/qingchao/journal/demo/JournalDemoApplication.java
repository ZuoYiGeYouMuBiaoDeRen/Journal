package qingchao.journal.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class JournalDemoApplication {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		log.info("=============Service is starting=============");
		SpringApplication.run(JournalDemoApplication.class, args);
		log.info("=============Service start success, use {} millis===========",System.currentTimeMillis()-start);
	}

}
