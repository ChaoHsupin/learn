package site.yanyan.learn.configer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.LinkedList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {


    @Bean
    public Docket sysDocket() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("开发接口")
                .apiInfo(new ApiInfoBuilder().title("开发接口-接口文档")
                        .contact(new Contact("言言无绝期", "www.yanyan.site", "zhaoxubin2016@live.com")).version("1.0")
                        .build())
                .select().paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("site.yanyan.learn.controller.dev")).build()
                .globalOperationParameters(SwaggerConfig.getParamList());
    }

    @Bean
    public Docket manage() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("用户管理")
                .apiInfo(new ApiInfoBuilder().title("用户管理-接口文档")
                        .contact(new Contact("言言无绝期", "www.yanyan.site", "zhaoxubin2016@live.com")).version("1.0")
                        .build())
                .select().paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("site.yanyan.learn.controller.sys")).build()
                .globalOperationParameters(SwaggerConfig.getParamList());
    }

    @Bean
    public Docket serve() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("功能API")
                .apiInfo(new ApiInfoBuilder().title("用户管理-接口文档")
                        .contact(new Contact("言言无绝期", "www.yanyan.site", "zhaoxubin2016@live.com")).version("1.0")
                        .build())
                .select().paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("site.yanyan.learn.controller.serve")).build()
                .globalOperationParameters(SwaggerConfig.getParamList());
    }


    //一些额外的请求参数配置
    static List<Parameter> getParamList() {
        List<Parameter> pars = new LinkedList<>();
        ParameterBuilder tokenPar = new ParameterBuilder();
        tokenPar.name("Authentication").description("令牌")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false).build();

        ParameterBuilder signPar = new ParameterBuilder();
        signPar.name("sign").description("数据签名")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false).build();
        ParameterBuilder timePar = new ParameterBuilder();
        timePar.name("timestamp").description("时间戳")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false).build();


        pars.add(tokenPar.build());
        pars.add(signPar.build());
        pars.add(timePar.build());
        return pars;
    }
}