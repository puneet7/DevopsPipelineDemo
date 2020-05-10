pipeline {
	environment {
    	registry = "puneet7/calculator"
    	registryCredential = 'dockerhub-login'
    	dockerImage = ''
    }
    agent any 
    stages {
        stage('Cloning our Git') {
            steps {
                git 'https://github.com/puneet7/MavenDemo.git'
            }
        }
        stage('clean') { 
            steps {
                sh "mvn clean"
            }
        }
        stage('package') { 
            steps {
                sh "mvn package"
            }
        }
        stage('build image') {
      	    steps {
        	    script {
          			dockerImage = docker.build registry + ":latest"
        		}
      		}
    	}
    	stage('publish Image') {
      		steps {
        		script {
          			docker.withRegistry( '', registryCredential ) {
            		dockerImage.push()
          			}
        		}
      		}
    	}
    	stage('Cleaning up') {
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

