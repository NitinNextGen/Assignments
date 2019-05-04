
pipeline {
    agent any
    tools {
        maven 'apache-maven-3.3.1' //The tool name must be pre-configured in Jenkins under Manage Jenkins → Global Tool Configuration
    }
    stages {
        stage('Compile and Build') {
            steps {
		sh 'mvn compile'
                sh 'mvn clean package'
            }
        }
	stage('Build image') {
		steps {
          	sh 'docker build -f "dockerfile" -t nitinpanwar/helloworld '
	    }
	}
	   
	stage('Push image') {
		steps {
			withDockerRegistry([ credentialsId: "6544de7e-17a4-4576-9b9b-e86bc1e4f903", url: "" ]) {
            			sh 'docker push nitinpanwar/helloworld
            		
		 	}
	    }	
        }
    }
}


