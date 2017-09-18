node{

	stage('checkokut scm & package'){
		git  url: gitHubUrl, 
    	branch: branchName

    	sh 'mvn clean package'
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
	
	// stage('checkokut scm & package'){
	// 	git  url: gitHubUrl, 
 //    	branch: branchName

 //    	sh 'mvn clean package'
	// }
		
	stage('deploy-qa'){
		sh 'echo "mvn spring-boot:run -Dspring.profiles.active=qa" | at now + 1 minutes'
	}		
} 