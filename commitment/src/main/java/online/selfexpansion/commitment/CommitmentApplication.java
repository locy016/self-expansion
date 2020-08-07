package online.selfexpansion.commitment;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("online.selfexpansion.commitment.mapper")
public class CommitmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommitmentApplication.class, args);
    }

}
