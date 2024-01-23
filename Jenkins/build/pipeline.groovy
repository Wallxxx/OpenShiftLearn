pipeline {
    agent any
    stages {
        stage('Build java application') {
            steps {
                script {
                    sh 'mvn clean package'
                }
            }
        }

        stage('Build docker-image') {
            steps {
                script {
                    docker.build('openshiftlearn:latest')
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