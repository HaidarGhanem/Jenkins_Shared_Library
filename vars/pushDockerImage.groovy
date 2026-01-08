#!/user/bin/env groovy

def call(Map config = [:]) {
    def user = config.user
    def image = config.image
    echo "Pushing Docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub-id', passwordVariable: 'PASS', usernameVariable: 'USER')])
    {
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh "docker push ${user}/${image}:${env.BUILD_NUMBER}"
    }
}
