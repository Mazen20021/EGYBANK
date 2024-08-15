plugins {
    java
    id("org.springframework.boot") version "3.3.2"
    id("io.spring.dependency-management") version "1.1.6"
}

group = "com.EgyPay"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
//    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
//    implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
//    implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
//    implementation("org.springframework.boot:spring-boot-starter-freemarker")
//    implementation("org.springframework.boot:spring-boot-starter-groovy-templates")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.5.0")
    implementation("org.springframework.boot:spring-boot-starter-jdbc")
//    implementation("org.springframework.boot:spring-boot-starter-oauth2-authorization-server")
//    implementation("org.springframework.boot:spring-boot-starter-oauth2-client")
//    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-web-services")
//    implementation("org.springframework.boot:spring-boot-starter-websocket")
//    implementation("org.springframework.session:spring-session-jdbc")
//    implementation("org.thymeleaf.extras:thymeleaf-extras-springsecurity6")
    compileOnly("org.projectlombok:lombok")
//    developmentOnly("org.springframework.boot:spring-boot-devtools")
    runtimeOnly("com.microsoft.sqlserver:mssql-jdbc")
    runtimeOnly("com.mysql:mysql-connector-j")
//    runtimeOnly("io.asyncer:r2dbc-mysql")
//    runtimeOnly("io.r2dbc:r2dbc-mssql:1.0.0.RELEASE")
//    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
//    testImplementation("io.projectreactor:reactor-test")
//    testImplementation("org.springframework.security:spring-security-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation ("org.modelmapper:modelmapper:2.4.2")

}

tasks.withType<Test> {
    useJUnitPlatform()
}
