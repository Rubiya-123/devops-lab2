pipeline {
    agent any

    tools {
        maven 'Maven3'      // Keep your existing Maven tool name
        jdk 'JAVA_HOME'     // Keep your existing JDK tool name
    }

    environment {
        DOCKER_HUB_CREDENTIALS = 'dockerhub-credentials-id' // Replace with your Jenkins credentials ID
        DOCKER_IMAGE = 'rubiya5317/myapp'
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Docker Login') {
            steps {
                withCredentials([usernamePassword(credentialsId: DOCKER_HUB_CREDENTIALS,
                                                  usernameVariable: 'USERNAME',
                                                  passwordVariable: 'PASSWORD')]) {
                    bat "docker login -u %USERNAME% -p %PASSWORD%"
                }
            }
        }

        stage('Docker Build') {
            steps {
                bat "docker build -t %DOCKER_IMAGE% ."
            }
        }

        stage('Docker Push') {
            steps {
                bat "docker push %DOCKER_IMAGE%"
            }
        }
    }

    post {
        success {
            echo 'Pipeline finished successfully!'
        }
        failure {
            echo 'Pipeline failed!'
        }
    }
}
