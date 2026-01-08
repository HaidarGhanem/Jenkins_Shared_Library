#!/user/bin/env groovy

def call(Map config = [:]) {
    def user = config.user
    def image = config.image
    def commitHash = sh(script: "git rev-parse --short HEAD", returnStdout: true).trim()
    def tag = config.tag ?: commitHash
    echo "Building Docker image..."
    sh "docker build -t ${user}/${image}:${tag} ."
}
