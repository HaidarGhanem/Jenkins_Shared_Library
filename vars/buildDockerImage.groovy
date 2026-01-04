#!/user/bin/env groovy

def call(Map config = [:]) {
    def user = config.user
    def image = config.image
    def tag = config.tag
    echo "Building Docker image..."
    sh "docker build -t ${user}/${image}:${tag} ."
}
