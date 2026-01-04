#!/user/bin/env groovy

def call() {
    echo "Building Docker image..."
    sh "docker build -t ${USER}/demo-maven:1.0 ."
}
