pipeline {
    agent any

    environment {
        IMAGE_NAME = "j3ffer/biblioteca"
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

        stage('SonarQube Analysis') {
            environment {
                scannerHome = tool 'SonarScanner' // nombre configurado en Global Tool Configuration
            }
            steps {
                withSonarQubeEnv('SonarQubeServer') { // nombre configurado en Configure System
                    sh '''${scannerHome}/bin/sonar-scanner \
                        -Dsonar.projectKey=biblioteca \
                        -Dsonar.projectName=biblioteca \
                        -Dsonar.projectVersion=1.0 \
                        -Dsonar.sources=src/main/java \
                        -Dsonar.tests=src/test \
                        -Dsonar.coverage.jacoco.xmlReportPaths=./build/reports/jacoco/test/jacocoTestReport.xml \
                        -Dsonar.java.binaries=build/classes \
                        -Dsonar.host.url=$SONAR_HOST_URL \
                        -Dsonar.login=$SONAR_AUTH_TOKEN'''
                }
            }
        }

        stage('Build Docker image') {
            steps {
                sh "docker build -t ${IMAGE_NAME}:${IMAGE_TAG} ."
            }
        }

        stage('Tag Docker image') {
            steps {
                echo "Tagging image..."
                sh "docker tag ${IMAGE_NAME}:${IMAGE_TAG} ${IMAGE_NAME}"
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
                    sh "docker push ${IMAGE_NAME}:${IMAGE_TAG}"
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
