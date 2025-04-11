def call(String Project, String ImageTag, String dockerhubuserParam){
  withCredentials([usernamePassword(credentialsId: 'docker', passwordVariable: 'dockerhubpass', usernameVariable: 'DOCKER_USER')]) {
      sh "docker login -u ${DOCKER_USER} -p ${dockerhubpass}"
  }
  sh "docker push ${dockerhubuserParam}/${Project}:${ImageTag}"
}

