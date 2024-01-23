pipeline {
    agent any

    environment {
        OPENSHIFT_TOKEN = credentials('665d17de-95b3-428d-b1c0-466a16f6a1ad')
    }

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

        stage('Push image to registry') {
            steps {
                script {
                    openshiftLogin(
                            serverUrl: 'https://api.sandbox-m2.ll9k.p1.openshiftapps.com:6443',
                            token: env.OPENSHIFT_TOKEN
                    )
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