#!/user/bin/env groovy

def call() {
    echo "Building application JAR..."
    sh "mvn clean package"
}