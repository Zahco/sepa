# sepa

## Pré-requis
apt-get install heroku

## Login
heroku login
geoffrey.spaur@gmail.com
aqwzsxedc.2017

## Création du projet heroku
heroku create gscl-sepa

## War deploy
### Installation
heroku plugins:install heroku-cli-deploy
### Utilisation
heroku war:deploy target/sepa-server.war --app gscl-sepa

## DataBase
### Installation
heroku addons:create heroku-postgresql:hobby-dev
### Utilisation
heroku pg:psql --app gscl-sepa