def gitHubUrl = 'https://github.com/harshjain25/demoservice1.git'
def branchName = 'testbranch'

node{

	stage('checkokut-build'){
		git  url: gitHubUrl, 
    	branch: branchName

    	sh 'mvn clean package -Dmaven.test.skip=true'
	}

	stage('unit-test'){
		sh 'mvn test'
	}

	stage('integration-test'){
		sh 'mvn integration-test -P integration'
	}

	stage('deploy-dev'){
		sh 'echo "mvn spring-boot:run -Dspring.profiles.active=dev" | at now + 1 minutes'
	}
}

node {

	stage('qa-integration-test'){
		sh 'mvn integration-test -P integration'
	}
		
	stage('deploy-UAT'){
		sh 'echo "mvn spring-boot:run -Dspring.profiles.active=qa" | at now + 1 minutes'
	}		
} 