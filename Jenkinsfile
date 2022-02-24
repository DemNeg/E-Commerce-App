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
                 sh "docker build -t gousindevops/taxeApp ."
             }
        }
        stage("Login to Dockerhub"){
            steps {
                sh "docker login -u $DOCKERHUB_CREDENTIALS_USR -p $DOCKERHUB_CREDENTIALS_PSW"
            }
        }

        stage("Docker push") {
            steps {
                 sh "docker push gousindevops/taxeApp"
             }
        }
    }
    post{
        always{
            sh "docker logout"
        }
    }
}