package cau.cau_be.config.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(
    title = "CAU API",
    description = "심화 프로젝트랩 3M1S 팀 CAU 프로젝트 API 서버",
    version = "1.0.0"
))
public class SwaggerConfig {

}
