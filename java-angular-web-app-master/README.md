## Spring boot app with Angular 4 client embedded [![Build Status](https://travis-ci.org/amanganiello90/java-angular-web-app.svg)](https://travis-ci.org/amanganiello90/java-angular-web-app)

![Technology-Stack](https://github.com/amanganiello90/java-angular-web-app/blob/branch-screen/stack.png)

<img src="https://img.shields.io/github/forks/amanganiello90/java-angular-web-app.svg">&nbsp;
<img src="https://img.shields.io/github/stars/amanganiello90/java-angular-web-app.svg">&nbsp;<a href="https://github.com/amanganiello90/java-angular-web-app/issues"><img src="https://img.shields.io/github/issues/amanganiello90/java-angular-web-app.svg">
</a>&nbsp;<img src="https://img.shields.io/github/license/amanganiello90/java-angular-web-app.svg">&nbsp;<img src="https://img.shields.io/github/downloads/amanganiello90/java-angular-web-app/total.svg">&nbsp;

|Please donate whether you wish support us to give more time to app's growth | [![](https://www.paypal.com/en_US/IT/i/btn/btn_donateCC_LG.gif)](https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=XTC895QYD28TC) |
|:------------------------------------------------------------------------------|:------------------------------------------------------------------------------------------------------------------------------------------------------|

The frontend-app is gotten from :https://github.com/creativetimofficial/material-dashboard-angular.
The project produces **an only jar** using maven spring-boot, that is you can implement java backend services, together the angular client developed in typescript (angular-cli). Download the zip of this branch or clone the git repo.


## NEWS

* 03/04/2018 added embedded [node](https://nodejs.org/dist/v9.4.0/win-x64/) for express in electron-app-exe folder using electron-packager
* 23/03/2018 refer to resolved [Issue 2](https://github.com/amanganiello90/java-angular-web-app/issues/2) related to add [travis ci](https://travis-ci.org/) and automatic deploy on [keroku](https://www.heroku.com/) with .travis-deploy-heroku.sh file 
* 05/03/2018 added spring boot jar child process mode running in electron app
* 05/03/2018 added express server external process in electron app to live angular app built
* 02/03/2018 refer to resolved [Issue 1](https://github.com/amanganiello90/java-angular-web-app/issues/1) related the routing of single page app in spring boot tomcat server
* 02/03/2018 a feature that integrates an embedded spring-boot rest web service that uses mongodb with the front-end application (**in development** on feature/integration-mongodb branch)
* 02/03/2018 added example on how implement a rest web service with spring-boot that uses mongodb (feature/webservice-mongodb branch)
* 18/10/2017 added example on how implement a rest web service with spring-boot that uses h2 database embedded (feature/h2 branch)


## NEXT DEVELOPMENTS (checked in progress)

- [x] Integrate mongodb (and h2) and webservice in spring-boot
- [ ] Integrate mongodb (and h2) and webservice in node express server
- [ ] Use embedded jre for jar in electron


## Table of contents

   * [Description](#description)
      * [Functional informations](#functional-informations)
      * [Prerequisites](#prerequisites)
      * [Live](#live)
      * [Build and run](#build-and-run)
      * [Electron](#electron) 
		* [Express server mode](#express-server-mode)
		* [Spring boot jar mode](#spring-boot-jar-mode)
		* [Express server electron packager exe mode](#express-server-electron-packager-exe-mode)
   * [Deploy jar on heroku from your machine](#deploy-jar-on-heroku-from-your-machine)
   * [Automatic build and deploy with travis](#automatic-build-and-deploy-with-travis)
   * [Live demo heroku deployed jar](#live-demo-heroku-deployed-jar)



## Description

The project is used to develop the client in the **frontend-app** folder with the __angular-cli__, and the **java backend** with the __maven spring boot project configured__.
For this, import your client (frontend-app) in the angular/typescript IDE (i.e. __visual studio code__) and your maven java backend in __Eclipse__.

### Functional informations

The steps to build the jar are defined in the pom.xml file. The project builds the frontend with the output folder **frontend-app/dist** and copies it in the __target/classes/static__ folder in order to load the client in the spring boot home page together the java services.
The port information is stored in **src/main/resources/application.properties** file in the __server.port__ property.

### Prerequisites


* Add npm build.prod script in your **front-end package.json project** with @angular/cli devDependency as:

```
{
  "name": "md-free-angular-cli",
  "version": "1.4.1",
  "license": "MIT",
  "scripts": {
    "ng": "ng",
    "start": "ng serve",
    "build": "ng build",
    "build.prod": "ng build --prod",
    "test": "ng test",
    "lint": "ng lint",
    "e2e": "ng e2e"
  },
  "private": true,
  "dependencies": {
    ....
  },
  "devDependencies": {
    "@angular/cli": "1.4.2",
	....
  }
}
```

* JDK 8 (set JAVA_HOME environment variable)

* The Node.js version compatible with your angular app

* MAVEN (to use **mvn** command else use in windows ./mvnw.cmd or in linux ./mvnw instead)

* IDE ( i.e. Eclipse for java and visual studio code for typescript/angular projects)

### Live

Execute in the main folder of this repo, if you have already built the frontend and there is the generated code in **frontend-app/dist** :

```
mvn clean spring-boot:run
```
else:

```
mvn clean spring-boot:run -Pbuild-ui
```

Open browser on localhost:8081:

![Live-App](https://github.com/amanganiello90/java-angular-web-app/blob/branch-screen/live-app.jpg)

### Build and run

If you have already built the frontend (i. e. after develop on visual studio code) and you have the generated code of the _ng build_ in **frontend-app/dist**, execute in the main folder of this repo:

```
mvn clean package
```

If you want to build also the frontend, run:

```
mvn clean package -Pbuild-ui
```

After all cases run:

```
java -jar target/*.jar
```

Open browser on localhost:8081

### Electron 

#### Express server mode 

After built your front-end app with the **-Pbuild-ui** profile (or with *npm run build.prod* command under frontend-app folder), run in the **electron-app** folder these commands:


* npm install
* npm start

App in electron:

![Electron-App](https://github.com/amanganiello90/java-angular-web-app/blob/branch-screen/electron-app.jpg)

In this way a express server child process is run in the electron container. You can read log in its window with **F1 keyword**.

Express log in electron:

![Electron-Log](https://github.com/amanganiello90/java-angular-web-app/blob/branch-screen/electron-log.jpg)


#### Spring boot jar mode 

After generated your spring boot jar with **mvn clean package**, run in the **electron-jar** folder these steps:


* npm install
* copy the app.jar under target in electron-jar folder
* npm start

In this way spring boot jar start as child process in the electron container. You can read log in its window with **F1 keyword**.

Spring Boot log in electron:

![Electron-Spring](https://github.com/amanganiello90/java-angular-web-app/blob/branch-screen/electron-spring.jpg)

#### Express server electron packager exe mode 

After built your front-end app with the **-Pbuild-ui** profile (or with *npm run build.prod* command under frontend-app folder), run in the **electron-app-exe** folder these commands:


* npm install
* copy the dist folder under frontend-app in electron-app-exe folder
* npm run package


After this, you will have an **electron-app.exe** to run under **electron-app-exe\distribution\electron-app-win32-ia32** folder.
In this way a express server child process is run in the electron container. You can read log in its window with **F1 keyword**.


## Deploy jar on heroku from your machine


Create an account on [keroku](https://www.heroku.com/) .

After install the __heroku-cli__

```
npm install -g heroku-cli
```

Then:

```
heroku plugins:install heroku-cli-deploy

heroku create spring-boot-angular-app2  --no-remote

```

To deploy the jar file, execute in the main folder of this repo:

```
heroku deploy:jar target/app.jar --app spring-boot-angular-app2
```

View [app](https://spring-boot-angular-app2.herokuapp.com/)

## Automatic build and deploy with travis

You can configure your git repo for continuous integration with [travis](https://travis-ci.org/) .

For the configuration travis will use the **.travis.yml** and **.travis-deploy-heroku.sh** files.

Then, for your repo you have to configure only two things:

* Replace your heroku deploy app name in the **.travis-deploy-heroku.sh** (here *spring-boot-angular-app* with *spring-boot-angular-app2*) that before you have created on heroku with the command (or heroku dashboard):

```
heroku create spring-boot-angular-app2  --no-remote

```

* Set the HEROKU_API_KEY environment variable on travis. You can retrieve it after these commands on your machine:

```
heroku login
heroku auth:token

```
The last display the token that you will set in the HEROKU_API_KEY variable. 
It allows travis to have permission to deploy on heroku.

## Live demo heroku deployed jar

A demo [app](https://spring-boot-angular-app.herokuapp.com/)

