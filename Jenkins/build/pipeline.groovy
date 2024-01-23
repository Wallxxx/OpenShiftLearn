pipeline {
    agent any
    stages {
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