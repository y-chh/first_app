## How to use CLI to create a git repo?

# Project Details:
Spring Framework overview:
Goals of Spring -> lightweight development with Java POJOs(Plain old java object)
-> dependency injection to promote loose coupling
-> Minimize boilerplate java code

#core container:
Beans:
Core:
SpEL:
Context:

*******
How Maven Works?

First; it reads from the project config file, pom.xml file
Second: it checks for those dependencies in the local repo (Maven Local Repo)
Third: it will get dependencies from central maven repo
Fourth : it will save it in local repo
Fifth: prepares the build and run it
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
> By-default spring boot will load properties file from : application.properties
* Read data from application.properties file
> #Configure server port :
> server.port = 8585
> * # Configure my props:
> * coach.name = Mickey Mouse
> * team.name = The Mouse Crew
    >   * # Reading Format: ** @Value("{coach.name}")
          >     * private String coachName;
>     * # @Value("{team.name}")
>     * private String teamName;
>
>
#### Warning #####
> Do not use the src/main/webapp directory if your application is packed as JAR file. Although this is a standard Maven directory
> , it works only with WAR packaging. it is silently ignored by most build tools if you generate a JAR.
>
*****
## Teamplates:
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
>
##### Running application from commandline:
***Two Options
> Option 1: java -jar <app_name.jar>
> *** from terminal: get to the directiory location and package the application using "./mvnw package".
> this packes the application into target/ subdirectory
> ## mvnw: allows you to run a Maven project, no need to have maven installed in your project path
> now cd into the directory(/target) where we packaged the .jar file
> once you are in the right directory where .jar file is present: ##Use command: "java -jar <full_app_name_version>"
****

> Option 2: Using spring boot maven plugin:
> 