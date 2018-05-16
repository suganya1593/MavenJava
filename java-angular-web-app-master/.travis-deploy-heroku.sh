#!/bin/bash

npm install -g heroku-cli && heroku plugins:install heroku-cli-deploy && heroku deploy:jar target/app.jar --app spring-boot-angular-app

