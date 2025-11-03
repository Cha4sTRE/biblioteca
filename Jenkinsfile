pipeline {
    agent any
    environment {
            IMAGE_NAME = "j3ffr/biblioteca"  // cambia por tu usuario/repositorio DockerHub
            IMAGE_TAG = "latest"
        }
    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build app') {
            steps {
                sh './gradlew clean build'
            }
        }
        stage('Build Docker image') {
            steps {
                sh "docker build -t ${IMAGE_NAME}:${IMAGE_TAG} ."
            }
        }

         stage('Tag Docker image') {
            steps {
                echo "Tagging image as ${TAG}..."
                sh "docker tag ${IMAGE_NAME}:build-${BUILD_NUMBER} ${IMAGE_NAME}:${TAG}"
            }
        }
         stage('Push to DockerHub') {
            steps {
                echo "Pushing Docker image to DockerHub..."
                withCredentials([usernamePassword(
                    credentialsId: 'docker-id',
                    usernameVariable: 'DOCKER_USER',
                    passwordVariable: 'DOCKER_PASS'
                )]) {
                    sh "echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin"
                    sh "docker push ${IMAGE_NAME}:${TAG}"
                }
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
