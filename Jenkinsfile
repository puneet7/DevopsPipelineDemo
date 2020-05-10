pipeline {
	environment {
    	registry = "puneet7/calculator"
    	registryCredential = 'dockerhub-login'
    	dockerImage = ''
    }
    agent any 
    stages {
        stage('Clone Git Repo') {
            steps {
                git 'https://github.com/puneet7/MavenDemo.git'
            }
        }
        stage('Maven Clean') { 
            steps {
                sh "mvn clean"
            }
        }
        stage('Build a JAR with Maven') { 
            steps {
                sh "mvn package"
            }
        }
        stage('Create a Docker Image') {
      	    steps {
        	    script {
          			dockerImage = docker.build registry + ":latest"
        		}
      		}
    	}
    	stage('Push Docker Image') {
      		steps {
        		script {
          			docker.withRegistry( '', registryCredential ) {
            		dockerImage.push()
          			}
        		}
      		}
    	}
    	stage('Remove docker image from local memory') {
            steps{
                sh "docker rmi $registry:latest"
            }
        }
        stage('Deploy with Rundeck'){
            steps{
                script{
                    step(
                        [$class: 'RundeckNotifier',
                        jobId: "c379f403-7c23-4069-abdb-9bd25c8e6a0c",
                        shouldWaitForRundeckJob: true,
                        shouldFailTheBuild: true,
                        includeRundeckLogs: true,
                        rundeckInstance: "Rundeck"]
                        )
                       
                }
            }
                
        }
    }
}

