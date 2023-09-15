## How to use CLI to create a git repo?

# Project Details:
Spring Framework overview:
Goals of Spring -> lightweight development with Java POJOs(Plain old java object)
-> dependency injection to promote loose coupling
-> Minimize boilerplate java code

#core container:
Beans: is a fundamental concept. it is essentially an object that is instantiated, assembled, and managed by the spring Ioc(Inversion of Control)
container. These are building blocks of a spring application, and they represent the various components and objects that make up the application.

Here are some key characteristics/features:
1. Instantiation: Beans are typically java objects that are created by the spring container. The container is responsible for instantiating
these objects, and it does so base on the configuration provided.
2. Configuration Metadata: Beans are configured using metadata, which is usually specified in XML files, Java configuration classes, or annotations.
This metadata includes details like the bean's class, dependencies, and initialization parameters.
3. Dependencies Injection: Spring manages the dependencies between beans. When one bean depends on another, Spring automatically injects the depndent
bean into the requesting bean. This process is called dependency Injection and is a core principle fo Spring.
4. Lifecycle Management: Spring manages the lifecycle of beans, including creating,initializing,using,and potentially destroying them. You can
hook into bean lifecycle events using callback methods.
5. Scope: Beans can have different scopes, such as singleton(a single instance shared by all clients),  prototype(a new instance for each request)
, request(one instance per HTTP request), session(one instance per HTTP session), and more. The default scope is usually singleton.
6. Customization: You can customize the behavior of beans by adding annotations or implementing specific interfaces. For example, you can
use annotations like '@Component', '@Service', or '@Controller' to mark class as bean, and you can implement interfaces like 'InitializingBean' or
'DisposableBean' to define custom initialization and destruction logic.
7. Autowiring: Spring can automatically wire(connect) beans together by examining the dependencies defined in the configuration metadata. Autowiring 
eliminates the need for explicitly property or constructor injection.
8. Name and ID: Each bean has a name or ID associated with it, which is used to identify and reference the bean within the application context.
By default, the name is the lowercase version fo the bean's class name.
************************
### Here's an example of defining a simple bean in Spring Using XML configuration:
#<bean id="myBean" class="com.example.MyBean">
<!-- Dependencies and properties can be defined here -->
#</bean>

Core:
SpEL:
Context:

*********************
## Infrastructure: 
1. AOP (Aspect Oriented Programming): is a programming paradigm and methodology that provides a way to modularize cross-cutting concerns in 
software applications. Cross-cutting concerns are aspects of a program that affect multiple modules or components and are challenging to modularize
using traditional OOP techniques.
AOP introduces the concept of "aspects" to address these cross-cutting concerns. An aspect is a module that encapsulates behavior that can be applied to multiple parts of an application without altering the core logic of those parts. AOP achieves this by allowing you to define aspects separately from the main application logic and then applying these aspects where needed in a declarative manner.

Key concepts in AOP include:
1. **Advice**: Advice is a unit of code that represents a specific aspect's behavior. It defines what should happen and when it should happen. There are different types of advice, such as "before," "after," and "around," which determine whether the advice code should execute before, after, or around the target code.
2. **Join Point**: A join point is a specific point in the execution of a program, such as a method invocation or an exception being thrown. Join points are defined in the code where advice can be applied.
3. **Pointcut**: A pointcut is a set of one or more join points where advice should be applied. It defines the criteria for selecting specific join points in the program's execution flow.
4. **Aspect**: An aspect is a module that encapsulates advice and pointcut definitions. It combines advice and pointcuts to specify what code should be executed at which join points.
5. **Weaving**: Weaving is the process of integrating aspects into the application's codebase. It can occur at different times: compile-time, load-time, or runtime. The choice of weaving strategy depends on the AOP framework being used.
6. **AspectJ**: AspectJ is a widely-used AOP framework for the Java programming language. It provides a powerful set of language extensions for defining aspects and is often used in conjunction with Spring Framework for AOP support.
***************************
1.Aspects:
2.Instrumentation
3.Messaging
*******

### Data Access Layer:
In Spring, the Data Access Layer (DAL) is responsible for handling interactions with the database or other data sources. It abstracts and encapsulates the underlying database operations, making it easier to manage and maintain data-related tasks. Spring provides several features and tools to create an effective Data Access Layer, including:

1. **Data Source Configuration:**
    - Define and configure a data source in your Spring application context. Spring supports various data sources, including JDBC, JPA (Java Persistence API), Hibernate, and NoSQL databases.

2. **JDBC Template:**
    - Spring's `JdbcTemplate` is a powerful and simple abstraction for working with JDBC (Java Database Connectivity). It reduces boilerplate code and simplifies database operations.
    - Example:
   ```java
   @Autowired
   private JdbcTemplate jdbcTemplate;
   ```

3. **Object-Relational Mapping (ORM):**
    - Spring supports popular ORM frameworks like Hibernate, JPA, and JPA-based implementations like Spring Data JPA. ORM allows you to map Java objects to database tables, making database interactions more object-oriented.
    - Example with Spring Data JPA:
   ```java
   @Repository
   public interface UserRepository extends JpaRepository<User, Long> {
       // Custom queries can be defined here
   }
   ```

4. **Transactions:**
    - Spring provides a declarative way to manage transactions using annotations like `@Transactional`. This ensures that database operations are either fully completed or fully rolled back in case of an error.
    - Example:
   ```java
   @Transactional
   public void saveUser(User user) {
       userRepository.save(user);
   }
   ```

5. **Exception Handling:**
    - Spring's DataAccessException hierarchy simplifies handling database-related exceptions by providing a consistent and convenient way to manage errors.

6. **Spring Data:**
    - Spring Data projects, such as Spring Data JPA and Spring Data JDBC, provide higher-level abstractions and repository interfaces to simplify data access further.
    - Example with Spring Data JPA:
   ```java
   @Repository
   public interface UserRepository extends JpaRepository<User, Long> {
       List<User> findByLastName(String lastName);
   }
   ```

7. **QueryDSL:**
    - QueryDSL is a powerful library that allows you to create type-safe SQL-like queries in Java code. It integrates seamlessly with Spring Data and provides an alternative to string-based queries.
    - Example with QueryDSL:
   ```java
   QUser user = QUser.user;
   List<User> users = new JPAQueryFactory(entityManager)
       .selectFrom(user)
       .where(user.lastName.eq("Smith"))
       .fetch();
   ```

8. **Testing:**
    - Spring provides support for unit and integration testing of the Data Access Layer using testing annotations and utilities like `@DataJpaTest`, `@SpringBootTest`, and embedded databases.

9. **Connection Pooling:**
    - Spring can manage connection pooling for database connections, improving performance and resource utilization.

By effectively utilizing these Spring features and tools, you can create a robust and maintainable Data Access Layer in your Spring application, whether you're working with traditional JDBC, ORM frameworks, or NoSQL databases.

*******************
## Web Layer: All web related classes. Home of the  Spring MVC framework.
1. Servlet
2. WebSocket
3. Web
********************************
## Maven:

1. ** Maven is a widely-used build automation and project management tool primarily used for Java projects, although it can be applied to 
projects in other programming languages as well. It simplifies the process of building, managing dependencies, and packaging software 
projects. Maven uses a declarative approach to project configuration and is known for its convention-over-configuration philosophy. **

### What Problem it solves?

Maven solves several common problems in software development by providing a standardized and automated build process, dependency management, and project management capabilities:

1. **Build Automation:** Maven automates the build process, which involves compiling source code, running tests, packaging the application, and producing deliverables like JAR files, WAR files, or executable files. This automation reduces manual effort and the potential for human error in the build process.

2. **Dependency Management:** Maven simplifies the management of project dependencies. Instead of manually downloading and configuring libraries and external dependencies, Maven allows developers to declare dependencies in a POM file. Maven then retrieves and manages these dependencies from remote repositories, ensuring that the correct versions are used.

3. **Consistency:** Maven enforces a standardized project structure and naming conventions. This consistency makes it easier for developers to understand and navigate the codebase, particularly in larger projects with multiple contributors.

4. **Reusability:** Maven promotes code reuse by making it straightforward to share and publish libraries and artifacts. Developers can package their code as reusable libraries and publish them to central repositories for others to use.

5. **Project Lifecycle Management:** Maven defines a clear project lifecycle with well-defined phases, such as compile, test, package, install, and deploy. Developers can easily execute these phases in a predictable sequence, ensuring that code is properly compiled, tested, and packaged.

6. **Transitive Dependency Resolution:** Maven automatically resolves and manages transitive dependencies, simplifying the process of ensuring that all required libraries are included in the project. If Library A depends on Library B, and your project depends on Library A, Maven ensures that Library B is also included.

7. **Dependency Scope:** Maven supports different dependency scopes, allowing developers to define whether a dependency is required for compilation, testing, runtime, or other specific phases. This helps optimize the size and performance of the final application.

8. **Plugin Ecosystem:** Maven's extensible architecture allows developers to use a wide range of plugins to extend its capabilities. These plugins can perform tasks such as code generation, documentation generation, code quality analysis, and more.

9. **Repository Management:** Maven can manage both local and remote repositories, making it easy to host your own internal repositories for sharing custom libraries or artifacts within your organization.

10. **Integration with IDEs:** Many integrated development environments (IDEs) provide seamless integration with Maven, allowing developers to import Maven projects and leverage its build and dependency management capabilities directly within the IDE.

In summary, Maven simplifies and streamlines the development process by providing a consistent and automated way to build, manage dependencies, and manage projects. It helps reduce complexity, increase productivity, and improve collaboration among developers, making it a valuable tool in software development.

### How does maven work?

Maven works by providing a standardized and declarative approach to building, managing dependencies, and managing projects. It relies on a configuration file known as the Project Object Model (POM) to define how a project should be built and what dependencies it requires. Here's an overview of how Maven works:

1. **Project Setup:**
    - To start using Maven, you create a new project or convert an existing project into a Maven project. This typically involves creating a directory structure that follows Maven's conventions, including source code directories (e.g., `src/main/java`), resource directories (e.g., `src/main/resources`), and test directories (e.g., `src/test/java`).

2. **POM File:**
    - The heart of Maven is the Project Object Model (POM) file, named `pom.xml`. This XML file contains project-specific information and configuration details, including:
        - Project name, version, and description.
        - Project dependencies (libraries and other artifacts).
        - Build settings and plugins.
        - Repository locations for dependency resolution.
        - Project properties and profiles.

3. **Dependency Management:**
    - In the POM file, you declare project dependencies by specifying their coordinates (group ID, artifact ID, and version) and other optional details. Maven uses this information to resolve dependencies and download them from remote repositories if necessary.
    - Maven maintains a local repository on your machine where it stores downloaded dependencies to avoid redundant downloads.

4. **Build Lifecycle:**
    - Maven defines a standardized build lifecycle with well-defined phases, such as `clean`, `compile`, `test`, `package`, `install`, and `deploy`. These phases represent different stages in the software development and delivery process.
    - You can execute these phases using Maven commands (`mvn clean`, `mvn compile`, etc.), and Maven will perform the corresponding tasks defined in plugins bound to each phase.
5. **Plugins:**
    - Plugins are extensions that enhance Maven's capabilities. Each phase of the build lifecycle can be associated with one or more plugins, which perform specific tasks. For example, the `maven-compiler-plugin` compiles source code, while the `maven-surefire-plugin` runs tests.
    - Plugins are configured in the POM file, specifying their goals (tasks) and configuration parameters.

6. **Lifecycle Binding:**
    - The POM file binds specific plugins and goals to the standard lifecycle phases. This binding defines which tasks should be executed at each phase. For example, the `compile` phase might be bound to the `compile` goal of the `maven-compiler-plugin`.

7. **Building the Project:**
    - To build the project, you run Maven commands like `mvn clean package`. Maven will execute the associated phases and goals in the specified order.
    - During the build process, Maven compiles source code, runs tests, packages the application, and produces output artifacts (e.g., JAR files, WAR files) based on the project's configuration.

8. **Reporting and Documentation:**
    - Maven generates project reports and documentation, such as test reports, code quality reports, and project documentation, based on plugins configured in the POM file.

9. **Repository Management:**
    - Maven supports both local and remote repositories. Developers can host their own internal repositories for sharing custom libraries or artifacts within their organization.

10. **Integration with IDEs:**
    - Most integrated development environments (IDEs) offer built-in or plugin-based support for Maven, allowing developers to import Maven projects and perform build and dependency management tasks directly within the IDE.

In summary, Maven simplifies and automates various aspects of the software development process by providing a structured, declarative, and standardized approach to building and managing projects. It enforces conventions, promotes consistency, and enhances dependency management, making it a powerful tool for developers and build automation.

 ** First; it reads from the project config file, pom.xml file
Second: it checks for those dependencies in the local repo (Maven Local Repo)
Third: it will get dependencies from central maven repo
Fourth : it will save it in local repo
Fifth: prepares the build and run it **


**********

POM (Project-Object-Model) Structure:
> project meta-data : PROJECT NAME, VERSION ETC, OUTPUT FILE TYPE: JAR, WAR
> ********
> List of Dependencies : List of project we depend on Spring, Hibernate, etc
> *******
> plugins: Additional task to run , like Junit test report etc
>
Project Coordinates:
* Uniquely identify a project
* Elements:
> GroupId : Name of Company, group , or organization . Convention to use reverse domain name: com.learning.java
*****
> ArtifactId: Name of this project : MySpringApp
*** 
> Version: A specific release version like: 1.0, 1.1, etc
> if a project is under active development then: 1.0 - Snapshot
>

Application properties file:
* By-default spring boot will load properties file from : application.properties
* Read data from application.properties file
> ### Configuring .properties file :
> Configure server port :
     server.port = 8585
> * coach.name = Mickey Mouse
> * team.name = The Mouse Crew
### Reading Format: 
```java
   @Value("{coach.name}")
    private String coachName;
```

```java
    @Value("{team.name}")
    private String teamName;
```

#### Warning #####
> Do not use the src/main/webapp directory if your application is packed as JAR file. Although this is a standard Maven directory
> , it works only with WAR packaging. it is silently ignored by most build tools if you generate a JAR.
>
*****
## Teamlates:
> Spring boot does autoconfiguration for following templates:
> Freemarker:
> **
> Thymleaf:
> **
> Mustache:
> ** By Default spring boot will load templates from spring "/templates" directory
>
> ***** 
## Spring boot starters:
>
> A curated list of maven dependencies.
> A Collection of dependencies grouped together.
> Tested and verified by spring development team.
> Makes it much easier for developer to get started with spring .
> Reduces the amount of maven dependencies.
>
> Example: <Spring-boot-starter-web> (contains : spring_web; spring_webMVC; hibernate_validator; json; tomcat; etc)
***
# Spring Boot Dev Tools:
> Enables you to automatically start the app after modifications.
> 
> Add "spring-boot-devtools" dependency in your pom.xml file.

****************
# Spring Boot Actuators:
> Automatically exposes endpoints for metrics out-of-the box. End points are prefixed with : /actuator
> ***
> /health : Health information about your application
> ****
> Exposing end points:
> By default /health end point is exposed. In order to wrok with /info endpoint (which can provide information
> about your application) add some values in application.properties file.
> ###### management.endpoints.web.exposure.include = health, info
> ###### management.info.evn.enabled = true
> update application.properties with your app info
> ** info.app.name = my cool app
> ** into.app.description = this is the description of the application
> ** info.app.version = 1.0.0
> #### when /info endpoint is triggered, it will expose these app information in json format.

### How to secure these endpoints?
>1. Using Spring security.

***********
## Spring Security:
*************

##### Running application from commandline:
***Two Options 
> Option 1: java -jar <app_name.jar>
> *** from terminal: get to the directory location and package the application using "./mvnw package".
> this packs the application into target/ subdirectory
> ### mvnw: allows you to run a Maven project, no need to have maven installed in your project path
> now cd into the directory(/target) where we packaged the .jar file
> once you are in the right directory where .jar file is present: ##Use command: "java -jar <full_app_name_version>"
****

> Option 2: Using spring boot maven plugin:
 
*************
### Inversion of control:
Ioc is a fundamental design pattern principle in software engineering and is one of the core concepts underlying the spring framework.
IoC represents a shift in control over the flow of a program's execution , moving it from the program itself to a separate component or container.

### Dependency Injection:
Constructor based injection:
Setter based injection:

> @Component: marks the class as a Spring Bean. A Spring bean is just a regular java class that is managed by Spring.
> Component also makes the bean available for DI.
































