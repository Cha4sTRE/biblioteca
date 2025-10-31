pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                sh './gradlew clean build -x test'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t biblioteca-app:latest .'
            }
        }

        stage('Deploy with Docker Compose') {
            steps {
                // Detener si hay instancias previas
                sh 'docker compose down || true'
                // Levantar todo de nuevo
                sh 'docker compose up -d --build'
            }
        }
    }

    post {
        always {
            echo 'Pipeline finalizado'
        }
        failure {
            echo '❌ Error en el pipeline'
        }
        success {
            echo '✅ Despliegue exitoso'
        }
    }
}
