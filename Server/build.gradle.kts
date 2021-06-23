group = "org.mebelShop"
version = "1.0"

plugins {
    java
    id("org.springframework.boot") version "2.5.1"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    application
}

apply(plugin = "io.spring.dependency-management")

repositories {
    mavenCentral()

    maven {
        url = uri("https://maven.springframework.org/release")
    }

    gradlePluginPortal()
}

dependencies{
    // Spring
    implementation("org.springframework.boot:" +
            "spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:" +
            "spring-boot-starter-security")
    implementation("org.springframework.boot:" +
            "spring-boot-starter-web")

    // DataBase
    implementation("org.postgresql:" +
            "postgresql")

    //Java setter/getter tool
    compileOnly("org.projectlombok:" +
            "lombok")
    annotationProcessor("org.projectlombok:" +
            "lombok")
    //Test
    testImplementation("org.springframework.boot:" +
            "spring-boot-starter-test")
    testImplementation("org.springframework.security:" +
            "spring-security-test")
    testImplementation("org.springframework.security:" +
            "spring-security-config")

    //JWT
    implementation("io.jsonwebtoken:" +
            "jjwt-api:0.11.2")
    implementation("io.jsonwebtoken:" +
            "jjwt-impl:0.11.2")
    implementation("io.jsonwebtoken:" +
            "jjwt-jackson:0.11.2")

//    <!--        <dependency>-->
//    <!--            <groupId>org.flywaydb</groupId>-->
//    <!--            <artifactId>flyway-core</artifactId>-->
//    <!--        </dependency>-->
//    </dependencies>
//
//    <build>
//    <plugins>
//    <plugin>
//    <groupId>org.springframework.boot</groupId>
//    <artifactId>spring-boot-maven-plugin</artifactId>
//    <configuration>
//    <excludes>
//    <exclude>
//    <groupId>org.projectlombok</groupId>
//    <artifactId>lombok</artifactId>
//    </exclude>
//    </excludes>
//    </configuration>
//    </plugin>
//    </plugins>
//    </build>
}

sourceSets.main {
    java.srcDirs("src/")
    resources.srcDirs("src/main/resources")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

tasks.processResources{
    duplicatesStrategy = DuplicatesStrategy.INCLUDE
}

application{
    mainClass.set("com.example.mebelshop.MebelShopApplication")
}

tasks.jar {
    manifest {
        attributes(
            "Main-Class" to application.mainClass.get()
        )
    }
    exclude("META-INF/*.RSA")
    exclude("META-INF/*.SF")
    exclude("META-INF/*.DSA")
}


//tasks.register<Jar>("buildFatJar") {
//    dependsOn(tasks.build)
//    manifest {
//        attributes["Main-Class"] = application.mainClass.get()
//    }
//    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
//    from(configurations.compileClasspath.get().files.map { if (it.isDirectory) it else zipTree(it) })
//    with(tasks.jar.get() as CopySpec)
//    archiveBaseName.set("${project.name}-fat")
//    exclude("META-INF/*.RSA")
//    exclude("META-INF/*.SF")
//    exclude("META-INF/*.DSA")
//}