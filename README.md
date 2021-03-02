# Swagger

```xml
<!-- Swagger 2 --> 
<dependency> 
    <groupId>io.springfox</groupId> 
    <artifactId>springfox-swagger2</artifactId> 
    <version>2.9.2</version> 
</dependency> 
<dependency> 
    <groupId>io.springfox</groupId> 
    <artifactId>springfox-swagger-ui</artifactId> 
    <version>2.9.2</version> 
</dependency>
```

+ config

```java
@Configuration
@EnableSwagger2 
public class SwaggerConfig { 

    private final String BASE_PACKAGE = "com.example.demo";

    @Bean 
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)
        .select() 
        .apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE)) 
        .paths(PathSelectors.any()) 
       // .paths(PathSelectors.ant("/v1/api/**")) // v1/api/ 인 URL만 필터링
        .build()
        .apiInfo(apiInfo())
        .enable(true);
    } 

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API 타이틀")
                .description("API 상세소개 및 사용법 등")
                .version("1.0")
                .build();
    }
```
+ example

```java
@RestController
@Api(value="swagger-rest-controller", description = "swagger") // Controller에 대한 Swagger 설명
@RequestMapping("/api/v1") 
public class TestController {

    @ApiOperation(  // API에 대한 Swagger 설명
        value="서비스",
        notes = "서비스입니다.",
        httpMethod = "GET",
        consumes = "application/json",
        produces = "application/json",
        protocols = "http",
        responseHeaders = {
                //headers
    }) 
    @ApiResponses({  // Response Message에 대한 Swagger 설명
        @ApiResponse(code = 200, message = "OK"),
    })
    @GetMapping("user/search") 
    public Map<String, String> search() { 
        Map<String, String> response = new HashMap<String, String>(); 
        response.put("name", "taehong.kim"); 
        response.put("age", "28"); 
        response.put("email", "xxxxxxxx@gmail.com"); 
        return response; 
    } 
```