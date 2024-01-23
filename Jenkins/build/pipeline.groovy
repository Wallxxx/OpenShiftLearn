pipeline {
    agent any
    stages {
        stage('Clone git repo') {
            steps {
                script {
                    checkout([$class: 'GitSCM', branches: [[name: '*/master']], userRemoteConfigs: [[url: 'https://github.com/Wallxxx/OpenShiftLearn.git']]])
                }
            }
        }

        stage('Build') {
            steps {
                script {
                    sh 'mvn clean package'
                }
            }
        }
    }

    post {
        success {
            echo 'Success'
            archiveArtifacts 'target/OpenShiftLearn-1.0.jar'
        }
        failure {
            echo 'Failure'
        }
    }
}