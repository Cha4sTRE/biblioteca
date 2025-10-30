pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'master',
                    url: 'https://github.com/Cha4sTRE/biblioteca.git',
                    credentialsId: 'cd-token' // tu ID de credenciales
            }
        }

        stage('Build') {
            steps {
                sh './gradlew clean build'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t biblioteca-app:latest .'
            }
        }

        stage('Deploy') {
            steps {
                sh '''
                    docker stop biblioteca-app || true
                    docker rm biblioteca-app || true
                    docker run -d -p 8080:8080 --name biblioteca-app biblioteca-app:latest
                '''
            }
        }
    }
}
