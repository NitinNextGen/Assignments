
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
    }
}
