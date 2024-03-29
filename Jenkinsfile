pipeline{
    agent any
    tools{
        maven 'maven 3.9.6'
    }
    stages{
        stage('Build maven 3.9.6'){
            steps{
               checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/LaroseIkitama/examen_devops']])
                sh 'mvn install'
            }
        }
        stage('Build Test') {
            steps {
                // Étape de construction et de test avec Maven
                script {
                    try{
                        checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/LaroseIkitama/examen_devops']])
                        sh 'mvn test' // Exécute les tests unitaires avec Maven
                    }catch (Exception e) {
                        echo "Une erreur s'est produite lors de la construction et des tests unitaires : ${e.getMessage()}"
                        currentBuild.result = 'UNSTABLE'
                    }
                }
            }
        }
        stage('Build docker image'){
            steps{
                script{
                    def dockerTag = "v2"
                    try{
                        sh 'docker build -t laroseikitama/examen-larose:${dockerTag} .'
                        //docker.build("laroseikitama/examen-larose:${dockerTag}")  // Nom de l'image Docker à construire
                    }catch (Exception e) {
                        echo "Une erreur s'est produite lors de la construction de l'image Docker : ${e.getMessage()}"
                        currentBuild.result = 'FAILURE'
                    }
                }
            }
        }
    }
}