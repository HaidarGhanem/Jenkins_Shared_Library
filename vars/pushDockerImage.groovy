#!/user/bin/env groovy

def call(Map config = [:]) {
    def dockerId = config.dockerId
    def user = config.user
    def image = config.image
    def commitHash = sh(script: "git rev-parse --short HEAD", returnStdout: true).trim()
    echo "Pushing Docker image..."
    withCredentials([usernamePassword(credentialsId: "${dockerId}", passwordVariable: 'PASS', usernameVariable: 'USER')])
    {
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh "docker push ${user}/${image}:${commitHash}"
    }
}
