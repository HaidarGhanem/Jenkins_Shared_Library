#!/user/bin/env groovy

def call() {
    echo "Building Docker image..."
    sh "docker build -t ${USER}/${APP_NAME}:${APP_TAG} ."
}
