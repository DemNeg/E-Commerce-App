pipeline {
    agent any
    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
    }
    environment{
        DOCKERHUB_CREDENTIALS=credentials('registry')
    }
    stages {
        stage("Package") {
            steps {
                 sh "mvn package"
             }
        }
         stage("Docker build") {
            steps {
                 sh "docker build -t gousindevops/ecommerce_app1 ."
             }
        }
        stage("Login to Dockerhub"){
            steps {
                sh "docker login -u $DOCKERHUB_CREDENTIALS_USR -p $DOCKERHUB_CREDENTIALS_PSW"
            }
        }

        stage("Docker push") {
            steps {
                 sh "docker push gousindevops/ecommerce_app1"
             }
        }
         stage("Docker push") {
             steps { docker -H 192.168.33.11:4243 run hello-world
                  sh "docker -H 192.168.33.11:4243 run -d -p8888:8080 --name=famms_app gousindevops/ecommerce_app1"
             }
         }
    }
    post{
        always{
            sh "docker logout"
        }
    }
}