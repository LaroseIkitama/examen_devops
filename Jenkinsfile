pipeline{
    agent any
    tools{
        maven 'maven 3.9.6'
    }
    stages{
        stage('Build maven 3.9.6'){
            steps{
               checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/LaroseIkitama/examen_devops']])
                sh 'mvn clean'
            }
        }
        stage('Build and Test Unitaire') {
            steps {
                // Étape de construction et de test avec Maven
                script {
                    checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/LaroseIkitama/examen_devops']])
                    sh 'mvn test' // Exécute les tests unitaires avec Maven
                }
            }
        }
        stage('Build docker image'){
            steps{
                script{
                    //sh 'docker build -t laroseikitama/examen-larose .'
                    sh 'docker --version'
                    //docker.build('examen-larose') // Nom de l'image Docker à construire
                }
            }
        }
    }
}