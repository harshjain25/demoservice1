def bitbucketurl = 'https://github.com/harshjain25/demoservice1.git'
def mavenVersion = 'maven3.3.9'
def mavenGoals = 'test spring-boot:run'
def branchName = 'testbranch'
def credentialsId = '725c170f-8828-45ae-a379-44057601e14d'


pipelineJob('demo pipeline'){
  
  definition {
    cpsScm {
      
      scm {
        git {
          
          remote { 
            url(bitbucketurl) 
          }
          
          branches(branchName)
          scriptPath('groovy/demoPipelineScript.groovy')
        }

        // the single line below also works, but it
        // only covers the 'master' branch and may not give
        // enough control.
        // git(repo, 'master', { node -> node / 'extensions' << '' } )
      }
    }
  }
	
  triggers {
    githubPush()
  }
  
}