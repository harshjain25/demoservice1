node{

	stage('hello'){
		sh 'echo helloworld'
	}

	stage('done'){
		sh 'done'
	}
}