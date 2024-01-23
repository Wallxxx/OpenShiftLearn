pipeline {
    agent any

    environment {
        OPENSHIFT_SERVER = 'https://api.sandbox-m2.ll9k.p1.openshiftapps.com:6443'
        OPENSHIFT_PROJECT = 'panaceea-dev'
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
                    sh 'oc login --token=${OPENSHIFT_TOKEN} --server=${OPENSHIFT_SERVER}'
                    sh 'oc project ${OPENSHIFT_PROJECT}'
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