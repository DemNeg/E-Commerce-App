pipeline{
//Feature branch
agent any;
tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
    }
    stages{
    //Download code from github
        stage ('download_code_github'){
            steps{
                checkout scm
            }
        }
        //Perform maven package
        stage ('package'){
            steps{
                sh "mvn package"
            }
        }
        //Perform docker build image
        stage ('docker_build'){
            steps{
               sh "docker build -t gousindevops/taxeApp ."
            }
        }
    }
}